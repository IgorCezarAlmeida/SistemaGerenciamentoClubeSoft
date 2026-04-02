package br.edu.ifpr.bsi.sistemaclubesoft.controller;

import br.edu.ifpr.bsi.sistemaclubesoft.model.estatisticasAdversario.EstatisticasAdversario;
import br.edu.ifpr.bsi.sistemaclubesoft.services.EstatisticasAdversarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/EstatisticasAdversarios")
public class EstatisticasAdversarioController {
    @Autowired
    private EstatisticasAdversarioService estatisticasAdversarioService;

    @GetMapping
    public ResponseEntity<List<EstatisticasAdversario>> listar(){
        List<EstatisticasAdversario>contratos = this.estatisticasAdversarioService.listar();
        return ResponseEntity.status(HttpStatus.CREATED).body(contratos);
    }


    @PostMapping
    public ResponseEntity<EstatisticasAdversario> inserir(@RequestBody EstatisticasAdversario request){
        EstatisticasAdversario contratoSalvo = estatisticasAdversarioService.salvar(request);
        return ResponseEntity.ok(contratoSalvo);
    }

    @PutMapping("/{codigo}")
    public ResponseEntity<EstatisticasAdversario> atualizar(@PathVariable Long codigo, @RequestBody EstatisticasAdversario request){
        EstatisticasAdversario estatisticasAdversarioAtualizado = estatisticasAdversarioService.atualizar(codigo, request);
        return ResponseEntity.ok(estatisticasAdversarioAtualizado);
    }

    @DeleteMapping("/{codigo}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Long codigo){
        estatisticasAdversarioService.excluir(codigo);
    }

}
