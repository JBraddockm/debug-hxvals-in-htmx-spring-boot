package debug.address;

import io.github.wimdeblauwe.htmx.spring.boot.mvc.HxRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.FragmentsRendering;

@Controller
@RequestMapping("addresses")
@RequiredArgsConstructor
public class AddressController {

  private final OpenStreetMapClient openStreetMapClient;

  @GetMapping("/lookup")
  @HxRequest
  public View addressLookup(@RequestParam String query, Model model) {

    model.addAttribute("locations", openStreetMapClient.searchLocation(query));

    return FragmentsRendering.with("address/fragments/address-lookup").build();
  }

  @PostMapping("/select")
  @HxRequest
  public View addressSelect(
      @RequestParam String buildingName,
      @RequestParam String houseNumber,
      @RequestParam String road,
      @RequestParam String city,
      @RequestParam String postalCode,
      @RequestParam String country,
      Model model) {

    model.addAttribute(
        "address",
        new Address(
            buildingName,
            "%s %s".formatted(houseNumber, road),
            "",
            city,
            postalCode,
            country));
    return FragmentsRendering.with("address/fragments/address-select").build();
  }
}
