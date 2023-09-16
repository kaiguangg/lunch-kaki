package com.lunch.lunchkaki.Controller;

import com.lunch.lunchkaki.Service.RestaurantService;
import dto.RestaurantsDTO;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class RoomController {
    @Autowired
    private RestaurantService restaurantService;

    @GetMapping(value = "/room/{roomId}")
    public ResponseEntity<Object> getAllRestaurants(@PathVariable Integer roomId) {
        return restaurantService.getAllRestaurants(roomId);
    }

    @PostMapping(value = "/room")
    public ResponseEntity<Object> createRoom(@RequestBody RestaurantsDTO restaurantsDTO) {
        return restaurantService.saveRestaurant(restaurantsDTO);
    }

  @GetMapping(value = "/random-restaurant/{roomId}")
  public ResponseEntity<String> getRandomRestaurant(@PathVariable Integer roomId) {
    return restaurantService.getRandomRestaurant(roomId);
  }

}

