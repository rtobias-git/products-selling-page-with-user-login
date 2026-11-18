# Sistema de Gestão de Vendas com Login

![Java](https://img.shields.io/badge/Java-17-orange?style=for-the-badge&logo=openjdk&logoColor=white)
![Jakarta EE](https://img.shields.io/badge/Jakarta%20EE-10-blue?style=for-the-badge&logo=eclipse&logoColor=white)
![PrimeFaces](https://img.shields.io/badge/PrimeFaces-15.0-007ACC?style=for-the-badge)
![JPA](https://img.shields.io/badge/JPA-Hibernate%2FEclipseLink-59666C?style=for-the-badge)
![MySQL](https://img.shields.io/badge/MySQL-Database-4479A1?style=for-the-badge&logo=mysql&logoColor=white)

Aplicação web desenvolvida em Java com Jakarta EE (JSF, JPA, CDI e EJB) e PrimeFaces como projeto prático para a disciplina de Ferramentas de Programação no IFSP (Campus Presidente Epitácio). O sistema conta com autenticação de usuários, controle de rotas por PhaseListener e fluxo de vendas com montagem de pedido.

---

## Capturas de tela

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

## Funcionalidades

1. **Autenticação de usuários:** tela de login com validação de credenciais no banco via PessoaDAO e gerenciamento de sessão com SessionScoped.
2. **Controle de acesso:** interceptação de requisições com PhaseListener para proteger a página de vendas, redirecionando acessos não autorizados para a tela de acesso negado.
3. **Gerenciamento do pedido:** seleção de itens, soma automática de produtos repetidos, filtro de listagem por categoria e exclusão individual de itens antes da confirmação.
4. **Fechamento e persistência:** cálculo do valor total, registro da data/hora atual e gravação da venda e dos itens no banco de dados via JPA.

---

## Estrutura do projeto

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

## Como executar

### Pré-requisitos
- Java JDK 17 ou superior
- Servidor Jakarta EE (como GlassFish 7)
- Banco de dados MySQL rodando localmente
- NetBeans configurado para projetos web

### Passos
1. Clone o repositório:
   ```bash
   git clone https://github.com/rtobias-git/products-selling-page-with-user-login.git
   ```
2. Ajuste o arquivo `web/WEB-INF/glassfish-resources.xml` com as credenciais do seu banco MySQL.
3. Abra o projeto na sua IDE e execute o deploy no servidor GlassFish.

---

## Autor

Desenvolvido por **Tobias Rafael** ([@rtobias-git](https://github.com/rtobias-git)), estudante do IFSP Campus Presidente Epitácio.
