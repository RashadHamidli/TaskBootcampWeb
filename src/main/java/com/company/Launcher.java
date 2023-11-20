package com.company;

import com.company.controller.TaskController;
import com.company.dto.request.TaskRequest;
import com.company.service.inter.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Launcher{

    public static void main(String[] args) {
        SpringApplication.run(Launcher.class, args);
    }

}
