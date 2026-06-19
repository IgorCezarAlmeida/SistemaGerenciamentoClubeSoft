package br.edu.ifpr.bsi.sistemaclubesoft.controller;


import br.edu.ifpr.bsi.sistemaclubesoft.model.escalacao.Escalacao;
import br.edu.ifpr.bsi.sistemaclubesoft.services.EscalacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/escalacoes")
@CrossOrigin(origins = "http://localhost:5173")
public class EscalacaoController {

    @Autowired
    private EscalacaoService escalacaoService;

    @GetMapping
    public ResponseEntity<List<Escalacao>> listar(){
        List<Escalacao>contratos = this.escalacaoService.listar();
        return ResponseEntity.status(HttpStatus.CREATED).body(contratos);
    }


    @PostMapping
    public ResponseEntity<Escalacao> inserir(@RequestBody Escalacao request){
        Escalacao escalacaoSalva = escalacaoService.salvar(request);
        return ResponseEntity.ok(escalacaoSalva);
    }

    @PutMapping("/{codigo}")
    public ResponseEntity<Escalacao> atualizar(@PathVariable Long codigo, @RequestBody Escalacao request){
        Escalacao jogadorAtualizado = escalacaoService.atualizar(codigo, request);
        return ResponseEntity.ok(jogadorAtualizado);
    }

    @DeleteMapping("/{codigo}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Long codigo){
        escalacaoService.excluir(codigo);
    }
}
