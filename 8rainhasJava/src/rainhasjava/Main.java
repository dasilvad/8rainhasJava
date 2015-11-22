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
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int linha = 1;//linha incicial onde a rainha sera colocada
        Rainha rainha = new Rainha();
        rainha.posicionarRainha(linha);
        rainha.imprimirTabuleiro();
    }
    
}
