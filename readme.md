# This project is focused on various technologies with Spring


Such as:

- H2 in memory database --> [H2 Features](http://www.h2database.com/html/features.html
)

- RabbitMQ --> [RabbitMQ Features](https://blog.bi-geek.com/rabbitmq-para-principiantes/
)

## The project consists of:

- An application that generates a consumption API (__room-web-app__).

- Another project that sends messages to the RabbitMQ to glue the messages and consume them (__room-clr-app__).

- Another project for the consumption of messages stored on the RabbitMQ server (__room-cleaner-consumer__)
