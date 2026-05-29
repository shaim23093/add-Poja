package com.example.arith.endpoint.rest.controller.health;

import com.example.arith.Service.ServiceDivision;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping
public class ControleurDivision {
  private final ServiceDivision serviceDivision;

  @GetMapping("/div")
  public double division(@RequestParam double a, @RequestParam double b) {
    return serviceDivision.division(a, b);
  }

  @ExceptionHandler({IllegalArgumentException.class, ArithmeticException.class})
  public ResponseEntity<String> handleException(RuntimeException ex) {
    return ResponseEntity.badRequest().body(ex.getMessage());
  }
}
