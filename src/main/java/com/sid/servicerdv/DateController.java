package com.sid.servicerdv;


import com.sid.servicerdv.Date;
import com.sid.servicerdv.DateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/v1/rdv")
@RequiredArgsConstructor
public class DateController {

    private final DateRepository dateRepository;

    @PostMapping("/newdate")
    public ResponseEntity<String> saveDate(@RequestBody @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        try {
            dateRepository.save(new Date(date));
            return ResponseEntity.ok("Date saved successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error saving date");
        }
    }
}
