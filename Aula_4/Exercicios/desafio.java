package Aula_4.Exercicios;

import java.io.*;

public class desafio {
    public static void main(String args[]) throws IOException {
        ListaLigadaDuplamenteEncadeada listaNoiva = new ListaLigadaDuplamenteEncadeada();
        ListaLigadaDuplamenteEncadeada listaNoivo = new ListaLigadaDuplamenteEncadeada();
        ListaLigadaDuplamenteEncadeada listaConjunta = new ListaLigadaDuplamenteEncadeada();
        String aux = "";

        //Criação da lista do noivo com base em um arquivo repleto de nomes
        File noivo = new File("C:\\Users\\Gadrit\\IdeaProjects\\Estrutura de Dados\\src\\Aula_3\\Exercicios\\ListaNoivo.txt");
        if(noivo.exists()){
            FileReader fro = new FileReader(noivo);
            BufferedReader bro = new BufferedReader(fro);
            while(bro.ready()){
                listaNoivo.inserirFinal(bro.readLine());
            }
        }

        //Criação da lista do noiva com base em um arquivo repleto de nomes
        File noiva = new File("C:\\Users\\Gadrit\\IdeaProjects\\Estrutura de Dados\\src\\Aula_3\\Exercicios\\ListaNoiva.txt");
        if(noiva.exists()){
            FileReader fra = new FileReader(noiva);
            BufferedReader bra = new BufferedReader(fra);
            while(bra.ready()){
                listaNoiva.inserirFinal(bra.readLine());
            }
        }

        //juntando as listas
        listaConjunta = listaConjunta.juntarListas(listaNoiva, listaNoivo);
        int tamanhoLista = listaConjunta.contarNos();
        //System.out.println(listaConjunta.mostrarItem(2).compareTo(listaConjunta.mostrarItem(3)));
        for(int i = 1; i <= listaConjunta.contarNos(); i++){
            for(int j = 1; j <= listaConjunta.contarNos()-1; j++){
                if(listaConjunta.mostrarItem(j).compareTo(listaConjunta.mostrarItem(j+1)) > 0){
                    aux = listaConjunta.mostrarItem(j);
                    listaConjunta.remover(listaConjunta.mostrarItem(j));
                    if(j+1 == tamanhoLista){
                        listaConjunta.inserirFinal(aux);
                    }else{
                        listaConjunta.inserirMeio(aux, j+1);
                    }
                }
            }
        }
        listaConjunta.mostrarLista();
    }
}
