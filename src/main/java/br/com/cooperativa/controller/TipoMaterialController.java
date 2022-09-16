package br.com.cooperativa.controller;

import br.com.cooperativa.model.TipoMaterial;
import br.com.cooperativa.service.TipoMaterialService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tipomaterial")
@CrossOrigin("localhost:3000")
public class TipoMaterialController {

    private final TipoMaterialService tipoMaterialService;

    public TipoMaterialController(TipoMaterialService tipoMaterialService) {
        this.tipoMaterialService = tipoMaterialService;
    }

    @GetMapping
    @ResponseBody
    public ResponseEntity<Page<TipoMaterial>> getAll(Pageable pageable) {
        return tipoMaterialService.findAll(pageable);
    }
}
