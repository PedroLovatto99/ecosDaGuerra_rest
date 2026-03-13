package com.projeto.Teatros;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TeatroService {

    TeatroRepository teatroRepo;
    TeatroMapper teatroMapper;

    public TeatroService(TeatroRepository teatroRepo, TeatroMapper teatroMapper) {
        this.teatroRepo = teatroRepo;
        this.teatroMapper = teatroMapper;
    }


    public List<TeatroDTO> listarTeatros() {
        List<TeatroModel> teatros = teatroRepo.findAll();
        return teatros.stream()
                .map(teatroMapper::toDTO)
                .collect(Collectors.toList());
    }


    public TeatroDTO criarTeatro(TeatroDTO teatroDTO) {
        TeatroModel teatro = teatroMapper.toModel(teatroDTO);
        teatro = teatroRepo.save(teatro);
        return teatroMapper.toDTO(teatro);
    }

    public TeatroDTO AcharTeatroID(Long id) {
        Optional<TeatroModel> teatroPorID = teatroRepo.findById(id);
        return teatroPorID.map(teatroMapper::toDTO).orElse(null);
    }

    public TeatroDTO alterarTeatro(Long id, TeatroDTO teatroDTO) {
        Optional<TeatroModel> teatro = teatroRepo.findById(id);
        if(teatro.isPresent()) {
            TeatroModel teatroAtualizado = teatroMapper.toModel(teatroDTO);
            teatroAtualizado.setId(id);
            TeatroModel teatroSalvo = teatroRepo.save(teatroAtualizado);
            return teatroMapper.toDTO(teatroSalvo);

        }
        return null;
    }

    public void deletarTeatro(Long id) {
        teatroRepo.deleteById(id);
    }



}
