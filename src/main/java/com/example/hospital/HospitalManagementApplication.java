package com.example.hospital;


import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * *******************************************************
 * Package: com.example.hospitalmngt
 * File: HospitalManagementApplication.java
 * Author: Ochwada
 * Date: Monday, 30.Jun.2025, 4:08 PM
 * Description: Entry point for the Hospital Management application. The @SpringBootApplication annotation enables
 * component scanning, autoconfiguration, and configuration properties support.
 * - Running this class starts the embedded server and initializes the Spring context.
 * Objective:
 * *******************************************************
 */

@SpringBootApplication
public class HospitalManagementApplication {
    static {
        // Load environment variables from a .env file if present
        Dotenv dotenv = Dotenv.configure()
                .ignoreIfMissing()
                .load();

        // Set all required secrets as system properties
        // e.g., System.setProperty("DB_PASSWORD", dotenv.get("DB_PASSWORD"));
        System.setProperty("DB_PASSWORD", dotenv.get("DB_PASSWORD"));
    }

    /**
     * Main method to launch the application.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {

        SpringApplication.run(HospitalManagementApplication.class, args);

    }


}
