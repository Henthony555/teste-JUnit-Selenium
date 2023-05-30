package br.com.ifpe.recorremultas.modelo.agencias;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ifpe.recorremultas.util.entity.GenericService;

@Service
public class AgenciasService extends GenericService {

   @Autowired
   private AgenciasRepository repository;

   @Transactional
   public Agencias save(Agencias agencias) {

       super.preencherCamposAuditoria(agencias);
       return repository.save(agencias);
   }

}

