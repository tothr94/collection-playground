package countries;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import countries.model.Country;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 * A repository reading and storing {@link Country} instances.
 */
public final class CountryRepository {
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper().registerModule(new JavaTimeModule());
    private static CountryRepository instance;

    /**
     * Returns the repository instance.
     *
     * @return the instance
     */
    public static CountryRepository getInstance() {
        if (instance == null) {
            instance = new CountryRepository();
        }
        return instance;
    }

    private final List<Country> countries;

    /**
     * Constructor.
     */
    private CountryRepository() {
        try {
            this.countries = OBJECT_MAPPER.readValue(
                    CountryRepository.class.getResourceAsStream("countries.json"),
                    new TypeReference<>() {
                    });
        } catch (IOException e) {
            throw new AssertionError("Failed to load resource countries.json", e); // Can't happen
        }
    }

    /**
     * Returns the list of {@link Country} objects.
     *
     * @return the list
     */
    public List<Country> getCountries() {
        return new ArrayList<>(this.countries);
    }

    public static void main(String[] args) {
        CountryRepository repository = CountryRepository.getInstance();
        for (Country country : repository.getCountries()) {
            System.out.println(country);
        }
    }
}
