package br.edu.ifpr.bsi.sistemaclubesoft.services;

import br.edu.ifpr.bsi.sistemaclubesoft.model.estatisticas.Estatisticas;
import br.edu.ifpr.bsi.sistemaclubesoft.repositories.EstatisticasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class EstatisticasService {

    @Autowired
    private EstatisticasRepository estatisticasRepository;

    public List<Estatisticas> listar(){
        return estatisticasRepository.findAll();
    }
    public Estatisticas salvar(Estatisticas estatisticas){
        return this.estatisticasRepository.save(estatisticas);
    }
    @Transactional
    public Estatisticas atualizar(Long codigo,Estatisticas estatisticas){
        try {
            Estatisticas estatisticasEncontradas = this.estatisticasRepository.findById(codigo).orElse(null);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Estatisticas não encontradas" );
        }
        estatisticas.setCodigo(codigo);
        return this.estatisticasRepository.save(estatisticas);
    }

    @Transactional
    public void excluir(Long codigo){
        try {
            Estatisticas estatisticasExcluir = this.estatisticasRepository.findById(codigo).orElse(null);
            estatisticasRepository.delete(estatisticasExcluir);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Estatisticas não encontradas" );
        }
    }
}
