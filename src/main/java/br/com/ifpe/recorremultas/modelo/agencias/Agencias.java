package br.com.ifpe.recorremultas.modelo.agencias;

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
@Table(name = "Agencias")
@Where(clause = "habilitado = true")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Agencias extends EntidadeAuditavel {

    @Column
    private String nomeAgencia;

    @Column
    private String latitude;

    @Column
    private String longitude;

}
