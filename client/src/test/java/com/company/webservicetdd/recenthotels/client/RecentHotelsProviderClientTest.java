package com.company.webservicetdd.recenthotels.client;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.eq;
import static org.mockito.Matchers.isA;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

import java.net.URI;
import java.util.Locale;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.company.webservicetdd.recenthotels.RecentHotel;
import com.company.webservicetdd.recenthotels.RecentHotels;
import com.company.webservicetdd.recenthotels.RecentHotelsParameter;
import com.google.common.collect.ImmutableList;

/**
 * Unit test for {@link RecentHotelsProviderClient}.
 *
 * @author Daniel_Imre
 */
public class RecentHotelsProviderClientTest {
    private static final URI ENDPOINT_URI = URI.create("http://some.thing");
    private RecentHotelsProviderClient client;
    @Mock
    private RestTemplate restTemplate;

    @Before
    public void initContext() {
        initMocks(this);
        client = new RecentHotelsProviderClient(ENDPOINT_URI);
        client.setRestTemplate(restTemplate);
    }

    @Test
    public void shouldInvokeRemoteServiceViaPostRequest() {
        when(restTemplate.postForEntity(isA(URI.class), isA(RecentHotelsParameter.class), eq(RecentHotels.class))).thenReturn(new ResponseEntity<>(new RecentHotels(
                ImmutableList.<RecentHotel>of()), HttpStatus.OK));

        RecentHotelsParameter params = RecentHotelsParameter.builder().forUser("someuser").withLocale(Locale.CANADA_FRENCH).limit(3).build();
        RecentHotels result = client.getRecentHotels(params);

        assertThat(result, is(equalTo(new RecentHotels(ImmutableList.<RecentHotel>of()))));
        verify(restTemplate, times(1)).postForEntity(eq(ENDPOINT_URI), eq(params), eq(RecentHotels.class));
    }
}
