package countries.queries;

import countries.model.Country;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

/**
 * Defines aggregation queries for {@link Country} objects.
 */
public interface AggregationCountryQueries {

    /**
     * Returns a dictionary which maps each country code to the corresponding country.
     *
     * @param countries the list of countries
     * @return the dictionary
     */
    Map<String, Country> getCountriesByCodes(
            List<Country> countries);

    /**
     * Returns a dictionary which maps each region to the count of its countries.
     *
     * @param countries the list of countries
     * @return the dictionary
     */
    Map<Country.Region, Long> getCountOfCountriesByRegions(
            List<Country> countries);

    /**
     * Returns a dictionary which maps each region to its countries.
     *
     * @param countries the list of countries
     * @return the dictionary
     */
    Map<Country.Region, Set<Country>> getCountriesByRegions(
            List<Country> countries);

    /**
     * Returns a dictionary which maps each region to its most populous country.
     *
     * @param countries the list of countries
     * @return the dictionary
     */
    Map<Country.Region, Optional<Country>> getMostPopulousCountryByRegions(
            List<Country> countries);

    /**
     * Returns a dictionary which maps each region the list of its countries ordered by their capital names to their continent.
     *
     * @param countries the list of countries
     * @return the dictionary
     */
    Map<Country.Region, List<Country>> getCountriesByRegionsOrderByCapitals(
            List<Country> countries);

    /**
     * Returns a dictionary which maps each region to the corresponding countries which population is between the given bounds (inclusive) to their continent.
     *
     * @param countries  the list of countries
     * @param lowerBound the lower bound
     * @param upperBound the upper bound
     * @return the dictionary
     */
    Map<Country.Region, Set<Country>> getCountriesByRegionsFilterByPopulation(
            List<Country> countries,
            long lowerBound,
            long upperBound);

    /**
     * Returns a dictionary which maps each region to the corresponding country codes, then each country code to the corresponding country.
     *
     * @param countries the list of countries
     * @return the dictionary
     */
    Map<Country.Region, Map<String, Country>> getCountriesByRegionsAndCodes(
            List<Country> countries);

    /**
     * Returns a dictionary which maps region to the letters that occur in the first place of corresponding
     * country names, then each letter to the corresponding countries.
     *
     * @param countries the list of countries
     * @return the dictionary
     */
    Map<Country.Region, Map<String, Set<Country>>> getCountriesByRegionsAndFirstLetters(
            List<Country> countries);

    /**
     * Returns a dictionary which maps the letters that occur in the first place of corresponding
     * country names to regions, then each letter to the corresponding countries.
     *
     * @param countries the list of countries
     * @return the dictionary
     */
    Map<String, Map<Country.Region, Set<Country>>> getCountriesByFirstLettersAndRegions(
            List<Country> countries);

    /**
     * Returns a dictionary which maps each region to the set of country names, using the given locale.
     *
     * @param countries the list of countries
     * @param locale    the locale
     * @return the dictionary
     */
    Map<Country.Region, Set<String>> getLocalizedCountryNamesByRegions(
            List<Country> countries,
            String locale);

    /**
     * Returns a dictionary which maps each locale to the corresponding country names.
     *
     * @param countries the list of countries
     * @return the dictionary
     */
    Map<String, Set<String>> getCountryNamesByLocales(
            List<Country> countries);

    /**
     * Returns a dictionary which maps each locale to the corresponding country names which countries are located in the given region.
     *
     * @param countries the list of countries
     * @param region    the region
     * @return the dictionary
     */
    Map<String, Set<String>> getCountryNamesByLocales(
            List<Country> countries,
            Country.Region region);

    /**
     * Returns a dictionary which maps each region to the country name which is the first in the given locale.
     *
     * @param countries the list of countries
     * @param locale    the locale
     * @return the dictionary
     */
    Map<Country.Region, Optional<String>> getFirstLocalizedCountryNamesByRegions(
            List<Country> countries,
            String locale);

    /**
     * Returns a dictionary which maps each region to the country which name is the first in the given locale.
     *
     * @param countries the list of countries
     * @param locale    the locale
     * @return the dictionary
     */
    Map<Country.Region, Optional<Country>> getFirstLocalizedCountriesByRegions(
            List<Country> countries,
            String locale);
}
