package br.com.ifpe.recorremultas.api.peticao;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ifpe.recorremultas.modelo.peticao.Peticao;
import br.com.ifpe.recorremultas.modelo.peticao.PeticaoService;
import br.com.ifpe.recorremultas.util.entity.GenericController;

@RestController
@RequestMapping("/api/peticao")
public class PeticaoController extends GenericController {

   @Autowired
   private PeticaoService peticaoService;

   @PostMapping
   public ResponseEntity<Peticao> save(@RequestBody @Valid PeticaoRequest request) {

      Peticao peticao = peticaoService.save(request.build());
       return new ResponseEntity<Peticao>(peticao, HttpStatus.CREATED);
   }

   @GetMapping
   public List<Peticao> listarTodos() {
  
       return peticaoService.listarTodos();
   }

   @GetMapping("/{id}")
   public Peticao obterPorID(@PathVariable Long id) {

       return peticaoService.obterPorID(id);
   }

   @PutMapping("/{id}")
   public ResponseEntity<Peticao>update(@PathVariable("id") Long id, @RequestBody PeticaoRequest request) {

      peticaoService.update(id, request.build());
       return ResponseEntity.ok().build();
   }

   @DeleteMapping("/{id}")
   public ResponseEntity<Void> delete(@PathVariable Long id) {

        peticaoService.delete(id);
       return ResponseEntity.ok().build();
   }

}

