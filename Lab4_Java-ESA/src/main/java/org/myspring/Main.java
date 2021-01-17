package org.myspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

@SpringBootApplication
@EnableJms
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class,args);
    }
}
