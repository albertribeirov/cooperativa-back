package br.com.cooperativa.controller;

import br.com.cooperativa.dto.DetalhamentoVendaDTO;
import br.com.cooperativa.model.DetalhamentoVenda;
import br.com.cooperativa.service.DetalhamentoVendaService;
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

import java.util.List;

@RestController
@RequestMapping("/detalhamentovenda")
@CrossOrigin("localhost:3000")
public class DetalhamentoVendaController {

    private final DetalhamentoVendaService detalhamentoVendaService;

    public DetalhamentoVendaController(DetalhamentoVendaService detalhamentoVendaService) {
        this.detalhamentoVendaService = detalhamentoVendaService;
    }

    @GetMapping
    @ResponseBody
    public ResponseEntity<List<DetalhamentoVenda>> getAll() {
        return detalhamentoVendaService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<DetalhamentoVenda> getDetalhamento(@PathVariable Long id) {
        return detalhamentoVendaService.findById(id);
    }

    @PostMapping
    @ResponseBody
    public ResponseEntity<DetalhamentoVenda> createDetalhamentoVenda(@RequestBody DetalhamentoVendaDTO detalhamentoForm) {
        return detalhamentoVendaService.save(detalhamentoForm.dtoToDetalhamentoVenda());
    }

    @PutMapping("/{id}")
    public ResponseEntity<DetalhamentoVenda> updateDetalhamentoVenda(@PathVariable Long id, @RequestBody DetalhamentoVendaDTO detalhamentoForm) {
        return detalhamentoVendaService.updateById(id, detalhamentoForm.dtoToDetalhamentoVenda());
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public ResponseEntity<DetalhamentoVenda> deleteDetalhamentoVenda(@PathVariable Long id) {
        return detalhamentoVendaService.deleteById(id);
    }
}