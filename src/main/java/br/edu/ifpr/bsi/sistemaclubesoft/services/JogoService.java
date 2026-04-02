package br.edu.ifpr.bsi.sistemaclubesoft.services;

import br.edu.ifpr.bsi.sistemaclubesoft.model.jogo.Jogo;
import br.edu.ifpr.bsi.sistemaclubesoft.repositories.JogoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class JogoService {

    @Autowired
    private JogoRepository jogoRepository;

    public List<Jogo> listar(){
        return jogoRepository.findAll();
    }
    public Jogo salvar(Jogo jogo){
        return this.jogoRepository.save(jogo);
    }
    @Transactional
    public Jogo atualizar(Long codigo,Jogo jogo){
        try {
            Jogo jogoEncontrado = this.jogoRepository.findById(codigo).orElse(null);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Jogo não encontrado" );
        }
        jogo.setCodigo(codigo);
        return this.jogoRepository.save(jogo);
    }

    @Transactional
    public void excluir(Long codigo){
        try {
            Jogo jogoExcluir = this.jogoRepository.findById(codigo).orElse(null);
            jogoRepository.delete(jogoExcluir);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Jogo não encontrado" );
        }
    }
}
