package br.edu.ifpr.bsi.sistemaclubesoft.services;

import br.edu.ifpr.bsi.sistemaclubesoft.model.estatisticasAdversario.EstatisticasAdversario;
import br.edu.ifpr.bsi.sistemaclubesoft.repositories.EstatisticasAdversarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class EstatisticasAdversarioService {

    @Autowired
    private EstatisticasAdversarioRepository estatisticasAdversarioRepository;

    public List<EstatisticasAdversario> listar(){
        return estatisticasAdversarioRepository.findAll();
    }
    public EstatisticasAdversario salvar(EstatisticasAdversario estatisticasAdversario){
        return this.estatisticasAdversarioRepository.save(estatisticasAdversario);
    }
    @Transactional
    public EstatisticasAdversario atualizar(Long codigo,EstatisticasAdversario estatisticasAdversario){
        try {
            EstatisticasAdversario contratoEncontrado = this.estatisticasAdversarioRepository.findById(codigo).orElse(null);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"estatisticas não encontradas" );
        }
        estatisticasAdversario.setCodigo(codigo);
        return this.estatisticasAdversarioRepository.save(estatisticasAdversario);
    }

    @Transactional
    public void excluir(Long codigo){
        try {
            EstatisticasAdversario estatisticasAdversarioExcluir = this.estatisticasAdversarioRepository.findById(codigo).orElse(null);
            estatisticasAdversarioRepository.delete(estatisticasAdversarioExcluir);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"estatisticas não encontradas" );
        }
    }
}
