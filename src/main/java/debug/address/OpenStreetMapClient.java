package debug.address;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
@RequiredArgsConstructor
public class OpenStreetMapClient {
  private final RestClient osmRestClient;

  private final String OSM_NOMINATIM_API_BASE_URL = "nominatim.openstreetmap.org";

  public List<NominatimAPIResponseDTO> searchLocation(String query) {
    List<NominatimClientAPIResponse<OpenStreetMapAddress, String>> nominatimClientAPIResponseList =
        osmRestClient
            .get()
            .uri(
                uriBuilder ->
                    uriBuilder
                        .scheme("https")
                        .host(OSM_NOMINATIM_API_BASE_URL)
                        .path("/search")
                        .queryParam("q", query)
                        .queryParam("format", "jsonv2")
                        .queryParam("addressdetails", 1)
                        .queryParam("countrycodes", "gb")
                        .queryParam("limit", 5)
                        .build())
            .accept(MediaType.APPLICATION_JSON)
            .retrieve()
            .onStatus(
                HttpStatusCode::is4xxClientError,
                (request, response) -> {
                  throw new AddressNotFoundException(
                      response.getStatusCode(), response.getStatusText());
                })
            .body(new ParameterizedTypeReference<>() {});

    // @TODO OSM returns empty list with 200 when no result is found.

    assert nominatimClientAPIResponseList != null && !nominatimClientAPIResponseList.isEmpty();

    return nominatimClientAPIResponseList.stream()
        .map(osma -> new NominatimAPIResponseDTO(osma.displayName(), osma.address()))
        .toList();
  }
}
