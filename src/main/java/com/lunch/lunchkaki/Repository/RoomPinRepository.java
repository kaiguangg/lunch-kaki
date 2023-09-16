package com.lunch.lunchkaki.Repository;


import com.lunch.lunchkaki.Domain.RoomPin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomPinRepository extends JpaRepository<RoomPin, Integer> {

}
