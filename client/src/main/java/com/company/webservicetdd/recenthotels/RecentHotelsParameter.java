package com.company.webservicetdd.recenthotels;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Locale;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Parameters of recent hotel API.
 *
 * @author Daniel_Imre
 */
public final class RecentHotelsParameter {
    private final String userId;
    private final Locale locale;
    private int limit;

    private RecentHotelsParameter(Builder builder) {
        userId = checkNotNull(builder.userId);
        locale = builder.locale;
        limit = builder.limit;
    }

    @JsonCreator
    public RecentHotelsParameter(@JsonProperty("userId") String userId, @JsonProperty("locale") Locale locale, @JsonProperty("limit") int limit) {
        this.userId = userId;
        this.locale = locale;
        this.limit = limit;
    }

    public String getUserId() {
        return userId;
    }

    public Locale getLocale() {
        return locale;
    }

    public int getLimit() {
        return limit;
    }

    @Override
    public String toString() {
        return com.google.common.base.Objects.toStringHelper(this).omitNullValues().add("userId", userId).add("locale", locale).add("limit", limit).toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        RecentHotelsParameter that = (RecentHotelsParameter) o;
        return Objects.equals(limit, that.limit) && Objects.equals(userId, that.userId) && Objects.equals(locale, that.locale);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, locale, limit);
    }

    public static Builder builder() {
        return new Builder();
    }

    /**
     * Builder for {@link RecentHotelsParameter}.
     */
    public static final class Builder {
        private String userId;
        private Locale locale = Locale.US;
        private int limit = 2;

        private Builder() {
        }

        public Builder forUser(String userId) {
            this.userId = userId;
            return this;
        }

        public Builder withLocale(Locale locale) {
            this.locale = locale;
            return this;
        }

        public Builder limit(int limit) {
            this.limit = limit;
            return this;
        }

        public RecentHotelsParameter build() {
            return new RecentHotelsParameter(this);
        }
    }
}
