package br.com.cooperativa.controller;

import br.com.cooperativa.model.Cooperado;
import br.com.cooperativa.service.CooperadoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cooperado")
@CrossOrigin("localhost:3000")
public class CooperadoController {

    private final CooperadoService cooperadoService ;

    public CooperadoController(CooperadoService cooperadoService) {
        this.cooperadoService = cooperadoService;
    }

    @GetMapping("/todos")
    @ResponseBody
    public ResponseEntity<List<Cooperado>> getAll() {
        return cooperadoService.findAll();
    }

    @GetMapping("/buscar")
    @ResponseBody
    public ResponseEntity<Cooperado> getCooperado(@RequestParam Long id){
        return cooperadoService.findById(id);
    }

    @PostMapping("/salvar")
    public ResponseEntity<Cooperado> createCooperado(@RequestBody Cooperado cooperadoForm) {
        return cooperadoService.save(cooperadoForm);
    }

    @PutMapping("/atualizar")
    @ResponseBody
    public ResponseEntity<Cooperado> updateCooperado(@RequestParam Long id, @RequestBody Cooperado cooperadoForm) {
        return cooperadoService.updateById(id, cooperadoForm);
    }

    @DeleteMapping("/deletar")
    @ResponseBody
    public ResponseEntity<Cooperado> deleteCooperado(@RequestParam Long id) {
        return cooperadoService.deleteById(id);
    }
}