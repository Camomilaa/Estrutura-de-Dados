package Aula_3.Exercicios;

public class Questao1 {
    public static void main(String args[]){
        ListaLigada listaInicial = new ListaLigada();
        ListaLigada listaPrioridade = new ListaLigada();
        ListaLigada listaSemPrioridade = new ListaLigada();

        //Adicionando todos os itens a uma lista inicial
        for(int i=1; i<=200; i++){
            listaInicial.inserirFinal(i);
        }

        //lista com prioridade
        for(int i = 1; i < 100; i++){
            //System.out.println(listaInicial.mostrarNum(i));
            if(listaInicial.mostrarNum(i) % 2 != 0){
                listaPrioridade.inserirFinal(listaInicial.mostrarNum(i));
            }
        }

        //lista sem prioridade
        for(int i = 1; i <= 200; i++){
            if(i < 100){
                if(listaInicial.mostrarNum(i) % 2 == 0){
                    listaSemPrioridade.inserirFinal(listaInicial.mostrarNum(i));
                }
            } else{
                listaSemPrioridade.inserirFinal(listaInicial.mostrarNum(i));
            }
        }
        System.out.println("Lista com prioridade: ");
        listaPrioridade.mostrarLista();
        System.out.println("///////////");
        System.out.println("Lista sem prioridade: ");
        listaSemPrioridade.mostrarLista();
    }
}
