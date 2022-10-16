package br.com.cooperativa.integration;

import br.com.cooperativa.dto.TipoMaterialDTO;
import br.com.cooperativa.repository.TipoMaterialRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.annotation.Resource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class PersistenceTests extends IntegrationTest {

    @Resource
    private TipoMaterialRepository tipoMaterialRepository;

    @Test
    @DisplayName("Teste de persistência de um tipo de material")
    void tipoMaterialShouldBePersistedSuccessfully() {
        var tipoMaterial = TipoMaterialDTO.builder()
                .nome("Material de teste")
                .build()
                .dtoToTipoMaterial();

        tipoMaterialRepository.save(tipoMaterial);
        var tiposMaterial = tipoMaterialRepository.findAll();
        var tipoMaterialFromDb = tiposMaterial.get(0);

        assertEquals(tiposMaterial.size(), 1);
        assertThat(tipoMaterialFromDb).isEqualTo(tipoMaterial).isEqualToComparingOnlyGivenFields("nome");
    }
}
