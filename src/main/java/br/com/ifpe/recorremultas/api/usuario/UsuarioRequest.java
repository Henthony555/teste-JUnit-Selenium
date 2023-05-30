package br.com.ifpe.recorremultas.api.usuario;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.ifpe.recorremultas.modelo.usuario.Usuario;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioRequest {
    
    private String nomeCompleto;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataNascimento;
 
    private String cpf;
 
    private String email;
 
    private String senha;
 
    public Usuario build() {
 
        return Usuario.builder()
                .nomeCompleto(nomeCompleto)
                .dataNascimento(dataNascimento) 
                .cpf(cpf)
                .email(email)
                .senha(senha)
                .build();
        }

}
