package com.lunch.lunchkaki.Service;

import com.lunch.lunchkaki.Domain.Restaurants;
import com.lunch.lunchkaki.Domain.RoomPin;
import com.lunch.lunchkaki.Repository.RestaurantRepository;
import com.lunch.lunchkaki.Repository.RoomPinRepository;
import dto.RestaurantsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RestaurantService {

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Autowired
    private RoomPinRepository roomPinRepository;

    public ResponseEntity<Object> getAllRestaurants(Integer roomId) {

        Optional<RoomPin> roomPin = roomPinRepository.findById(roomId);

        if (roomPin.isEmpty() || !roomPin.isPresent()) {
            return new ResponseEntity<>("Room PIN is invalid.", HttpStatus.BAD_REQUEST);
        }

        Optional<Restaurants> restaurantsList = restaurantRepository.findById(roomId);
        if (restaurantsList.isEmpty() || !restaurantsList.isPresent()) {
            return new ResponseEntity<>("Room PIN is invalid.", HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(restaurantsList, HttpStatus.OK);
    }

    public ResponseEntity<String> saveRestaurant(RestaurantsDTO restaurantsDTO) {
        if (restaurantsDTO.getRestaurants().isEmpty()) {
            return new ResponseEntity<>("Restaurant name is empty.", HttpStatus.BAD_REQUEST);
        }

        Integer roomPin = roomPinRepository.getNextRoomId();
        List<Restaurants> restaurantsList = new ArrayList<>();

        for (String name : restaurantsDTO.getRestaurants()) {
            Restaurants restaurant = new Restaurants();
            restaurant.setRoomId(roomPin);
            restaurant.setName(name);
            restaurant.setCreatedDate(LocalDateTime.now());

            restaurantsList.add(restaurant);
        }

        restaurantRepository.saveAll(restaurantsList);

        return new ResponseEntity<>("Room has created.", HttpStatus.CREATED);
    }
}
