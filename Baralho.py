import random
from Carta import Carta

class Baralho:
    #vetor com todas as cartas do jogo
    cartas = [
    Carta(1, 1, 4, 5, "001"),    # Geezard
    Carta(5, 1, 1, 3, "002"),    # Funguar
    Carta(1, 3, 3, 5, "003"),    # Bite Bug
    Carta(6, 1, 1, 2, "004"),    # Red Bat
    Carta(2, 1, 3, 5, "005"),    # Blobra
    Carta(2, 4, 1, 4, "006"),    # Gayla
    Carta(1, 4, 5, 1, "007"),    # Gesper
    Carta(3, 2, 5, 1, "008"),    # Fastitocalon-F
    Carta(2, 6, 1, 1, "009"),    # Blood Soul
    Carta(4, 4, 2, 3, "010"),    # Caterchipillar
    Carta(2, 2, 1, 6, "011"),    # Cockatrice
    Carta(7, 3, 1, 1, "012"),    # Grat
    Carta(6, 2, 2, 3, "013"),    # Buel
    Carta(5, 3, 3, 4, "014"),    # Mesmerize
    Carta(6, 4, 1, 3, "015"),    # Glacial Eye
    Carta(3, 5, 4, 3, "016"),    # Belhelmel
    Carta(5, 2, 3, 5, "017"),    # Thrustaevis
    Carta(5, 3, 1, 5, "018"),    # Anacondaur
    Carta(5, 5, 2, 2, "019"),    # Creeps
    Carta(4, 5, 4, 2, "020"),    # Grendel
    Carta(3, 1, 2, 7, "021"),    # Jelleye
    Carta(5, 5, 2, 3, "022"),    # Grand Mantis
    Carta(6, 3, 6, 2, "023"),    # Forbidden
    Carta(6, 1, 3, 6, "024"),    # Armadodo
    Carta(3, 5, 5, 5, "025"),    # Tri-Face
    Carta(7, 1, 5, 3, "026"),    # Fastitocalon
    Carta(7, 5, 1, 3, "027"),    # Snow Lion
    Carta(5, 3, 6, 3, "028"),    # Ochu
    Carta(5, 2, 6, 4, "029"),    # SAM08G
    Carta(4, 7, 4, 2, "030"),    # Death Claw
    Carta(6, 6, 2, 3, "031"),    # Cactuar
    Carta(3, 4, 6, 4, "032"),    # Tonberry
    Carta(7, 3, 2, 5, "033"),    # Abyss Worm
    Carta(2, 6, 3, 7, "034"),    # Turtapod
    Carta(6, 4, 5, 5, "035"),    # Vysage
    Carta(4, 2, 6, 7, "036"),    # T-Rexaur
    Carta(2, 6, 7, 3, "037"),    # Bomb
    Carta(1, 4, 6, 7, "038"),    # Blitz
    Carta(7, 1, 3, 6, "039"),    # Wendigo
    Carta(7, 4, 4, 4, "040"),    # Torama
    Carta(3, 3, 7, 6, "041"),    # Imp
    Carta(6, 7, 2, 3, "042"),    # Blue Dragon
    Carta(4, 5, 5, 6, "043"),    # Adamantoise
    Carta(7, 4, 5, 3, "044"),    # Hexadragon
    Carta(6, 6, 5, 5, "045"),    # Iron Giant
    Carta(3, 5, 6, 7, "046"),    # Behemoth
    Carta(7, 5, 6, 3, "047"),    # Chimera
    Carta(3, 2, 10, 1, "048"),   # PuPu
    Carta(6, 6, 2, 7, "049"),    # Wedge, Biggs
    Carta(5, 7, 5, 4, "050"),    # GIM47N
    Carta(7, 4, 7, 2, "051"),    # Malboro
    Carta(7, 7, 2, 4, "052"),    # Ruby Dragon
    Carta(5, 7, 3, 6, "053"),    # Elnoyle
    Carta(4, 7, 6, 4, "054"),    # Tonberry King
    Carta(6, 2, 6, 7, "055"),    # Wedge, Biggs
    Carta(2, 8, 8, 4, "056"),    # Fujin Raijin
    Carta(7, 3, 8, 4, "057"),    # Elvoret
    Carta(4, 7, 8, 3, "058"),    # X-ATM092
    Carta(7, 8, 2, 5, "059"),    # Granaldo
    Carta(1, 8, 8, 3, "060"),    # Gerogero
    Carta(8, 8, 2, 2, "061"),    # Iguion
    Carta(6, 4, 8, 5, "062"),    # Abadon
    Carta(4, 5, 8, 6, "063"),    # Trauma
    Carta(1, 4, 8, 8, "064"),    # Oilboyle
    Carta(6, 8, 5, 4, "065"),    # Shumi
    Carta(7, 8, 5, 1, "066"),    # Krysta
    Carta(8, 4, 4, 8, "067"),    # Propagator
    Carta(8, 4, 8, 4, "068"),    # Jumbo Cactuar
    Carta(8, 2, 5, 8, "069"),    # Tri-Point
    Carta(5, 6, 6, 8, "070"),    # Gargantua
    Carta(8, 7, 6, 3, "071"),    # Mobile Type 8
    Carta(8, 5, 3, 8, "072"),    # Tiamat
    Carta(5, 8, 7, 5, "073"),    # Red Giant
    Carta(1, 7, 8, 7, "074"),    # Catoblepas
    Carta(7, 6, 4, 8, "075"),    # Ultima Weapon
    Carta(4, 8, 9, 9, "076"),    # Eden
    Carta(5, 9, 8, 10, "077"),   # Squall
    ]  
    
    #pega cartas aleatorias do nosso vetor com todas as cartas
    def distribuirCartas():
        baralho = random.sample(Baralho.cartas, 10)

        deck1 = baralho[:5]
        
        for carta in deck1:
            carta.dono = 0
        
        deck2 = baralho[5:10]

        
        for carta in deck2:
            carta.dono = 1

        return [deck1, deck2]
