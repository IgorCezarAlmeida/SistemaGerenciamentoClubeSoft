package br.edu.ifpr.bsi.sistemaclubesoft.model.jogo;

import br.edu.ifpr.bsi.sistemaclubesoft.model.GenericModel;
import br.edu.ifpr.bsi.sistemaclubesoft.model.estatisticas.Estatisticas;
import br.edu.ifpr.bsi.sistemaclubesoft.model.partida.Partida;
import br.edu.ifpr.bsi.sistemaclubesoft.model.timeAdversario.TimeAdversario;
import br.edu.ifpr.bsi.sistemaclubesoft.model.torneio.Torneio;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "tb_jogo")
public class Jogo extends GenericModel {
    @Column(name = "mando_de_campo")
    private String mandoDeCampo;
    @Column(name = "resultado_final")
    private String resultadoFinal;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "partida_id")
    private Partida partida;
    @ManyToOne
    @JoinColumn(name="timeAdversario_id")
    private TimeAdversario timeAdversario;
    @OneToMany(mappedBy = "jogo",cascade = CascadeType.ALL,fetch = FetchType.LAZY,orphanRemoval = true)
    private List<Estatisticas> Estatisticas;
}
