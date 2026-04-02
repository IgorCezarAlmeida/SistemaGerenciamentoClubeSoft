package br.edu.ifpr.bsi.sistemaclubesoft.services;

import br.edu.ifpr.bsi.sistemaclubesoft.model.torneio.Torneio;
import br.edu.ifpr.bsi.sistemaclubesoft.repositories.TorneioRepository;
import jakarta.annotation.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class TorneioService {

    @Resource
    private TorneioRepository torneioRepository;

    public List<Torneio> listar(){
        return torneioRepository.findAll();
    }
    public Torneio salvar(Torneio torneio){
        return this.torneioRepository.save(torneio);
    }
    @Transactional
    public Torneio atualizar(Long codigo,Torneio torneio){
        try {
            Torneio torneioEncontrado = this.torneioRepository.findById(codigo).orElse(null);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Torneio não encontrado" );
        }
        torneio.setCodigo(codigo);
        return this.torneioRepository.save(torneio);
    }

    @Transactional
    public void excluir(Long codigo){
        try {
            Torneio torneioExcluir = this.torneioRepository.findById(codigo).orElse(null);
            torneioRepository.delete(torneioExcluir);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Torneio não encontrado" );
        }
    }
}
