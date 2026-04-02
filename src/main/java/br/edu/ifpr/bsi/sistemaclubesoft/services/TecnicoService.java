package br.edu.ifpr.bsi.sistemaclubesoft.services;

import br.edu.ifpr.bsi.sistemaclubesoft.model.tecnico.Tecnico;
import br.edu.ifpr.bsi.sistemaclubesoft.repositories.TecnicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class TecnicoService {

    @Autowired
    private TecnicoRepository tecnicoRepository;

    public List<Tecnico> listar(){
        return tecnicoRepository.findAll();
    }
    public Tecnico salvar(Tecnico tecnico){
        return this.tecnicoRepository.save(tecnico);
    }
    @Transactional
    public Tecnico atualizar(Long codigo,Tecnico tecnico){
        try {
            Tecnico tecnicoEncontrado = this.tecnicoRepository.findById(codigo).orElse(null);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Tecnico não encontrado" );
        }
        tecnico.setCodigo(codigo);
        return this.tecnicoRepository.save(tecnico);
    }

    @Transactional
    public void excluir(Long codigo){
        try {
            Tecnico tecnicoExcluir = this.tecnicoRepository.findById(codigo).orElse(null);
            tecnicoRepository.delete(tecnicoExcluir);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Tecnico não encontrado" );
        }
    }
}
