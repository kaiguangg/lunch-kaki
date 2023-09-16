package com.lunch.lunchkaki.Repository;


import com.lunch.lunchkaki.Domain.Restaurants;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurants, Integer> {

}
