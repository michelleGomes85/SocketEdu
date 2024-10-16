# SocketEdu

## Descrição
SocketEdu é um projeto simples para demonstrar a integração entre dois sistemas: um cliente Java e um servidor Python. O cliente envia objetos em formato JSON representando turmas e alunos, enquanto o servidor os recebe, processa e exibe os dados.

## Estrutura do Projeto
O projeto é dividido em duas partes:

- **SocketEdu-Java**: 
  - Contém a implementação do cliente que envia dados ao servidor.
  - Classes principais:
    - `Client`: Envia objetos `Turma` em formato JSON.
    - `Aluno`: Representa um aluno.
    - `Turma`: Representa uma turma com uma lista de alunos.

- **SocketEdu-Python**:
  - Implementa o servidor que recebe dados do cliente.
  - Classes principais:
    - `Aluno`: Representa um aluno.
    - `Turma`: Representa uma turma com uma lista de alunos.
    - Funções para iniciar o servidor e processar mensagens recebidas.

## Como Executar o Projeto

### Pré-requisitos
- Java Development Kit (JDK)
- Python 3.x

### Passos para execução

1. **Executar o Servidor Python**:
   - Navegue até o diretório `SocketEdu-Python/app`.
   - Execute o servidor com o comando:
     ```bash
       python server.py
     ```

2. **Executar o Cliente Java**:
   - Navegue até o diretório `SocketEdu-Java/src`.
   - Compile o cliente com o comando:
     ```bash
     javac app/Client.java models/*.java
     ```
   - Execute o cliente com o comando:
     ```bash
     java app.Client
     ```

## Funcionalidade
- O cliente Java cria instâncias de `Turma`, adiciona alunos e envia esses dados para o servidor em formato JSON.
- O servidor Python recebe os dados, converte o JSON para instâncias de `Turma` e `Aluno`, e exibe as informações no console.
