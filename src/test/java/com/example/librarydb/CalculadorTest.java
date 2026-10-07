package com.example.librarydb;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.librarydb.service.Calculadora;

public class CalculadorTest {
    private Calculadora calcular;
    @BeforeEach 
    void setup(){
        calcular = new Calculadora();
    }
    @Test 
    void deseoSumar2NrosPositivos(){
        Double resultado = calcular.sumar(5.0,6.0);
        assertEquals(11, resultado);
    }

}
