package com.example.arith.endpoint.rest.controller.health;

import com.example.arith.Service.ServiceAddition;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping()
public class ControleurAddition {
    private final ServiceAddition serviceAddition;

    @GetMapping
    public double addition(@RequestParam double a, @RequestParam double b) {
        return serviceAddition.addition(a, b);
    }

    @ExceptionHandler({IllegalArgumentException.class})
    public ResponseEntity<String> handleException(RuntimeException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }
}
