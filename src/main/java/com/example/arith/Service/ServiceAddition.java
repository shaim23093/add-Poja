package com.example.arith.Service;

import org.springframework.stereotype.Service;

@Service
public class ServiceAddition {
  private void validerPositif(double a, double b) {
    if (a < 0 || b < 0) {
      throw new IllegalArgumentException("Les valeurs de a et b doivent être positives");
    }
  }

  public double addition(double a, double b) {
    validerPositif(a, b);
    return a + b;
  }
}
