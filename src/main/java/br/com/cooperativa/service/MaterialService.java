package br.com.cooperativa.service;

import br.com.cooperativa.model.Material;
import br.com.cooperativa.repository.MaterialRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
}
