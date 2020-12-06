package com.esercizio.HybernateEs1.services;

import com.esercizio.HybernateEs1.entities.Prodotto;
import com.esercizio.HybernateEs1.entities.Vendita;
import com.esercizio.HybernateEs1.repos.ProdottoRepo;
import com.esercizio.HybernateEs1.repos.VenditaRepo;
import com.esercizio.HybernateEs1.views.RispostaVenditaProdotto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

@Service
@Configurable
public class MainService {
    public RispostaVenditaProdotto getVenditeProdotto(Prodotto p){
        Integer numeroVendite = p.getVendite().stream().reduce(0,(acc,v)->acc+=v.getQuantita(), Integer::sum);
        return new RispostaVenditaProdotto(numeroVendite, p.getPrezzo().multiply(BigDecimal.valueOf(numeroVendite)));
    }
}
