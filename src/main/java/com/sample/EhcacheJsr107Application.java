package com.sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 *
 * @author WS
 */

@SpringBootApplication
@EnableCaching
public class EhcacheJsr107Application
{
    public static void main(String[] args) 
    {
        SpringApplication.run(EhcacheJsr107Application.class, args);
    }
}
