package br.edu.ifsp.pep.entidade;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author aluno
 */
@Entity
@Table(name = "pessoa")
@NamedQueries(value = {
    @NamedQuery(name = "Pessoa.buscarTodas", query = "FROM Pessoa p"),
    @NamedQuery(name = "Pessoa.login", query = "FROM Pessoa p WHERE p.login = :login AND p.senha = :senha")
})
public class Pessoa implements Serializable {

    @Id //chave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto increment
    @Column(name = "codigo")
    private Integer codigo;

    @Column(name = "nome", nullable = false, length = 80)
    /*
    name -> nome do atributo no banco de dados.
    nullable -> define se o atributo pode se null.
    length -> tamanho do varchar.
     */
    private String nome;

    @Column(name = "data_nascimento", nullable = false)
    private LocalDate dataNascimento;

    @Column(name = "salario", nullable = false, scale = 2, precision = 8)
    /*
    precision -> tamanho do valor decimal.
    scale -> quantidade de casas decimais.
     */
    private BigDecimal salario;

    @Column(name = "email", nullable = false, length = 80, unique = true)
    //unique -> define se o atributo pode nao pode ser repetido (unico).ú
    private String email;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo", nullable = false, length = 15)
    private TipoPessoa tipo;

    @ManyToMany
    @JoinTable(name = "pessoa_veiculo",
            joinColumns = @JoinColumn(name = "pessoa_codigo"),
            inverseJoinColumns = @JoinColumn(name = "veiculo_codigo")
    )
    private List<Veiculo> veiculos;
    
    @Column(name = "login", length = 20, nullable = false, unique = true)
    private String login;
    
    @Column(name = "senha", length = 10, nullable = false)
    private String senha;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
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

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public TipoPessoa getTipo() {
        return tipo;
    }

    public void setTipo(TipoPessoa tipo) {
        this.tipo = tipo;
    }

    public List<Veiculo> getVeiculos() {
        return veiculos;
    }

    public void setVeiculos(List<Veiculo> veiculos) {
        this.veiculos = veiculos;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.codigo);
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
        final Pessoa other = (Pessoa) obj;
        return Objects.equals(this.codigo, other.codigo);
    }

}
