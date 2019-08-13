package com.saul.boot.landon.roomwebapp.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saul.boot.landon.roomwebapp.models.Room;
import com.saul.boot.landon.roomwebapp.repository.RoomRepository;

@Service
public class RoomServices {
	private RoomRepository roomRepository;
	
	@Autowired
	public RoomServices(RoomRepository roomRepository) {
		super();
		this.roomRepository = roomRepository;
	}
	
	public List<Room> getAllRooms(){
		List<Room> rooms = new ArrayList<>();
		this.roomRepository.findAll().forEach(rooms::add);
		return rooms;
	}
}
