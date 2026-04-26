package Ex4;

import java.util.ArrayList;
import java.util.List;

class Equipe {
    List<Aluno> alunos = new ArrayList<>();

    public void adicionarAluno(Aluno aluno) {
        alunos.add(aluno);
    }

    public void exibir() {
        for (Aluno aluno : alunos) {
            System.out.println(aluno);
        }
    }
}
