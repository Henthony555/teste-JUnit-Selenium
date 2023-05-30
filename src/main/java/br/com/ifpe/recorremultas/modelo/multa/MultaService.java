package br.com.ifpe.recorremultas.modelo.multa;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ifpe.recorremultas.util.entity.GenericService;

@Service
public class MultaService extends GenericService {

   @Autowired
   private MultaRepository repository;

   @Transactional
   public Multa save(Multa multa) {

       super.preencherCamposAuditoria(multa);
       return repository.save(multa);
   }

}
