package br.com.cooperativa.controller;

import br.com.cooperativa.dto.CooperadoDTO;
import br.com.cooperativa.model.Cooperado;
import br.com.cooperativa.service.CooperadoService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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
    public ResponseEntity<Page<Cooperado>> getAll(Pageable pageable) {
        return cooperadoService.findAll(pageable);
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