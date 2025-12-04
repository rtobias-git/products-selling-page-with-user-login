package br.edu.ifsp.pep.dao;

import br.edu.ifsp.pep.entidade.Pessoa;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import java.util.List;

/**
 *
 * @author aluno
 */
@Stateless
public class PessoaDAO extends AbstractDAO<Pessoa> {

    public List<Pessoa> buscarTodas() {

        EntityManager em = getEntityManager();
        TypedQuery<Pessoa> query = em.createNamedQuery("Pessoa.buscarTodas", Pessoa.class);

        return query.getResultList();
    }

    public Pessoa login(String login, String senha) throws Exception {
        EntityManager em = getEntityManager();
        TypedQuery<Pessoa> query = em.createNamedQuery("Pessoa.login", Pessoa.class);
        query.setParameter("login", login);
        query.setParameter("senha", senha);

        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            throw new Exception("Login ou Senha incorretos.");
        }
    }
}
