package tech.artcoded.websitev2.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class BrainDeadApplication {
    public static void main(String[] args) {
        SpringApplication.run(BrainDeadApplication.class, args);
    }
}
