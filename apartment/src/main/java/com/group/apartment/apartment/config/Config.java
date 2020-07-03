package com.group.apartment.apartment.config;

import org.springframework.boot.SpringBootVersion;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Role;
import org.springframework.core.SpringVersion;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.text.SimpleDateFormat;
import java.util.Date;

//@Configuration

@Component

public class Config  {

   // @Scheduled(fixedRate = 1000)
    public void cronJobSch() {
        //Condition
        System.out.println("The Cron Job Started Spring Version ==>" + SpringVersion.getVersion());
        System.out.println("The Cron Job Started Spring Boot Version ==>" + SpringBootVersion.getVersion());
        System.out.println("System Properties ==>" + System.getProperty("java.version"));

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        Date now = new Date();
        String strDate = sdf.format(now);
        System.out.println("Java cron job expression:: " + strDate);
    }


}
