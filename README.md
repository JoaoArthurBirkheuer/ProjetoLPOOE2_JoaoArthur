# Projeto Biblioteca - LPOO

Este projeto é um sistema de gerenciamento de biblioteca desenvolvido para a disciplina de **Linguagem de Programação Orientada a Objetos (LPOO)**, sendo uma extensão do repositório ProjetoLPOOE1_JoaoArthur. Ele permite o cadastro e a administração de usuários, funcionários, livros e empréstimos utilizando **Java**, **JPA** (Java Persistence API) e o banco de dados **PostgreSQL**, bem como a manipulação desses dados através de uma interface gráfica por meio de JFrames e JDBC. Este sistema não só demonstra o uso de herança, associações e persistência de dados em um contexto de gerenciamento de biblioteca como também simula sua interface visual e permite manipulação facilitada dos dados através dela. 

## Estrutura do Projeto

O projeto utiliza **Apache Maven** para gerenciamento de dependências e estrutura. As configurações do banco de dados e o mapeamento de entidades são realizados com JPA, integrando o sistema ao PostgreSQL. Para a criação da interface visual, foram utilizadas estruturas JFrame - que, por sua vez, fazem uso de botões, caixas de texto, filtros de busca e demais elementos exigidos para a manipulação de usuários, funcionários, livros, empréstimos de livros e avaliações de livros.

### Principais Dependências

O arquivo `pom.xml` inclui as dependências necessárias para o funcionamento do projeto:

- **javax.persistence**: Biblioteca para uso de JPA na persistência de entidades e transações.
- **org.postgresql.Driver**: Driver JDBC para conexão ao banco de dados PostgreSQL.

## Configuração do Banco de Dados

O projeto está configurado para utilizar um banco de dados PostgreSQL chamado `BibliotecaLPOO`. As configurações de conexão são definidas no arquivo `persistence.xml`, localizado em `src/main/resources/META-INF`.

```xml
<persistence version="2.2" xmlns="http://xmlns.jcp.org/xml/ns/persistence" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/persistence           http://xmlns.jcp.org/xml/ns/persistence/persistence_2_2.xsd">
  <persistence-unit name="BibliotecaLPOO" transaction-type="RESOURCE_LOCAL">
    <provider>org.hibernate.jpa.HibernatePersistenceProvider</provider>
    <properties>
      <property name="javax.persistence.jdbc.url" value="jdbc:postgresql://localhost:5432/ProjetoLPOOE1_JoaoArthur"/>
      <property name="javax.persistence.jdbc.user" value="postgres"/>
      <property name="hibernate.hbm2ddl.auto" value="create"/>
      <property name="javax.persistence.jdbc.driver" value="org.postgresql.Driver"/>
      <property name="javax.persistence.jdbc.password" value="jb12"/>
      <property name="javax.persistence.schema-generation.database.action" value="drop-and-create"/>
      <property name="hibernate.dialect" value="org.hibernate.dialect.PostgreSQLDialect"/>
      <property name="hibernate.show_sql" value="true"/>
    </properties>
  </persistence-unit>
</persistence>
```

# Estrutura de Classes e Relacionamentos - Biblioteca

Este projeto utiliza **herança**, **associações** e o mapeamento ORM com JPA/Hibernate para modelar as entidades e suas interações em uma biblioteca.

