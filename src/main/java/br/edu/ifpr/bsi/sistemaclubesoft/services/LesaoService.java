package br.edu.ifpr.bsi.sistemaclubesoft.services;

import br.edu.ifpr.bsi.sistemaclubesoft.model.lesao.Lesao;
import br.edu.ifpr.bsi.sistemaclubesoft.repositories.LesaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class LesaoService {

    @Autowired
    private LesaoRepository lesaoRepository;

    public List<Lesao> listar(){
        return lesaoRepository.findAll();
    }
    public Lesao salvar(Lesao lesao){
        return this.lesaoRepository.save(lesao);
    }
    @Transactional
    public Lesao atualizar(Long codigo,Lesao lesao){
        try {
            Lesao lesaoEncontrada = this.lesaoRepository.findById(codigo).orElse(null);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Lesão não encontrada" );
        }
        lesao.setCodigo(codigo);
        return this.lesaoRepository.save(lesao);
    }

    @Transactional
    public void excluir(Long codigo){
        try {
            Lesao lesaoExcluir = this.lesaoRepository.findById(codigo).orElse(null);
            lesaoRepository.delete(lesaoExcluir);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Lesão não encontrada" );
        }
    }
}
