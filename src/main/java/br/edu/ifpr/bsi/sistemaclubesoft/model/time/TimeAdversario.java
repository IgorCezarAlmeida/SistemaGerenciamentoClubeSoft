package br.edu.ifpr.bsi.sistemaclubesoft.model.time;

import br.edu.ifpr.bsi.sistemaclubesoft.model.GenericModel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tb_time_Adversario")
public class TimeAdversario extends GenericModel {
    @Column(name = "nome")
    private String nome;
    @Column(name = "pontos_fortes")
    private String pontos_fortes;
    @Column(name = "pontos_fracos")
    private String pontos_fracos;
    @Column(name = "tecnico_adversario")
    private String tecnicoAdversario;
}
