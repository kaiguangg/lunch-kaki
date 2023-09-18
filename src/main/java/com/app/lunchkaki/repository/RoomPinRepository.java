package com.app.lunchkaki.repository;


import com.app.lunchkaki.domain.RoomPin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomPinRepository extends JpaRepository<RoomPin, Integer> {

}
