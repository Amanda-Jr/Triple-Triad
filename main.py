from Baralho import Baralho
from Tabuleiro import Tabuleiro
from Jogador import Jogador
from Partida import Partida
import os


baralho = Baralho.distribuirCartas()
tabuleiro = Tabuleiro()

deck1 = baralho[0]   
deck2 = baralho[1]

j1 = Jogador("Joao", deck1)

j2 = Jogador("Maria", deck2)

pt = Partida(j1, j2, tabuleiro)


while(not tabuleiro.checaTabuleiroCompleto()):
    
    print(f'{j1.nome}: {j1.pontos}  |   {j2.nome}: {j2.pontos}')
    
    try:
        pt.jogar()
    except:
        print("Posição Inválida, tente novamente.")
        pt.jogar()
    
    os.system('clear')



    


