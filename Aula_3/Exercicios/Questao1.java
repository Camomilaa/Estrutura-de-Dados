package Aula_3.Exercicios;

public class Questao1 {
    public static void main(String args[]){
        ListaLigada listaInicial = new ListaLigada();
        ListaLigada listaPrioridade = new ListaLigada();
        ListaLigada listaSemPrioridade = new ListaLigada();
        int impares = 1, pares = 1;
        //Adicionando todos os itens a uma lista inicial
        for(int i=1; i<200; i++){
            if(listaInicial.contarNos() == 0){
                listaInicial.inserirInicio(new Integer(i));
                listaInicial.inserirFinal(new Integer(200));
            }else{
                listaInicial.inserirMeio(new Integer(i), i);
            }
        }
        //lista com prioridade
        for(int i = 1; i < 98; i++){
            //System.out.println(listaInicial.mostrarNum(i));
            if(listaInicial.mostrarNum(i) % 2 != 0){
                if(listaPrioridade.contarNos() == 0){
                    listaPrioridade.inserirInicio(listaInicial.mostrarNum(i));
                    listaPrioridade.inserirFinal(99);
                } else{
                    listaPrioridade.inserirMeio(listaInicial.mostrarNum(i), impares);
                }
                impares++;
            }
        }

        //lista sem prioridade
        for(int i = 1; i <= 199; i++){
            if(i < 100){
                if(listaInicial.mostrarNum(i) % 2 == 0){
                    if(listaSemPrioridade.contarNos() == 0){
                        listaSemPrioridade.inserirInicio(listaInicial.mostrarNum(i));
                        listaSemPrioridade.inserirFinal(200);
                    } else{
                        listaSemPrioridade.inserirMeio(listaInicial.mostrarNum(i), pares);
                    }
                    pares++;
                }
            } else{
                listaSemPrioridade.inserirMeio(listaInicial.mostrarNum(i), pares);
                pares++;
            }
        }
        System.out.println("Lista com prioridade: ");
        listaPrioridade.mostrarLista();
        System.out.println("///////////");
        System.out.println("Lista sem prioridade: ");
        listaSemPrioridade.mostrarLista();
    }
}
