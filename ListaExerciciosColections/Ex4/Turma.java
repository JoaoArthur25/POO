package Ex4;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Turma {
    List<Aluno> alunos = new ArrayList<>();

    public void adicionarAluno(Aluno aluno) {
        alunos.add(aluno);
    }

    private void ordenarAlunosPorMedia() {
        alunos.sort(Comparator.comparingDouble(Aluno::getMedia));
    }

    public List<Equipe> separarEmEquipes() {
        ordenarAlunosPorMedia();

        List<Equipe> equipes = new ArrayList<>();
        int inicio = 0;
        int fim = alunos.size() - 1;

        while (inicio <= fim) {
            Equipe equipe = new Equipe();

            if (inicio <= fim) equipe.adicionarAluno(alunos.get(inicio++));
            if (inicio <= fim) equipe.adicionarAluno(alunos.get(fim--));
            if (inicio <= fim) equipe.adicionarAluno(alunos.get(inicio++));
            if (inicio <= fim) equipe.adicionarAluno(alunos.get(fim--));

            equipes.add(equipe);
        }

        return equipes;
    }
}