package com.bysix.labseq;

import io.swagger.v3.oas.annotations.*;
import io.swagger.v3.oas.annotations.info.Info;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@OpenAPIDefinition(info = @Info(title = "Labsec API", version = "1.0", description = "Bysix Challenge API implementing a simple algorithm to calculate the Labsec sequence"))
class LabseqApplicationTests {

    @Test
    void contextLoads() {
    }

}
