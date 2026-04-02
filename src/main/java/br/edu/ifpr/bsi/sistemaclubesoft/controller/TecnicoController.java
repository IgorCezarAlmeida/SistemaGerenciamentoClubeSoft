package br.edu.ifpr.bsi.sistemaclubesoft.controller;

import br.edu.ifpr.bsi.sistemaclubesoft.model.tecnico.Tecnico;
import br.edu.ifpr.bsi.sistemaclubesoft.services.TecnicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tecnicos")
public class TecnicoController {

    @Autowired
    private TecnicoService tecnicoService;

    @GetMapping
    public ResponseEntity<List<Tecnico>> listar(){
        List<Tecnico>tecnicos = this.tecnicoService.listar();
        return ResponseEntity.status(HttpStatus.CREATED).body(tecnicos);
    }


    @PostMapping
    public ResponseEntity<Tecnico> inserir(@RequestBody Tecnico request){
        Tecnico tecnicoSalvo = tecnicoService.salvar(request);
        return ResponseEntity.ok(tecnicoSalvo);
    }

    @PutMapping("/{codigo}")
    public ResponseEntity<Tecnico> atualizar(@PathVariable Long codigo, @RequestBody Tecnico request){
        Tecnico jogadorAtualizado = tecnicoService.atualizar(codigo, request);
        return ResponseEntity.ok(jogadorAtualizado);
    }

    @DeleteMapping("/{codigo}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Long codigo){
        tecnicoService.excluir(codigo);
    }
}
