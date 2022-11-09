package countries.utils;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import countries.model.Country;

/**
 * Deserializes values of enum {@link countries.model.Country.Region}.
 */
public final class RegionSerializer extends StdSerializer<Country.Region> {

    /**
     * Constructor.
     */
    public RegionSerializer() {
        super(Country.Region.class);
    }

    @Override
    public void serialize(Country.Region value, JsonGenerator gen, SerializerProvider provider) throws IOException {
        gen.writeString(
            switch (value) {
                case AFRICA -> "Africa";
                case AMERICAS -> "Americas";
                case ASIA -> "Asia";
                case EUROPE -> "Europe";
                case OCEANIA -> "Oceania";
                case POLAR -> "Polar";
                case UNSPECIFIED -> "";
            }
        );
    }

}