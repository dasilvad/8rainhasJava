/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rainhasjava;

/**
 *
 * @author daniel
 */
public class Rainha {
    private int [] colunas;
    private int[] posicao;//armazena a coluna em que a rainha e colocada, o indice do vetor e a coordenada linha
    private int[] diagonalPrincipal;
    private int[] diagonalSecundaria;
    
    Rainha(){
     colunas = new int[9]; 
     posicao = new int[9];
     diagonalPrincipal= new int[15];
     diagonalSecundaria = new int [15];
    }
    //verifica se a coordenada (linha, coluna) nao esta sendo atacada por uma rainha
    //a linha nunca se repetira, portanto nao precisa testar ela. Portanto, somente a coluna e diagonais principais serao testadas
    int posicaoValida(int linha, int coluna){

        if (colunas[coluna] == 0 && diagonalPrincipal[linha+coluna-2] == 0 && diagonalSecundaria[linha-coluna+7] == 0){
            return 1;
        }else{
            return 0;
        }
    }
    
    int posicionarRainha(int linha){

        int coluna;
        if (linha <= 8){//tenta colocar uma rainha ate que nao tenha linha mais no tabuleiro

            for (coluna=1; coluna <=8; coluna++){

                if (posicaoValida(linha, coluna) == 1){//posicao nao esta sendo atacada
                    colunas[coluna] = linha;
                    posicao[linha] = coluna;
                    diagonalPrincipal[linha+coluna - 2] = 1;
                    diagonalSecundaria[linha-coluna+7] = 1;

                    if (posicionarRainha(linha+1) == 0){
                        return 0;//coloca uma outra rainha em uma proxima linha
                    }
                    colunas[coluna] = 0;
                    posicao[linha] = 0;
                    diagonalPrincipal[linha+coluna - 2] = 0;
                    diagonalSecundaria[linha-coluna+7] = 0;
                }
            }
            return 1;
        }
        return 0;
    }
    
    void imprimirTabuleiro(){
        System.out.println("\nPosições válidas para colocar a rainha\n");
        for (int i=1; i <= 8;i++){
            System.out.println("linha: "+i+" coluna: "+posicao[i]);
        }
        System.out.println("\n\n\n");
        System.out.println("Tabuleiro \n");

        for (int i=1; i <= 8;i++){
            for (int j=1; j<=8; j++){
                if (posicao[i] == j){
                    System.out.print("R ");
                }else{
                    System.out.print("- ");
                }

            }
            System.out.println("");
        }

    }
}
