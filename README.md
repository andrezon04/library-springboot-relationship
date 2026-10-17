# API de biblioteca

API de estudo em Java e Spring Boot para praticar persistência e relacionamentos entre usuários, carteirinhas de biblioteca e empréstimos.

## Tecnologias

Java 25, Spring Boot 4.0.3, Spring Web MVC, Spring Data JPA, Hibernate, MySQL, Lombok e Maven Wrapper.

## Modelo de dados

| Entidade | Dados principais | Relacionamento |
| --- | --- | --- |
| `User` | Identificador, nome e e-mail | Uma carteirinha e uma lista de empréstimos. |
| `LibraryWallet` | Número, data de emissão e validade | Associação um para um com o usuário. |
| `Loan` | Identificador, data do empréstimo e data de devolução | Associação muitos para um com o usuário. |

## Como executar

1. Instale o JDK 25 e disponibilize uma instância do MySQL.
2. Clone o projeto:

```bash
git clone https://github.com/andrezon04/library-springboot-relationship.git
cd library-springboot-relationship
```

3. Crie o banco de dados:

```sql
CREATE DATABASE db_library;
```

4. Defina a conexão por variáveis de ambiente. Exemplo em Bash:

```bash
export SPRING_DATASOURCE_URL='jdbc:mysql://localhost:3306/db_library'
export SPRING_DATASOURCE_USERNAME='seu_usuario'
export SPRING_DATASOURCE_PASSWORD='sua_senha'
```

5. Inicie a aplicação:

```bash
bash mvnw spring-boot:run
```

No Windows, use `mvnw.cmd spring-boot:run`. A URL padrão é `http://localhost:8080`. A configuração atual usa `ddl-auto=update` para atualizar o esquema durante os estudos.

## Endpoints implementados

| Método | Rota | Operação |
| --- | --- | --- |
| POST | `/users` | Salvar usuário. |
| GET | `/users` | Listar usuários. |
| GET | `/users/{id}` | Consultar usuário por identificador. |
| DELETE | `/users/{id}` | Excluir usuário. |
| POST | `/librarywallets` | Salvar carteirinha. |
| POST | `/loans` | Salvar empréstimo. |
| GET | `/loans` | Listar empréstimos. |
| GET | `/loans/{id}` | Consultar empréstimo por identificador. |
| DELETE | `/loans/{id}` | Excluir empréstimo. |

Exemplo de criação de usuário:

```bash
curl -X POST http://localhost:8080/users \
  -H 'Content-Type: application/json' \
  -d '{"name":"Pessoa de exemplo","email":"pessoa@example.com"}'
```

## Verificação

```bash
bash mvnw test
```

O teste existente verifica o carregamento do contexto Spring e depende da configuração do banco. Ainda não há testes específicos das regras de empréstimo.

## Estado do projeto e próximos passos

Este repositório demonstra mapeamentos JPA e operações básicas. Os controllers acessam diretamente os repositories e recebem entidades no corpo das requisições.

Melhorias previstas: separar regras em serviços, criar DTOs, validar entradas, definir respostas para registros inexistentes, controlar a serialização dos relacionamentos bidirecionais e adicionar testes de comportamento.

