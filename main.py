import pygame
from Baralho import Baralho
from Tabuleiro import Tabuleiro
from Jogador import Jogador
from Partida import Partida
import os
import time

haVencedor = False

baralho = Baralho.distribuirCartas()
tabuleiro = Tabuleiro()

deck1 = baralho[0]   
deck2 = baralho[1]

j1 = Jogador("Joao", deck1)

j2 = Jogador("Maria", deck2)

# Inicializar o Pygame
pygame.init()

# Definir o tamanho inicial da janela
screen_width, screen_height = 1200, 600
screen = pygame.display.set_mode((screen_width, screen_height), pygame.RESIZABLE)

# Carregar a imagem de fundo
background = pygame.image.load("src/background.png")
background = pygame.transform.scale(background, (550, 400))

image_width, image_height = background.get_size()

# Calcular a posição para centralizar a imagem
image_x = (screen_width - image_width) // 2
image_y = (screen_height - image_height) // 2

# Loop principal do jogo
running = True
while running:
    for event in pygame.event.get():
        if event.type == pygame.QUIT:
            running = False
        
        # Evento de redimensionamento de janela (inclui quando o quadrado de maximizar é clicado)
        elif event.type == pygame.VIDEORESIZE:
            screen_width, screen_height = event.w, event.h
            screen = pygame.display.set_mode((screen_width, screen_height), pygame.RESIZABLE)
            
            # Redimensionar a imagem de fundo conforme o novo tamanho da janela
            #background = pygame.transform.scale(background, (screen_width, screen_height))


    image_width, image_height = background.get_size()

    # Calcular a posição para centralizar a imagem
    image_x = (screen_width - image_width) // 2
    image_y = (screen_height - image_height) // 2
    # Desenhar a imagem de fundo
    screen.blit(background, (image_x, image_y))

    posX = 0
    posY = 0
    for c in j1.cartas:
        carta = pygame.image.load(f"src/{c.id}.png")
        carta = pygame.transform.scale(carta, (110, 80))
        screen.blit(carta, (posX, posY))
        posY += 100

    posX = screen_width - 110
    posY = 0
    for c2 in j2.cartas:
        carta2 = pygame.image.load(f"src/{c2.id}.png")
        carta2 = pygame.transform.scale(carta2, (110, 80))
        screen.blit(carta2, (posX, posY))
        posY += 100

    # flip() the display to put your work on screen
    pygame.display.flip()

pygame.quit()



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






    


