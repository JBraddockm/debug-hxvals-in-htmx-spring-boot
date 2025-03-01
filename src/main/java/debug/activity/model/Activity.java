package debug.activity.model;

import debug.address.Address;
import java.io.Serializable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@Getter
@ToString
public class Activity implements Serializable {
  private Address address;

  public Activity(Address address) {
    this.address = address;
  }
}
