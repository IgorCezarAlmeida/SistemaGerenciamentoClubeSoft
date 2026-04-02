package br.edu.ifpr.bsi.sistemaclubesoft.controller;

import br.edu.ifpr.bsi.sistemaclubesoft.model.estatisticas.Estatisticas;
import br.edu.ifpr.bsi.sistemaclubesoft.services.EstatisticasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estatisticas")
public class EstatisticasController {

    @Autowired
    private EstatisticasService estatisticasService;

    @GetMapping
    public ResponseEntity<List<Estatisticas>> listar(){
        List<Estatisticas>contratos = this.estatisticasService.listar();
        return ResponseEntity.status(HttpStatus.CREATED).body(contratos);
    }


    @PostMapping
    public ResponseEntity<Estatisticas> inserir(@RequestBody Estatisticas request){
        Estatisticas estatisticaSalva = estatisticasService.salvar(request);
        return ResponseEntity.ok(estatisticaSalva);
    }

    @PutMapping("/{codigo}")
    public ResponseEntity<Estatisticas> atualizar(@PathVariable Long codigo, @RequestBody Estatisticas request){
        Estatisticas estatisticasAtualizada = estatisticasService.atualizar(codigo, request);
        return ResponseEntity.ok(estatisticasAtualizada);
    }

    @DeleteMapping("/{codigo}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Long codigo){
        estatisticasService.excluir(codigo);
    }
}
