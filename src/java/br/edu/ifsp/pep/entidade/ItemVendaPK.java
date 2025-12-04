package br.edu.ifsp.pep.entidade;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author aluno
 */
public class ItemVendaPK implements Serializable {
    
    private Integer venda;
    
    private Integer produto;

    public Integer getVenda() {
        return venda;
    }

    public void setVenda(Integer venda) {
        this.venda = venda;
    }

    public Integer getProduto() {
        return produto;
    }

    public void setProduto(Integer produto) {
        this.produto = produto;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + Objects.hashCode(this.venda);
        hash = 89 * hash + Objects.hashCode(this.produto);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ItemVendaPK other = (ItemVendaPK) obj;
        if (!Objects.equals(this.venda, other.venda)) {
            return false;
        }
        return Objects.equals(this.produto, other.produto);
    }
    
    
}
