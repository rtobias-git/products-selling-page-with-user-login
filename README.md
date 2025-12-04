SALES MANAGEMENT SYSTEM

1. CONTEXT AND OBJECTIVE

This project was developed as a study for my college tools exam.

The main objective was:
- To create a functional web interface to simulate the complete life cycle of a Point of Sale transaction.

2. ARCHITECTURE AND TECHNOLOGIES

- CORE TECHNOLOGIES: JSF (with Facelets) and JPA.
- BACKEND: Java (Managed Beans).
- PERSISTENCE: JPA (Mapping of entities: Product, Sale, and SaleItem).
- FRONTEND: Standard JSF components (h:dataTable, h:commandButton, etc.).

3. WORKFLOW AND FUNCTIONALITIES

The system operates in four main stages:

3.1. MODULE: AUTHENTICATION (Login)
- Purpose: Secure access to the system.
- Functionality: Receives 'Login' and 'Senha' (Password) to validate the user and grant access to the sales area.
- Reference: 

3.2. MODULE: SALE CREATION (Venda)
- Purpose: Assemble the order.
- Product Selection: The user chooses the product from a list (e.g., Rice, Soy, Bleach) and defines the Quantity.
- Actions: 'Adicionar' (Add) button includes the item in the table. Trash can icon ('Excluir' - Exclude) removes the item.
- Filter: Allows filtering products by 'Categoria' (Category, e.g., Grains).
- Next Step: The 'Visualizar Pedido' (View Order) button advances to confirmation.

3.3. MODULE: CONFIRMATION
- Purpose: Final review and total calculation.
- Summary: Displays a table with the Product, Quantity, and Unit Price of each item.
- Calculation: Displays the 'Total' sale amount (E.g., 27.0).
- Action: The 'Finalizar' (Finalize) button registers the sale (JPA persistence) and completes the transaction.

3.4. MODULE: FEEDBACK
- Purpose: Notify the success of the operation.
- Message: Displays the notification "Venda Finalizada: Total Pago: [Total Amount]" (Sale Finalized: Total Paid: [Total Amount]) on the homepage.

4. TRANSACTION EXAMPLE (RN.05)

- The system demonstrates the total calculation using the following order:
    - Arroz (Rice) (1 x 13.00) = 13.00
    - Água Sanitária (Bleach) (1 x 5.00) = 5.00
    - Bolacha Recheada (Filled Cookie) (3 x 3.00) = 9.00
- TOTAL SALE = 27.00

5. EXECUTION REQUIREMENTS

- Java JDK (Version compatible with JSF/JPA)
- Java Application Server (E.g., WildFly, Tomcat with JSF, GlassFish)
- Dependency Manager (E.g., Maven or Gradle)
