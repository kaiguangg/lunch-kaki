package com.lunch.lunchkaki.Controller;

import com.lunch.lunchkaki.Service.RestaurantService;
import dto.RestaurantsDTO;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api")
public class RoomController {
    @Autowired
    private RestaurantService restaurantService;

    @GetMapping(value = "/room/{roomId}")
    public ResponseEntity<Object> getAllRestaurants(@PathVariable Integer roomId) {
        return restaurantService.getAllRestaurants(roomId);
    }

    @PostMapping(value = "/room")
    public ResponseEntity<String> createRoom(@RequestBody RestaurantsDTO restaurantsDTO) {
//        Restaurants savedRestaurants = restaurantService.saveRestaurant(restaurantsDTO);
        return restaurantService.saveRestaurant(restaurantsDTO);
    }

}

