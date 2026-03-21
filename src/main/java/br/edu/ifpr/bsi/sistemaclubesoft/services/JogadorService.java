package br.edu.ifpr.bsi.sistemaclubesoft.services;

import br.edu.ifpr.bsi.sistemaclubesoft.model.jogador.Jogador;
import br.edu.ifpr.bsi.sistemaclubesoft.repositories.JogadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JogadorService {

    @Autowired
    private JogadorRepository jogadorRepository;

    public List<Jogador> listar(){
        return jogadorRepository.findAll();
    }
    public Jogador salvar(Jogador jogador){
        return this.jogadorRepository.save(jogador);
    }
}
