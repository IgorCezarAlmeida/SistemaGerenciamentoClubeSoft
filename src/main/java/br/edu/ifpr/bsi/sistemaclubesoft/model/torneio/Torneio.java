package br.edu.ifpr.bsi.sistemaclubesoft.model.torneio;

import br.edu.ifpr.bsi.sistemaclubesoft.model.GenericModel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tb_torneio")
public class Torneio extends GenericModel {
    @Column(name = "nome")
    private String nome;
    @Column(name = "temporada")
    private String temporada;
    @Column(name = "organizador")
    private String organizador;
    @Column(name = "tipo")
    private String tipo;
}
