# GerenciamentoPessoal

API REST para gerenciamento de tarefas pessoais desenvolvida com Spring Boot.

---

# Tecnologias Utilizadas

* Java
* Spring Boot
* Spring Web
* Spring Data JPA
* PostgreSQL
* Lombok
* Bean Validation
* Swagger/OpenAPI

---

# Funcionalidades

A API permite:

* Listar tarefas
* Buscar tarefa por ID
* Criar tarefa
* Atualizar tarefa
* Deletar tarefa
* Validar dados enviados pelo cliente
* Tratar erros de forma personalizada
* Documentação automática com Swagger
* Versionamento da API

---

# URL Base da API

```http
http://localhost:8080
```

---

# Versão da API

Foi implementado o versionamento por URL.

```http
/api/v1/tarefas
```

---

# Estrutura dos Endpoints

## Listar todas as tarefas

### GET

```http
GET /api/v1/tarefas
```

### Resposta

```json
[
  {
    "id": 1,
    "titulo": "Organizar tarefas",
    "descricao": "Cadastrar atividades pendentes",
    "concluida": false
  }
]
```

### Status HTTP

| Código | Descrição |
| ------ | --------- |
| 200    | OK        |

---

## Buscar tarefa por ID

### GET

```http
GET /api/v1/tarefas/{id}
```

### Exemplo

```http
GET /api/v1/tarefas/1
```

### Status HTTP

| Código | Descrição |
| ------ | --------- |
| 200    | OK        |
| 404    | Not Found |

---

## Criar nova tarefa

### POST

```http
POST /api/v1/tarefas
```

### Body JSON

```json
{
  "titulo": "Fazer compras",
  "descricao": "Comprar mantimentos para todo o mês",
  "concluida": false
}
```

### Status HTTP

| Código | Descrição   |
| ------ | ----------- |
| 201    | Created     |
| 400    | Bad Request |

---

## Atualizar tarefa

### PUT

```http
PUT /api/v1/tarefas/{id}
```

### Exemplo

```http
PUT /api/v1/tarefas/1
```

### Body JSON

```json
{
  "titulo": "Fazer compras atualizado",
  "descricao": "Comprar somente o que falta",
  "concluida": true
}
```

### Status HTTP

| Código | Descrição   |
| ------ | ----------- |
| 200    | OK          |
| 400    | Bad Request |
| 404    | Not Found   |

---

## Deletar tarefa

### DELETE

```http
DELETE /api/v1/tarefas/{id}
```

### Exemplo

```http
DELETE /api/v1/tarefas/1
```

### Status HTTP

| Código | Descrição  |
| ------ | ---------- |
| 204    | No Content |
| 404    | Not Found  |

---

# # Endpoints da API

## 1. Listar todas as tarefas

Retorna todas as tarefas cadastradas no sistema.

### Método

```http
GET /api/v1/tarefas
```

### Parâmetros

Nenhum.

### Exemplo de Requisição

```http
GET http://localhost:8080/api/v1/tarefas
```

### Resposta de Sucesso (200 OK)

```json
[
  {
    "id": 1,
    "titulo": "Organizar tarefas",
    "descricao": "Cadastrar atividades pendentes",
    "concluida": false
  }
]
```

### Códigos de Resposta

| Código | Descrição                   |
| ------ | --------------------------- |
| 200    | Lista retornada com sucesso |
| 500    | Erro interno do servidor    |

---

## 2. Buscar tarefa por ID

Retorna uma tarefa específica.

### Método

```http
GET /api/v1/tarefas/{id}
```

### Parâmetros

| Parâmetro | Tipo | Descrição               |
| --------- | ---- | ----------------------- |
| id        | Long | Identificador da tarefa |

### Exemplo de Requisição

```http
GET http://localhost:8080/api/v1/tarefas/1
```

### Resposta de Sucesso (200 OK)

```json
{
  "id": 1,
  "titulo": "Organizar tarefas",
  "descricao": "Cadastrar atividades pendentes",
  "concluida": false
}
```

### Resposta de Erro (404 Not Found)

```json
{
  "mensagem": "Tarefa não encontrada",
  "status": 404
}
```

### Códigos de Resposta

| Código | Descrição                |
| ------ | ------------------------ |
| 200    | Tarefa encontrada        |
| 404    | Tarefa não encontrada    |
| 500    | Erro interno do servidor |

---

