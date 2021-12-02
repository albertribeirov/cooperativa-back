package br.com.cooperativa.controller;

import br.com.cooperativa.dto.CooperadoDTO;
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

    @GetMapping
    @ResponseBody
    public ResponseEntity<List<Cooperado>> getAll() {
        return cooperadoService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<Cooperado> getCooperado(@PathVariable Long id){
        return cooperadoService.findById(id);
    }

    @PostMapping
    public ResponseEntity<Cooperado> createCooperado(@RequestBody CooperadoDTO cooperadoForm) {
        return cooperadoService.save(cooperadoForm.dtoToCooperado());
    }

    @PutMapping("/{id}")
    @ResponseBody
    public ResponseEntity<Cooperado> updateCooperado(@PathVariable Long id, @RequestBody CooperadoDTO cooperadoForm) {
        return cooperadoService.updateById(id, cooperadoForm.dtoToCooperado());
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public ResponseEntity<Cooperado> deleteCooperado(@PathVariable Long id) {
        return cooperadoService.deleteById(id);
    }
}