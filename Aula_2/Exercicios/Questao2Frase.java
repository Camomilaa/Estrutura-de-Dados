package Aula_2.Exercicios;

import java.util.HashSet;
import java.util.Scanner;

public class Questao2Frase {
    public static void main(String[] args){
        Scanner leitor = new Scanner(System.in);
        String[] fraseDesconstruida;
        int vogais = 0;
        var hashset = new HashSet<String>();

        System.out.println("Digite a frase: ");
        String frase = leitor.nextLine();
        fraseDesconstruida = frase.toLowerCase().split("");

        for(int i=0; i< fraseDesconstruida.length; i++){
            if(fraseDesconstruida[i].equals("a")||fraseDesconstruida[i].equals("e")||fraseDesconstruida[i].equals("i")||fraseDesconstruida[i].equals("o")||fraseDesconstruida[i].equals("u")){
                hashset.add(fraseDesconstruida[i]);
            }
        }
        vogais = hashset.size();

        System.out.println("Existem " + vogais + " nessa frase");

    }
}
