package br.com.ifpe.recorremultas.api.agencias;

import br.com.ifpe.recorremultas.modelo.agencias.Agencias;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AgenciasRequest {

    private String nomeAgencia;

    private String latitude;

    private String longitude;

   public Agencias build() {

       return Agencias.builder()
               .nomeAgencia(nomeAgencia)
               .latitude(latitude)
               .longitude(longitude)
               .build();
   }
}

