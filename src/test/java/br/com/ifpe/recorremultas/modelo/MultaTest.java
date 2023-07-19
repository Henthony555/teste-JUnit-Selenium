package br.com.ifpe.recorremultas.modelo;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import br.com.ifpe.recorremultas.modelo.multa.Multa;

public class MultaTest {

    @Test
    public void testGettersAndSetters() {
        Multa multa = new Multa();
        multa.setCodigo("123");
        multa.setInfracao("Excesso de Velocidade");
        multa.setValorMulta(150.0);
        multa.setPontosDescontados(5);
        multa.setGrauMulta("Leve");

        assertEquals("123", multa.getCodigo());
        assertEquals("Excesso de Velocidade", multa.getInfracao());
        assertEquals(150.0, multa.getValorMulta(), 0.001);
        assertEquals(5, multa.getPontosDescontados().intValue());
        assertEquals("Leve", multa.getGrauMulta());
    }

    @Test
    public void testGettersAndSetters2() {
        Multa multa = new Multa();
        multa.setCodigo("123");
        multa.setInfracao("Excesso de Velocidade");
        multa.setValorMulta(150.0); 
        multa.setPontosDescontados(5);
        multa.setGrauMulta("Leve");

        assertEquals("123", multa.getCodigo());
        assertEquals("Excesso de Velocidade", multa.getInfracao());
        assertEquals(200.0, multa.getValorMulta(), 0.001); 
        assertEquals(5, multa.getPontosDescontados().intValue());
        assertEquals("Leve", multa.getGrauMulta());
    }
}


