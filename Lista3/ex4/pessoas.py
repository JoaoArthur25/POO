from abc import ABC, abstractmethod


class Pessoa(ABC):
    def __init__(self, nome: str):
        self._nome = nome

    @property
    def nome(self):
        return self._nome

    @abstractmethod
    def __repr__(self):
        pass


class Aluno(Pessoa):
    def __init__(self, nome: str, notas: list[float]):
        super().__init__(nome)
        self._notas = notas 

    def calcularMedia(self) -> float:
        return sum(self._notas) / len(self._notas)

    def __repr__(self) -> str:
        media = self.calcularMedia()
        situacao = "Aprovado" if media >= 7 else "Em exame"
        return (
            f"Aluno: {self._nome} | "
            f"Notas: {self._notas} | "
            f"Media: {media:.2f} | "
            f"Situacao: {situacao}"
        )


class Professor(Pessoa):
    def __init__(self, nome: str, salario: float):
        super().__init__(nome)
        self._salario = salario

    def __repr__(self) -> str:
        return f"Professor: {self._nome} | Salario: R$ {self._salario:.2f}"


# ── Main 

if __name__ == "__main__":
    professores = [
        Professor("Fabiano Baldo", 8500.00),
        Professor("Maria Silva", 7200.50),
    ]

    alunos = [
        Aluno("Ana Costa",    [8.0, 7.5, 9.0, 8.5, 7.0]),
        Aluno("Bruno Lima",   [5.0, 6.0, 4.5, 5.5, 6.5]),
        Aluno("Carla Souza",  [9.0, 9.5, 8.0, 9.0, 10.0]),
        Aluno("Diego Rocha",  [3.0, 4.0, 5.0, 4.5, 3.5]),
        Aluno("Elena Ferreira",[7.0, 7.0, 6.5, 8.0, 7.5]),
    ]

    print("=== Professores ===")
    for p in professores:
        print(p)

    print("\n=== Alunos ===")
    for a in alunos:
        print(a)
