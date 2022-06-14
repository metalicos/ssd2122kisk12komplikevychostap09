package com.komplikevych.ssd2122kisk12komplikevychostap09.config;

import org.ini4j.Wini;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.File;
import java.io.IOException;

@Configuration
public class AppConfig {

    @Bean
    Wini getWini() throws IOException {
        return new Wini(new File("JAR/sequencefile.ini"));
    }
}
