package br.com.ifpe.recorremultas.modelo.peticao;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Where;

import br.com.ifpe.recorremultas.util.entity.EntidadeAuditavel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Entity
@Table(name = "Peticao")
@Where(clause = "habilitado = true")

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Peticao extends EntidadeAuditavel  {

   @Column
   private String nomeCompleto;
   @Column
   private String nacionalidade;
   @Column
   private String estadoCivil;
   @Column
   private String profissao;
   @Column
   private String cnh;
   @Column
   private String orgaoExpeditor;
   @Column
   private String cpf;
   @Column
   private String telefone;
   @Column
   private String enderecoCompleto;
   @Column
   private String marcaModelo;
   @Column
   private String placa;
   @Column
   private String renavam;
   @Column
   private String chassi;
   @Column
   private LocalDate dataMulta;
   @Column
   private String orgaoEmissor;
   @Column
   private String notificacao;
   @Column
   private String justificativaCancelamento;

}
