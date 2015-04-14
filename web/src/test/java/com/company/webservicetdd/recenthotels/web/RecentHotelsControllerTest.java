package com.company.webservicetdd.recenthotels.web;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.sameInstance;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import com.company.webservicetdd.recenthotels.RecentHotel;
import com.company.webservicetdd.recenthotels.RecentHotels;
import com.company.webservicetdd.recenthotels.RecentHotelsParameter;
import com.company.webservicetdd.recenthotels.RecentHotelsProvider;
import com.google.common.collect.ImmutableList;

/**
 * Unit test for {@link RecentHotelsController}.
 *
 * @author Daniel_Imre
 */
public class RecentHotelsControllerTest {
    private RecentHotelsController controller;
    @Mock
    private RecentHotelsProvider service;

    @Before
    public void initContext() {
        initMocks(this);
        controller = new RecentHotelsController(service);
    }

    @Test
    public void shouldInvokeServiceToFetchRecentHotels() {
        RecentHotelsParameter parameter = RecentHotelsParameter.builder().forUser("anyuser").build();
        RecentHotels expectedResponse = new RecentHotels(ImmutableList.<RecentHotel>of());
        when(service.getRecentHotels(eq(parameter))).thenReturn(expectedResponse);

        RecentHotels response = controller.getRecentHotels(parameter);

        assertThat(response, is(sameInstance(expectedResponse)));
    }

    @Test(expected = InvalidRecentHotelsRequestException.class)
    public void shouldThrowInvalidRecentHotelsRequestExceptionIfParameterIsNull() {
        controller.getRecentHotels(null);
    }
}
