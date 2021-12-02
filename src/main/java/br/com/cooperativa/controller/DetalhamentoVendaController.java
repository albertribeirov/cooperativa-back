package br.com.cooperativa.controller;

import br.com.cooperativa.model.DetalhamentoVenda;
import br.com.cooperativa.service.DetalhamentoVendaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/detalhamentovenda")
@CrossOrigin("localhost:3000")
public class DetalhamentoVendaController {

    private final DetalhamentoVendaService detalhamentoVendaService;

    public DetalhamentoVendaController(DetalhamentoVendaService detalhamentoVendaService) {
        this.detalhamentoVendaService = detalhamentoVendaService;
    }

    @GetMapping("/todos")
    @ResponseBody
    public ResponseEntity<List<DetalhamentoVenda>> getAll() {
        return detalhamentoVendaService.findAll();
    }

    @GetMapping("/buscar")
    @ResponseBody
    public ResponseEntity<DetalhamentoVenda> getDetalhamento(@RequestParam Long id) {
        return detalhamentoVendaService.findById(id);
    }

    @PostMapping("/salvar")
    @ResponseBody
    public ResponseEntity<DetalhamentoVenda> createDetalhamentoVenda(@RequestBody DetalhamentoVenda detalhamentoForm) {
        return detalhamentoVendaService.save(detalhamentoForm);
    }

    @PutMapping("/atualizar")
    public ResponseEntity<DetalhamentoVenda> updateDetalhamentoVenda(@RequestParam Long id, @RequestBody DetalhamentoVenda detalhamentoForm) {
        return detalhamentoVendaService.updateById(id, detalhamentoForm);
    }

    @DeleteMapping("/deletar")
    @ResponseBody
    public ResponseEntity<DetalhamentoVenda> deleteDetalhamentoVenda(@RequestParam Long id) {
        return detalhamentoVendaService.deleteById(id);
    }
}