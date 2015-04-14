package com.company.webservicetdd.recenthotels;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.Locale;

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

    @Test
    public void shouldReturnTwoLocalizedRecentHotelsForSomeUser() {
        RecentHotelsParameter parameter = RecentHotelsParameter.builder().forUser("someuserid").withLocale(Locale.GERMANY).limit(2).build();

        RecentHotels result = client.getRecentHotels(parameter);

        assertThat(result, is(equalTo(new RecentHotels(Arrays.asList(recentHotel("1", "Hotel 1 name"), recentHotel("3", "Hotel 3 name"))))));
    }

    @Test
    public void shouldReturnThreeLocalizedRecentHotelsForOtherUser() {
        RecentHotelsParameter parameter = RecentHotelsParameter.builder().forUser("otheruserid").withLocale(Locale.UK).limit(4).build();

        RecentHotels result = client.getRecentHotels(parameter);

        assertThat(result, is(equalTo(new RecentHotels(Arrays.asList(recentHotel("2", "Hotel 2"), recentHotel("4", "Hotel 4"), recentHotel("6", "Hotel 6"))))));
    }

    private RecentHotel recentHotel(String id, String name) {
        return RecentHotel.builder().withId(id).withName(name).build();
    }
}
