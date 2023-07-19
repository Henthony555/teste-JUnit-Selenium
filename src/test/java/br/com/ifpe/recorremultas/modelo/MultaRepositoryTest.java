package br.com.ifpe.recorremultas.modelo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.ifpe.recorremultas.modelo.multa.Multa;
import br.com.ifpe.recorremultas.modelo.multa.MultaRepository;
 

@RunWith(SpringRunner.class)
@DataJpaTest // Configuração específica para testes com Spring Data JPA
public class MultaRepositoryTest {

    @Autowired
    private MultaRepository multaRepository;

    @Test
    public void testSaveMulta() {
        Multa multa = new Multa();
        multa.setCodigo("123");
        multa.setInfracao("Excesso de Velocidade");
        multa.setValorMulta(150.0);
        multa.setPontosDescontados(5);
        multa.setGrauMulta("Leve");

        multaRepository.save(multa);

        assertNotNull(multa.getId()); // Verifica se o ID foi gerado após a persistência
    }

    @Test
    public void testFindMultaById() {
        // Primeiro, salve uma multa no banco de dados para ser buscada posteriormente
        Multa multa = new Multa();
        multa.setCodigo("123");
        multa.setInfracao("Excesso de Velocidade");
        multa.setValorMulta(150.0);
        multa.setPontosDescontados(5);
        multa.setGrauMulta("Leve");
        multaRepository.save(multa);

        // Agora, busque a multa pelo ID
        Optional<Multa> multaEncontrada = multaRepository.findById(multa.getId());

        assertTrue(multaEncontrada.isPresent()); // Verifica se a multa foi encontrada
        assertEquals("123", multaEncontrada.get().getCodigo());
        assertEquals("Excesso de Velocidade", multaEncontrada.get().getInfracao());
        assertEquals(150.0, multaEncontrada.get().getValorMulta(), 0.001);
        assertEquals(5, multaEncontrada.get().getPontosDescontados().intValue());
        assertEquals("Leve", multaEncontrada.get().getGrauMulta());
    }

    @Test
    public void testFindAllMultas() {
        // Primeiro, salve algumas multas no banco de dados para serem buscadas posteriormente
        Multa multa1 = new Multa();
        multa1.setCodigo("123");
        multa1.setInfracao("Excesso de Velocidade");
        multa1.setValorMulta(150.0);
        multa1.setPontosDescontados(5);
        multa1.setGrauMulta("Leve");
        multaRepository.save(multa1);

        Multa multa2 = new Multa();
        multa2.setCodigo("456");
        multa2.setInfracao("Estacionar em local proibido");
        multa2.setValorMulta(200.0);
        multa2.setPontosDescontados(7);
        multa2.setGrauMulta("Média");
        multaRepository.save(multa2);

        // Agora, busque todas as multas
        List<Multa> multasEncontradas = multaRepository.findAll();

        assertEquals(2, multasEncontradas.size()); // Verifica se todas as multas foram encontradas
    }

    @Test
    public void testDeleteMulta() {
        // Primeiro, salve uma multa no banco de dados para ser deletada posteriormente
        Multa multa = new Multa();
        multa.setCodigo("123");
        multa.setInfracao("Excesso de Velocidade");
        multa.setValorMulta(150.0);
        multa.setPontosDescontados(5);
        multa.setGrauMulta("Leve");
        multaRepository.save(multa);

        // Agora, delete a multa
        multaRepository.delete(multa);

        // Tente buscar a multa pelo ID após a exclusão
        Optional<Multa> multaDeletada = multaRepository.findById(multa.getId());

        assertFalse(multaDeletada.isPresent()); // Verifica se a multa foi excluída
    }
}
