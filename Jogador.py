from Carta import Carta


class Jogador:
    def __init__(self, nome, cartas):
        self.nome = nome  # Nome do jogador
        self.cartas = cartas  # Lista de cartas que o jogador possui 
        self.pontos = 5   # Pontuação inicial


    def capturarCarta(self):
        self.pontos += 1

    def serCapturado(self):
        self.pontos -= 1

    def exibirCartas(self):
        linhas = ["", "", ""]
        
        for carta in self.cartas:
            carta_str = str(carta).splitlines()
            for i in range(3):
                # Adiciona espaçamento entre as cartas
                linhas[i] += carta_str[i].ljust(10)  # Ajuste do espaçamento

        for linha in linhas:
            print(linha.strip())  # Remove espaços extras no final

    def __str__(self):
        return f"Jogador: {self.nome}, Pontos: {self.pontos}, Cartas: {len(self.cartas)}"
    
