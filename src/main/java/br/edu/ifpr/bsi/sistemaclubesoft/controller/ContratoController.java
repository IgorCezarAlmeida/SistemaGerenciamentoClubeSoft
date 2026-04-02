package br.edu.ifpr.bsi.sistemaclubesoft.controller;

import br.edu.ifpr.bsi.sistemaclubesoft.model.contrato.Contrato;
import br.edu.ifpr.bsi.sistemaclubesoft.services.ContratoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contratos")
public class ContratoController {

    @Autowired
    private ContratoService contratoService;

    @GetMapping
    public ResponseEntity<List<Contrato>> listar(){
        List<Contrato>contratos = this.contratoService.listar();
        return ResponseEntity.status(HttpStatus.CREATED).body(contratos);
    }


    @PostMapping
    public ResponseEntity<Contrato> inserir(@RequestBody Contrato request){
        Contrato contratoSalvo = contratoService.salvar(request);
        return ResponseEntity.ok(contratoSalvo);
    }

    @PutMapping("/{codigo}")
    public ResponseEntity<Contrato> atualizar(@PathVariable Long codigo, @RequestBody Contrato request){
        Contrato jogadorAtualizado = contratoService.atualizar(codigo, request);
        return ResponseEntity.ok(jogadorAtualizado);
    }

    @DeleteMapping("/{codigo}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Long codigo){
        contratoService.excluir(codigo);
    }
}
