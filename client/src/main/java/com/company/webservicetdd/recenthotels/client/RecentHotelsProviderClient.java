package com.company.webservicetdd.recenthotels.client;

import java.net.URI;

import com.company.webservicetdd.recenthotels.RecentHotelsProvider;

/**
 * Client for {@link RecentHotelsProvider}.
 *
 * @author Daniel_Imre
 */
public class RecentHotelsProviderClient implements RecentHotelsProvider {
    private final URI endPointUri;

    public RecentHotelsProviderClient(URI endPointUri) {
        this.endPointUri = endPointUri;
    }

    @Override
    public String fetchUri() {
        return endPointUri.toString();
    }
}
