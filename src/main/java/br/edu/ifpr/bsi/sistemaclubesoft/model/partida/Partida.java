package br.edu.ifpr.bsi.sistemaclubesoft.model.partida;

import br.edu.ifpr.bsi.sistemaclubesoft.model.GenericModel;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tb_partida")
public class Partida extends GenericModel {

}
