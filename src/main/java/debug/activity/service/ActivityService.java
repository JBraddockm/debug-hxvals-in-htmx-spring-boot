package debug.activity.service;

import debug.activity.ActivityInternalAPI;
import debug.activity.dto.ActivityCreationParameters;
import debug.activity.mapper.ActivityMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ActivityService implements ActivityInternalAPI {
  private final ActivityMapper activityMapper;

  @Override
  public ActivityCreationParameters createActivity(
      ActivityCreationParameters activityCreationParameters) {
    System.out.println("Address: " + activityMapper.toActivity(activityCreationParameters).toString());
    return activityCreationParameters;
  }
}
