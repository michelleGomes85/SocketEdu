import socket
import json

import sys
import os

# Adiciona o caminho do diretório pai ao sys.path
sys.path.append(os.path.dirname(os.path.dirname(os.path.abspath(__file__))))

from models.aluno import Aluno
from models.turma import Turma

def iniciar_servidor(host='localhost', porta=5000):
    
    servidor = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    servidor.setsockopt(socket.SOL_SOCKET, socket.SO_REUSEADDR, 1)
    servidor.bind((host, porta))
    servidor.listen(1)
    print(f'Servidor escutando em {host}:{porta}')

    while True:

        conn, addr = servidor.accept()
        print(f'Conectado a {addr}')

        message = conn.recv(1024).decode()
        
        process_message(message)

        conn.sendall(b'Mensagem recebida')
        conn.close()

def process_message(json_data):

    # Converte a string JSON para um dicionário Python
    turma_dict = json.loads(json_data)

    # Cria uma nova instância da Turma
    turma = Turma(turma_dict['id'], turma_dict['nome'], turma_dict['ano'])

    # Para cada aluno no JSON, cria uma nova instância de Aluno e adiciona à turma
    for aluno_data in turma_dict['alunos']:
        aluno = Aluno(aluno_data['matricula'], aluno_data['nome'], aluno_data['idade'])
        turma.adicionar_aluno(aluno)

    turma.listar_dados()

    return turma

if __name__ == "__main__":
    iniciar_servidor()
