package br.edu.ifpr.bsi.sistemaclubesoft.controller;

import br.edu.ifpr.bsi.sistemaclubesoft.model.torneio.Torneio;
import br.edu.ifpr.bsi.sistemaclubesoft.services.TorneioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/torneios")
public class TorneioController {

    @Autowired
    private TorneioService torneioService;

    @GetMapping
    public ResponseEntity<List<Torneio>> listar(){
        List<Torneio>contratos = this.torneioService.listar();
        return ResponseEntity.status(HttpStatus.CREATED).body(contratos);
    }


    @PostMapping
    public ResponseEntity<Torneio> inserir(@RequestBody Torneio request){
        Torneio torneioSalvo = torneioService.salvar(request);
        return ResponseEntity.ok(torneioSalvo);
    }

    @PutMapping("/{codigo}")
    public ResponseEntity<Torneio> atualizar(@PathVariable Long codigo, @RequestBody Torneio request){
        Torneio torneioAtualizado = torneioService.atualizar(codigo, request);
        return ResponseEntity.ok(torneioAtualizado);
    }

    @DeleteMapping("/{codigo}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Long codigo){
        torneioService.excluir(codigo);
    }
}
