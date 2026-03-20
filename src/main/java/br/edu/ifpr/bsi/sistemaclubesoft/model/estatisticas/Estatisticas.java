package br.edu.ifpr.bsi.sistemaclubesoft.model.estatisticas;

import br.edu.ifpr.bsi.sistemaclubesoft.model.jogador.Jogador;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tb_estatisticas")
public class Estatisticas extends Jogador {
    @Column(name = "gols")
    private int gols;
    @Column(name = "assistencias")
    private int assistencias;
    @Column(name = "minutos_jogados")
    private float minutosJogados;
    @Column(name = "jogos")
    private int jogos;
    @Column(name = "passes")
    private int passes;
    @Column(name = "desarmes")
    private int desarmes;
    @Column(name = "cartoes_amarelos")
    private int cartoesAmarelos;
    @Column(name = "cartoes_vermelhos")
    private int cartoesVermelhos;
    @Column(name = "faltas_jogador")
    private int faltasJogador;
}
