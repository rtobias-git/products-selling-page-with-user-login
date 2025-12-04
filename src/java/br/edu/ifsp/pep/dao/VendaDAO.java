package br.edu.ifsp.pep.dao;

import br.edu.ifsp.pep.entidade.ItemVenda;
import br.edu.ifsp.pep.entidade.Produto;
import br.edu.ifsp.pep.entidade.Venda;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.List;

/**
 *
 * @author aluno
 */
@Stateless
public class VendaDAO extends AbstractDAO<Venda> {

    @Override
    public void inserir(Venda venda) throws Exception {
        EntityManager em = getEntityManager();
        try {
            for (ItemVenda item : venda.getItens()) {
                Produto produto = item.getProduto();
                produto.removerQuantidade(item.getQuantidade());
                em.merge(produto);
            }

            em.persist(venda);
            
        } catch (Exception ex) {
            try {
                em.getTransaction().rollback();
            } catch (IllegalStateException e) {
                throw new Exception(ex.getMessage());

            }
        }
    }
     
}
