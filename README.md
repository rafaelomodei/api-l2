# L2 - API

Este repositório contém a API do servidor de jogo L2. Esta API é responsável pela comunicação entre o servidor do jogo e o front-end, proporcionando funcionalidades como login, registro de usuários, sistema de doações, e exibição do ranking dos jogadores.

## Tecnologias Utilizadas

- Java 17
- Spring Boot
- MySQL
- Maven

## Pré-requisitos

- Java JDK 17 ou superior
- Maven 3.6 ou superior
- MySQL (ou qualquer outro banco de dados compatível)
- IDE (recomendado: IntelliJ IDEA, Eclipse ou VS Code)

## Configuração do Banco de Dados

1. Crie um banco de dados MySQL:

   ```sql
   CREATE DATABASE l2_velha_guarda;
   ```

2. Atualize as informações de conexão no arquivo `application.properties` ou `application.yml` que está localizado na pasta `src/main/resources/`:

   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/l2_velha_guarda
   spring.datasource.username=SEU_USUARIO
   spring.datasource.password=SUA_SENHA
   spring.jpa.hibernate.ddl-auto=update
   spring.jpa.show-sql=true
   ```

## Instruções para Executar o Projeto

1. Clone o repositório:

   ```sh
   git clone https://github.com/rafaelomodei/api-l2
   cd l2_velha_guarda_api
   ```

2. Compile o projeto com Maven:

   ```sh
   mvn clean install
   ```

3. Execute a aplicação:

   ```sh
   mvn spring-boot:run
   ```

4. A API estará disponível em: [http://localhost:8080](http://localhost:8080)

## Endpoints Disponíveis

| Método | Endpoint             | Descrição                          |
| ------ | -------------------- | ---------------------------------- |
| POST   | `/api/auth/login`    | Realiza o login de um jogador      |
| POST   | `/api/auth/register` | Registra um novo jogador           |
| GET    | `/api/rank/top-pvp`  | Retorna o ranking de Top PVP       |
| GET    | `/api/rank/top-pk`   | Retorna o ranking de Top PK        |
| POST   | `/api/donation`      | Registra uma doação para moeda TKT |

## Testes

Para executar os testes:

```sh
mvn test
```
