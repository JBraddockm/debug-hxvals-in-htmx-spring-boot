package debug.activity.web;

import debug.activity.ActivityInternalAPI;
import debug.activity.mapper.ActivityMapper;
import debug.address.Address;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/activities")
@RequiredArgsConstructor
public class ActivityController {
  private final ActivityInternalAPI activityInternalAPI;
  private final ActivityMapper activityMapper;


  @GetMapping("/create")
  public String create(Model model) {
    model.addAttribute("activity", new CreateActivityFormData());
    return "activity/create";
  }

  @PostMapping("/create")
  public String create(
      @ModelAttribute("activity") CreateActivityFormData activityFormData) {

    activityInternalAPI.createActivity(
        activityMapper.toActivityCreationParameters(activityFormData));
    return "redirect:/activities/create";
  }
}
