package com.company.webservicetdd.recenthotels.service.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.company.webservicetdd.hotel.dao.HotelNameDao;
import com.company.webservicetdd.recenthotels.dao.RecentHotelDao;
import com.company.webservicetdd.recenthotels.service.RecentHotelsService;

/**
 * Configuration for recent hotels.
 *
 * @author Daniel_Imre
 */
@Configuration
public class RecentHotelsServiceConfiguration {
    @Bean
    public RecentHotelsService recentHotelsService() {
        return new RecentHotelsService(new RecentHotelDao(), new HotelNameDao());
    }
}
