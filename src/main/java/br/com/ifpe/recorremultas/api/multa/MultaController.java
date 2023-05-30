package br.com.ifpe.recorremultas.api.multa;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ifpe.recorremultas.modelo.multa.Multa;
import br.com.ifpe.recorremultas.modelo.multa.MultaService;
import br.com.ifpe.recorremultas.util.entity.GenericController;

@RestController
@RequestMapping("/api/multa")
public class MultaController extends GenericController {

   @Autowired
   private MultaService MultaService;

   @PostMapping
   public ResponseEntity<Multa> save(@RequestBody @Valid MultaRequest request) {

       Multa Multa = MultaService.save(request.build());
       return new ResponseEntity<Multa>(Multa, HttpStatus.CREATED);
   }
}
