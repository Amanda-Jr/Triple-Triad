from Jogador import Jogador
from Tabuleiro import Tabuleiro


class Partida:

    def __init__(self, jogador1=Jogador, jogador2=Jogador, tabuleiro=Tabuleiro):
        self.jogadores = [jogador1, jogador2]
        self.tabuleiro = tabuleiro
        self.vez = 0

    def jogar(self):
        self.jogadores[self.vez].exibirCartas(self.vez)
        carta = int(input("Digite o numero da sua carta: "))
        self.jogadores[self.vez].cartas[carta].dono = self.jogadores[self.vez].nome
        linha = int(input("Digite a linha: "))
        coluna = int(input("Digite a coluna: "))
        self.tabuleiro.colocarCarta(self.jogadores[self.vez].cartas[carta], linha, coluna)
        print(self.jogadores[self.vez].cartas[carta].dono)
        self.jogadores[self.vez].cartas.pop(carta)
        print(self.tabuleiro.mat[linha][coluna])

        if(self.vez == 0):
            self.vez = 1
        else:
            self.vez = 0