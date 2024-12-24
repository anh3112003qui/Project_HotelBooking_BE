package com.anh3112003qui.quile_hotel.repository;

import com.anh3112003qui.quile_hotel.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface RoomRepository extends JpaRepository<Room, Long> {
}
