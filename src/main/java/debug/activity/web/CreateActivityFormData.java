package debug.activity.web;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateActivityFormData {
  private String buildingName;
  private String addressLine1;
  private String addressLine2;
  private String city;
  private String postalCode;
  private String country;
}