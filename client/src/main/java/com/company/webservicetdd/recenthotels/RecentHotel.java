package com.company.webservicetdd.recenthotels;

import java.util.Objects;

/**
 * Holds hotel data specific to recent hotels.
 *
 * @author Daniel_Imre
 */
public final class RecentHotel {
    private final String id;
    private final String name;

    private RecentHotel(Builder builder) {
        id = builder.id;
        name = builder.name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return com.google.common.base.Objects.toStringHelper(this).omitNullValues().add("id", id).add("name", name).toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        RecentHotel that = (RecentHotel) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    public static Builder builder() {
        return new Builder();
    }

    /**
     * Builder for {@link RecentHotel}.
     */
    public static final class Builder {
        private String id;
        private String name;

        private Builder() {
        }

        public Builder withId(String id) {
            this.id = id;
            return this;
        }

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public RecentHotel build() {
            return new RecentHotel(this);
        }
    }
}
