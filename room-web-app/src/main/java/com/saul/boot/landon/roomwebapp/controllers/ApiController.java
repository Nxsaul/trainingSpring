package com.saul.boot.landon.roomwebapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.saul.boot.landon.roomwebapp.models.Room;
import com.saul.boot.landon.roomwebapp.services.RoomServices;

@RestController
@RequestMapping("/api")
public class ApiController {
	@Autowired
	private RoomServices roomServices;
		
	@GetMapping("/rooms")
	public List<Room> getAllRooms(){
		return this.roomServices.getAllRooms();
	}
}
