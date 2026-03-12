package com.projeto.Batalhas;

import com.projeto.Teatros.TeatroModel;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class BatalhaMapper {

    public BatalhaModel toModel(BatalhaDTO batalhaDTO) {

        BatalhaModel batalhaModel = new BatalhaModel();

        batalhaModel.setNome(batalhaDTO.getNome());
        batalhaModel.setDataInicio(batalhaDTO.getDataInicio());
        batalhaModel.setDataFim(batalhaDTO.getDataFim());
        batalhaModel.setResultado(batalhaDTO.getResultado());

        TeatroModel teatro = new TeatroModel();
        teatro.setId(batalhaDTO.getTeatro_id());
        batalhaModel.setTeatro(teatro);

        return batalhaModel;

    }

    public BatalhaDTO toDTO(BatalhaModel batalhaModel) {

        BatalhaDTO batalhaDTO = new BatalhaDTO();

        batalhaDTO.setNome(batalhaModel.getNome());
        batalhaDTO.setDataInicio(batalhaModel.getDataInicio());
        batalhaDTO.setDataFim(batalhaModel.getDataFim());
        batalhaDTO.setTeatro_id(batalhaModel.getTeatro().getId());
        batalhaDTO.setResultado(batalhaModel.getResultado());

        return batalhaDTO;

    }



}
