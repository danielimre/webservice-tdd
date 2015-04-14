package com.company.webservicetdd.hotel.dao;

import java.util.Collection;
import java.util.Locale;
import java.util.Map;

import com.google.common.base.Function;
import com.google.common.collect.FluentIterable;

/**
 * DAO for hotel name data.
 *
 * @author Daniel_Imre
 */
public class HotelNameDao {
    public Map<Long, String> getById(Collection<Long> ids, final Locale locale) {
        return FluentIterable.from(ids).toMap(new Function<Long, String>() {
            @Override
            public String apply(Long input) {
                String name = "Hotel " + input;
                if (Locale.GERMANY.equals(locale)) {
                    name = "Hotel " + input + " name";
                }
                return name;
            }
        });
    }
}
