package com.company.webservicetdd.recenthotels.service;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

import java.util.Locale;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import com.company.webservicetdd.hotel.dao.HotelNameDao;
import com.company.webservicetdd.recenthotels.RecentHotel;
import com.company.webservicetdd.recenthotels.RecentHotels;
import com.company.webservicetdd.recenthotels.RecentHotelsParameter;
import com.company.webservicetdd.recenthotels.dao.RecentHotelDao;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;

/**
 * Unit test for {@link RecentHotelsService}.
 *
 * @author Daniel_Imre
 */
public class RecentHotelsServiceTest {
    private static final String USERID = "userid";
    private static final int LIMIT = 4;
    private static final Locale LOCALE = Locale.UK;
    private RecentHotelsService service;
    @Mock
    private RecentHotelDao recentHotelsDao;
    @Mock
    private HotelNameDao hotelNameDao;

    @Before
    public void initContext() {
        initMocks(this);
        service = new RecentHotelsService(recentHotelsDao, hotelNameDao);
    }

    @Test
    public void shouldInvokeRecentHotelsDaoToFetchThem() {
        when(recentHotelsDao.getRecentHotelsFor(USERID, LIMIT)).thenReturn(ImmutableList.of(1L, 3L));
        when(hotelNameDao.getById(eq(ImmutableList.of(1L, 3L)), eq(LOCALE))).thenReturn(ImmutableMap.of(1L, "hotel1", 3L, "hotel3"));

        RecentHotelsParameter parameter = RecentHotelsParameter.builder().forUser(USERID).limit(LIMIT).withLocale(LOCALE).build();
        RecentHotels recentHotels = service.getRecentHotels(parameter);

        assertThat(recentHotels, is(equalTo(new RecentHotels(ImmutableList.of(aHotel("1", "hotel1"), aHotel("3", "hotel3"))))));
    }

    private RecentHotel aHotel(String hotelId, String hotelName) {
        return RecentHotel.builder().withId(hotelId).withName(hotelName).build();
    }
}
