# 📝 Lista de Tarefas - Spring Boot + Docker

Este projeto é uma aplicação para gerenciamento de tarefas (To-Do List), desenvolvida para demonstrar a integração entre Java, Spring Boot e PostgreSQL utilizando um ambiente totalmente conteinerizado com Docker.

## 🚀 Tecnologias Utilizadas
* **Java 25**
* **Spring Boot 4.0.2**
* **Spring Data JPA**
* **Thymeleaf**
* **PostgreSQL**
* **Docker & Docker Compose**
* **Maven**

---

## ⚙️ Como Configurar e Rodar

O projeto utiliza um sistema de variáveis de ambiente para proteger credenciais sensíveis e facilitar a portabilidade entre diferentes máquinas.

### 1. Preparação das Credenciais
Na raiz do projeto, existe um arquivo chamado `.env.example`.
1.  Crie uma cópia deste arquivo e renomeie para `.env`:
    ```bash
    cp .env.example .env
    ```
2.  Abra o arquivo `.env` e preencha as variáveis com suas configurações locais:
    - `DB_USER`: Usuário do banco de dados (ex: postgres).
    - `DB_PASSWORD`: Senha de sua preferência.
    - `DB`: Nome do banco de dados.
    - `PORT`: Porta onde o app rodará (ex: 8080).
    - `PORT_POSTGRES`: Porta do banco de dados (ex: 5432).

### 2. Build da Aplicação
1. Gere o arquivo executável `.jar`:
  ```bash
  ./mvnw package -DskipTests
  ```
2. Gere a imagem do app:
  ```bash
  docker build -t tarefas . 
  ```
3. Gere o container:
  ```bash
  docker-compose up -d
  ```
