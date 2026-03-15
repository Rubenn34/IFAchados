# IFAchados

Sistema desenvolvido para auxiliar no **gerenciamento de objetos perdidos e encontrados** dentro de uma instituição.

O objetivo do sistema é registrar itens perdidos ou encontrados e auxiliar na identificação dos possíveis donos através de um **mecanismo de correspondência baseado em similaridade de características**.

---

## Sobre o Projeto

O **IFAchados** foi desenvolvido como projeto acadêmico com o propósito de aplicar conceitos de:

- Programação Orientada a Objetos
- Persistência de dados com banco de dados relacional
- Arquitetura em camadas
- Desenvolvimento de interfaces desktop em Java

O sistema permite registrar objetos perdidos ou encontrados, armazenar informações relevantes e sugerir possíveis correspondências entre registros.

---

## Funcionalidades

O sistema possui as seguintes funcionalidades:

- Cadastro de usuários
- Cadastro de objetos perdidos
- Cadastro de objetos encontrados
- Registro de devolução de objetos
- Consulta de itens cadastrados
- Sistema de correspondência entre itens perdidos e encontrados
- Interface gráfica para gerenciamento das informações

---

## Sistema de Correspondência de Itens

Uma das funcionalidades principais do sistema é o **mecanismo de correspondência (match) entre itens perdidos e encontrados**.

Quando um item é cadastrado, o sistema pode comparar suas características com outros registros existentes no banco de dados.

A análise considera atributos como:

- Nome do objeto
- Data em que foi perdido ou encontrado
- Local do ocorrido
- Descrição do item

Com base nesses dados, o sistema calcula o **grau de similaridade entre os registros** e sugere possíveis correspondências.

Esse recurso ajuda a identificar com mais facilidade os donos dos objetos encontrados.

---

## Tecnologias Utilizadas

O projeto foi desenvolvido utilizando as seguintes tecnologias:

- **Java**
- **Java Swing** (Interface gráfica)
- **MySQL**
- **JDBC**
- **Apache Ant** (build do projeto)
- **NetBeans**

---

## Arquitetura do Projeto

O projeto segue uma organização em camadas para separar responsabilidades.

### Camadas do sistema

**DAO (Data Access Object)**  
Responsável pela comunicação com o banco de dados.

**Domínio**  
Contém as classes que representam as entidades do sistema.

**UI (User Interface)**  
Responsável pela interface gráfica do sistema e interação com o usuário.

---

## Estrutura do Projeto

