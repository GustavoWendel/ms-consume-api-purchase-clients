package com.br.spring.api.desafioibm.infra.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.introspect.VisibilityChecker;
import com.fasterxml.jackson.databind.type.TypeFactory;
import feign.Util;
import feign.codec.Decoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PurchaseClientConfig {

    @Bean
    public Decoder feignDecoder() {
        return ((response, type) -> {
            String bodyStr = Util.toString(response.body().asReader(Util.UTF_8));
            JavaType javaType = TypeFactory.defaultInstance().constructType(type);
            return new ObjectMapper()
                    .disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
                    .setVisibility(VisibilityChecker.Std.defaultInstance().withFieldVisibility(JsonAutoDetect.Visibility.ANY))
                    .readValue(bodyStr, javaType);
        });
    }
}
