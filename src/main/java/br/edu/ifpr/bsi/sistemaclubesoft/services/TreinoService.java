package br.edu.ifpr.bsi.sistemaclubesoft.services;


import br.edu.ifpr.bsi.sistemaclubesoft.model.treino.Treino;
import br.edu.ifpr.bsi.sistemaclubesoft.repositories.TreinoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class TreinoService {

    @Autowired
    private TreinoRepository treinoRepository;

    public List<Treino> listar(){
        return treinoRepository.findAll();
    }
    public Treino salvar(Treino treino){
        return this.treinoRepository.save(treino);
    }
    @Transactional
    public Treino atualizar(Long codigo,Treino treino){
        try {
            Treino treinoEncontrado = this.treinoRepository.findById(codigo).orElse(null);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Treino não encontrado" );
        }
        treino.setCodigo(codigo);
        return this.treinoRepository.save(treino);
    }

    @Transactional
    public void excluir(Long codigo){
        try {
            Treino treinoExcluir = this.treinoRepository.findById(codigo).orElse(null);
            treinoRepository.delete(treinoExcluir);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Treino não encontrado" );
        }
    }
}
