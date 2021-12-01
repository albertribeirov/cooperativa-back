package br.com.cooperativa.service;

import br.com.cooperativa.model.Material;
import br.com.cooperativa.repository.MaterialRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MaterialService {

    //Logger to easy debug
    private static final Logger logger = LoggerFactory.getLogger(ClienteService.class);

    private final MaterialRepository materialRepository;

    public MaterialService(MaterialRepository materialRepository) {
        this.materialRepository = materialRepository;
    }

    @Transactional
    public ResponseEntity<Material> save(Material material){
        materialRepository.save(material);
        logger.info("Salvo com sucesso.");
        return ResponseEntity.ok().build();
    }

    @Transactional
    public ResponseEntity<Material> deleteById(Number id){
        logger.info("Procurando material com id: " + id);
        if(!materialRepository.existsById((Long) id)){
            logger.warn("Não encontrado");
            return ResponseEntity.notFound().build();
        }
        materialRepository.deleteById((Long) id);
        logger.info("Material deletado com sucesso. Id: " + id);
        return ResponseEntity.ok().build();
    }

    @Transactional
    public ResponseEntity<Material> updateById(Number id, Material material){
        logger.info("Procurando material com id: " + id);
        if(!materialRepository.existsById((Long) id)){
            logger.warn("Não encontrado.");
            return ResponseEntity.notFound().build();
        }
        material.setId((Long) id);
        Material materialAtt = materialRepository.save(material);
        logger.info("Material encontrado com sucesso. Id: " + id);
        return ResponseEntity.ok(materialAtt);
    }

    public ResponseEntity<List<Material>> findAll(){
        List<Material> materials = materialRepository.findAll();
        logger.info("Encontrado uma lista de materiais. Tamanho: " + materials.size());
        return ResponseEntity.ok(materials);
    }

    public ResponseEntity<Material> findById(Number id){
        logger.info("Procurando material com id: " + id);
        if(!materialRepository.existsById((Long) id)){
            logger.warn("Não encontrado");
            return ResponseEntity.notFound().build();
        }
        Material material = materialRepository.findById((Long) id).get();
        logger.info("Material encontrado com sucesso.");
        return ResponseEntity.ok(material);
    }
}
