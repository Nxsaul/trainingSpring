package com.saul.boot.landon.processor;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.saul.boot.landon.models.Room;

@Component
public class RoomCleanerProcessor {
	private final ObjectMapper objectMapper;
	private static final Logger LOGGER = LoggerFactory.getLogger(RoomCleanerProcessor.class);

	@Autowired
	public RoomCleanerProcessor(ObjectMapper objectMapper) {
		super();
		this.objectMapper = objectMapper;
	}

	public void receiveMessage(String roomJson) {
		LOGGER.info("Message Received");
		try {
			Room room = this.objectMapper.readValue(roomJson, Room.class);
			LOGGER.info("Room ready for cleaning " + room.getNumber());
		} catch (IOException exc) {
			LOGGER.error("Exception caught", exc);
		}
	}
}
