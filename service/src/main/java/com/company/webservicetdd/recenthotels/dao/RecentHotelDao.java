package com.company.webservicetdd.recenthotels.dao;

import java.util.List;

import com.google.common.collect.FluentIterable;
import com.google.common.collect.ImmutableList;

/**
 * DAO for recent hotels.
 *
 * @author Daniel_Imre
 */
public class RecentHotelDao {
    public List<Long> getRecentHotelsFor(String userid, int limit) {
        List<Long> result = ImmutableList.of(2L, 4L, 6L);
        if ("someuserid".equals(userid)) {
            result = ImmutableList.of(1L, 3L, 5L);
        }
        return FluentIterable.from(result).limit(limit).toList();
    }
}
