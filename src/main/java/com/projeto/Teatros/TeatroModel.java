package com.projeto.Teatros;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.projeto.Batalhas.BatalhaModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "teatros")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class TeatroModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nome;

    @OneToMany(mappedBy = "teatro")
    @JsonIgnore
    private List<BatalhaModel> batalhas;





}
