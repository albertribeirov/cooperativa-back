package br.com.cooperativa.service;

import br.com.cooperativa.model.TipoMaterial;
import br.com.cooperativa.repository.TipoMaterialRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TipoMaterialService {

    //Logger to easy debug
    private static final Logger logger = LoggerFactory.getLogger(TipoMaterialService.class);

    private final TipoMaterialRepository tipoMaterialRepository;

    // Dependency Injection
    public TipoMaterialService(TipoMaterialRepository tipoMaterialRepository) {
        this.tipoMaterialRepository = tipoMaterialRepository;
    }

    @Transactional
    public ResponseEntity<TipoMaterial> save(TipoMaterial tipoMaterial) {
        tipoMaterialRepository.save(tipoMaterial);
        logger.info("Tipo salvo com sucesso.");
        return ResponseEntity.ok().build();
    }

    @Transactional
    public ResponseEntity<TipoMaterial> deleteById(Number id) {
        logger.info("Procurando tipo com id: " + id);
        if (!tipoMaterialRepository.existsById((Long) id)) {
            logger.warn("Não encontrado.");
            return ResponseEntity.notFound().build();
        }
        tipoMaterialRepository.deleteById((Long) id);
        logger.info("Deletado com sucesso.");
        return ResponseEntity.ok().build();
    }

    @Transactional
    public ResponseEntity<TipoMaterial> updateById(Number id, TipoMaterial tipoMaterial) {
        logger.info("Procurando tipo com id: " + id);
        if (!tipoMaterialRepository.existsById((Long) id)) {
            logger.warn("Não encontrado.");
            return ResponseEntity.notFound().build();
        }
        tipoMaterial.setId((Long) id);
        TipoMaterial tipoMaterialAtt = tipoMaterialRepository.save(tipoMaterial);
        logger.info("Tipo atualizado com sucesso.");
        return ResponseEntity.ok(tipoMaterialAtt);
    }

    public ResponseEntity<List<TipoMaterial>> findAll(){
        List<TipoMaterial> tipoMaterials = tipoMaterialRepository.findAll();
        logger.info("Lista de Tipos encontrada com sucesso. Tamanho: " + tipoMaterials.size());
        return ResponseEntity.ok(tipoMaterials);
    }

    public ResponseEntity<TipoMaterial> findById(Number id){
        logger.info("Procurando tipo com id: " + id);
        if(!tipoMaterialRepository.existsById((Long) id)){
            logger.warn("Não encontrado.");
            return ResponseEntity.notFound().build();
        }
        TipoMaterial tipoMaterial = tipoMaterialRepository.findById((Long) id).get();
        logger.info("Tipo encontrado com sucesso. Nome: " + tipoMaterial.getNome());
        return ResponseEntity.ok(tipoMaterial);
    }

}
