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
import java.util.*;

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

  public ResponseEntity<Object> saveRestaurant(RestaurantsDTO restaurantsDTO) {
    if (restaurantsDTO.getRestaurants().isEmpty()) {
      return new ResponseEntity<>("Restaurant name is empty.", HttpStatus.BAD_REQUEST);
    }

    RoomPin roomPin = new RoomPin();

    roomPin.setCreatedDate(LocalDateTime.now());
    roomPinRepository.saveAndFlush(roomPin);

    List<Restaurants> restaurantsList = new ArrayList<>();

    for (String name : restaurantsDTO.getRestaurants()) {
      Restaurants restaurant = new Restaurants();
      restaurant.setRoomId(roomPin.getId());
      restaurant.setName(name);
      restaurant.setCreatedDate(LocalDateTime.now());

      restaurantsList.add(restaurant);
    }

    restaurantRepository.saveAll(restaurantsList);

    return new ResponseEntity<>(roomPin, HttpStatus.CREATED);
  }

  public ResponseEntity<String> getRandomRestaurant(Integer roomId) {
    if (Objects.isNull(roomId)) {
      return new ResponseEntity<>("Room PIN is empty.", HttpStatus.BAD_REQUEST);
    }

    Optional<RoomPin> roomPin = roomPinRepository.findById(roomId);
    if (roomPin.isEmpty() || !roomPin.isPresent()) {
      return new ResponseEntity<>("Room PIN is invalid.", HttpStatus.BAD_REQUEST);
    }

    List<Restaurants> restaurantsList = restaurantRepository.getAllRestaurants(roomId);
    if (Objects.isNull(restaurantsList)) {
      return new ResponseEntity<>("Please create a new room.", HttpStatus.BAD_REQUEST);
    }

    // Create a Random object
    Random rand = new Random();

    // Generate a random index between 0 and the size of the list
    int randomIndex = rand.nextInt(restaurantsList.size());

    // Get the element at the random index
    String randomRestaurant = restaurantsList.get(randomIndex).getName();

    return new ResponseEntity<>(randomRestaurant, HttpStatus.OK);
  }
}
