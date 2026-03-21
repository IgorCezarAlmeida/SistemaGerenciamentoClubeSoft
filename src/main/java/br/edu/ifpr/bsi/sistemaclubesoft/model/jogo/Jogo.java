package br.edu.ifpr.bsi.sistemaclubesoft.model.jogo;

import br.edu.ifpr.bsi.sistemaclubesoft.model.GenericModel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "tb_jogo")
public class Jogo extends GenericModel {
    @Column(name = "data")
    private Date data;
    @Column(name = "hora")
    private String hora;
    @Column(name = "local")
    private String local;

}
