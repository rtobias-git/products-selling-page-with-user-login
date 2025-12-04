package br.edu.ifsp.pep.converter;

import br.edu.ifsp.pep.dao.ProdutoDAO;
import br.edu.ifsp.pep.entidade.Produto;
import jakarta.enterprise.inject.spi.CDI;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;

@FacesConverter(forClass = Produto.class)
public class ProdutoConverter implements Converter<Produto>{
    
    @Override
    public Produto getAsObject(FacesContext fc, UIComponent uic, String string) {
        if (string == null) {
            return null;
        }
        //Obtem o DAO
        ProdutoDAO produtoDAO = CDI.current().select(ProdutoDAO.class).get();
        
        //Busca no BD
        return produtoDAO.buscarPorCodigo(Integer.valueOf(string));
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Produto produto) {
        return produto == null ? null : produto.getCodigo().toString();
    }
      
}
