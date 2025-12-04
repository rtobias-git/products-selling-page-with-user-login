
package br.edu.ifsp.pep.dao;

import br.edu.ifsp.pep.entidade.ItemVenda;
import br.edu.ifsp.pep.entidade.Produto;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.List;

/**
 *
 * @author aluno
 */
@Stateless
public class ProdutoDAO extends AbstractDAO<Produto> {
    
    public List<Produto> buscarTodos() {
        EntityManager em = getEntityManager();
        TypedQuery<Produto> query = em.createNamedQuery("Produto.buscarTodos", Produto.class);
        
        return query.getResultList();
    }
    
    public List<Produto> buscarPorNome() {
        return null;
    }
    
    public Produto buscarPorCodigo(Integer codigo) {
        
        EntityManager em = getEntityManager();
        return em.find(Produto.class, codigo);
    }
    
    public List<Produto> buscarPelaCategoria(Integer id) {
        EntityManager em = getEntityManager();
        TypedQuery<Produto> query = em.createNamedQuery("Produto.buscarPelaCategoria", Produto.class);
        query.setParameter("id", id);
        return query.getResultList();
    }
}
