package com.example.AnywaySpringBoot;

import com.example.AnywaySpringBoot.REST1.ConsumRest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class REST {

  private static final Logger log = LoggerFactory.getLogger(REST.class);

  public static void main(String[] args) {
    SpringApplication.run(REST.class, args);
  }

  @Bean
  public RestTemplate restTemplate(RestTemplateBuilder builder) {
    return builder.build();
  }

  @Bean
  public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
    return args -> {
      ConsumRest quote =
          restTemplate.getForObject("https://quoters.apps.pcfone.io/api/random", ConsumRest.class);
      log.info(quote.toString());
    };
  }

}
