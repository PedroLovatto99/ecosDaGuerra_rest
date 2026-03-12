package com.projeto.Batalhas;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BatalhaService {

    private BatalhaRepository batalhaRepo;
    private BatalhaMapper batalhaMapper;

    public BatalhaService(BatalhaRepository batalhaRepo, BatalhaMapper batalhaMapper) {
        this.batalhaRepo = batalhaRepo;
        this.batalhaMapper = batalhaMapper;
    }

    public List<BatalhaDTO> listarBatalhas() {
        List<BatalhaModel> batalhas = batalhaRepo.findAll();
        return batalhas.stream()
                .map(batalhaMapper::toDTO)
                .collect(Collectors.toList());
    }

    public BatalhaDTO criarBatalhas(BatalhaDTO batalhaDTO) {
        BatalhaModel batalha = batalhaMapper.toModel(batalhaDTO);
        batalha = batalhaRepo.save(batalha);
        return batalhaMapper.toDTO(batalha);
    }

    public BatalhaDTO listarBatalhaId(Long id) {
        Optional<BatalhaModel> batalhaPorId = batalhaRepo.findById(id);
        return batalhaPorId.map(batalhaMapper::toDTO).orElse(null);

        }

    public BatalhaDTO atualizarBatalha(BatalhaDTO batalhaDTO, Long id) {
        Optional<BatalhaModel> batalhaExistente = batalhaRepo.findById(id);
        if(batalhaExistente.isPresent()) {
            BatalhaModel batalhaAtualizada = batalhaMapper.toModel(batalhaDTO);
            batalhaAtualizada.setId(id);
            BatalhaModel batalhaSalva = batalhaRepo.save(batalhaAtualizada);
            return batalhaMapper.toDTO(batalhaSalva);
        }

        return null;

    }

    public void deletarBatalha(Long id) {
        batalhaRepo.deleteById(id);
    }




    }


