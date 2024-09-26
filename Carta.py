class Carta:

    dono = -1

    def __init__(self, cima, dir, baixo, esq):
        self.dir = dir
        self.esq = esq
        self.cima = cima
        self.baixo = baixo


    #isso aqui é o toString em python
    def __str__(self) -> str:
        return f'   {self.cima}\n{self.esq}    {self.dir}\n   {self.baixo}'         
