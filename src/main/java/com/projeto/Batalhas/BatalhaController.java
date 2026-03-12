package com.projeto.Batalhas;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/batalhas")
public class BatalhaController {

    private BatalhaService batalhaService;

    public BatalhaController(BatalhaService batalhaService) {
        this.batalhaService = batalhaService;
    }

    @GetMapping
    public List<BatalhaDTO> listarBatalhas() {
        return batalhaService.listarBatalhas();
    }

    @PostMapping
    public BatalhaDTO criarBatalha(@RequestBody BatalhaDTO batalhaDTO) {
        return batalhaService.criarBatalhas(batalhaDTO);
    }

    @GetMapping("/{id}")
    public BatalhaDTO acharBatalhaId(@PathVariable Long id){
        return batalhaService.listarBatalhaId(id);
    }

    @PutMapping("/{id}")
    public BatalhaDTO atualizarBatalha(@RequestBody BatalhaDTO batalha, @PathVariable Long id) {
        return batalhaService.atualizarBatalha(batalha, id);
    }

    @DeleteMapping("/{id}")
    public void deletarBatalha(@PathVariable Long id) {
        batalhaService.deletarBatalha(id);
    }


}
