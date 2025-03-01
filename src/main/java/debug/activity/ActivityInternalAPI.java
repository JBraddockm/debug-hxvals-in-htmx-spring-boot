package debug.activity;

import debug.activity.dto.ActivityCreationParameters;

public interface ActivityInternalAPI {
  ActivityCreationParameters createActivity(ActivityCreationParameters activityCreationParameters);
}
