# agrotis-api

Restful API com serviços de CREATE, READ, UPDATE e DELETE.

## Como utilizar?
Para realizar os testes, primeiro deve-se cadastrar uma **propriedade** e um **laboratório**.
Em seguida, cadastrar, consultar, editar ou excluir um usuário.

## Stack

**API:** Spring Boot, MySQL, Maven, etc.

**Unit Tests:** JUnit, Mockito

## Run Locally

Clone o projeto

```bash
  git clone https://github.com/flaviolima/agrotis-api.git
```

Vá para o diretório raiz do projeto

```bash
  cd agrotis-api
```
Editar credenciais do banco (mysql) no arquivo application.properties

```
# Configuration for MySQL Database
spring.jpa.hibernate.ddl-auto=update
spring.datasource.url = jdbc:mysql://localhost:3306/agrotis-db 
spring.datasource.username=root
spring.datasource.password=root@2022
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.show-sql:true
```

Maven build

```bash
  mvn clean install
```

Inicie o servidor

```bash
  mvn spring-boot:run
```

## API Reference
Os serviços foram desevolvidos para atender a demanda do [layout figma](https://github.com/matiassingers/awesome-readme) fornecido.

####  Cadastrar usuário

```http
  POST /users
```
Exemplo Request
```
{
	"name": "Flavio Lima",
	"startAt": "2022-02-02T17:41:44Z",
	"finishAt": "2023-02-02T17:41:44Z",
	"notes": "Observacao exemplo de teste",
	"property": {
		"id": 1
	},
	"laboratory": {
		"id": 9
	}
}
```

####  Atualizar usuário

```http
  PUT /users/${id}
```
Exemplo Request
```
{
	"name": "Flavio Oliveira",
	"startAt": "2022-03-02T17:41:44Z",
	"finishAt": "2023-06-02T17:41:44Z",
	"notes": "Observacao exemplo de testeste",
	"property": {
		"id": 2
	},
	"laboratory": {
		"id": 3
	}
}
```

#### Buscar todos usuários

```http
  GET /users
```

#### Buscar usuário por ID

```http
  GET /users/${id}
```

#### Excluir usuário

```http
  DELETE /users/${id}
```

#### Cadastrar laboratório

```http
  POST /laboratories
```

Exemplo Request
```
{
	"name": "Agro Flavio"
}
```

#### Buscar todos laboratórios

```http
  GET /laboratories
```

#### Cadastrar propriedade

```http
  POST /properties
```
Exemplo Request
```
{
	"name": "Agrotis 12",
	"document": 18402295000198
}
```

#### Buscar todas propriedades

```http
  GET /properties
```


## Insomnia test execution
[screen-capture.webm](https://user-images.githubusercontent.com/8599639/181623679-f49ecc09-851f-4dd6-9b17-d1cd41935354.webm)





