package Aula_5.Exercicios;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class Questao1 {
    public static void main(String args[]) throws FileNotFoundException {
        File arquivo = new File("C:\\Users\\Gadrit\\IdeaProjects\\Estrutura de Dados\\src\\Aula_5\\Exercicios\\frases.txt");
        Stack<String> frases = new Stack<>();

        Scanner sc = new Scanner(arquivo);
        while(sc.hasNext()){
            frases.push(sc.nextLine());
        }
        int pilhaSemTop = frases.size() - 10;

        while(!frases.empty()){
            if(frases.size() > pilhaSemTop){
                System.out.println(frases.pop());
            } else{
                frases.pop();
            }
        }

    }
}
