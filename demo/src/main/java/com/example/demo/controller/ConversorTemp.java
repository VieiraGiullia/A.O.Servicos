package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConversorTemp {

    @GetMapping("/celsiusParaFahrenheit")
    public double celsiusToFahrenheit(@RequestParam double grau) {
        return grau * 9 / 5 + 32;
    }

    @GetMapping("/fahrenheitParaCelsius")
    public double fahrenheitToCelsius(@RequestParam double grau) {
        return (grau - 32) * 5 / 9;
    }
}
