
class Tabuleiro:  


    def __init__(self):
        linha = [None] * 5

        self.mat = [linha] * 5


    def colocarCarta(self, carta, linha, coluna):
        if(self.mat[linha][coluna] == None and (0 < linha <= 3 and 0 < coluna <= 3)):
            self.mat[linha][coluna] = carta

        else: 
            raise Exception("Posição Inválida, tente novamente.")
            
    def exibirTabuleiro(self):
        print()
        for i in range(1, 4):
            for j in range(1, 4):
                print(self.mat[i][j], end=" | ")
            print()
            print("-"*20)
            

    def checaTabuleiroCompleto(self):
        for i in range(1, 4):
            for j in range(1, 4):
                if(self.mat[i][j] == None):
                    return False
        return True