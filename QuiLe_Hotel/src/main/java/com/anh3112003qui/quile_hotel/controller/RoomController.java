package com.anh3112003qui.quile_hotel.controller;

import com.anh3112003qui.quile_hotel.model.Room;
import com.anh3112003qui.quile_hotel.response.RoomResponse;
import com.anh3112003qui.quile_hotel.service.IRoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/rooms")
public class RoomController {

    private final IRoomService roomService;

    public RoomController(IRoomService roomService) {
        this.roomService = roomService;
    }

    @PostMapping(value = "/add/new-room", produces = "application/json")
    @ResponseBody
    public ResponseEntity<RoomResponse> addNewRoom(
            @RequestParam("photo") MultipartFile photo,
            @RequestParam("roomType") String roomType,
            @RequestParam("roomPrice") BigDecimal roomPrice) throws SQLException, IOException {
        Room savedRoom = roomService.addNewRoom(photo, roomType, roomPrice);
        RoomResponse response = new RoomResponse(savedRoom.getId(), savedRoom.getRoomType(), savedRoom.getRoomPrice());
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(response);
    }

    @GetMapping("/room/types")
    public List<String> getRoomTypes() {
        List<String> roomTypes = roomService.getAllRoomTypes();
        System.out.println("Room Types: " + roomTypes); // Log để kiểm tra
        return roomTypes;
    }
}
