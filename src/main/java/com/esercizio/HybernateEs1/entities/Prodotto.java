package com.esercizio.HybernateEs1.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.*;

@Entity
public class Prodotto {
    @Id @GeneratedValue(
            strategy = GenerationType.AUTO
    )
    @Column(
            updatable = false,
            nullable = false
    )
    private Long id;

    @Column(
            unique = true
    )
    private String nome;

    @Column(nullable = false)
    private BigDecimal prezzo;

    @OneToMany(mappedBy = "prodotto", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Vendita> vendite =new ArrayList<>();

    public List<Vendita> getVendite(){
        return vendite;
    }

    public Prodotto() {
    }

    public Prodotto (String nome, BigDecimal prezzo) {
        this.nome = nome;
        this.prezzo = prezzo;
    }
    public String getNome() {
        return nome;
    }
    public BigDecimal getPrezzo() {
        return prezzo;
    }

    //Sostituita dalla fetch-lazy
    public void addVendita(Vendita v){
        vendite.add(v);
    }
}
