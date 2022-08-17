package Aula_1.Exercicios;
import java.util.Random;
import java.util.Scanner;

// Essa questão pede um sistema que realize uma busca sequencial simples em um vetor.

public class Questao1 {
    public static void main(String[] args){
        Scanner ent = new Scanner(System.in);
        Random aleatorio = new Random();
        int[] vetor = new int[10];
        boolean achado = false;

        System.out.println("Mostrando o vetor");
        System.out.printf("( - ");
        for(int i = 0; i<vetor.length; i++){
            vetor[i] = aleatorio.nextInt(999);
            System.out.printf(vetor[i] + " - ");
        }
        System.out.printf(")\n");

        System.out.println("Digite o numero que deseja pesquisar: ");
        int num = ent.nextInt();

        for(int i = 0; i<vetor.length; i++){
            if(num == vetor[i]){
                System.out.println("Numero " + num + " encontrado na posicao " + i);
                achado = true;
            }
        }

        if (achado == false){
            System.out.println("Numero nao encontrado");
        }

    }
}
