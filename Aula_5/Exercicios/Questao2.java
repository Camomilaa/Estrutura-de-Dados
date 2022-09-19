package Aula_5.Exercicios;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Questao2 {
    public static void main(String args[]) throws FileNotFoundException {
        File arquivo = new File("C:\\Users\\Gadrit\\IdeaProjects\\Estrutura de Dados\\src\\Aula_5\\Exercicios\\ingressos.txt");
        Queue<String> ingressos = new LinkedList<>();
        Random aleatorio = new Random();

        Scanner sc = new Scanner(arquivo);
        while(sc.hasNext()){
            ingressos.add(sc.nextLine());
        }

        for(int i = 0; i<10; i++){
            System.out.println("VIP: " + ingressos.poll());
        }

        int sorteado = aleatorio.nextInt(ingressos.size() - 1);
        for(int i = 0; i < ingressos.size(); i++){
            if(sorteado == i){
                System.out.println(ingressos.poll() + " sorteado para ver a banda!");
                break;
            } else{
                ingressos.add(ingressos.poll());
            }
        }
    }
}
