package br.edu.ifsp.pep.entidade;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

/**
 *
 * @author aluno
 */
@Entity
@Table(name = "produto")
@NamedQueries(value = {
    @NamedQuery(name = "Produto.buscarTodos", 
            query = "SELECT p FROM Produto p"),
    
    @NamedQuery(name = "Produto.buscarPelaCategoria", 
            query = "SELECT p FROM Produto p WHERE p.categoria.codigo = :codigo")
})
public class Produto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo", nullable = false)
    private Integer codigo;

    @Column(name = "nome", nullable = false, length = 40)
    private String nome;

    @Column(name = "preco", nullable = false, precision = 6, scale = 2)
    private BigDecimal preco;

    @Column(name = "quantidade", nullable = false)
    private Integer quantidade;

    @ManyToOne
    @JoinColumn(name = "categoria_codigo", nullable = false)
    private Categoria categoria;

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void removerQuantidade(Integer quantidade) throws Exception {
        if (quantidade == 0) {
            throw new Exception("Quantidade deve ser maior do que zero.");
        }

        if (this.quantidade < quantidade) {
            throw new Exception("Quantidade em estoque insuficiente.");
        }

        this.quantidade -= quantidade;
    }

//    public void setQuantidade(Integer quantidade) {
//        this.quantidade = quantidade;
//    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + Objects.hashCode(this.codigo);
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
        final Produto other = (Produto) obj;
        return Objects.equals(this.codigo, other.codigo);
    }

}
