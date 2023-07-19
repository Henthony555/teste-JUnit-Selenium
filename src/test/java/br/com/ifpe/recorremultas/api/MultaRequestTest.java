package br.com.ifpe.recorremultas.api;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.com.ifpe.recorremultas.api.multa.MultaRequest;
import br.com.ifpe.recorremultas.modelo.multa.Multa;

public class MultaRequestTest {

    @Test
    public void testBuildMultaFromMultaRequest() {
        // Criar uma instância de MultaRequest e configurar suas propriedades
        MultaRequest multaRequest = new MultaRequest();
        multaRequest.setCodigo("123");
        multaRequest.setInfracao("Excesso de Velocidade");
        multaRequest.setValorMulta(150.0);
        multaRequest.setPontosDescontados(5);
        multaRequest.setGrauMulta("Leve");

        // Obter uma instância de Multa através do método build()
        Multa multa = multaRequest.build();

        // Verificar se as propriedades da Multa estão corretas
        assertEquals("123", multa.getCodigo());
        assertEquals("Excesso de Velocidade", multa.getInfracao());
        assertEquals(150.0, multa.getValorMulta(), 0.001);
        assertEquals(5, multa.getPontosDescontados().intValue());
        assertEquals("Leve", multa.getGrauMulta());
    }

    @Test
    public void testMultaRequestProperties() {
        // Criar uma instância de MultaRequest e configurar suas propriedades
        MultaRequest multaRequest = new MultaRequest();
        multaRequest.setCodigo("456");
        multaRequest.setInfracao("Estacionar em local proibido");
        multaRequest.setValorMulta(200.0);
        multaRequest.setPontosDescontados(7);
        multaRequest.setGrauMulta("Média");

        // Verificar se as propriedades de MultaRequest estão corretas
        assertEquals("456", multaRequest.getCodigo());
        assertEquals("Estacionar em local proibido", multaRequest.getInfracao());
        assertEquals(200.0, multaRequest.getValorMulta(), 0.001);
        assertEquals(7, multaRequest.getPontosDescontados().intValue());
        assertEquals("Média", multaRequest.getGrauMulta());
    }
}

