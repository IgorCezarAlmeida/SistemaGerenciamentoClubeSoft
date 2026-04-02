package br.edu.ifpr.bsi.sistemaclubesoft.services;

import br.edu.ifpr.bsi.sistemaclubesoft.model.timeAdversario.TimeAdversario;
import br.edu.ifpr.bsi.sistemaclubesoft.repositories.TimeAdversarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class TimeAdversarioService {

    @Autowired
    private TimeAdversarioRepository timeAdversarioRepository;

    public List<TimeAdversario> listar(){
        return timeAdversarioRepository.findAll();
    }
    public TimeAdversario salvar(TimeAdversario timeAdversario){
        return this.timeAdversarioRepository.save(timeAdversario);
    }
    @Transactional
    public TimeAdversario atualizar(Long codigo,TimeAdversario timeAdversario){
        try {
            TimeAdversario TimeAdversarioEncontrado = this.timeAdversarioRepository.findById(codigo).orElse(null);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Time Adversario não encontrado" );
        }
        timeAdversario.setCodigo(codigo);
        return this.timeAdversarioRepository.save(timeAdversario);
    }

    @Transactional
    public void excluir(Long codigo){
        try {
            TimeAdversario timeAdversarioExcluir = this.timeAdversarioRepository.findById(codigo).orElse(null);
            timeAdversarioRepository.delete(timeAdversarioExcluir);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Time Adversario não encontrado" );
        }
    }
}
