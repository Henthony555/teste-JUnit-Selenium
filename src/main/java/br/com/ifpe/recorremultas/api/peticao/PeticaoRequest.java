package br.com.ifpe.recorremultas.api.peticao;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.ifpe.recorremultas.modelo.peticao.Peticao;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PeticaoRequest {

   private String nomeCompleto;

   private String nacionalidade;

   private String estadoCivil;

   private String profissao;

   private String cnh;

   private String orgaoExpeditor;

   private String cpf;

   private String telefone;

   private String enderecoCompleto;

   private String marcaModelo;

   private String placa;

   private String renavam;

   private String chassi;

   @JsonFormat(pattern = "dd/MM/yyyy")
   private LocalDate dataMulta;

   private String orgaoEmissor;

   private String notificacao;

   private String justificativaCancelamento;

   public Peticao build() {

       return Peticao.builder()
               .nomeCompleto(nomeCompleto)
               .nacionalidade(nacionalidade)
               .estadoCivil(estadoCivil)
               .profissao(profissao)
               .cnh(cnh)
               .cpf(cpf)
               .orgaoExpeditor(orgaoExpeditor)
               .telefone(telefone)
               .enderecoCompleto(enderecoCompleto)
               .marcaModelo(marcaModelo)
               .placa(placa)
               .renavam(renavam)
               .chassi(chassi)
               .dataMulta(dataMulta)
               .orgaoEmissor(orgaoEmissor)
               .notificacao(notificacao)
               .justificativaCancelamento(justificativaCancelamento)
               .build();
              
   }
}
