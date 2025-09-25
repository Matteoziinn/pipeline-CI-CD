# 📌 Gerenciador de Tarefas  

![Java](https://img.shields.io/badge/Java-17-orange)  
![Spring Boot](https://img.shields.io/badge/SpringBoot-3.x-brightgreen)  
![Maven](https://img.shields.io/badge/Maven-Build-blue)  
![Docker](https://img.shields.io/badge/Docker-Ready-2496ED)  

Este projeto é uma aplicação Java desenvolvida com **Spring Boot** para gerenciamento de tarefas.  
O objetivo é permitir o cadastro, listagem e organização de atividades de forma simples e prática.  

---

## 🚀 Tecnologias utilizadas
- **Java 17+**  
- **Spring Boot**  
- **Maven**  
- **Docker**   

---

## ⚙️ Como executar o projeto

### Usando Maven
```bash
# Clonar o repositório
git clone https://github.com/SEU-USUARIO/gerenciador-tarefas.git
cd gerenciador-tarefas

# Executar o projeto
mvn spring-boot:run
```

### Usando Docker
```bash
# Construir a imagem
docker build -t gerenciador-tarefas .

# Executar o container
docker run -p 8080:8080 gerenciador-tarefas
```

A aplicação estará disponível em:  
👉 [http://localhost:8080](http://localhost:8080)

---

## 📂 Estrutura básica do projeto
```
gerenciadortarefas/
 ├── src/
 │   ├── main/java/br/com/empresa/gerenciadortarefas
 │   │     └── GerenciadortarefasApplication.java
 │   └── test/...
 ├── pom.xml
 ├── Dockerfile
 └── README.md
```

---

## ✨ Funcionalidades
- Cadastro de tarefas  
- Listagem de tarefas  
- Suporte a execução via Docker  
- Estrutura pronta para integração com banco de dados  

---

## 📌 Exemplos de uso (API REST)

### ➕ Criar uma nova tarefa
```bash
curl -X POST http://localhost:8080/tarefas      -H "Content-Type: application/json"      -d '{
           "titulo": "Estudar Spring Boot",
           "descricao": "Revisar conceitos de REST",
           "status": "PENDENTE"
         }'
```

### 📋 Listar todas as tarefas
```bash
curl -X GET http://localhost:8080/tarefas
```

### ✅ Atualizar o status de uma tarefa
```bash
curl -X PUT http://localhost:8080/tarefas/1      -H "Content-Type: application/json"      -d '{
           "titulo": "Estudar Spring Boot",
           "descricao": "Revisar conceitos de REST",
           "status": "CONCLUIDA"
         }'
```

### ❌ Deletar uma tarefa
```bash
curl -X DELETE http://localhost:8080/tarefas/1
```

---

## 👥 Membros do Projeto
- Matteo Souza Caetano  
- Matheus Borges  
- Adison de Oliveira  

---

## 📜 Licença
Este projeto é de uso acadêmico/demonstrativo.  
