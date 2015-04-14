package com.company.webservicetdd.recenthotels.web;

import static com.google.common.base.Preconditions.checkNotNull;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.company.webservicetdd.recenthotels.RecentHotels;
import com.company.webservicetdd.recenthotels.RecentHotelsParameter;
import com.company.webservicetdd.recenthotels.RecentHotelsProvider;

/**
 * Controller for {@link RecentHotelsProvider}.
 *
 * @author Daniel_Imre
 */
@Controller
public class RecentHotelsController implements RecentHotelsProvider {
    private final RecentHotelsProvider service;

    public RecentHotelsController(RecentHotelsProvider service) {
        this.service = checkNotNull(service);
    }

    @Override
    public String fetchUri() {
        throw new UnsupportedOperationException();
    }

    @RequestMapping(value = "/recenthotels", method = RequestMethod.POST)
    @ResponseBody
    @Override
    public RecentHotels getRecentHotels(@RequestBody RecentHotelsParameter parameter) {
        if (parameter == null) {
            throw new InvalidRecentHotelsRequestException();
        }
        return service.getRecentHotels(parameter);
    }
}
