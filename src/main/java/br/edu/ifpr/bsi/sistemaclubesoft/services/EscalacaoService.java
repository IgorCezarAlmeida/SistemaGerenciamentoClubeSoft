package br.edu.ifpr.bsi.sistemaclubesoft.services;


import br.edu.ifpr.bsi.sistemaclubesoft.model.escalacao.Escalacao;
import br.edu.ifpr.bsi.sistemaclubesoft.repositories.EscalacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class EscalacaoService {

    @Autowired
    private EscalacaoRepository escalacaoRepository;

    public List<Escalacao> listar(){
        return escalacaoRepository.findAll();
    }
    public Escalacao salvar(Escalacao escalacao){
        return this.escalacaoRepository.save(escalacao);
    }
    @Transactional
    public Escalacao atualizar(Long codigo,Escalacao contrato){
        try {
            Escalacao escalacaoEncontrada = this.escalacaoRepository.findById(codigo).orElse(null);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Escalação não encontrada" );
        }
        contrato.setCodigo(codigo);
        return this.escalacaoRepository.save(contrato);
    }

    @Transactional
    public void excluir(Long codigo){
        try {
            Escalacao escalacaoExcluir = this.escalacaoRepository.findById(codigo).orElse(null);
            escalacaoRepository.delete(escalacaoExcluir);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Escalação não encontrada" );
        }
    }
}
