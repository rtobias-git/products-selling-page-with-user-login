package br.edu.ifsp.pep.entidade;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

/**
 *
 * @author aluno
 */
@Entity
@Table(name = "item_venda")
@IdClass(ItemVendaPK.class)
public class ItemVenda implements Serializable {
    
    @Id
    @JoinColumn(name = "produto_id", nullable = false)
    private Produto produto;
    
    @Id
    @JoinColumn(name = "venda_id", nullable = false)
    private Venda venda;
    
    @Column(name = "quantidade", nullable = false)
    private int quantidade;
    
    @Column(name = "preco", nullable = false, precision = 6, scale = 2)
    private BigDecimal preco;

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + Objects.hashCode(this.produto);
        hash = 23 * hash + Objects.hashCode(this.venda);
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
        final ItemVenda other = (ItemVenda) obj;
        if (!Objects.equals(this.produto, other.produto)) {
            return false;
        }
        return Objects.equals(this.venda, other.venda);
    }
    
    
    
}
