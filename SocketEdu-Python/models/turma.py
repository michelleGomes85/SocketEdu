import json
from .aluno import Aluno 

class Turma:

    def __init__(self, id_turma, nome, ano):

        self.id = id_turma
        self.nome = nome
        self.ano = ano
        self.alunos = [] 

    def adicionar_aluno(self, aluno):
        self.alunos.append(aluno) 

    def listar_dados(self):

        print(f'\n{self.nome} ({self.ano})\n')

        for aluno in self.alunos:
            print(f'- {aluno.nome}, {aluno.idade} anos, matricula {aluno.matricula}')

    def to_json(self):

        turma_dict = {

            'id': self.id,
            'nome': self.nome,
            'ano': self.ano,
            'alunos': [
                {
                    'matricula': aluno.matricula,
                    'nome': aluno.nome,
                    'idade': aluno.idade
                }

                for aluno in self.alunos
            ]
        }

        return json.dumps(turma_dict)
