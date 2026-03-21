package br.edu.ifpr.bsi.sistemaclubesoft.controller;

import br.edu.ifpr.bsi.sistemaclubesoft.model.jogador.Jogador;
import br.edu.ifpr.bsi.sistemaclubesoft.services.JogadorService;
import org.springframework.beans.factory.annotation.Autowired;
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
        return ResponseEntity.ok(jogadores);
    }

    @PostMapping
    public ResponseEntity<Jogador> inserir(@RequestBody Jogador request){
        Jogador jogadorSalvo = jogadorService.salvar(request);
        return ResponseEntity.ok(jogadorSalvo);
    }
}
