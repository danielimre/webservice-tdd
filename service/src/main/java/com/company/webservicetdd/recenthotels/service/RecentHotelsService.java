package com.company.webservicetdd.recenthotels.service;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.List;
import java.util.Map;

import com.company.webservicetdd.hotel.dao.HotelNameDao;
import com.company.webservicetdd.recenthotels.RecentHotel;
import com.company.webservicetdd.recenthotels.RecentHotels;
import com.company.webservicetdd.recenthotels.RecentHotelsParameter;
import com.company.webservicetdd.recenthotels.RecentHotelsProvider;
import com.company.webservicetdd.recenthotels.dao.RecentHotelDao;
import com.google.common.base.Function;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.ImmutableList;

/**
 * Invokes additional services to fetch and populate recent hotels.
 *
 * @author Daniel_Imre
 */
public class RecentHotelsService implements RecentHotelsProvider {
    private final RecentHotelDao recentHotelsDao;
    private final HotelNameDao hotelNameDao;

    public RecentHotelsService(RecentHotelDao recentHotelsDao, HotelNameDao hotelNameDao) {
        this.recentHotelsDao = checkNotNull(recentHotelsDao);
        this.hotelNameDao = checkNotNull(hotelNameDao);
    }

    @Override
    public String fetchUri() {
        throw new UnsupportedOperationException();
    }

    @Override
    public RecentHotels getRecentHotels(RecentHotelsParameter parameter) {
        List<Long> recentHotels = recentHotelsDao.getRecentHotelsFor(parameter.getUserId(), parameter.getLimit());
        final Map<Long, String> names = hotelNameDao.getById(recentHotels, parameter.getLocale());
        List<RecentHotel> result = FluentIterable.from(recentHotels).transform(new Function<Long, RecentHotel>() {
            @Override
            public RecentHotel apply(Long hotelId) {
                return RecentHotel.builder().withId(String.valueOf(hotelId)).withName(names.get(hotelId)).build();
            }
        }).toList();
        return new RecentHotels(result);
    }
}
