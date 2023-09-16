package com.gugawag.pdist.ejb.session;

import com.gugawag.pdist.modelo.Mensagem;
import com.gugawag.pdist.modelo.Usuario;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;


import java.util.List;

@Stateless(name = "usuarioService")
public class UsuarioService {
    @EJB
    private UsuarioDAO usuarioDAO;

    @EJB
    private MensagemService mensagemService;
    public void inserir(long id, String nome) {
        Usuario novoUsuario = new Usuario(id, nome);
        this.usuarioDAO.inserir(novoUsuario);

        if(id==4){
            Mensagem mensagem = new Mensagem();
            mensagem.setTexto("Mensagem u4");
            this.mensagemService.inserir(novoUsuario.getId(), mensagem.getTexto());
        }
        if (id == 5) {
            Mensagem mensagem = new Mensagem();
            mensagem.setTexto("Mensagem u5");
            this.mensagemService.inserir(novoUsuario.getId(), mensagem.getTexto());
            throw new RuntimeException("Ocorreu uma exceção após a inserção da mensagem u5");
        }

    }

    public List<Usuario> listar() {
        return this.usuarioDAO.listar();
    }
}
