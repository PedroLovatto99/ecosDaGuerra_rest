package com.projeto.Batalhas;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/batalhas")
public class BatalhaController {

    private BatalhaService batalhaService;

    public BatalhaController(BatalhaService batalhaService) {
        this.batalhaService = batalhaService;
    }

    @GetMapping
    public ResponseEntity<List<BatalhaDTO>> listarBatalhas() {
        List<BatalhaDTO> batalhas = batalhaService.listarBatalhas();
        return ResponseEntity.ok(batalhas);
    }

    @PostMapping
    public ResponseEntity<String> criarBatalha(@Valid @RequestBody BatalhaDTO batalhaDTO) {
        BatalhaDTO batalha = batalhaService.criarBatalhas(batalhaDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Teatro criado com sucesso: "
                        + batalha.getNome() +" "
                        + batalha.getDataInicio()+" "
                        + batalha.getDataFim()+" "
                        + batalha.getTeatro_id()+" "
                        + batalha.getResultado());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> acharBatalhaId(@PathVariable Long id){
        BatalhaDTO batalha = batalhaService.listarBatalhaId(id);
        if(batalha != null) {
            return ResponseEntity.ok(batalha);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Teatro não encontrado");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizarBatalha(@Valid @RequestBody BatalhaDTO batalhaAtualizada, @PathVariable Long id) {
        BatalhaDTO batalha = batalhaService.atualizarBatalha(batalhaAtualizada, id);
        if (batalha != null) {
            return ResponseEntity.ok(batalha);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Batalha não encontrada");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarBatalha(@PathVariable Long id) {
        if(batalhaService.listarBatalhaId(id) != null) {
            batalhaService.deletarBatalha(id);
            return ResponseEntity.ok("Batalha deletada");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Batalha não encontrada");
        }

    }


}
