package com.projeto.Batalhas;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.projeto.Teatros.TeatroModel;
import jakarta.persistence.*;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BatalhaDTO {

    @NotBlank
    @Size(max = 100)
    private String nome;

    @NotNull
    private LocalDate dataInicio;

    @NotNull
    private LocalDate dataFim;

    @NotNull
    private Long teatro_id;

    @NotNull
    private BatalhaResultado resultado;


    @JsonIgnore
    @AssertTrue(message = "A data de fim não pode ser anterior à data de início")
    public boolean isDataFimValida() {

        if (dataInicio == null || dataFim == null) {
            return true;
        }

        return !dataFim.isBefore(dataInicio);
    }



}
