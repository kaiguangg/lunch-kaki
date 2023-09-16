package dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class RestaurantsDTO {

    @JsonProperty("roomId")
    private Integer roomId;

    @JsonProperty("restaurants")
    private List<String> restaurants;

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    public List<String> getRestaurants() {
        return restaurants;
    }

    public void setRestaurants(List<String> restaurants) {
        this.restaurants = restaurants;
    }
}
