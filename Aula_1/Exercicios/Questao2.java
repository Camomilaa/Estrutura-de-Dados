package Aula_1.Exercicios;

import java.util.Random;

public class Questao2 {
    public static void main(String[] args){
        int[][] matriz = new int[3][4];
        Random aleatorio = new Random();
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for(int i = 0; i<matriz.length; i++){
            for(int j = 0; j<matriz[i].length; j++){
                matriz[i][j] = aleatorio.nextInt(999);
                if(matriz[i][j]>max){
                    max = matriz[i][j];
                }
                if(matriz[i][j]<min){
                    min = matriz[i][j];
                }
                System.out.printf("[" + matriz[i][j] + "]\t");
            }
            System.out.printf("\n");
        }
        System.out.println("Maior valor: " + max);
        System.out.println("Menor valor: " + min);
    }
}
