package com.company.webservicetdd.recenthotels.web.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.company.webservicetdd.recenthotels.RecentHotelsProvider;
import com.company.webservicetdd.recenthotels.service.configuration.RecentHotelsServiceConfiguration;
import com.company.webservicetdd.recenthotels.web.RecentHotelsController;

/**
 * Endpoint configuration for {@link com.company.webservicetdd.recenthotels.RecentHotelsProvider}.
 *
 * @author Daniel_Imre
 */
@Configuration
@EnableWebMvc
@Import(RecentHotelsServiceConfiguration.class)
public class RecentHotelsConfiguration {

    @Bean
    public RecentHotelsController recentHotelsController(RecentHotelsProvider recentHotelsService) {
        return new RecentHotelsController(recentHotelsService);
    }
}
