import json

class Filme:
    def __init__(self):
        self.titulo = ""
        self.ano = 0
        self.classificacao = ""
        self.nota = 0.0

    def carregar_json(self, dados):
        self.titulo = dados["titulo"]
        self.ano = dados["ano"]
        self.classificacao = dados["classificacao"]
        self.nota = dados["nota"]

    def __str__(self):
        return f"{self.titulo} ({self.ano}) - {self.classificacao} - Nota: {self.nota}"


json_filmes = '''
[
    {
        "titulo": "A Rainy Day in New York",
        "ano": 2019,
        "classificacao": "PG-13",
        "nota": 6.6
    },
    {
        "titulo": "Jurassic World: Fallen Kingdom",
        "ano": 2018,
        "classificacao": "PG-13",
        "nota": 6.2
    },
    {
        "titulo": "2001: A Space Odyssey",
        "ano": 1968,
        "classificacao": "G",
        "nota": 8.3
    },
    {
        "titulo": "Toy Story 4",
        "ano": 2019,
        "classificacao": "G",
        "nota": 7.8
    }
]
'''

dados = json.loads(json_filmes)

filmes = []

for item in dados:
    filme = Filme()
    filme.carregar_json(item)
    filmes.append(filme)

filmes.sort(key=lambda f: f.nota, reverse=True)

for filme in filmes:
    print(filme)