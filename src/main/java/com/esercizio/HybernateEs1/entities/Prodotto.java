package com.esercizio.HybernateEs1.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.*;

@Entity
public class Prodotto {
    private static List<Vendita> vendite =new ArrayList<>();
    @Id @GeneratedValue(
            strategy = GenerationType.AUTO
    )
    @Column(
            name = "id",
            updatable = false,
            nullable = false
    )
    private Long id;
    @Column(
            name = "Nome",
            unique = true
    )
    private String nome;
    @Column(
            name = "prezzo",
            nullable = false
    )
    private BigDecimal prezzo;

    @OneToMany(mappedBy = "prodotto", cascade = CascadeType.ALL, orphanRemoval = true)
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
}
