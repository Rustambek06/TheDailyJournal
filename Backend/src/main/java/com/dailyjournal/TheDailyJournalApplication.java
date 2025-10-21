package com.dailyjournal; // ⚠️ этот package ОБЯЗАТЕЛЬНО совпадает с путём

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TheDailyJournalApplication {
    public static void main(String[] args) {
        SpringApplication.run(TheDailyJournalApplication.class, args);
    }
}
