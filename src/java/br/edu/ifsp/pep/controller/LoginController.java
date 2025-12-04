package br.edu.ifsp.pep.controller;

import br.edu.ifsp.pep.dao.PessoaDAO;
import br.edu.ifsp.pep.entidade.Pessoa;
import br.edu.ifsp.pep.util.Mensagem;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.Serializable;

@Named
@SessionScoped
public class LoginController implements Serializable {

    @Inject
    private PessoaDAO pessoaDAO;

    private String login;
    private String senha;
    private Pessoa pessoaLogada;

    public LoginController() {
        System.out.println("Construtor Login Controller");
    }

    public String acessar() {
        try {
            this.pessoaLogada = this.pessoaDAO.login(login, senha);
            this.login = "";
            this.senha = "";
            return "/index";
        } catch (Exception ex) {
            this.pessoaLogada = null;
            Mensagem.erro(ex.getMessage());
            return null;
        }
    }

    public Pessoa getPessoaLogada() {
        return pessoaLogada;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

}
