package br.com.cooperativa.service;

import br.com.cooperativa.model.Material;
import br.com.cooperativa.repository.MaterialRepository;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MaterialService {

    private final MaterialRepository materialRepository;

    public MaterialService(MaterialRepository materialRepository) {
        this.materialRepository = materialRepository;
    }

    @Transactional
    public ResponseEntity<Material> save(Material material){
        materialRepository.save(material);
        return ResponseEntity.ok().build();
    }

    @Transactional
    public ResponseEntity<Material> deleteById(Number id){
        if(!materialRepository.existsById((Long) id)){
            return ResponseEntity.notFound().build();
        }
        materialRepository.deleteById((Long) id);
        return ResponseEntity.ok().build();
    }

    @Transactional
    public ResponseEntity<Material> updateById(Number id, Material material){
        if(!materialRepository.existsById((Long) id)){
            return ResponseEntity.notFound().build();
        }
        material.setId((Long) id);
        Material materialAtt = materialRepository.save(material);
        return ResponseEntity.ok(materialAtt);
    }

    public ResponseEntity<List<Material>> findAll(){
        List<Material> materials = materialRepository.findAll();
        return ResponseEntity.ok(materials);
    }
}
