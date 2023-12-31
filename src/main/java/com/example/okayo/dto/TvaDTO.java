package com.example.okayo.dto;

import java.util.Date;

import java.util.List;

import com.example.okayo.entity.Tva;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TvaDTO {
    private Long id;
    private Float valeur;
    private Date debut_validite;
    private Date fin_validite;

    private List<ProductDTO> products;

    public TvaDTO(Tva tva) {
        this.id = tva.getId();
        this.valeur = tva.getValeur();
        this.debut_validite = tva.getDebut_validite();
        this.fin_validite = tva.getFin_validite();
    }
}
