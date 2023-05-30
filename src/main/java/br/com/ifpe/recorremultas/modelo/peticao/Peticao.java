Package br.com.ifpe.recorremultas.modelo.peticao;
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
@Table(name = "Petição")
@Where(clause = "habilitado = true")

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Peticao extends EntidadeAuditavel  {

   @Column
   Private String nomeCompleto;
   @Column
   Private String nacionalidade;
   @Column
   Private String estadoCivil;
   @Column
   Private String profissao;
   @Column
   Private String cnh;
   @Column
   Private String orgaoExpeditor;
   @Column
   Private String cpf;
   @Column
   Private String telefone;
   @Column
   Private String enderecoCompleto;
   @Column
   Private String marcaModelo;
   @Column
   Private String placa;
   @Column
   Private String renavam;
   @Column
   Private String chassi;
   @Column
   Private LocalDate dataMulta;
   @Column
   Private String orgaoEmissor;
   @Column
   Private String notificacao;
   @Column
   Private String justificativaCancelamento;

}
