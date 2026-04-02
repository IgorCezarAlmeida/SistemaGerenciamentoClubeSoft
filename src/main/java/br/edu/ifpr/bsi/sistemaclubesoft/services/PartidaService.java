package br.edu.ifpr.bsi.sistemaclubesoft.services;

import br.edu.ifpr.bsi.sistemaclubesoft.model.partida.Partida;
import br.edu.ifpr.bsi.sistemaclubesoft.repositories.PartidaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class PartidaService {

    @Autowired
    private PartidaRepository partidaRepository;

    public List<Partida> listar(){
        return partidaRepository.findAll();
    }
    public Partida salvar(Partida partida){
        return this.partidaRepository.save(partida);
    }
    @Transactional
    public Partida atualizar(Long codigo,Partida partida){
        try {
            Partida partidaEncontrada = this.partidaRepository.findById(codigo).orElse(null);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Partida não encontrada" );
        }
        partida.setCodigo(codigo);
        return this.partidaRepository.save(partida);
    }

    @Transactional
    public void excluir(Long codigo){
        try {
            Partida partidaExluir = this.partidaRepository.findById(codigo).orElse(null);
            partidaRepository.delete(partidaExluir);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Partida não encontrada" );
        }
    }
}
