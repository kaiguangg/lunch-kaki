package com.app.lunchkaki.domain;

import jakarta.persistence.*;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "ROOM_PIN", schema="LUNCH")
public class RoomPin {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_ROOM_ID")
    @SequenceGenerator(name = "SEQ_ROOM_ID", sequenceName = "SEQ_ROOM_ID", schema = "LUNCH", allocationSize = 1)
    @Column(name = "ID", columnDefinition = "NUMBER(6,0)")
    private Integer id;

    @NotNull
    @Column(name = "CREATED_DATE", columnDefinition = "TIMESTAMP(6)")
    private LocalDateTime createdDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }
}
