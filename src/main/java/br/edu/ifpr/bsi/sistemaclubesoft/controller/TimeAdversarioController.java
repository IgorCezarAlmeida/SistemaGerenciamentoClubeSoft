package br.edu.ifpr.bsi.sistemaclubesoft.controller;

import br.edu.ifpr.bsi.sistemaclubesoft.model.timeAdversario.TimeAdversario;
import br.edu.ifpr.bsi.sistemaclubesoft.services.TimeAdversarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/timesAdversarios")
public class TimeAdversarioController {

    @Autowired
    private TimeAdversarioService timeAdversarioService;

    @GetMapping
    public ResponseEntity<List<TimeAdversario>> listar(){
        List<TimeAdversario>timesAdversarios = this.timeAdversarioService.listar();
        return ResponseEntity.status(HttpStatus.CREATED).body(timesAdversarios);
    }


    @PostMapping
    public ResponseEntity<TimeAdversario> inserir(@RequestBody TimeAdversario request){
        TimeAdversario timeAdversarioSalvo = timeAdversarioService.salvar(request);
        return ResponseEntity.ok(timeAdversarioSalvo);
    }

    @PutMapping("/{codigo}")
    public ResponseEntity<TimeAdversario> atualizar(@PathVariable Long codigo, @RequestBody TimeAdversario request){
        TimeAdversario timeAdversarioAtualizado = timeAdversarioService.atualizar(codigo, request);
        return ResponseEntity.ok(timeAdversarioAtualizado);
    }

    @DeleteMapping("/{codigo}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Long codigo){
        timeAdversarioService.excluir(codigo);
    }
}
