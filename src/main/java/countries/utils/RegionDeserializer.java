package countries.utils;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import countries.model.Country;

import java.io.IOException;

/**
 * Serializes values of enum {@link countries.model.Country.Region}.
 */
public final class RegionDeserializer extends StdDeserializer<Country.Region> {

    /**
     * Constructor.
     */
    public RegionDeserializer() {
        super(Country.Region.class);
    }

    @Override
    public Country.Region deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        String s = p.getValueAsString();
        return switch (s) {
            case "Africa" -> Country.Region.AFRICA;
            case "Americas" -> Country.Region.AMERICAS;
            case "Asia" -> Country.Region.ASIA;
            case "Europe" -> Country.Region.EUROPE;
            case "Oceania" -> Country.Region.OCEANIA;
            case "Polar" -> Country.Region.POLAR;
            case "" -> Country.Region.UNSPECIFIED;
            default -> throw ctxt.weirdStringException(s, Country.Region.class, "Invalid region name");
        };
    }

}