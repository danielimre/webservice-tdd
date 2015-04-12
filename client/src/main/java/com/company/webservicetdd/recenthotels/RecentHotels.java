package com.company.webservicetdd.recenthotels;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.List;
import java.util.Objects;

/**
 * Holds recent hotels.
 *
 * @author Daniel_Imre
 */
public class RecentHotels {
    private final List<RecentHotel> hotels;

    public RecentHotels(List<RecentHotel> hotels) {
        this.hotels = checkNotNull(hotels);
    }

    public List<RecentHotel> getHotels() {
        return hotels;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        RecentHotels that = (RecentHotels) o;
        return Objects.equals(hotels, that.hotels);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hotels);
    }

    @Override
    public String toString() {
        return com.google.common.base.Objects.toStringHelper(this).omitNullValues().add("hotels", hotels).toString();
    }
}
