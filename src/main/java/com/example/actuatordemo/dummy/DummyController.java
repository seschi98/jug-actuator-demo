package com.example.actuatordemo.dummy;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dummy")
@RequiredArgsConstructor
public class DummyController {

    private final DummyService dummyService;

    @GetMapping
    public ResponseEntity<?> getDummy() {
        dummyService.doSomething();
        return ResponseEntity.ok("dummy");
    }

}
