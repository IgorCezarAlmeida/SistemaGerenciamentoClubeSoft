package br.edu.ifpr.bsi.sistemaclubesoft.controller;

import br.edu.ifpr.bsi.sistemaclubesoft.model.treino.Treino;
import br.edu.ifpr.bsi.sistemaclubesoft.services.TreinoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/treinos")
@CrossOrigin(origins = "http://localhost:5173")
public class TreinoController {

    @Autowired
    private TreinoService treinoService;

    @GetMapping
    public ResponseEntity<List<Treino>> listar(){
        List<Treino>treinos = this.treinoService.listar();
        return ResponseEntity.status(HttpStatus.CREATED).body(treinos);
    }


    @PostMapping
    public ResponseEntity<Treino> inserir(@RequestBody Treino request){
        Treino  treinoSalvo = treinoService.salvar(request);
        return ResponseEntity.ok(treinoSalvo);
    }

    @PutMapping("/{codigo}")
    public ResponseEntity<Treino> atualizar(@PathVariable Long codigo, @RequestBody Treino request){
        Treino treinoAtualizado = treinoService.atualizar(codigo, request);
        return ResponseEntity.ok(treinoAtualizado);
    }

    @DeleteMapping("/{codigo}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Long codigo){
        treinoService.excluir(codigo);
    }
}
