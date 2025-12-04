package br.edu.ifsp.pep.dao;

import br.edu.ifsp.pep.entidade.Categoria;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.List;

@Stateless
public class CategoriaDAO extends AbstractDAO<Categoria>{
    
    public List<Categoria> buscarTodas() {
        EntityManager em = getEntityManager();
        TypedQuery<Categoria> query = em.createNamedQuery("Categoria.buscarTodas", Categoria.class);
        return query.getResultList();
    }
    
    public List<Categoria> buscarPeloNome(String nome) {
        EntityManager em = getEntityManager();
        TypedQuery<Categoria> query = em.createNamedQuery("Categoria.buscarPeloNome", Categoria.class);
        query.setParameter("nome", "%" + nome + "%");
        return query.getResultList();
    }
    
    public Categoria buscarPeloId(Integer id) {
        EntityManager em = getEntityManager();
        return em.find(Categoria.class, id);
    }
    
}
