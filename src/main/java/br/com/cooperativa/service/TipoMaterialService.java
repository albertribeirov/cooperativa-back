package br.com.cooperativa.service;

import br.com.cooperativa.model.TipoMaterial;
import br.com.cooperativa.repository.TipoMaterialRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Slf4j
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class TipoMaterialService {

    private final TipoMaterialRepository tipoMaterialRepository;

    @Transactional
    public TipoMaterial save(TipoMaterial tipoMaterial) {
        var tipoMaterialFromDb = tipoMaterialRepository.saveAndFlush(tipoMaterial);
        log.info("Tipo salvo com sucesso.");
        return tipoMaterialFromDb;
    }

    @Transactional
    public boolean deleteById(Long id) {
        log.info("Procurando TipoMaterial com id {}", id);
        if (!tipoMaterialRepository.existsById(id)) {
            log.warn("Não encontrado TipoMaterial de id {}", id);
            return false;
        }

        tipoMaterialRepository.deleteById(id);
        log.info("TipoMaterial de id {} deletado com sucesso", id);
        return true;
    }

    @Transactional
    public TipoMaterial updateById(Long id, TipoMaterial tipoMaterial) {
        log.info("Procurando tipo com id {}", id);
        if (!tipoMaterialRepository.existsById(id)) {
            log.warn("Não encontrado TipoMaterial de id {}", id);
            return tipoMaterial;
        }
        tipoMaterial.setId(id);
        TipoMaterial tipoMaterialUpdated = tipoMaterialRepository.save(tipoMaterial);
        log.info("TipoMaterial de id {} atualizado com sucesso.", id);
        return tipoMaterialUpdated;
    }

    public Page<TipoMaterial> findAll(Pageable pageable) {
        Page<TipoMaterial> tiposDeMaterial = tipoMaterialRepository.findAll(pageable);
        log.info("Lista de TipoMaterial encontrada com sucesso. Tamanho {}", tiposDeMaterial.getTotalElements());
        return tiposDeMaterial;
    }

    public Optional<TipoMaterial> findById(Long id) {
        log.info("Procurando tipo com id {}", id);
        return tipoMaterialRepository.findById(id);
    }

}
