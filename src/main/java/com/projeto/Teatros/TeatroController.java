package com.projeto.Teatros;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<TeatroDTO>> listarTeatros() {
        List<TeatroDTO> teatros = teatroService.listarTeatros();
        return ResponseEntity.ok((teatros));
    }

    @PostMapping
    public ResponseEntity<String> criarTeatro(@Valid @RequestBody TeatroDTO teatro) {
        TeatroDTO novoTeatro =  teatroService.criarTeatro(teatro);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Teatro criado com sucesso: " + novoTeatro.getNome());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> listarTeatroPorId(@PathVariable Long id) {

        TeatroDTO teatro =  teatroService.AcharTeatroID(id);

        if(teatro != null) {
            return ResponseEntity.ok(teatro);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Teatro não encontrado");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizarTeatro(@PathVariable Long id, @RequestBody @Valid TeatroDTO teatroAtualizado) {
        TeatroDTO teatro = teatroService.alterarTeatro(id, teatroAtualizado);

        if (teatro != null) {
            return ResponseEntity.ok(teatro);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Teatro não encontrado");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarTeatro(@PathVariable Long id) {
        if(teatroService.AcharTeatroID(id) != null) {
            teatroService.deletarTeatro(id);
            return ResponseEntity.ok("Teatro deletado");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Teatro não encontrado");
        }
    }

}
