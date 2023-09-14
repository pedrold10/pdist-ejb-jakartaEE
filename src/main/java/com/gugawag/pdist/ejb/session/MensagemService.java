package com.gugawag.pdist.ejb.session;

import com.gugawag.pdist.modelo.Mensagem;
import com.gugawag.pdist.modelo.Usuario;
import jakarta.ejb.EJB;

import java.util.List;

public class MensagemService {

    @EJB
    private MensagemDAO mensagemDAO;

    public void inserir(long id, String texto){
        Mensagem mensagem = new Mensagem(id, texto);
        this.mensagemDAO.inserir(mensagem);
    }

    public List<Mensagem> listar(){
        return this.mensagemDAO.listar();
    }
}
