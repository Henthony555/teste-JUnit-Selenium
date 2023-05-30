package br.com.ifpe.recorremultas.modelo.multa;

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
@Table(name = "Multa")
@Where(clause = "habilitado = true")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Multa extends EntidadeAuditavel  {

   @Column
   private String codigo;

   @Column
   private String infracao;

   @Column
   private Double valorMulta;

   @Column
   private Integer pontosDescontados;

   @Column
   private String grauMulta;

}
