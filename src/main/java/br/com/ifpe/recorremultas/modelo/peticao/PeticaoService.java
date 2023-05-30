package br.com.ifpe.oxefood.modelo.peticao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ifpe.recorremultas.util.entity.GenericService;

@Service
public class PeticaoService extends GenericService {

    @Transactional
    public void update(Long id, Peticao peticaoAlterado) {
 
       Peticao peticao = repository.findById(id).get();
       peticao.setNome(peticaoAlterado.getNome());
       peticao.setDataNascimento(peticaoAlterado.getDataNascimento());
       peticao.setCpf(peticaoAlterado.getCpf());
       peticao.setFoneCelular(peticaoAlterado.getFoneCelular());
       peticao.setFoneFixo(peticaoAlterado.getFoneFixo());
         
       super.preencherCamposAuditoria(peticao);
       repository.save(peticao);
   }

   @Autowired
   private PeticaoRepository repository;

   @Transactional
   public Peticao save(Peticao peticao) {

       super.preencherCamposAuditoria(peticao);
       return repository.save(peticao);
   }

   public List<Peticao> listarTodos() {
  
    return repository.findAll();
}

public Peticao obterPorID(Long id) {

    return repository.findById(id).get();
}

  

}

