from Jogador import Jogador
from Tabuleiro import Tabuleiro


class Partida:

    def __init__(self, jogador1=Jogador, jogador2=Jogador, tabuleiro=Tabuleiro):
        self.jogadores = [jogador1, jogador2]
        self.tabuleiro = tabuleiro
        self.vez = 0

    def regras(self, linha, coluna, carta, tabuleiro=Tabuleiro):
        
        #Se a carta for menor
        if(not (tabuleiro.mat[linha][coluna+1] == None)):
            if(carta.dir < tabuleiro.mat[linha][coluna+1].esq and carta.dono != tabuleiro.mat[linha][coluna+1].dono):
                if(carta.dono >= 1 ):
                    carta.dono = 0
                    self.jogadores[1].pontos -= 1
                    self.jogadores[0].pontos += 1
                else: 
                    carta.dono = 1
                    self.jogadores[0].pontos -= 1
                    self.jogadores[1].pontos += 1
                
                
        
        if(not (tabuleiro.mat[linha][coluna-1] == None)):
            if(carta.esq < tabuleiro.mat[linha][coluna-1].dir and carta.dono != tabuleiro.mat[linha][coluna-1].dono):
                if(carta.dono >= 1 ):
                    carta.dono = 0
                    self.jogadores[1].pontos -= 1
                    self.jogadores[0].pontos += 1
                else: 
                    carta.dono = 1
                    self.jogadores[0].pontos -= 1
                    self.jogadores[1].pontos += 1
                    
        if(not (tabuleiro.mat[linha-1][coluna] == None)):        
            if(carta.cima < tabuleiro.mat[linha-1][coluna].baixo and carta.dono != tabuleiro.mat[linha-1][coluna].dono):
                if(carta.dono >= 1 ):
                    carta.dono = 0
                    self.jogadores[1].pontos -= 1
                    self.jogadores[0].pontos += 1
                else: 
                    carta.dono = 1
                    self.jogadores[0].pontos -= 1
                    self.jogadores[1].pontos += 1
                    
        if(not (tabuleiro.mat[linha+1][coluna] == None)):        
            if(carta.baixo < tabuleiro.mat[linha+1][coluna].cima and carta.dono != tabuleiro.mat[linha+1][coluna].dono):
                if(carta.dono >= 1 ):
                    carta.dono = 0
                    self.jogadores[1].pontos -= 1
                    self.jogadores[0].pontos += 1
                else: 
                    carta.dono = 1
                    self.jogadores[0].pontos -= 1
                    self.jogadores[1].pontos += 1
        
        #Se a carta for maior
        if(not (tabuleiro.mat[linha][coluna+1] == None)):
            if(carta.dir > tabuleiro.mat[linha][coluna+1].esq and carta.dono != tabuleiro.mat[linha][coluna+1].dono):
                tabuleiro.mat[linha][coluna+1].dono = carta.dono
                if(carta.dono >= 1 ):
                    self.jogadores[1].pontos += 1
                    self.jogadores[0].pontos -= 1
                else: 
                    self.jogadores[0].pontos += 1
                    self.jogadores[1].pontos -= 1
                
        
        if(not (tabuleiro.mat[linha][coluna-1] == None)):
            if(carta.esq > tabuleiro.mat[linha][coluna-1].dir and carta.dono != tabuleiro.mat[linha][coluna-1].dono):
                tabuleiro.mat[linha][coluna-1].dono = carta.dono
                if(carta.dono >= 1 ):
                    self.jogadores[1].pontos += 1
                    self.jogadores[0].pontos -= 1
                else: 
                    self.jogadores[0].pontos += 1
                    self.jogadores[1].pontos -= 1
                    
        if(not (tabuleiro.mat[linha-1][coluna] == None)):        
            if(carta.cima > tabuleiro.mat[linha-1][coluna].baixo and carta.dono != tabuleiro.mat[linha-1][coluna].dono):
                tabuleiro.mat[linha-1][coluna].dono = carta.dono
                if(carta.dono >= 1 ):
                    self.jogadores[1].pontos += 1
                    self.jogadores[0].pontos -= 1
                else: 
                    self.jogadores[0].pontos += 1
                    self.jogadores[1].pontos -= 1
                    
        if(not (tabuleiro.mat[linha+1][coluna] == None)):        
            if(carta.baixo > tabuleiro.mat[linha+1][coluna].cima and carta.dono != tabuleiro.mat[linha+1][coluna].dono):
                tabuleiro.mat[linha+1][coluna].dono = carta.dono
                if(carta.dono >= 1 ):
                    self.jogadores[1].pontos += 1
                    self.jogadores[0].pontos -= 1
                else: 
                    self.jogadores[0].pontos += 1
                    self.jogadores[1].pontos -= 1
    
    def jogar(self):
        print("\nVez: Jogador", self.vez+1)
        self.tabuleiro.exibirTabuleiro()
        self.jogadores[self.vez].exibirCartas(self.vez)
        
        carta = int(input("Digite o numero da sua carta: "))
        #self.jogadores[self.vez].cartas[carta].dono = self.jogadores[self.vez].nome
        linha = int(input("Digite a linha: "))
        coluna = int(input("Digite a coluna: "))
        self.tabuleiro.colocarCarta(self.jogadores[self.vez].cartas[carta], linha, coluna)
        
        self.regras(linha, coluna, self.jogadores[self.vez].cartas[carta], self.tabuleiro)
        print(self.jogadores[self.vez].cartas[carta].dono)
        self.jogadores[self.vez].cartas.pop(carta)
        print(self.tabuleiro.mat[linha][coluna])
        self.tabuleiro.exibirTabuleiro()
        
        if(self.vez == 0):
            self.vez = 1
        else:
            self.vez = 0
    
    
                    
