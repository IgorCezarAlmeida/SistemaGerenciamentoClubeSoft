package br.edu.ifpr.bsi.sistemaclubesoft.model.tecnico;

import br.edu.ifpr.bsi.sistemaclubesoft.model.GenericModel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tb_tecnico")
public class Tecnico extends GenericModel {
    @Column(table = "nome_tecnico")
    private String nome;
    @Column(table = "data_nasc_tecnico")
    private String dataNascimento;
    @Column(table = "email")
    private String email;
    @Column(table = "senha")
    private String senha;
}