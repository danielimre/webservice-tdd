package com.company.webservicetdd.recenthotels.web.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.company.webservicetdd.recenthotels.web.RecentHotelsController;

/**
 * Endpoint configuration for {@link com.company.webservicetdd.recenthotels.RecentHotelsProvider}.
 *
 * @author Daniel_Imre
 */
@Configuration
@EnableWebMvc
public class RecentHotelsConfiguration {
    @Bean
    public RecentHotelsController recentHotelsController() {
        return new RecentHotelsController();
    }
}
