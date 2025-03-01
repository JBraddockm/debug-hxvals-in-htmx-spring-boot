package debug.address;

import java.io.Serializable;

public record Address(
    String buildingName,
    String addressLine1,
    String addressLine2,
    String city,
    String postalCode,
    String country)
    implements Serializable {}
