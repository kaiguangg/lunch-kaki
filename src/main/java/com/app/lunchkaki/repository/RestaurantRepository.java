package com.app.lunchkaki.repository;


import com.app.lunchkaki.domain.Restaurants;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurants, Integer> {

  @Query(nativeQuery = true, value = "SELECT ROOM_ID, NAME, CREATED_DATE FROM LUNCH.RESTAURANTS WHERE ROOM_ID = :roomId" )
  List<Restaurants> getAllRestaurants(@Param("roomId") Integer roomId);

}