## 3. Criar nova tarefa

Cria uma nova tarefa.

### Método

```http
POST /api/v1/tarefas
```

### Body JSON

| Campo     | Tipo    | Obrigatório |
| --------- | ------- | ----------- |
| titulo    | String  | Sim         |
| descricao | String  | Sim         |
| concluida | Boolean | Sim         |

### Exemplo de Requisição

```json
{
  "titulo": "Fazer compras",
  "descricao": "Comprar mantimentos para o mês",
  "concluida": false
}
```

### Resposta de Sucesso (201 Created)

```json
{
  "id": 1,
  "titulo": "Fazer compras",
  "descricao": "Comprar mantimentos para o mês",
  "concluida": false
}
```

### Resposta de Erro (400 Bad Request)

```json
{
  "mensagem": "O título é obrigatório",
  "status": 400
}
```

### Códigos de Resposta

| Código | Descrição                 |
| ------ | ------------------------- |
| 201    | Tarefa criada com sucesso |
| 400    | Dados inválidos           |
| 500    | Erro interno do servidor  |

---

## 4. Atualizar tarefa

Atualiza uma tarefa existente.

### Método

```http
PUT /api/v1/tarefas/{id}
```

### Parâmetros

| Parâmetro | Tipo | Descrição               |
| --------- | ---- | ----------------------- |
| id        | Long | Identificador da tarefa |

### Exemplo de Requisição

```json
{
  "titulo": "Fazer compras atualizado",
  "descricao": "Comprar somente o que falta",
  "concluida": true
}
```

### Resposta de Sucesso (200 OK)

```json
{
  "id": 1,
  "titulo": "Fazer compras atualizado",
  "descricao": "Comprar somente o que falta",
  "concluida": true
}
```

### Resposta de Erro (404 Not Found)

```json
{
  "mensagem": "Tarefa não encontrada",
  "status": 404
}
```

### Códigos de Resposta

| Código | Descrição                     |
| ------ | ----------------------------- |
| 200    | Tarefa atualizada com sucesso |
| 400    | Dados inválidos               |
| 404    | Tarefa não encontrada         |
| 500    | Erro interno do servidor      |

---

## 5. Excluir tarefa

Remove uma tarefa do sistema.

### Método

```http
DELETE /api/v1/tarefas/{id}
```

### Parâmetros

| Parâmetro | Tipo | Descrição               |
| --------- | ---- | ----------------------- |
| id        | Long | Identificador da tarefa |

### Exemplo de Requisição

```http
DELETE http://localhost:8080/api/v1/tarefas/1
```

### Resposta de Sucesso (204 No Content)

Sem conteúdo no corpo da resposta.

### Resposta de Erro (404 Not Found)

```json
{
  "mensagem": "Tarefa não encontrada",
  "status": 404
}
```

### Códigos de Resposta

| Código | Descrição                   |
| ------ | --------------------------- |
| 204    | Tarefa removida com sucesso |
| 404    | Tarefa não encontrada       |
| 500    | Erro interno do servidor    |

```

---

# Validações Implementadas

Os seguintes campos são obrigatórios:

* titulo
* descricao
* concluida

Validações realizadas com:

```java
@NotBlank
@NotNull
```

---

# Documentação Swagger

A documentação interativa da API pode ser acessada após iniciar a aplicação:

```http
http://localhost:8080/swagger-ui/index.html
```

A documentação apresenta:

* Endpoints disponíveis
* Métodos HTTP
* Parâmetros aceitos
* Estruturas de requisição
* Estruturas de resposta

---

# Testes da API

Os testes da API foram realizados utilizando:

* Postman

---

# Códigos HTTP Utilizados

| Código | Descrição             |
| ------ | --------------------- |
| 200    | OK                    |
| 201    | Created               |
| 204    | No Content            |
| 400    | Bad Request           |
| 404    | Not Found             |
| 500    | Internal Server Error |

---

# Arquitetura do Projeto

O projeto foi organizado utilizando arquitetura em camadas:

```text
controller
service
repository
model
dto
exception
config
```

---

# Melhorias Implementadas nesta Versão

* Reestruturação da arquitetura do projeto
* Implementação de versionamento da API
* Tratamento global de exceções
* Respostas de erro padronizadas
* Validação de dados de entrada
* Integração com Swagger/OpenAPI
* Documentação atualizada

---

# Autor

Marcelo Borges
