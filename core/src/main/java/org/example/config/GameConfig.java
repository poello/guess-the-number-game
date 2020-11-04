package org.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GameConfig {
    // == fields ==
    private int maxNumber = 25;
    private int guessCount = 8;

    // == bean methods ==
    @Bean
    public int maxNumber() {
        return maxNumber;
    }

    @Bean
    public int guessCount() {
        return guessCount;
    }
}
