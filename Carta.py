from termcolor import colored

class Carta:

    dono = -1

    def __init__(self, cima, dir, baixo, esq):
        self.dir = dir
        self.esq = esq
        self.cima = cima
        self.baixo = baixo


    #isso aqui é o toString em python
    def __str__(self) -> str:
        cima_str = colored(f"   {self.cima}      ", 'cyan')
        esq_dir_str = colored(f"{self.esq}    {self.dir}    ", 'cyan')
        baixo_str = colored(f"   {self.baixo}      ", 'cyan')
        return f"{cima_str}\n{esq_dir_str}\n{baixo_str}"       
