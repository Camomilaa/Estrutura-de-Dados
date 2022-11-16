package Aula_8.Exercicios;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        Tree arvore = new Tree();
        int op = 0;

        do{
            System.out.println("\nSelecione a operação que deseja realizar\n Caso deseje encerrar, digite -1");
            System.out.println("1. Inserir ");
            System.out.println("2. Procurar");
            System.out.println("3. Contar folhas");
            System.out.println("4. Checar se está vazia");
            System.out.println("5. Maior nodo");
            System.out.println("6. Menor nodo");
            System.out.println("7. Verificar se duas árvores binárias são idênticas:");
            System.out.println("8. Altura");
            System.out.println("9. Balanceada?");

            op = ler.nextInt();

            switch(op){
                case 1:
                    System.out.println("Insira um número para colocar na arvore");
                    arvore.inserir(ler.nextInt());
                    break;
                case 2:
                    System.out.println("Insira um número para saber se existe na arvore");
                    System.out.println(arvore.encontrar(ler.nextInt()));;
                    break;
                case 3:
                    System.out.println(arvore.contarFolhas());
                    break;
                case 4:
                    System.out.println(arvore.vazio());
                    break;
                case 5:
                    System.out.println(arvore.max());
                    break;
                case 6:
                    System.out.println(arvore.min());
                    break;
                case 7:
                    System.out.println("Digite o nome da outra arvore:");
                    String outraArvore = ler.nextLine();
                    System.out.println(arvore.equals(outraArvore));
                    break;
                case 8:
                    System.out.println(arvore.altura() + 1);
                    break;
                case 9:
                    System.out.println(arvore.eBalanceada());
                    break;
                case default:
                    System.out.println("opção inválida");
                    break;
            }

        }while(op != -1);
    }
}
