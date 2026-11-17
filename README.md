# 🛒 Sistema de Gestão de Vendas com Login e Controle de Acesso

![Java](https://img.shields.io/badge/Java-17-orange?style=for-the-badge&logo=openjdk&logoColor=white)
![Jakarta EE](https://img.shields.io/badge/Jakarta%20EE-10-blue?style=for-the-badge&logo=eclipse&logoColor=white)
![PrimeFaces](https://img.shields.io/badge/PrimeFaces-15.0-007ACC?style=for-the-badge)
![JPA](https://img.shields.io/badge/JPA-Hibernate%2FEclipseLink-59666C?style=for-the-badge)
![MySQL](https://img.shields.io/badge/MySQL-Database-4479A1?style=for-the-badge&logo=mysql&logoColor=white)

Aplicação web desenvolvida em **Java com Jakarta EE (JSF/Facelets, JPA, CDI e EJB)** e **PrimeFaces** como projeto de preparação e estudo para a avaliação da disciplina de **Ferramentas de Programação** (IFSP Campus Presidente Epitácio). O sistema implementa autenticação de usuários, controle de acesso por `PhaseListener` e todo o ciclo de criação e finalização de pedidos de venda.

---

## 📸 Capturas de Tela

| Tela de Login | Seleção de Produtos |
| :---: | :---: |
| ![Tela de Login](images-to-the-project/user%20login%20interface.png) | ![Seleção de Produtos](images-to-the-project/menu%20to%20select%20items.png) |

| Adição, Filtro por Categoria e Exclusão de Itens | Pedido Montado no Carrinho |
| :---: | :---: |
| ![Gerenciamento do Pedido](images-to-the-project/interface%20to%20add%20items%20to%20the%20order,%20including%20filtering%20and%20removing.png) | ![Itens Selecionados](images-to-the-project/selected%20product%20to%20finalize%20purchase.png) |

| Confirmação e Total da Venda | Venda Finalizada com Notificação |
| :---: | :---: |
| ![Confirmação da Venda](images-to-the-project/screen%20for%20finalization%20of%20the%20sale.png) | ![Venda Finalizada](images-to-the-project/interface%20after%20finalizing%20purchase.png) |

---

## ⚙️ Funcionalidades e Fluxo do Sistema

1. **Autenticação (`login.xhtml` e `LoginController`):**
   - Validação de **Login** e **Senha** no banco via `PessoaDAO`.
   - Armazenamento da sessão do usuário logado em bean `@SessionScoped`.

2. **Controle de Acesso (`ControleAcessoListener`):**
   - Implementa `PhaseListener` do Jakarta Faces para interceptar requisições à página `/venda/criar.xhtml`.
   - Caso o usuário não esteja autenticado, redireciona automaticamente para `/acesso-negado.xhtml`.

3. **Criação da Venda (`venda/criar.xhtml` e `VendaController`):**
   - Seleção de produto e definição da quantidade; ao adicionar um produto já presente no pedido, a quantidade é somada automaticamente.
   - **Filtro por Categoria:** permite filtrar a lista de produtos disponíveis por categoria.
   - **Exclusão de Item:** botão com ícone de lixeira para remover itens da tabela antes do fechamento.

4. **Confirmação e Persistência (`venda/visualizar.xhtml`):**
   - Exibe o resumo dos itens, quantidades, preços unitários e o valor **Total** calculado.
   - Ao clicar em **Finalizar**, registra a data/hora atual (`LocalDateTime.now()`), persiste a `Venda` e seus `ItemVenda` via `VendaDAO`, limpa o carrinho e redireciona para a página inicial com a mensagem flash `"Venda Finzalizada: Total Pago: [valor]"`.

---

## 📁 Estrutura do Projeto

```text
products-selling-page-with-user-login/
├── src/
│   ├── conf/
│   │   └── persistence.xml
│   └── java/br/edu/ifsp/pep/
│       ├── controller/
│       │   ├── LoginController.java
│       │   ├── PessoaController.java
│       │   └── VendaController.java
│       ├── converter/
│       │   └── ProdutoConverter.java
│       ├── dao/
│       │   ├── CategoriaDAO.java
│       │   ├── PessoaDAO.java
│       │   ├── ProdutoDAO.java
│       │   └── VendaDAO.java
│       ├── entidade/
│       │   ├── Categoria.java
│       │   ├── Endereco.java
│       │   ├── ItemVenda.java
│       │   ├── ItemVendaPK.java
│       │   ├── Pessoa.java
│       │   ├── Produto.java
│       │   ├── TipoPessoa.java
│       │   ├── TipoVeiculo.java
│       │   ├── Veiculo.java
│       │   └── Venda.java
│       └── listener/
│           └── ControleAcessoListener.java
├── web/
│   ├── acesso-negado.xhtml
│   ├── index.xhtml
│   ├── login.xhtml
│   ├── venda/
│   │   ├── criar.xhtml
│   │   └── visualizar.xhtml
│   └── WEB-INF/
│       ├── faces-config.xml
│       ├── glassfish-resources.xml
│       └── template.xhtml
└── images-to-the-project/               # Capturas de tela do sistema
```

---

## 🚀 Requisitos de Execução

- **Java JDK 17+**
- **Servidor de Aplicação Jakarta EE** (ex.: GlassFish 7 ou WildFly)
- **Banco de Dados MySQL** configurado conforme `web/WEB-INF/glassfish-resources.xml` (`java:app/jdbc/db_jpa`)
- **Apache NetBeans** (ou ferramenta compatível com projetos Ant)

---

## 👤 Autor

Desenvolvido por **Tobias Rafael** ([@rtobias-git](https://github.com/rtobias-git)) — IFSP Campus Presidente Epitácio.
