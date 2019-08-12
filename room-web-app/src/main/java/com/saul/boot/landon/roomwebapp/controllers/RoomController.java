package com.saul.boot.landon.roomwebapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.saul.boot.landon.roomwebapp.services.RoomServices;

@Controller
@RequestMapping("/rooms")
public class RoomController {
	
	@Autowired
	private RoomServices roomServices;
		
	@GetMapping
	public String getAllRooms(Model model) {
		model.addAttribute("rooms", this.roomServices.getAllRooms());
		return "rooms";
	}
}
	