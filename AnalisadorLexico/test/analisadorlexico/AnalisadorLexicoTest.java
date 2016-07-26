/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package analisadorlexico;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Anderson Queiroz
 */
public class AnalisadorLexicoTest {
    
    String cadeia, identificador, numero, caracter, palavra;
    AnalisadorLexico analisar;
    String reservadas[] = {"programa", "const", "var", "funcao", "inicio", "fim",
        "se", "entao", "senao", "enquanto", "faca", "leia", "escreva", "inteiro",
        "real", "booleano", "verdadeiro", "falso", "cadeia", "caractere"};
    
    
    @Before
    public void setUp() {
        cadeia = "\"qualquer coisa ele aceita &%&#!23u(/)NJAS \"";
        identificador = "test_123;";
        numero = "12.54;";
        caracter = "\'A\'";
        palavra = "inicio";
        analisar = new AnalisadorLexico();
    }

    @Test
    public void palavrasReservadas() {
        for (int i = 0; i < reservadas.length; i++)
        {
            palavra = reservadas[i];            
            assertTrue(analisar.automatoPalavraReservada(palavra));
        }
        
        palavra = "test";
        assertFalse(analisar.automatoPalavraReservada(palavra));
        
        palavra = "qualquer coisa";
        assertFalse(analisar.automatoPalavraReservada(palavra));
        
        palavra = "\"inicio";
        assertFalse(analisar.automatoPalavraReservada(palavra));
        
        palavra = "programe";
        assertFalse(analisar.automatoPalavraReservada(palavra));        
    }
    
      @Test
    public void autoNumero() {
        assertTrue(analisar.automatoNumero(numero));
        
        numero = ".123";
        assertFalse(analisar.automatoNumero(numero));
        
        numero = "123";
        assertFalse(analisar.automatoNumero(numero));
        
        numero = "10985;";
        assertTrue(analisar.automatoNumero(numero));
        
        numero = "a13;";
        assertFalse(analisar.automatoNumero(numero));
        
        numero = "12.a";
        assertFalse(analisar.automatoNumero(numero));
        
        numero = "12+";
        assertTrue(analisar.automatoNumero(numero));
        
    }
    
    @Test
    public void automatoIdentificador() {
        assertTrue(analisar.automatoIdentificador(identificador));
        
        identificador = "qualquer;";
        assertTrue(analisar.automatoIdentificador(identificador));
        
        identificador = "qualquer.123;";
        assertFalse(analisar.automatoIdentificador(identificador));
        
        identificador = "qualquer+123;";
        assertFalse(analisar.automatoIdentificador(identificador));
        
        
    }
    
    
    
}
