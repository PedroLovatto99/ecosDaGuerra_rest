package com.projeto.Teatros;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teatros")
public class TeatroController {

    private TeatroService teatroService;

    public TeatroController(TeatroService teatroService) {
        this.teatroService = teatroService;
    }

    @GetMapping
    public List<TeatroDTO> listarTeatros() {
        return teatroService.listarTeatros();
    }

    @PostMapping
    public TeatroDTO criarTeatro(@Valid @RequestBody TeatroDTO teatro) {
        return teatroService.criarTeatro(teatro);
    }

    @GetMapping("/{id}")
    public TeatroDTO listarTeatroPorId(@PathVariable Long id) {
        return teatroService.AcharMissaoID(id);
    }

    @PutMapping("/{id}")
    public TeatroDTO atualizarTeatro(@Valid Long id, @RequestBody TeatroDTO teatroAtualizado) {
        return teatroService.alterarTeatro(id, teatroAtualizado);
    }

    @DeleteMapping
    public void deletarTeatro(@PathVariable Long id) {
        teatroService.deletarTeatro(id);
    }




}
