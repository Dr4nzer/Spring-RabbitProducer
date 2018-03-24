package com.scrap.rabbit;

import com.scrap.rabbit.config.RabbitConfig;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {

    private static final String MESSAGE = "Hola Mundo";

    @Autowired
    RabbitTemplate rabbitTemplate;

    public static void main(String args[]) {
        SpringApplication.run(Application.class, args);

    }

    @Override
    public void run(String... args) throws InterruptedException {
        System.out.println("[Application] Enviando el mensaje \"" + MESSAGE + "\"...");
        rabbitTemplate.convertAndSend(RabbitConfig.TOPIC_CORREO, RabbitConfig.ROUTING_KEY, MESSAGE);
    }

}
