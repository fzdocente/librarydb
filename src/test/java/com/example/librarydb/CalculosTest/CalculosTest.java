package com.example.librarydb.CalculosTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.librarydb.service.Calculos;

public class CalculosTest {
    private Calculos sumar1;
    @BeforeEach 
    void setup(){
        sumar1 = new Calculos();
    }
    @Test 
    void deseoSumarDosNumerosPositivos(){
        int resultado = sumar1.sumar(2,5);
        assertEquals(7, resultado);
    }

}