![image](https://github.com/user-attachments/assets/43230b93-e437-4b1b-9fe4-55e5eb626559)

## Classes Principais

### **Pessoa** (`@MappedSuperclass`)
- Classe abstrata que serve como base para `Usuario` e `Funcionario`.
- **Não gera uma tabela própria no banco de dados**, pois utiliza a estratégia `InheritanceType.TABLE_PER_CLASS`. 
- Atributos comuns, herdados por `Usuario` e `Funcionario`:
  - `idPessoa`: identificador gerado automaticamente com `@SequenceGenerator`.
  - `nome`: obrigatório, limitado a 50 caracteres.
  - `cpf`: único, obrigatório, limitado a 11 caracteres.
  - `email`: único, obrigatório, limitado a 30 caracteres.
  - `ehFuncionario`: booleano que indica se a pessoa é um funcionário.

### **Usuario**
- Representa um usuário comum da biblioteca.
- Pode realizar empréstimos e avaliações.

### **Funcionario**
- Representa um funcionário da biblioteca.
- Além dos atributos herdados de `Pessoa`, possui:
  - `cargo`: obrigatório e único.
- Pode realizar empréstimos e avaliações.

### **Livro**
- Representa os livros disponíveis na biblioteca.
- Atributos:
  - `idLivro` (chave primária).
  - `titulo` (máximo de 100 caracteres).
  - `autor` (máximo de 50 caracteres).
- Possui uma lista de avaliações (`avaliacoes`) relacionadas ao livro.

### **Emprestimo**
- Representa um empréstimo realizado.
- Atributos:
  - `idEmprestimo` (chave primária).
  - `dataEmprestimo` e `dataDevolucao`.
- Relacionamentos:
  - Está associado a um `Usuario` ou a um `Funcionario`.
  - Pode conter múltiplos `Livro`, estabelecendo uma relação muitos-para-muitos.

### **Avaliacao**
- Representa as avaliações que podem ser feitas sobre um livro.
- Atributos:
  - `idAvaliacao` (chave primária).
  - `descricao`: texto da avaliação.
  - `nota`: uma nota de 0 a 10 (float).
  - `idLivro`: ID do livro avaliado.
  - `idPessoa`: ID da pessoa (usuário ou funcionário) que fez a avaliação.
- A relação que Funcionário e Usuário têm com a classe Avaliação é de um para muitos

---

## Relacionamentos e Mapeamento

### **Pessoa e Avaliacao**
- Uma `Pessoa` (seja `Usuario` ou `Funcionario`) pode fazer várias avaliações.
- Relacionamento de um-para-muitos entre `Pessoa` e `Avaliacao`.

### **Pessoa e Emprestimo**
- Um `Usuario` ou `Funcionario` pode ter vários empréstimos registrados.
- Relacionamento de um-para-muitos.

### **Livro e Avaliacao**
- Um livro pode ter várias avaliações.
- Relacionamento de um-para-muitos entre `Livro` e `Avaliacao`.

### **Livro e Emprestimo**
- Relacionamento muitos-para-muitos.
- Um `Emprestimo` pode incluir vários `Livro`, e cada `Livro` pode estar em múltiplos `Emprestimos`.

---

## Estrutura de Tabelas

As tabelas geradas pelo JPA representam as entidades concretas e suas relações:

- **`tb_usuario`**:
  - Representa os usuários da biblioteca.
  - Contém atributos herdados de `Pessoa`, como `idPessoa`, `nome`, `cpf` e `email`.

- **`tb_funcionario`**:
  - Representa os funcionários da biblioteca.
  - Contém atributos herdados de `Pessoa` e o campo adicional `cargo`.

- **`tb_livro`**:
  - Representa os livros disponíveis na biblioteca.
  - Contém atributos como `idLivro`, `titulo` e `autor`.

- **`tb_avaliacao`**:
  - Registra as avaliações realizadas.
  - Contém os campos `idAvaliacao`, `descricao`, `nota`, `idLivro` e `idPessoa`.

- **`tb_emprestimo`**:
  - Registra os empréstimos.
  - Contém os campos `idEmprestimo`, `dataEmprestimo` e `dataDevolucao`.

- **`tb_emprestimo_livro`**:
  - Tabela associativa para a relação muitos-para-muitos entre `Emprestimo` e `Livro`.

## Interface visual

### **MainJFrame**
- Tela principal, contendo atalhos para todas as outras: Pessoas (Usuários, Funcionários), Livros, Empréstimos, Avaliações e Sobre.

### **SobreJFrame**
- Tela contendo uma descrição geral a respeito do sistema e as funções por ele ofertadas.

### **TelaUsuarios**
- Tela que permite a visualização dos usuários cadastrados. Contém os botões "Mostrar dados" (mostra o ID, nome, CPF e email dos usuários cadastrados em uma tabela), "Novo registro" (leva à tela de cadastro de usuários), "Editar selecionado" (leva à tela de edição do usuário) e "Deletar selecionado" (exclui o usuário selecionado). Também possui um filtro de busca, que permite procurar por cadastros específicos.

**TelaCadastroUsuario**
- Tela aberta pelo botão "Novo registro" da TelaUsuarios, que permite a inserção de Nome, CPF e Email de um usuário e armazenamento dos dados
por meio do botão "Validar e Registrar".

**EdicaoCadastroUsuario**
- Tela que permite a edição de um usuário cadastrado e selecionado na TelaUsuarios, bem como o salvamento das alterações realizadas em seus dados.

### **TelaFuncionarios**
- Tela que permite a visualização dos funcionários cadastrados. Contém os botões "Mostrar dados" (mostra o ID, nome, CPF, email e cargo dos funcionários cadastrados em uma tabela), "Novo registro" (leva à tela de cadastro de funcionários), "Editar selecionado" (leva à tela de edição do funcionário) e "Deletar selecionado" (exclui o funcionário selecionado). Também possui um filtro de busca, que permite procurar por cadastros específicos.

**TelaCadastroFuncionario**
- Tela que permite o cadastro de novos funcionários, informando o ID, nome, CPF, email e cargo.

**EdicaoCadastroFuncionario**
- Tela que permite que um funcionário selecionado na tabela da TelaFuncionarios tenha seus dados editados e salvos.

### **TelaLivros**
- Tela que permite a visualização dos livros disponíveis no acervos - seu id, título e autor. Possui botões que levam a telas de inserção de novos livros no acervo, além de permitir a edição e deleção de livros já inclusos nele. Também possui um filtro de busca, que permite procurar por cadastros específicos.

**TelaCadastroLivro**
- Tela que permite a inserção de novos livros no acervo, informando o título e o autor da obra.

**EdicaoCadastroLivro**
- Tela que permite a edição dos dados de um livro presente no acervo e selecionado na TelaLivros, permitindo alteração de seus dados e o salvamento das alterações realizadas.

### **TelaEmprestimos**
- Tela que permite a visualização dos empréstimos realizados, contendo informações como quem o fez e os livros inclusos no empréstimo em uma tabela. Possui botões que levam a telas de inserções de novos empréstimos, edição e deleção de empréstimos existentes. Também possui um filtro de busca, que permite procurar por cadastros específicos.

**TelaCadastroEmpresimos**
- Tela que permite a inserção de empréstimos, realizados por um funcionário ou usuário e permitindo a inserção de um ou mais livros. Também inclui no banco de dados a data do empréstimo e o prazo de devolução.

**EdicaoCadastroEmprestimos**
- Tela aberta a partir da TelaEmprestimos que permite a edição de um emprestimo selecionado - como alterar os livros que compõe aquele empréstimo, retirar e/ou adicionar novos -, bem como salvar as alterações feitas.

### **TelaAvaliacao**
- Tela que permmite a visualização das avaliações feitas. Contém os botões "Mostrar dados" (mostra o ID do avaliador e o livro avaliado em uma tabela), "Inspecionar avaliação" (leva a uma tela que contém maiores informações sobre a avaliação selecionada), "Fazer avaliação" (permite ), "Editar Selecionado" (leva à tela de edição da avaliação) e "Deletar selecionado" (exclui a avaliação selecionada). Também possui um filtro de busca, que permite procurar por cadastros específicos.

**TelaInspecionarAvaliacao**
- Tela que mostra a avaliação selecionada na TelaAvaliacao, contendo o ID do avaliador, título do livro, a nota atribuída e a descrição da avaliação.

**TelaFazerAvaliacao**
- Tela que permite a seleção do nome de quem está avaliando, de um título do livro que deseja avaliar, dar uma nota de 1 a 10 através de um sistema de Star Rating e escrever uma descrição para a avaliação. Contém um botão de "Validar e Registrar" para salvar a avaliação feita.

**EdicaoAvaliacao**
- Tela que permite editar uma avaliação já realizada e inserida no banco de dados após selecioná-la na TelaAvaliacao, bem como salvar as alterações feitas.



---
