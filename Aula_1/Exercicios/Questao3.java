package Aula_1.Exercicios;
import java.util.Random;
import java.util.Scanner;

//Essa questão pede um vetor preenchido por números aleatórios, ordenados com um sistema de busca binária

public class Questao3 {
    public static void main(String[] args){
        Random aleatorio = new Random();
        int[] vetor = new int[50];
        Scanner leitor = new Scanner(System.in);
        boolean achado = false;

        //enchendo o vetor de números aleatórios e o mostrando
        System.out.printf("Vetor desordenado: \n(");
        for(int i = 0; i<vetor.length; i++){
            vetor[i] = aleatorio.nextInt(999);
            System.out.printf(" " + vetor[i]);
        }
        System.out.printf(" )\n");

        //ordenando o vetor (Bubble Sort)
        System.out.printf("Vetor Ordenado: \n(");
        for(int i = 0; i<vetor.length; i++){
            for(int j = 0; j<vetor.length - 1; j++){
                int aux = 0;
                if(vetor[j]>vetor[j+1]) {
                    aux = vetor[j];
                    vetor[j] = vetor[j + 1];
                    vetor[j + 1] = aux;
                }
            }
        }

        //mostrando o vetor ordenado
        for(int i = 0; i<vetor.length; i++){
            System.out.printf(" " + vetor[i]);
        }
        System.out.printf(" )\n");

        //busca binária
        System.out.println("Digite o número que deseja encontrar: ");
        int numDesejado = leitor.nextInt();
        int inicio = 0, fim = vetor.length;

        while(inicio <= fim){
            int meio = (inicio + fim)/2;
            if(vetor[meio] == numDesejado){
                System.out.println("Número " + numDesejado + " foi encontrado na posicao " + meio);
                achado = true;
                break;
            } else if(vetor[meio] > numDesejado){
                fim = meio-1;
            } else{
                inicio = meio+1;
            }
        }
        if (achado == false){
            System.out.println("Número " + numDesejado + " não foi encontrado");
        }
    }
}
