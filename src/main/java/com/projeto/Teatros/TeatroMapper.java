package com.projeto.Teatros;

import org.springframework.stereotype.Component;

@Component
public class TeatroMapper {

    public TeatroModel toModel(TeatroDTO teatroDTO) {

        TeatroModel teatroModel = new TeatroModel();

        teatroModel.setNome(teatroDTO.getNome());

        return teatroModel;

    }

    public TeatroDTO toDTO(TeatroModel teatroModel) {

        TeatroDTO teatroDTO = new TeatroDTO();

        teatroDTO.setId(teatroModel.getId());
        teatroDTO.setNome(teatroModel.getNome());

        return teatroDTO;


    }



}
