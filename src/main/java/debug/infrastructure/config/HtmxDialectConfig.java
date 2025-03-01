package debug.infrastructure.config;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.json.JsonMapper;
import io.github.wimdeblauwe.htmx.spring.boot.thymeleaf.HtmxDialect;
import java.io.IOException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

//@Configuration
public class HtmxDialectConfig {

  @Bean
  @Primary
  public HtmxDialect customHtmxDialect() {
    JsonSerializer<Object> nullSerializer =
        new JsonSerializer<>() {
          @Override
          public void serialize(Object value, JsonGenerator gen, SerializerProvider serializers)
              throws IOException {
            gen.writeString("");
          }
        };

    JsonMapper jsonMapper = JsonMapper.builder().build();

    jsonMapper.getSerializerProvider().setNullValueSerializer(nullSerializer);

    return new HtmxDialect(jsonMapper);
  }
}
