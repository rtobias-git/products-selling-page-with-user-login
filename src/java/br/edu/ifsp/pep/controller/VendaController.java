package br.edu.ifsp.pep.controller;

import br.edu.ifsp.pep.dao.CategoriaDAO;
import br.edu.ifsp.pep.dao.ProdutoDAO;
import br.edu.ifsp.pep.dao.VendaDAO;
import br.edu.ifsp.pep.entidade.Categoria;
import br.edu.ifsp.pep.entidade.ItemVenda;
import br.edu.ifsp.pep.entidade.Produto;
import br.edu.ifsp.pep.entidade.Venda;
import br.edu.ifsp.pep.util.Mensagem;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Named
//@RequestScoped
//@ViewScoped //Enquanto nao trocar de pagina ou atualizar a pagina
@SessionScoped
public class VendaController implements Serializable {

    @Inject
    private VendaDAO vendaDAO;

    @Inject
    private CategoriaDAO categoriaDAO;

    @Inject
    private ProdutoDAO produtoDAO;

    private Categoria categoria;
    
    private Integer categoriaSelecionadaCodigo;
    
    private Produto produtoSelecionado; //combobox - select
    private int quantidade;

    private List<Produto> produtosFiltrados;

    private Venda venda = new Venda();
    private List<ItemVenda> itensVenda = new ArrayList<>();

    public void adicionar() {

        for (ItemVenda itemVenda : itensVenda) {
            if (itemVenda.getProduto().getCodigo().equals(produtoSelecionado.getCodigo())) {
                itemVenda.setQuantidade(itemVenda.getQuantidade() + quantidade);
                return;
            }
        }

        ItemVenda item = new ItemVenda();
        item.setProduto(produtoSelecionado);
        item.setVenda(venda);
        item.setPreco(produtoSelecionado.getPreco());
        item.setQuantidade(quantidade);

        itensVenda.add(item);

    }

    public String finalizar() {

        try {
            double totalCalculado = getValorTotal();
            venda.setData(LocalDateTime.now());
            venda.setItens(itensVenda);

            vendaDAO.inserir(venda);

            //Iniciar nova venda
            venda = new Venda();
            itensVenda = new ArrayList<>();
            produtoSelecionado = null;
            quantidade = 0;

            FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
            Mensagem.sucesso("Venda Finzalizada: Total Pago: " + totalCalculado);
            return "/index?faces-redirect=true";
        } catch (Exception ex) {
            ex.printStackTrace();
            Mensagem.erro(ex.getMessage());
        }
        return null;
    }

    public void excluir(ItemVenda item) {
        try {
            this.itensVenda.remove(item);
            Mensagem.sucesso("Item removido.");
        } catch (Exception ex) {
            ex.printStackTrace();
            Mensagem.erro("Erro ao remover item: " + ex.getMessage());
        }
    }

    public List<Categoria> buscarCategorias() {
        return categoriaDAO.buscarTodas();
    }

    public void filtrar() {
        if (categoriaSelecionadaCodigo != null) {
            // Atualiza o objeto categoria e filtra produtos
            this.categoria = categoriaDAO.buscarPeloId(categoriaSelecionadaCodigo);
            this.produtosFiltrados = produtoDAO.buscarPelaCategoria(categoriaSelecionadaCodigo);
        } else {
            this.produtosFiltrados = produtoDAO.buscarTodos();
            this.categoria = null;
        }
    }

    public Integer getCategoriaSelecionadaCodigo() {
        return categoriaSelecionadaCodigo;
    }

    public void setCategoriaSelecionadaCodigo(Integer categoriaSelecionadaCodigo) {
        this.categoriaSelecionadaCodigo = categoriaSelecionadaCodigo;
    }
    
    public double getValorTotal() {
        double valorTotal = 0;
        for (ItemVenda itemVenda : itensVenda) {
            valorTotal += itemVenda.getPreco().doubleValue() * itemVenda.getQuantidade();
        }
        return valorTotal;
    }

    public List<Produto> getProdutosFiltrados() {
        if (produtosFiltrados == null) {
            produtosFiltrados = produtoDAO.buscarTodos();
        }
        return produtosFiltrados;
    }

    public List<Produto> buscarTodosProdutos() {
        return produtoDAO.buscarTodos();
    }

    public Produto getProdutoSelecionado() {
        return produtoSelecionado;
    }

    public void setProdutoSelecionado(Produto produtoSelecionado) {
        this.produtoSelecionado = produtoSelecionado;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public List<ItemVenda> getItensVenda() {
        return itensVenda;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

}
