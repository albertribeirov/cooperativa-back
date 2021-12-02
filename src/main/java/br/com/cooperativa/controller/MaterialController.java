package br.com.cooperativa.controller;

import br.com.cooperativa.model.Material;
import br.com.cooperativa.service.MaterialService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/material")
@CrossOrigin("localhost:3000")
public class MaterialController {

    private final MaterialService materialService;

    public MaterialController(MaterialService materialService) {
        this.materialService = materialService;
    }

    @GetMapping("/todos")
    @ResponseBody
    public ResponseEntity<List<Material>> getAll() {
        return materialService.findAll();
    }

    @GetMapping("/buscar")
    @ResponseBody
    public ResponseEntity<Material> getMaterial(@RequestParam Long id){
        return materialService.findById(id);
    }

    @PostMapping("/salvar")
    @ResponseBody
    public ResponseEntity<Material> createMaterial(@RequestBody Material materialForm) {
        return materialService.save(materialForm);
    }

    @PutMapping("/atualizar")
    @ResponseBody
    public ResponseEntity<Material> updateMaterial(@RequestParam Long id, @RequestBody Material materialForm) {
        return materialService.updateById(id, materialForm);
    }

    @DeleteMapping("/deletar")
    @ResponseBody
    public ResponseEntity<Material> deleteMaterial(@RequestParam Long id) {
        return materialService.deleteById(id);
    }
}