package com.company.webservicetdd.recenthotels.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.company.webservicetdd.recenthotels.RecentHotel;
import com.company.webservicetdd.recenthotels.RecentHotels;
import com.company.webservicetdd.recenthotels.RecentHotelsParameter;
import com.company.webservicetdd.recenthotels.RecentHotelsProvider;
import com.google.common.collect.ImmutableList;

/**
 * Controller for {@link RecentHotelsProvider}.
 *
 * @author Daniel_Imre
 */
@Controller
public class RecentHotelsController implements RecentHotelsProvider {

    @Override
    public String fetchUri() {
        throw new UnsupportedOperationException();
    }

    @RequestMapping(value = "/recenthotels", method = RequestMethod.POST)
    @ResponseBody
    @Override
    public RecentHotels getRecentHotels(@RequestBody RecentHotelsParameter parameter) {
        return new RecentHotels(ImmutableList.of(RecentHotel.builder().withName("some").withId("thing").build()));
    }
}
