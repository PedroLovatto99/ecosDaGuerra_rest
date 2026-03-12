package com.projeto.Batalhas;
import com.projeto.Teatros.TeatroModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "batalhas")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class BatalhaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(nullable = false)
    private LocalDate dataInicio;

    @Column(nullable = false)
    private LocalDate dataFim;

    @ManyToOne
    @JoinColumn(name = "teatro_id")
    private TeatroModel teatro;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private BatalhaResultado resultado;



}
