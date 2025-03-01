package debug.activity.mapper;


import debug.activity.dto.ActivityCreationParameters;
import debug.activity.model.Activity;
import debug.activity.web.CreateActivityFormData;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ActivityMapper {

  @Mapping(source = "buildingName", target = "address.buildingName")
  @Mapping(source = "addressLine1", target = "address.addressLine1")
  @Mapping(source = "addressLine2", target = "address.addressLine2")
  @Mapping(source = "city", target = "address.city")
  @Mapping(source = "postalCode", target = "address.postalCode")
  @Mapping(source = "country", target = "address.country")
  ActivityCreationParameters toActivityCreationParameters(CreateActivityFormData formData);


  default Activity toActivity(ActivityCreationParameters activityCreationParameters) {
    return new Activity(
            activityCreationParameters.address());
  }
}
