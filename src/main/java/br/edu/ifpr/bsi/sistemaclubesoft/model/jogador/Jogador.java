package br.edu.ifpr.bsi.sistemaclubesoft.model.jogador;

import br.edu.ifpr.bsi.sistemaclubesoft.model.GenericModel;
import br.edu.ifpr.bsi.sistemaclubesoft.model.contrato.Contrato;
import br.edu.ifpr.bsi.sistemaclubesoft.model.lesao.Lesao;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "tb_jogador")
public class Jogador extends GenericModel {

    @Column(name = "nome_jogador")
    private String nome;
    @Column(name = "data_nasc_jogador")
    private String dataNascimento;
    @Column(name = "numero_camisa")
    private String numeroCamisa;
    @Column(name = "peso")
    private float peso;
    @Column(name = "altura")
    private int altura;
    @Column(name = "descricao")
    private String descricao;
    @Column(name = "pernaDominante")
    private String pernaDominante;
    @Column(name = "posicao")
    private String posicao;
    @OneToMany(mappedBy = "jogador",cascade = CascadeType.ALL,fetch = FetchType.LAZY,orphanRemoval = true)
    private List<Lesao> lesoes;
    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER,orphanRemoval = true)
    @JoinColumn(name = "contrato_id")
    private Contrato contrato;
}
