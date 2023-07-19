package br.com.ifpe.recorremultas.modelo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.ifpe.recorremultas.modelo.multa.Multa;
import br.com.ifpe.recorremultas.modelo.multa.MultaService;



@RunWith(SpringRunner.class)
@SpringBootTest // Configuração específica para testes com Spring Boot
public class MultaServiceTest {

    @Autowired
    private MultaService multaService;

    @Test
    @Transactional
    public void testSaveMulta() {
        Multa multa = new Multa();
        multa.setCodigo("123");
        multa.setInfracao("Excesso de Velocidade");
        multa.setValorMulta(150.0);
        multa.setPontosDescontados(5);
        multa.setGrauMulta("Leve");

        Multa savedMulta = multaService.save(multa);

        assertNotNull(savedMulta.getId()); // Verifica se o ID foi gerado após a persistência
    }

    @Test
    @Transactional
    public void testListAllMultas() {
        // Salve algumas multas no banco de dados para serem listadas posteriormente
        Multa multa1 = new Multa();
        multa1.setCodigo("123");
        multa1.setInfracao("Excesso de Velocidade");
        multa1.setValorMulta(150.0);
        multa1.setPontosDescontados(5);
        multa1.setGrauMulta("Leve");
        multaService.save(multa1);

        Multa multa2 = new Multa();
        multa2.setCodigo("456");
        multa2.setInfracao("Estacionar em local proibido");
        multa2.setValorMulta(200.0);
        multa2.setPontosDescontados(7);
        multa2.setGrauMulta("Média");
        multaService.save(multa2);

        // Busque todas as multas usando o serviço
        List<Multa> multasEncontradas = multaService.listAll();

        assertEquals(2, multasEncontradas.size()); // Verifica se todas as multas foram encontradas
    }

    @Test
    @Transactional
    public void testListMultaById() {
        // Primeiro, salve uma multa no banco de dados para ser buscada posteriormente
        Multa multa = new Multa();
        multa.setCodigo("123");
        multa.setInfracao("Excesso de Velocidade");
        multa.setValorMulta(150.0);
        multa.setPontosDescontados(5);
        multa.setGrauMulta("Leve");
        Multa savedMulta = multaService.save(multa);

        // Busque a multa pelo ID usando o serviço
        Multa multaEncontrada = multaService.listById(savedMulta.getId());

        assertNotNull(multaEncontrada); // Verifica se a multa foi encontrada
        assertEquals("123", multaEncontrada.getCodigo());
        assertEquals("Excesso de Velocidade", multaEncontrada.getInfracao());
        assertEquals(150.0, multaEncontrada.getValorMulta(), 0.001);
        assertEquals(5, multaEncontrada.getPontosDescontados().intValue());
        assertEquals("Leve", multaEncontrada.getGrauMulta());
    }

    @Test
    @Transactional
    public void testUpdateMulta() {
        // Primeiro, salve uma multa no banco de dados para ser atualizada posteriormente
        Multa multa = new Multa();
        multa.setCodigo("123");
        multa.setInfracao("Excesso de Velocidade");
        multa.setValorMulta(150.0);
        multa.setPontosDescontados(5);
        multa.setGrauMulta("Leve");
        Multa savedMulta = multaService.save(multa);

        // Modifique alguns atributos da multa
        Multa multaAlterada = new Multa();
        multaAlterada.setCodigo("456");
        multaAlterada.setInfracao("Estacionar em local proibido");
        multaAlterada.setValorMulta(200.0);
        multaAlterada.setPontosDescontados(7);
        multaAlterada.setGrauMulta("Média");

        // Atualize a multa usando o serviço
        multaService.update(savedMulta.getId(), multaAlterada);

        // Busque a multa atualizada pelo ID
        Multa multaAtualizada = multaService.listById(savedMulta.getId());

        assertEquals("456", multaAtualizada.getCodigo());
        assertEquals("Estacionar em local proibido", multaAtualizada.getInfracao());
        assertEquals(200.0, multaAtualizada.getValorMulta(), 0.001);
        assertEquals(7, multaAtualizada.getPontosDescontados().intValue());
        assertEquals("Média", multaAtualizada.getGrauMulta());
    }

    @Test
    @Transactional
    public void testDeleteMulta() {
        // Primeiro, salve uma multa no banco de dados para ser deletada posteriormente
        Multa multa = new Multa();
        multa.setCodigo("123");
        multa.setInfracao("Excesso de Velocidade");
        multa.setValorMulta(150.0);
        multa.setPontosDescontados(5);
        multa.setGrauMulta("Leve");
        Multa savedMulta = multaService.save(multa);

        // Exclua a multa usando o serviço
        multaService.delete(savedMulta.getId());

        // Tente buscar a multa pelo ID após a exclusão
        Multa multaDeletada = multaService.listById(savedMulta.getId());

        assertNull(multaDeletada); // Verifica se a multa foi excluída
    }
}
