package br.edu.ifpr.bsi.sistemaclubesoft.model.partida;

import br.edu.ifpr.bsi.sistemaclubesoft.model.GenericModel;
import br.edu.ifpr.bsi.sistemaclubesoft.model.jogo.Jogo;
import br.edu.ifpr.bsi.sistemaclubesoft.model.torneio.Torneio;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "tb_partida")
public class Partida extends GenericModel {
    @Column(name = "data")
    private Date data;
    @Column(name = "hora")
    private String hora;
    @Column(name = "local")
    private String local;
    @ManyToOne
    @JoinColumn(name="torneio_id")
    private Torneio torneio;

}
