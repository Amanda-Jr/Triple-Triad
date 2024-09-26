import random
from Carta import Carta

class Baralho:
    #vetor com todas as cartas do jogo
    cartas = [
        Carta(1, 1, 4, 5),    # Geezard
        Carta(5, 1, 1, 3),    # Funguar
        Carta(1, 3, 3, 5),    # Bite Bug
        Carta(6, 1, 1, 2),    # Red Bat
        Carta(2, 1, 3, 5),    # Blobra
        Carta(2, 4, 1, 4),    # Gayla
        Carta(1, 4, 5, 1),    # Gesper
        Carta(3, 2, 5, 1),    # Fastitocalon-F
        Carta(2, 6, 1, 1),    # Blood Soul
        Carta(4, 4, 2, 3),    # Caterchipillar
        Carta(2, 2, 1, 6),    # Cockatrice
        Carta(7, 3, 1, 1),    # Grat
        Carta(6, 2, 2, 3),    # Buel
        Carta(5, 3, 3, 4),    # Mesmerize
        Carta(6, 4, 1, 3),    # Glacial Eye
        Carta(3, 5, 4, 3),    # Belhelmel
        Carta(5, 2, 3, 5),    # Thrustaevis
        Carta(5, 3, 1, 5),    # Anacondaur
        Carta(5, 5, 2, 2),    # Creeps
        Carta(4, 5, 4, 2),    # Grendel
        Carta(3, 1, 2, 7),    # Jelleye
        Carta(5, 5, 2, 3),    # Grand Mantis
        Carta(6, 3, 6, 2),    # Forbidden
        Carta(6, 1, 3, 6),    # Armadodo
        Carta(3, 5, 5, 5),    # Tri-Face
        Carta(7, 1, 5, 3),    # Fastitocalon
        Carta(7, 5, 1, 3),    # Snow Lion
        Carta(5, 3, 6, 3),    # Ochu
        Carta(5, 2, 6, 4),    # SAM08G
        Carta(4, 7, 4, 2),    # Death Claw
        Carta(6, 6, 2, 3),    # Cactuar
        Carta(3, 4, 6, 4),    # Tonberry
        Carta(7, 3, 2, 5),    # Abyss Worm
        Carta(2, 6, 3, 7),    # Turtapod
        Carta(6, 4, 5, 5),    # Vysage
        Carta(4, 2, 6, 7),    # T-Rexaur
        Carta(2, 6, 7, 3),    # Bomb
        Carta(1, 4, 6, 7),    # Blitz
        Carta(7, 1, 3, 6),    # Wendigo
        Carta(7, 4, 4, 4),    # Torama
        Carta(3, 3, 7, 6),    # Imp
        Carta(6, 7, 2, 3),    # Blue Dragon
        Carta(4, 5, 5, 6),    # Adamantoise
        Carta(7, 4, 5, 3),    # Hexadragon
        Carta(6, 6, 5, 5),    # Iron Giant
        Carta(3, 5, 6, 7),    # Behemoth
        Carta(7, 5, 6, 3),    # Chimera
        Carta(3, 2, 10, 1),   # PuPu
        Carta(6, 6, 2, 7),    # Elastoid
        Carta(5, 7, 5, 4),    # GIM47N
        Carta(7, 4, 7, 2),    # Malboro
        Carta(7, 7, 2, 4),    # Ruby Dragon
        Carta(5, 7, 3, 6),    # Elnoyle
        Carta(4, 7, 6, 4),    # Tonberry King
        Carta(6, 2, 6, 7),    # Wedge, Biggs
        Carta(2, 8, 8, 4),    # Fujin Raijin
        Carta(7, 3, 8, 4),    # Elvoret
        Carta(4, 7, 8, 3),    # X-ATM092
        Carta(7, 8, 2, 5),    # Granaldo
        Carta(1, 8, 8, 3),    # Gerogero
        Carta(8, 8, 2, 2),    # Iguion
        Carta(6, 4, 8, 5),    # Abadon
        Carta(4, 5, 8, 6),    # Trauma
        Carta(1, 4, 8, 8),    # Oilboyle
        Carta(6, 8, 5, 4),    # Shumi
        Carta(7, 8, 5, 1),    # Krysta
        Carta(8, 4, 4, 8),    # Propagator
        Carta(8, 4, 8, 4),    # Jumbo Cactuar
        Carta(8, 2, 5, 8),    # Tri-Point
        Carta(5, 6, 6, 8),    # Gargantua
        Carta(8, 7, 6, 3),    # Mobile Type 8
        Carta(8, 5, 3, 8),    # Tiamat
        Carta(5, 8, 7, 5),    # Red Giant
        Carta(1, 7, 8, 7),    # Catoblepas
        Carta(7, 6, 4, 8),    # Ultima Weapon
        Carta(4, 8, 9, 9),    # Eden
        Carta(5, 9, 8, 10),   # Squall
    ]    
    
    #pega cartas aleatorias do nosso vetor com todas as cartas
    def distribuirCartas():
        baralho = random.sample(Baralho.cartas, 10)

        deck1 = baralho[:5]
        deck2 = baralho[5:10]


        return [deck1, deck2]
