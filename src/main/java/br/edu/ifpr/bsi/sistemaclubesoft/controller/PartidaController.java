package br.edu.ifpr.bsi.sistemaclubesoft.controller;

import br.edu.ifpr.bsi.sistemaclubesoft.model.partida.Partida;
import br.edu.ifpr.bsi.sistemaclubesoft.services.PartidaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/partidas")
public class PartidaController {

    @Autowired
    private PartidaService partidaService;

    @GetMapping
    public ResponseEntity<List<Partida>> listar(){
        List<Partida>partidas = this.partidaService.listar();
        return ResponseEntity.status(HttpStatus.CREATED).body(partidas);
    }


    @PostMapping
    public ResponseEntity<Partida> inserir(@RequestBody Partida request){
        Partida partidaSalva = partidaService.salvar(request);
        return ResponseEntity.ok(partidaSalva);
    }

    @PutMapping("/{codigo}")
    public ResponseEntity<Partida> atualizar(@PathVariable Long codigo, @RequestBody Partida request){
        Partida partidaAtualizada = partidaService.atualizar(codigo, request);
        return ResponseEntity.ok(partidaAtualizada);
    }

    @DeleteMapping("/{codigo}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Long codigo){
        partidaService.excluir(codigo);
    }
}
