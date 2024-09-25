from Baralho import Baralho

baralho = Baralho.distribuirCartas()

deck1 = baralho[0]
deck2 = baralho[1]
for c in deck1:
    print(c)