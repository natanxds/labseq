package com.bysix.labseq;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(info = @Info(title = "Labseq API", version = "1.0", description = "Documentation Labseq API v1.0"))
@SpringBootApplication
public class LabseqApplication {

    public static void main(String[] args) {
        SpringApplication.run(LabseqApplication.class, args);
    }

}
