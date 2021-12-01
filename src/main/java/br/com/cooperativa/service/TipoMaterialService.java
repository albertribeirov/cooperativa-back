package br.com.cooperativa.service;

import br.com.cooperativa.model.TipoMaterial;
import br.com.cooperativa.repository.TipoMaterialRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TipoMaterialService {

    private final TipoMaterialRepository tipoMaterialRepository;

    // Dependency Injection
    public TipoMaterialService(TipoMaterialRepository tipoMaterialRepository) {
        this.tipoMaterialRepository = tipoMaterialRepository;
    }

    @Transactional
    public ResponseEntity<TipoMaterial> save(TipoMaterial tipoMaterial){
        tipoMaterialRepository.save(tipoMaterial);
        return ResponseEntity.ok().build();
    }

}
