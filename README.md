# Spring Boot com TDD

[![Build Status](https://travis-ci.com/andreepdias/library-api.svg?token=MbBidx96Qqj7iqHMZyDX&branch=main)](https://travis-ci.com/andreepdias/library-api)[![codecov](https://codecov.io/gh/andreepdias/library-api/branch/main/graph/badge.svg?token=TZWQD8V2VK)](https://codecov.io/gh/andreepdias/library-api)

API da aplicação de empréstimo de livros (para bibliotecas) desenvolvida em um curso da Udemy utilizando Spring Boot com Desenvolvimento Guiado por Testes (TDD).

## Padrões adotados
* Arquitetura em camadas (Controller, Service, Domain, Repository)
* Transferência de informações com objeto de transferência de dados (DTO)
* Validação com Bean Validation (implementação do Hibernate)
* Desenvolvimento guiado por testes (TDD)
  * Testes unitários das camadas de recursos (Controllers), serviço (Services)
  * Testes de integração com o banco de dados da camada de repositórios (Repositories)


## Tecnologias utlizadas

* JUnit 5 para testes unitários
* Mockito para Mock de objetos
* Documentação com Swagger
* Banco de dados relacional em memória (H2)
* Lombok para simplificação (menor verbosidade) do código
* MailTrap para envio de emails agendados em ambiente de desenvolvimento
* Linguagem de query do java persistence (JPQL)
* Travis-CI para integração contínua
* CodeCov com JaCoCo para análise de cobertura de código
* Heroku para deploy na nuvem


## Entidades

#### Book
Representa um livro no sistema. Composto por título, autor e ISBN.

#### Loan
Representa um empréstimo da aplicação. Composto cliente, data de empréstimo, estado (retornado ou não), e livro associado.
