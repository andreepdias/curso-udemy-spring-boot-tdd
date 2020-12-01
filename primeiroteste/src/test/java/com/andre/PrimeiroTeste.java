package com.andre;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class PrimeiroTeste {

    @Mock
    Calculadora calculadora;

     int n1 = 10, n2 = 5;

    @BeforeEach
    public void setUp(){
        calculadora = new Calculadora();
    }

    @Test
    public void deveSomer2Numeros(){
        // Cenário
        // int n1 = 10, n2 = 5;

        // Execução
        int r = calculadora.somar(n1, n2);

        // Verificações
        Assertions.assertThat(r).isEqualTo(15);
    }

    @Test
    public void naoDeveSomarNumerosNegativos(){
        int n1 = -10, n2 = 5;

        org.junit.jupiter.api.Assertions
                .assertThrows(RuntimeException.class, () -> calculadora.somar(n1, n2));
    }

    @Test
    public void deveSubtrair2Numeros(){
        int r = calculadora.subtrair(n1, n2);

        Assertions.assertThat(r).isEqualTo(5);
    }
}

class Calculadora {
    int somar(int n1, int n2){
        if(n1 < 0 || n2 < 0){
            throw new RuntimeException("Não é permitido somar números negativos.");
        }
        return n1 + n2;
    }

    int subtrair(int n1, int n2){
        return n1 - n2;
    }
}