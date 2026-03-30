package br.edu.ifpr.bsi.sistemaclubesoft.services;

import br.edu.ifpr.bsi.sistemaclubesoft.model.jogador.Jogador;
import br.edu.ifpr.bsi.sistemaclubesoft.model.lesao.Lesao;
import br.edu.ifpr.bsi.sistemaclubesoft.repositories.JogadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.beans.Transient;
import java.util.List;

@Service
public class JogadorService {

    @Autowired
    private JogadorRepository jogadorRepository;

    public List<Jogador> listar(){
        return jogadorRepository.findAll();
    }
    public Jogador salvar(Jogador jogador){
        if (jogador.getLesoes() != null && jogador.getLesoes().isEmpty()){
            jogador.getLesoes().forEach(lesao -> lesao.setJogador(jogador));
        }
        return this.jogadorRepository.save(jogador);
    }
    @Transactional
    public Jogador atualizar(Long codigo,Jogador jogador){
       try {
           Jogador jogadorEncontrado = this.jogadorRepository.findById(codigo).orElse(null);
       } catch (Exception e) {
           throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Jogador não encontrado" );
       }
        if (jogador.getLesoes() != null && jogador.getLesoes().isEmpty()){
            jogador.getLesoes().forEach( lesao -> lesao.setJogador(jogador));
        }
       jogador.setCodigo(codigo);
       return this.jogadorRepository.save(jogador);
    }

    @Transactional
    public void excluir(Long codigo){
        try {
            Jogador jogadorExcluir = this.jogadorRepository.findById(codigo).orElse(null);
            jogadorRepository.delete(jogadorExcluir);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Jogador não encontrado" );
        }
    }
}
