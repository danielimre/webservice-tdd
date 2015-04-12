package com.company.webservicetdd.recenthotels.client;

import static com.google.common.base.Preconditions.checkNotNull;

import java.net.URI;

import com.company.webservicetdd.recenthotels.RecentHotels;
import com.company.webservicetdd.recenthotels.RecentHotelsParameter;
import com.company.webservicetdd.recenthotels.RecentHotelsProvider;

/**
 * Client for {@link RecentHotelsProvider}.
 *
 * @author Daniel_Imre
 */
public class RecentHotelsProviderClient implements RecentHotelsProvider {
    private final URI endPointUri;

    public RecentHotelsProviderClient(URI endPointUri) {
        this.endPointUri = checkNotNull(endPointUri);
    }

    @Override
    public String fetchUri() {
        return endPointUri.toString();
    }

    @Override
    public RecentHotels getRecentHotels(RecentHotelsParameter parameter) {
        return null;
    }
}
