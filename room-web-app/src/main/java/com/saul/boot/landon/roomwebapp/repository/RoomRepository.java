package com.saul.boot.landon.roomwebapp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.saul.boot.landon.roomwebapp.models.Room;

@Repository
public interface RoomRepository extends CrudRepository<Room,Long> {
}
