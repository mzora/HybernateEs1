package com.esercizio.HybernateEs1.entities;

import javax.persistence.*;
import java.util.Optional;

@Entity
public class Vendita {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;
    @ManyToOne @JoinColumn(name="nome")
    private Prodotto prodotto;

    private Integer quantita;
    public Prodotto getProdotto() {
        return prodotto;
    }
    public void setProdotto(Prodotto p){
        this.prodotto=p;
    }

    public Vendita() {
    }

    public Vendita(Prodotto prodotto, Integer quantita) {
        this.prodotto = prodotto;
        this.quantita = quantita;
    }

    public Vendita(Optional<Prodotto> optProd, Integer quantita) {
        this.prodotto = prodotto;
        this.quantita = quantita;
    }

    public Integer getQuantita() {
        return quantita;
    }
}
