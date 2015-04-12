package com.company.webservicetdd.recenthotels;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import javax.inject.Inject;

import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;

import com.company.webservicetdd.FunctionalTestBase;
import com.company.webservicetdd.recenthotels.client.configuration.RecentHotelsProviderClientConfiguration;

/**
 * Functional tests for recent hotels API.
 *
 * @author Daniel_Imre
 */
@ContextConfiguration(classes = {RecentHotelsProviderClientConfiguration.class})
public class RecentHotelsFunctionalTest extends FunctionalTestBase {
    @Inject
    private RecentHotelsProvider client;

    @Test
    public void shouldReturnEndpointUrl() {
        assertThat(client.fetchUri(), is(equalTo("http://localhost:9876/services/recenthotels")));
    }
}
