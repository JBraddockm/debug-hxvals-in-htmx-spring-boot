package debug.address;

import com.fasterxml.jackson.annotation.JsonProperty;

public record NominatimClientAPIResponse<T, V>(
    T address, @JsonProperty("display_name") V displayName) {}
