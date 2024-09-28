from termcolor import colored
class Tabuleiro:  


    def __init__(self):
        #linha = [None] * 5

        self.mat = [[None, None, None, None, None],
                    [None, None, None, None, None],
                    [None, None, None, None, None],
                    [None, None, None, None, None],
                    [None, None, None, None, None]] 


    def colocarCarta(self, carta, linha, coluna):
        if(self.mat[linha][coluna] == None and (0 < linha <= 3 and 0 < coluna <= 3)):
            self.mat[linha][coluna] = carta

        else: 
            raise Exception("Posição Inválida, tente novamente.")
            
    def exibirTabuleiro(self):
        for i in range(1, 4):  # Percorre as linhas
            for j in range(1, 4):  # Percorre as colunas
                
                
                if self.mat[i][j] is None:
                    print("           ", end=" | ")  # Imprime o espaço vazio
                else:
                    print(self.mat[i][j].getSrt(1), end=" | ")
            print()  # Pula para a próxima linha após imprimir cima de todas as cartas

            for j in range(1, 4):  # Percorre novamente para a linha do meio
                
                
                if self.mat[i][j] is None:
                    print("           ", end=" | ")
                else:
                    
                    print(self.mat[i][j].getSrt(2), end="| ")
            print()  # Pula para a próxima linha

            for j in range(1, 4):  # Percorre novamente para a linha de baixo
                
                
                if self.mat[i][j] is None:
                    print("           ", end=" | ")
                else:
                    
                    print(self.mat[i][j].getSrt(3), end=" | ")
            print()  # Pula para a próxima linha
            print("-" * 40)  # Separador para as linhas
            

    def checaTabuleiroCompleto(self):
        for i in range(1, 4):
            for j in range(1, 4):
                if(self.mat[i][j] == None):
                    return False
        return True