package com.saul.boot.clr;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.saul.boot.clr.models.Room;

@Component
public class RoomCleaningPrimer implements CommandLineRunner {

	@Value("${amqp.queue.name}")
	private String queueName;
	private static final Logger LOGGER = LoggerFactory.getLogger(RoomCleaningPrimer.class);

	private RestTemplate restTemplate;
	private final RabbitTemplate rabbitTemplate;
	private final ConfigurableApplicationContext context;
	private final ObjectMapper objectMapper;
		

	public RoomCleaningPrimer(	RabbitTemplate rabbitTemplate,	ConfigurableApplicationContext context,	ObjectMapper objectMapper) {
		super();
		this.restTemplate = new RestTemplate();
		this.rabbitTemplate = rabbitTemplate;
		this.context = context;
		this.objectMapper = objectMapper;
	}

	@Override
	public void run(String... args) throws Exception {
		String url = "http://localhost:8080/api/rooms";
		Room[] roomArray = this.restTemplate.getForObject(url, Room[].class);
		List<Room> rooms = Arrays.asList(roomArray);

		rooms.forEach(room->{
			LOGGER.info("Sending Message");
			try {
				String jsonString = objectMapper.writeValueAsString(room);
				rabbitTemplate.convertAndSend(queueName,jsonString);
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				LOGGER.error("Parsing Exception",e);
			}
		});

		context.close();
	}

}
