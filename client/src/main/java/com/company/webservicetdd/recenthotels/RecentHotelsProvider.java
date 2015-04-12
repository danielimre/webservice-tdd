package com.company.webservicetdd.recenthotels;

/**
 * Provides recent hotels.
 *
 * @author Daniel_Imre
 */
public interface RecentHotelsProvider {

    /**
     * Returns the service endpoint URI.
     *
     * @return the URI as string
     */
    String fetchUri();
}
