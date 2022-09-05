package Aula_2.Exercicios;

import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class Questao2Carro {
    public static void main(String[] args){
        Scanner leitor = new Scanner(System.in);
        String[] caractere;

        System.out.println("Digite a placa do seu carro: ");
        String placa = leitor.nextLine().toLowerCase();

        System.out.println("Digite o ano de fabricação do carro: ");
        int ano = leitor.nextInt();

        //mostrando estado do carro
        if(ano<2010){
            System.out.println("Carro velho");
        } else if(ano<2021){
            System.out.println("Carro semi novo");
        } else{
            System.out.println("Carro novo");
        }

        //ocultando vogais da placa
        caractere = placa.split("");
        placa = "";
        for(int i = 0; i<caractere.length; i++){
            if(caractere[i].equals("a")||caractere[i].equals("e")||caractere[i].equals("i")||caractere[i].equals("o")||caractere[i].equals("u")){
                caractere[i] = "*";
            }
            placa += caractere[i];
        }
        System.out.println(placa.toUpperCase());
    }
}
