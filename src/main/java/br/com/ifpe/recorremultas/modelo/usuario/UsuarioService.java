package br.com.ifpe.recorremultas.modelo.usuario;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ifpe.recorremultas.util.entity.GenericService;

@Service
public class UsuarioService extends GenericService {
    
    @Autowired
    private UsuarioRepository repository;
 
    @Transactional
    public Usuario save(Usuario usuario) {
 
        super.preencherCamposAuditoria(usuario);
        return repository.save(usuario);
    }
 
    public List<Usuario> listarTodos() {
   
     return repository.findAll();
 }
 
 public Usuario obterPorID(Long id) {
 
     return repository.findById(id).get();
 }

}
