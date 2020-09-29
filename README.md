# Cadastro-Eventos
CRUD de eventos e usuarios com spring e mysql


## Como funciona:
**Crie o banco de dados "eventos"**

`create database eventos`


**No arquivo `application.properties`:**

altere os valores de `spring.datasource.username` e `spring.datasource.password` de acordo com as configurações de instalação do seu MySql


## Como consumir o serviço:
**Função Listar tudo (GET):**

+ `http://localhost:8080/api/evento`
+ `http://localhost:8080/api/usuario`


**Função Listar um valor especifico (GET), onde "{id}" é o valor:**

+ `http://localhost:8080/api/evento/{id}`
+ `http://localhost:8080/api/usuario/{id}`


**Função Cadastrar (POST):**

+ `http://localhost:8080/api/produto`
+ `http://localhost:8080/api/usuario`


**Função Alterar (PUT), onde "{id} é o valor:**

+ `http://localhost:8080/api/produto/{id}`
+ `http://localhost:8080/api/usuario/{id}`


**Função Deletar (DELETE), onde "{id}" é o valor:**

+ `http://localhost:8080/api/produto/{id}`
+ `http://localhost:8080/api/usuario/{id}`

