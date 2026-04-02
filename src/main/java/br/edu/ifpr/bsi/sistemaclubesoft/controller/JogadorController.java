package br.edu.ifpr.bsi.sistemaclubesoft.controller;

import br.edu.ifpr.bsi.sistemaclubesoft.model.jogador.Jogador;
import br.edu.ifpr.bsi.sistemaclubesoft.services.JogadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jogadores")
public class JogadorController {

    @Autowired
    private JogadorService jogadorService;

    @GetMapping
    public ResponseEntity<List<Jogador>> listar(){
        List<Jogador>jogadores = this.jogadorService.listar();
        return ResponseEntity.status(HttpStatus.CREATED).body(jogadores);
    }


    @PostMapping
    public ResponseEntity<Jogador> inserir(@RequestBody Jogador request){
        Jogador jogadorSalvo = jogadorService.salvar(request);
        return ResponseEntity.ok(jogadorSalvo);
    }

    @PutMapping("/{codigo}")
    public ResponseEntity<Jogador> atualizar(@PathVariable Long codigo, @RequestBody Jogador request){
        Jogador jogadorAtualizado = jogadorService.atualizar(codigo, request);
        return ResponseEntity.ok(jogadorAtualizado);
    }

    @DeleteMapping("/{codigo}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Long codigo){
        jogadorService.excluir(codigo);
    }

}
