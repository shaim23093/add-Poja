package com.example.arith.endpoint.rest.controller.health;

import com.example.arith.Service.ServiceMultiplication;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping
public class ControleurMultiplication {
  private final ServiceMultiplication serviceMultiplication;

  @GetMapping("Mult")
  public double multiplication(@RequestParam double a, @RequestParam double b) {
    return serviceMultiplication.multiplication(a, b);
  }

  @ExceptionHandler({IllegalArgumentException.class})
  public ResponseEntity<String> handleException(RuntimeException ex) {
    return ResponseEntity.badRequest().body(ex.getMessage());
  }
}
