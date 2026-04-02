package br.edu.ifpr.bsi.sistemaclubesoft.controller;

import br.edu.ifpr.bsi.sistemaclubesoft.model.lesao.Lesao;
import br.edu.ifpr.bsi.sistemaclubesoft.services.LesaoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lesoes")
public class LesaoController {

    private LesaoService lesaoService;

    @GetMapping
    public ResponseEntity<List<Lesao>> listar(){
        List<Lesao>lesoes = this.lesaoService.listar();
        return ResponseEntity.status(HttpStatus.CREATED).body(lesoes);
    }


    @PostMapping
    public ResponseEntity<Lesao> inserir(@RequestBody Lesao request){
        Lesao lesaoSalva = lesaoService.salvar(request);
        return ResponseEntity.ok(lesaoSalva);
    }

    @PutMapping("/{codigo}")
    public ResponseEntity<Lesao> atualizar(@PathVariable Long codigo, @RequestBody Lesao request){
        Lesao lesaoAtualizada = lesaoService.atualizar(codigo, request);
        return ResponseEntity.ok(lesaoAtualizada);
    }

    @DeleteMapping("/{codigo}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Long codigo){
        lesaoService.excluir(codigo);
    }

}
