package br.com.ifpe.recorremultas.api.agencias;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ifpe.recorremultas.modelo.agencias.Agencias;
import br.com.ifpe.recorremultas.modelo.agencias.AgenciasService;
import br.com.ifpe.recorremultas.util.entity.GenericController;

@RestController
@RequestMapping("/api/agencias")
public class AgenciasController extends GenericController {

   @Autowired
   private AgenciasService agenciasService;

   @PostMapping
   public ResponseEntity<Agencias> save(@RequestBody @Valid AgenciasRequest request) {

       Agencias agencias = agenciasService.save(request.build());
       return new ResponseEntity<Agencias>(agencias, HttpStatus.CREATED);
   }
}

