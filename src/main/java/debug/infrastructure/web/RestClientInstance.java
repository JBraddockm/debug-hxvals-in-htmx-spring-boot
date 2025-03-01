package debug.infrastructure.web;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
public class RestClientInstance {

  @Bean
  RestClient restClient(RestClient.Builder builder) {
    return builder.build();
  }
}
