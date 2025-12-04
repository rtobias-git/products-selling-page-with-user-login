package br.edu.ifsp.pep.controller;

import br.edu.ifsp.pep.dao.PessoaDAO;
import br.edu.ifsp.pep.entidade.Pessoa;
import br.edu.ifsp.pep.entidade.TipoPessoa;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aluno
 */
//Manage Bean -> permite o acesso pelo arquivo xhtml.
@Named(value = "pessoaController") 
@SessionScoped
public class PessoaController implements Serializable {
    
    @Inject()
    private PessoaDAO pessoaDAO;
    
    public void inserir() {
        System.out.println("metodo inserir.");
        
        Pessoa p = new Pessoa();
        p.setNome("Jose");
        p.setEmail("jose@email.com");
        p.setSalario(new BigDecimal(1000));
        p.setDataNascimento(LocalDate.now());
        p.setTipo(TipoPessoa.Gerente);
        
        try {
            pessoaDAO.inserir(p);
        } catch (Exception ex) {
            Logger.getLogger(PessoaController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
