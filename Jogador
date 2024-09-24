class Jogador:
    def __init__(self, nome):
        self.nome = nome  # Nome do jogador
        self.cartas = []  # Lista de cartas que o jogador possui (inicialmente vazia)
        self.pontos = 5   # Pontuação inicial

    def adicionar_carta(self, carta):
        if len(self.cartas) < 5:
            self.cartas.append(carta)
        else:
            print(f"{self.nome} já tem 5 cartas!")

    def capturar_carta(self):
        self.pontos += 1

    def ser_capturado(self):
        self.pontos -= 1

    def exibir_cartas(self):
        for i, carta in enumerate(self.cartas, 1):
            print(f"Carta {i}: {carta}")

    def __str__(self):
        return f"Jogador: {self.nome}, Pontos: {self.pontos}, Cartas: {len(self.cartas)}"
