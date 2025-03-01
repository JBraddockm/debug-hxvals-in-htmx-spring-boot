package debug.address;

import org.springframework.http.HttpStatusCode;

public class AddressNotFoundException extends RuntimeException {
  public AddressNotFoundException(HttpStatusCode status, String message) {
    super("Open Street Map API request failed with status [%s]: %s".formatted(status, message));
  }
}
