package br.com.cooperativa.service;

import br.com.cooperativa.model.TipoMaterial;
import br.com.cooperativa.repository.TipoMaterialRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TipoMaterialService {

    private final TipoMaterialRepository tipoMaterialRepository;

    // Dependency Injection
    public TipoMaterialService(TipoMaterialRepository tipoMaterialRepository) {
        this.tipoMaterialRepository = tipoMaterialRepository;
    }

    @Transactional
    public ResponseEntity<TipoMaterial> save(TipoMaterial tipoMaterial) {
        tipoMaterialRepository.save(tipoMaterial);
        return ResponseEntity.ok().build();
    }

    @Transactional
    public ResponseEntity<TipoMaterial> deleteById(Number id) {
        if (!tipoMaterialRepository.existsById((Long) id)) {
            return ResponseEntity.notFound().build();
        }
        tipoMaterialRepository.deleteById((Long) id);
        return ResponseEntity.ok().build();
    }

    @Transactional
    public ResponseEntity<TipoMaterial> updateById(Number id, TipoMaterial tipoMaterial) {
        if (!tipoMaterialRepository.existsById((Long) id)) {
            return ResponseEntity.notFound().build();
        }
        tipoMaterial.setId((Long) id);
        TipoMaterial tipoMaterialAtt = tipoMaterialRepository.save(tipoMaterial);
        return ResponseEntity.ok(tipoMaterialAtt);
    }

    public ResponseEntity<List<TipoMaterial>> findAll(){
        List<TipoMaterial> tipoMaterials = tipoMaterialRepository.findAll();
        return ResponseEntity.ok(tipoMaterials);
    }

}
