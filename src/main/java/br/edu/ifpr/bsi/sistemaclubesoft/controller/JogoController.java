package br.edu.ifpr.bsi.sistemaclubesoft.controller;


import br.edu.ifpr.bsi.sistemaclubesoft.model.jogo.Jogo;
import br.edu.ifpr.bsi.sistemaclubesoft.services.JogoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jogos")
public class JogoController {

    @Autowired
    private JogoService jogoService;

    @GetMapping
    public ResponseEntity<List<Jogo>> listar(){
        List<Jogo>jogos = this.jogoService.listar();
        return ResponseEntity.status(HttpStatus.CREATED).body(jogos);
    }


    @PostMapping
    public ResponseEntity<Jogo> inserir(@RequestBody Jogo request){
        Jogo jogoSalvo = jogoService.salvar(request);
        return ResponseEntity.ok(jogoSalvo);
    }

    @PutMapping("/{codigo}")
    public ResponseEntity<Jogo> atualizar(@PathVariable Long codigo, @RequestBody Jogo request){
        Jogo jogadorAtualizado = jogoService.atualizar(codigo, request);
        return ResponseEntity.ok(jogadorAtualizado);
    }

    @DeleteMapping("/{codigo}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Long codigo){
        jogoService.excluir(codigo);
    }

}
