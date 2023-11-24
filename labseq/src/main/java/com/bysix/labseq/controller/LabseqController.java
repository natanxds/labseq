package com.bysix.labseq.controller;

import com.bysix.labseq.dto.LabsecResponse;
import com.bysix.labseq.service.LabseqService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "labseq", produces = "application/json")
@Tag(name = "Labseq API")
@AllArgsConstructor
@Slf4j
public class LabseqController {

    private final LabseqService labseqService;

    @Operation(summary = "Get Labseq by number", method = "GET", description = "Returns the Labseq value for the given number")
    @ApiResponse(responseCode = "200", description = "Success", content = @Content(mediaType = "application/json", schema = @Schema(implementation = LabsecResponse.class)))
    @ApiResponse(responseCode = "400", description = "Number must be positive")
    @GetMapping("/{number}")
    public ResponseEntity<Object> getLabseq(@PathVariable("number") long number) {
        log.info("Request received for number: " + number);
        return labseqService.getLabseq(number);
    }
}
