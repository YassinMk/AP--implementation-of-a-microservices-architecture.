package org.yassinmk.orderservice.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import feign.codec.Decoder;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.openfeign.support.SpringDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Configuration
public class FeignConfig {

    @Bean
    public Decoder feignDecoder(ObjectMapper objectMapper) {
        // Register the object mapper with HAL support
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setObjectMapper(objectMapper);

        // Get the list of message converters from RestTemplate
        List<HttpMessageConverter<?>> messageConverters = new RestTemplate().getMessageConverters();

        // Add your custom converter to the list
        messageConverters.add(converter);

        // Create an instance of HttpMessageConverters with the list of converters
        HttpMessageConverters httpMessageConverters = new HttpMessageConverters(messageConverters);

        return new SpringDecoder(() -> httpMessageConverters);
    }
}