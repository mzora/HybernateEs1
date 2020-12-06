package com.esercizio.HybernateEs1.views;

import java.math.BigDecimal;

public class RispostaVenditaProdotto {
    private Integer numeroVendite;
    private BigDecimal ammontare;

    public RispostaVenditaProdotto(Integer numeroVendite, BigDecimal ammontare){
        this.numeroVendite = numeroVendite;
        this.ammontare = ammontare;
    }

    public Integer getNumeroVendite() {
        return numeroVendite;
    }
    public BigDecimal getAmmontare() {
        return ammontare;
    }
}
