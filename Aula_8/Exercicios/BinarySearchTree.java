package Aula_8.Exercicios;

import java.util.Scanner;

public class BinarySearchTree
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);

        BST bst = new BST();
        System.out.println("Binary Search Tree\n");
        char ch;

        do
        {
            System.out.println("\nOperações da Árvore Binária de Pesquisa\n");
            System.out.println("1. inserir ");
            System.out.println("2. deletar");
            System.out.println("3. procurar");
            System.out.println("4. contar nodos");
            System.out.println("5. checar se está vazia");

            int choice = scan.nextInt();
            switch (choice)
            {
                case 1 :
                    System.out.println("Insira um número para colocar na arvore");
                    bst.inserir( scan.nextInt() );
                    break;
                case 2 :
                    System.out.println("Insira um número para apagar da arvore");
                    bst.deletar( scan.nextInt() );
                    break;
                case 3 :
                    System.out.println("Insira numero para pesquisar");
                    System.out.println("Resultado da busca: : "+ bst.procurar( scan.nextInt() ));
                    break;
                case 4 :
                    System.out.println("Nodos = "+ bst.contarNodos());
                    break;
                case 5 :
                    System.out.println("Vazio? = "+ bst.vazio());
                    break;
                default :
                    System.out.println("Entrada Invalida \n ");
                    break;
            }

            System.out.print("\nPost order : ");
            bst.postorder();
            System.out.print("\nPre order : ");
            bst.preorder();
            System.out.print("\nIn order : ");
            bst.inorder();

            System.out.println("\nDeseja continuar? (Escreva S ou N) \n");
            ch = scan.next().charAt(0);
        } while (ch == 'S'|| ch == 's');
    }
}
