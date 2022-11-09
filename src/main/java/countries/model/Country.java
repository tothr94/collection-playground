package countries.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import countries.utils.RegionDeserializer;
import countries.utils.RegionSerializer;
import lombok.*;

import java.math.BigDecimal;
import java.time.ZoneId;
import java.util.List;
import java.util.Map;

/**
 * Represents a country.
 */
@Builder
@Value
@With
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class Country {

    @JsonProperty("alpha2Code")
    @EqualsAndHashCode.Include
    String code;
    String name;
    String capital;
    Region region;
    long population;
    BigDecimal area;
    Map<String, String> translations;
    List<ZoneId> timezones;

    /**
     * Represents regions.
     */
    @JsonSerialize(using = RegionSerializer.class)
    @JsonDeserialize(using = RegionDeserializer.class)
    public enum Region {

        /**
         * Represents Africa.
         */
        @JsonProperty("Africa") AFRICA,

        /**
         * Represents Americas.
         */
        @JsonProperty("Americas") AMERICAS,

        /**
         * Represents Asia.
         */
        @JsonProperty("Asia") ASIA,

        /**
         * Represents Europe.
         */
        @JsonProperty("Europe") EUROPE,

        /**
         * Represents Oceania.
         */
        @JsonProperty("Oceania") OCEANIA,

        /**
         * Represents Polar.
         */
        @JsonProperty("Polar") POLAR,

        /**
         * Represents an unknown region.
         */
        @JsonProperty("") UNSPECIFIED;

    }
}
