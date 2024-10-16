package models;

import java.util.ArrayList;
import java.util.List;

public class Turma {

    private String id;
    private String nome;
    private int ano;
    private List<Aluno> alunos;

    public Turma(String id, String nome, int ano) {
        this.id = id;
        this.nome = nome;
        this.ano = ano;
        alunos = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public void adicionarAluno(Aluno aluno) {
        this.alunos.add(aluno);
    }

    public String toJSON() {

        StringBuilder json = new StringBuilder();
        json.append("{");
        json.append("\"id\":\"").append(id).append("\",");
        json.append("\"nome\":\"").append(nome).append("\",");
        json.append("\"ano\":").append(ano).append(",");
        json.append("\"alunos\":[");

        for (int i = 0; i < alunos.size(); i++) {
            json.append(alunos.get(i).toJSON());
            if (i < alunos.size() - 1) {
                json.append(",");
            }
        }

        json.append("]}");

        return json.toString();
    }
}
