package com.example.arith.endpoint.rest.controller.health;

import com.example.arith.Service.ServiceSoustraction;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping
@RequiredArgsConstructor
@RestController
public class ControleurSoustraction {
    private final ServiceSoustraction serviceSoustraction;

    @GetMapping
    public double soustraction(@RequestParam double a, @RequestParam double b) {
        return serviceSoustraction.soustraction(a, b);
    }

    @ExceptionHandler({IllegalArgumentException.class})
    public ResponseEntity<String> handleException(RuntimeException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }
}
