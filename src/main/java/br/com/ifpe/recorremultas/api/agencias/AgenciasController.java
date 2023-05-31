package br.com.ifpe.recorremultas.api.agencias;

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

    @GetMapping
    public List<Agencias> listarTodos() {

        return agenciasService.listarTodos();
    }

    @GetMapping("/{id}")
    public Agencias obterPorID(@PathVariable Long id) {

        return agenciasService.obterPorID(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Agencias> update(@PathVariable("id") Long id, @RequestBody AgenciasRequest request) {

        agenciasService.update(id, request.build());
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {

        agenciasService.delete(id);
        return ResponseEntity.ok().build();
    }

}
