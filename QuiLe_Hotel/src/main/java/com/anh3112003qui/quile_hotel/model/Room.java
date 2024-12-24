package com.anh3112003qui.quile_hotel.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.RandomStringUtils;

import java.math.BigDecimal;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;


@Entity
@Getter
@Setter
@AllArgsConstructor
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String roomType;
    private BigDecimal roomPrice;
    private boolean isBooked = false;
    @Lob
    @Column(columnDefinition = "BLOB")
    private Blob photo;


    @OneToMany(mappedBy="room", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<BookedRoom> bookings;

    public Room() {
        this.bookings = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public boolean isBooked() {
        return isBooked;
    }

    public Blob getPhoto() {
        return photo;
    }

    public BigDecimal getRoomPrice() {
        return roomPrice;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setBooked(boolean booked) {
        isBooked = booked;
    }

    public void setPhoto(Blob photo) {
        this.photo = photo;
    }

    public void setRoomPrice(BigDecimal roomPrice) {
        this.roomPrice = roomPrice;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public void addBooking(BookedRoom booking) {
        if (booking == null) {
            bookings = new ArrayList<>();
        }
        bookings.add(booking);
        booking.setRoom(this);
        isBooked = true;
        String bookingCode = RandomStringUtils.randomAlphanumeric(10);
        booking.setBookingConfirmationCode(bookingCode);
    }


}
