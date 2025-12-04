SISTEMA DE GESTÃO DE VENDAS

1. CONTEXTO E OBJETIVO

Este projeto foi desenvolvido como um estudo para minha prova de ferramentas na faculdade.

O objetivo principal era:
- Criar uma interface web funcional para simular o ciclo de vida completo de uma transação de Ponto de Venda.

2. ARQUITETURA E TECNOLOGIAS

- TECNOLOGIAS PRINCIPAIS: JSF (com Facelets) e JPA.
- BACKEND: Java (Managed Beans).
- PERSISTÊNCIA: JPA (Mapeamento das entidades Produto, Venda e ItemVenda).
- FRONTEND: Componentes padrão do JSF (h:dataTable, h:commandButton, etc.).

3. FLUXO DE USO E FUNCIONALIDADES

O sistema opera em quatro etapas principais:

3.1. MÓDULO: AUTENTICAÇÃO (Login)
- Propósito: Acesso seguro ao sistema.
- Funcionalidade: Recebe 'Login' e 'Senha' para validar o usuário e liberar o acesso à área de vendas.
- Referência: 

3.2. MÓDULO: CRIAÇÃO DE VENDA (Venda)
- Propósito: Montar o pedido.
- Seleção de Produto: O usuário escolhe o produto em uma lista (ex: Arroz, Soja, Água Sanitária) e define a Quantidade.
- Ações: Botão 'Adicionar' inclui o item na tabela. Botão de lixeira ('Excluir') remove o item.
- Filtro: Permite filtrar produtos por 'Categoria' (ex: Graos).
- Próxima Etapa: O botão 'Visualizar Pedido' avança para a confirmação.

3.3. MÓDULO: CONFIRMAÇÃO
- Propósito: Revisão final e cálculo do total.
- Resumo: Exibe uma tabela com o Produto, Quantidade e Preço unitário de cada item.
- Cálculo: Exibe o valor 'Total' da venda (Ex: 27.0).
- Ação: O botão 'Finalizar' registra a venda (persistência JPA) e conclui a transação.

3.4. MÓDULO: FEEDBACK
- Propósito: Notificar o sucesso da operação.
- Mensagem: Exibe a notificação "Venda Finalizada: Total Pago: [Valor Total]" na página inicial.

4. EXEMPLO DE TRANSAÇÃO (RN.05)

- O sistema demonstra o cálculo de total através do seguinte pedido:
    - Arroz (1 x 13.00) = 13.00
    - Água Sanitária (1 x 5.00) = 5.00
    - Bolacha Recheada (3 x 3.00) = 9.00
- TOTAL DA VENDA = 27.00

5. REQUISITOS DE EXECUÇÃO

- Java JDK (Versão compatível com JSF/JPA)
- Servidor de Aplicações Java (Ex: WildFly, Tomcat com JSF, GlassFish)
- Gerenciador de Dependências (Ex: Maven ou Gradle)
