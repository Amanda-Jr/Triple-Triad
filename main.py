from Baralho import Baralho
from Tabuleiro import Tabuleiro
from Jogador import Jogador
from Partida import Partida
import os
import time

haVencedor = False

while(not haVencedor):

    baralho = Baralho.distribuirCartas()
    tabuleiro = Tabuleiro()

    deck1 = baralho[0]   
    deck2 = baralho[1]

    j1 = Jogador("Joao", deck1)

    j2 = Jogador("Maria", deck2)

    pt = Partida(j1, j2, tabuleiro)

    vencedor = pt.iniciar()

    if(vencedor != None):
        haVencedor = True

    if(vencedor == None):
        print("Jogo empatou. Recomeçando...")
        time.sleep(2)
        os.system('cls')

print(f'Vencedor: {vencedor.nome}')






    


