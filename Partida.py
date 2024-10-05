import pygame
from Jogador import Jogador
from Tabuleiro import Tabuleiro
import os


class Partida:

    def __init__(self, jogador1=Jogador, jogador2=Jogador, tabuleiro=Tabuleiro):
        self.jogadores = [jogador1, jogador2]
        self.tabuleiro = tabuleiro
        self.vez = 0

    def regras(self, linha, coluna, carta, tabuleiro=Tabuleiro):
        
        somaDr = 0
        somaEq = 0
        somaCm = 0
        somaBx = 0

        if(tabuleiro.mat[linha][coluna+1] != None):
            somaDr = carta.dir + tabuleiro.mat[linha][coluna+1].esq
        if(tabuleiro.mat[linha][coluna-1] != None):
            somaEq = carta.esq + tabuleiro.mat[linha][coluna-1].dir
        if(tabuleiro.mat[linha-1][coluna] != None):
            somaCm = carta.cima + tabuleiro.mat[linha-1][coluna].baixo
        if(tabuleiro.mat[linha+1][coluna] != None):
            somaBx = carta.baixo + tabuleiro.mat[linha+1][coluna].cima

        if(somaDr == somaCm and somaDr != 0 and somaCm != 0):
            if(tabuleiro.mat[linha-1][coluna].dono != carta.dono):
                tabuleiro.mat[linha-1][coluna].dono = carta.dono

            if(tabuleiro.mat[linha][coluna+1].dono != carta.dono):
                tabuleiro.mat[linha][coluna+1].dono = carta.dono

        if(somaEq == somaBx and somaEq != 0 and somaBx != 0):
            if(tabuleiro.mat[linha][coluna-1].dono != carta.dono):
                tabuleiro.mat[linha][coluna-1].dono = carta.dono

            if(tabuleiro.mat[linha+1][coluna].dono != carta.dono):
                tabuleiro.mat[linha+1][coluna].dono = carta.dono

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
    
    def checaResultado(self):
        if(self.jogadores[0].pontos > self.jogadores[1].pontos):
            return self.jogadores[0]
        elif(self.jogadores[0].pontos < self.jogadores[1].pontos):
            return self.jogadores[1].nome
        else:
            return None

    def iniciar(self):
        j1 = self.jogadores[0]
        j2 = self.jogadores[1]

        while(not self.tabuleiro.checaTabuleiroCompleto()):
    
            print(f'{j1.nome}: {j1.pontos}  |   {j2.nome}: {j2.pontos}')
        
            try:
                self.jogar()
            except:
                print("Posição Inválida, tente novamente.")
                self.jogar()
            
            os.system('clear')
        
        return self.checaResultado()

        
                    
