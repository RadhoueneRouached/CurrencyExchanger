package de.currency.exchanger.klt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Spring boot application start point
 */
@SpringBootApplication
public class KltApplication {

    /**
     * start point
     *
     * @param args system arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(KltApplication.class, args);
    }
}
