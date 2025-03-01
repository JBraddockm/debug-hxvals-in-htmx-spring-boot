package debug.address;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;

public record OpenStreetMapAddress(
    @JsonAlias({"office"}) @JsonProperty("amenity") String buildingName,
    @JsonProperty("house_number") String houseNumber,
    String road,
    @JsonProperty("city_district") String cityDistrict,
    String city,
    @JsonProperty("state_district") String stateDistrict,
    @JsonProperty("postcode") String postalCode,
    String country) {}
