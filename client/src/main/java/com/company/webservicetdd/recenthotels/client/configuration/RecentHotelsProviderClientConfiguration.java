package com.company.webservicetdd.recenthotels.client.configuration;

import java.net.URI;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.company.webservicetdd.recenthotels.RecentHotelsProvider;
import com.company.webservicetdd.recenthotels.client.RecentHotelsProviderClient;

/**
 * Client configuration of recent hotels service.
 *
 * @author Daniel_Imre
 */
@Configuration
public class RecentHotelsProviderClientConfiguration {
    @Value("${WEBSERVICETDD_BASE_URL}/recenthotels")
    private URI endPointUri;

    @Bean
    public RecentHotelsProvider recentHotelsProviderClient() {
        return new RecentHotelsProviderClient(endPointUri);
    }
}
