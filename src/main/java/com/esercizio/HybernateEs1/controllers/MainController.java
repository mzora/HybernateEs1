package com.esercizio.HybernateEs1.controllers;

import com.esercizio.HybernateEs1.entities.Prodotto;
import com.esercizio.HybernateEs1.entities.Vendita;
import com.esercizio.HybernateEs1.repos.ProdottoRepo;
import com.esercizio.HybernateEs1.repos.VenditaRepo;
import com.esercizio.HybernateEs1.services.MainService;
import com.esercizio.HybernateEs1.views.RispostaVenditaProdotto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Optional;

@RestController
//@RequestMapping("/api/")
public class MainController {
    @Autowired private ProdottoRepo pr;
    @Autowired private VenditaRepo vr;

    @GetMapping("/{nome}/{prezzo}")
    public String aggiungiProdotto(@PathVariable("nome") String nome, @PathVariable("prezzo") BigDecimal prezzo) {
        pr.save(new Prodotto(nome, prezzo));
        return "salvato!!!";
    }

    @GetMapping("/vendita/{nome}/{quantita}")
    public String venditaProdotto(@PathVariable("nome") String nome,
                                  @PathVariable("quantita") Integer quantita,
                                  @Autowired MainService ms)
    {
        Optional<Prodotto> optProd = pr.findByNome(nome);
        if(optProd.isPresent()){
            vr.save(new Vendita(optProd, quantita));
            RispostaVenditaProdotto rvp = ms.getVenditeProdotto(optProd.get());
            return "Numero di vendite: "+rvp.getNumeroVendite()+". Ammontare: "+rvp.getAmmontare();
        }else{
            return "Prodotto non presente!";
        }
    }


}
