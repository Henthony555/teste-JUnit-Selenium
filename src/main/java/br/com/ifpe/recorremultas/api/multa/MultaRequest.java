package br.com.ifpe.recorremultas.api.multa;

import br.com.ifpe.recorremultas.modelo.multa.Multa;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MultaRequest {

    private String codigo;
 
    private String infracao;
 
    private Double valorMulta;
 
    private Integer pontosDescontados;
 
    private String grauMulta;
 

   public Multa build() {

       return Multa.builder()
               .codigo(codigo)
               .infracao(infracao)
               .valorMulta(valorMulta)
               .pontosDescontados(pontosDescontados)
               .grauMulta(grauMulta)
               .build();
   }
}
