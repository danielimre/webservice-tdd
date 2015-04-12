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

    /**
     * Retrieves recent hotels based on provided parameters.
     *
     * @param parameter the lookup parameters
     * @return recent hotels result, never null
     */
    RecentHotels getRecentHotels(RecentHotelsParameter parameter);
}
