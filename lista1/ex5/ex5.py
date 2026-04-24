class Editora:
    def __init__(self, nome: str, endereco: str, telefone: str):
        self.nome = nome
        self.endereco = endereco
        self.telefone = telefone

    def __str__(self):
        return f"Editora(nome='{self.nome}', endereco='{self.endereco}', telefone='{self.telefone}')"

class Secao:
    def __init__(self, nome: str, localizacao: str, capacidade: int):
        self.nome = nome
        self.localizacao = localizacao
        self.capacidade = capacidade

    def __str__(self):
        return f"Secao(nome='{self.nome}', localizacao='{self.localizacao}', capacidade={self.capacidade})"

editora1 = Editora('Companhia das Letras', 'Rua das Editoras, 100', '(11) 1234-5678')
editora2 = Editora('HarperCollins Brasil', 'Avenida do Livro, 200', '(21) 9876-5432')

secao1 = Secao('Ficção', 'Primeiro andar', 500)
secao2 = Secao('Tecnologia', 'Segundo andar', 300)

print(editora1)
print(editora2)
print(secao1)
print(secao2)