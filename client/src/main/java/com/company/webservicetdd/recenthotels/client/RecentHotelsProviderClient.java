package com.company.webservicetdd.recenthotels.client;

import static com.google.common.base.Preconditions.checkNotNull;

import java.net.URI;
import java.util.Arrays;

import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import com.company.webservicetdd.recenthotels.RecentHotels;
import com.company.webservicetdd.recenthotels.RecentHotelsParameter;
import com.company.webservicetdd.recenthotels.RecentHotelsProvider;

/**
 * Client for {@link RecentHotelsProvider}.
 *
 * @author Daniel_Imre
 */
public class RecentHotelsProviderClient implements RecentHotelsProvider {
    private final URI endPointUri;
    private RestTemplate restTemplate;

    public RecentHotelsProviderClient(URI endPointUri) {
        this.endPointUri = checkNotNull(endPointUri);
        restTemplate = new RestTemplate();
        restTemplate.setMessageConverters(Arrays.<HttpMessageConverter<?>>asList(new MappingJackson2HttpMessageConverter()));
    }

    @Override
    public String fetchUri() {
        return endPointUri.toString();
    }

    @Override
    public RecentHotels getRecentHotels(RecentHotelsParameter parameter) {
        return restTemplate.postForEntity(endPointUri, parameter, RecentHotels.class).getBody();
    }

    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = checkNotNull(restTemplate);
    }
}
