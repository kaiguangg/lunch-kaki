package com.app.lunchkaki.domain;

import jakarta.persistence.*;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "RESTAURANTS", schema="LUNCH")
@IdClass(Restaurants.RestaurantsId.class)
public class Restaurants {
    @Id
    @NotNull
    @Column(name = "ROOM_ID", columnDefinition = "NUMBER(6,0)")
    private Integer roomId;

    @Id
    @NotNull
    @Column(name = "NAME", columnDefinition = "VARCHAR2(100 BYTE)")
    private String name;

    @NotNull
    @Column(name = "CREATED_DATE", columnDefinition = "TIMESTAMP(6)")
    private LocalDateTime createdDate;

  public Integer getRoomId() {
    return roomId;
  }

  public void setRoomId(Integer roomId) {
    this.roomId = roomId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public LocalDateTime getCreatedDate() {
    return createdDate;
  }

  public void setCreatedDate(LocalDateTime createdDate) {
    this.createdDate = createdDate;
  }

  public static class RestaurantsId implements Serializable {
      private Integer roomId;
      private String name;

      public Integer getRoomId() {
          return roomId;
      }

      public void setRoomId(Integer roomId) {
          this.roomId = roomId;
      }

      public String getName() {
          return name;
      }

      public void setName(String name) {
          this.name = name;
      }
  }
}
