package org.itformacion.apistudent;

import org.itformacion.apistudent.model.Student;
import org.itformacion.apistudent.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ApiStudentApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiStudentApplication.class, args);
    }
}
