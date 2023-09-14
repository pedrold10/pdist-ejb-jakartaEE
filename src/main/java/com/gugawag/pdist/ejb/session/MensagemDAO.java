package com.gugawag.pdist.ejb.session;

import com.gugawag.pdist.modelo.Mensagem;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Stateless
public class MensagemDAO {

    @PersistenceContext(unitName = "default")
    private EntityManager em;

    public void inserir(Mensagem mensagem){
        em.persist(mensagem);
    }


}
