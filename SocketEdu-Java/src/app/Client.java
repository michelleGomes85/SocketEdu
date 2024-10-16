package app;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

import models.Aluno;
import models.Turma;

public class Client {
    public static void main(String[] args) throws Exception {
        new Client();
    }

    public Client() {
        init();
    }

    private void init() {
        
        Turma turma1 = new Turma("1", "Turma 1", 2019);

        turma1.adicionarAluno(new Aluno("12345", "João da Silva", 22));
        turma1.adicionarAluno(new Aluno("45874", "Maria do Carmo", 18));
        turma1.adicionarAluno(new Aluno("98547", "Paulo Roberto", 20));

        send_message(turma1.toJSON());

        Turma turma2 = new Turma("2", "Turma 2", 2022);
        turma2.adicionarAluno(new Aluno("41258", "Roberto Carlos", 17));
        turma2.adicionarAluno(new Aluno("87459", "Juliana de Paula", 18));

        send_message(turma2.toJSON());

    }

    private void send_message(String json) {
        
        try {
            Socket socket = new Socket("localhost", 5000);
            OutputStream outputStream = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(outputStream, true);
            
            // Enviar o JSON para o servidor
            writer.println(json);
            writer.flush();

            // Fechar conexões
            writer.close();
            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
