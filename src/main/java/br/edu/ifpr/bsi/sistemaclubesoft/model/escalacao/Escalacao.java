package br.edu.ifpr.bsi.sistemaclubesoft.model.escalacao;

import br.edu.ifpr.bsi.sistemaclubesoft.model.GenericModel;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tb_escalacao")
public class Escalacao extends GenericModel {

    private String esquemaTatico;

    private String istrucoes;
}
