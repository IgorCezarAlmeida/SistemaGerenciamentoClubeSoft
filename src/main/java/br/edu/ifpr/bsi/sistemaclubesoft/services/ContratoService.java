package br.edu.ifpr.bsi.sistemaclubesoft.services;


import br.edu.ifpr.bsi.sistemaclubesoft.model.contrato.Contrato;
import br.edu.ifpr.bsi.sistemaclubesoft.repositories.ContratoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ContratoService {
    @Autowired
    private ContratoRepository contratoRepository;

    public List<Contrato> listar(){
        return contratoRepository.findAll();
    }
    public Contrato salvar(Contrato contrato){
        return this.contratoRepository.save(contrato);
    }
    @Transactional
    public Contrato atualizar(Long codigo,Contrato contrato){
        try {
            Contrato contratoEncontrado = this.contratoRepository.findById(codigo).orElse(null);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Contrato não encontrado" );
        }
        contrato.setCodigo(codigo);
        return this.contratoRepository.save(contrato);
    }

    @Transactional
    public void excluir(Long codigo){
        try {
            Contrato contratoExcluir = this.contratoRepository.findById(codigo).orElse(null);
            contratoRepository.delete(contratoExcluir);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Contrato não encontrado" );
        }
    }
}