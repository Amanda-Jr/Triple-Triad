from termcolor import colored

class Carta:

    cor = 'white'
    dono = None

    def __init__(self, cima, dir, baixo, esq):
        self.dir = dir
        self.esq = esq
        self.cima = cima
        self.baixo = baixo


    #isso aqui é o toString em python
    def __str__(self) -> str:
        if(self.dono == 0):
            self.cor = 'cyan'
        if(self.dono == 1):
            self.cor = 'red'
        
        cima_str = colored(f"   {self.cima}      ", self.cor)
        esq_dir_str = colored(f"{self.esq}    {self.dir}    ", self.cor)
        baixo_str = colored(f"   {self.baixo}      ", self.cor)
        return f"{cima_str}\n{esq_dir_str}\n{baixo_str}"       
