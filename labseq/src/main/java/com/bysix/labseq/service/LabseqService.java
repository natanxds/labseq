package com.bysix.labseq.service;

import com.bysix.labseq.dto.LabsecResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class LabseqService {

    public ResponseEntity<Object> getLabseq(long number) {
        log.info("getLabseq called with number: {}", number);
        if (number < 0) {
            log.warn("Number must be positive, but was: {}", number);
            return ResponseEntity.badRequest().body("Number must be positive");
        }

        long result = calculateLabseq(number);
        log.info("getLabseq result for number {}: {}", number, result);
        return ResponseEntity.ok().body(new LabsecResponse(calculateLabseq(number)));
    }
    @Cacheable("labseq")
    public long calculateLabseq(long number) {
        log.info("Calculating labseq for number: {}", number);

        if (number < 4) {
            return number % 2;
        }

        long[] labseq = new long[4];
        labseq[0] = 0;
        labseq[1] = 1;
        labseq[2] = 0;
        labseq[3] = 1;

        for (int i = 4; i <= number; i++) {
            long temp = labseq[0] + labseq[1];
            labseq[0] = labseq[1];
            labseq[1] = labseq[2];
            labseq[2] = labseq[3];
            labseq[3] = temp;
            log.debug("Calculated labseq[{}] = {}", i, labseq[3]);
        }

        log.info("Finished calculating labseq for number: {}", number);
        return labseq[3];
    }
}
