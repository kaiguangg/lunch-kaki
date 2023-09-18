package com.app.lunchkaki.Service;

import com.app.lunchkaki.domain.Restaurants;
import com.app.lunchkaki.domain.RoomPin;
import com.app.lunchkaki.repository.RoomPinRepository;
import com.app.lunchkaki.repository.RestaurantRepository;
import com.app.lunchkaki.dto.RestaurantsDTO;
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

    List<Restaurants> restaurantsList = restaurantRepository.getAllRestaurants(roomId);
    if (Objects.isNull(restaurantsList)) {
      return new ResponseEntity<>("Please create a new room.", HttpStatus.BAD_REQUEST);
    }

    List<String> restaurants = new ArrayList<>();
    for (Restaurants r : restaurantsList) {
      restaurants.add(r.getName());
    }

    RestaurantsDTO response = new RestaurantsDTO();
    response.setRoomId(roomId);
    response.setRestaurants(restaurants);

    return new ResponseEntity<>(response, HttpStatus.OK);
  }

  public ResponseEntity<Object> createRoom(RestaurantsDTO restaurantsDTO) {
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

    return new ResponseEntity<>(roomPin.getId(), HttpStatus.CREATED);
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
