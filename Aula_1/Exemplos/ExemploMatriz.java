package Aula_1.Exemplos;
public class ExemploMatriz {

    public static void main(String[] args) {
        int[][] matriz = new int[10][10]; // inicializa a matriz com zeros
        //loop para preencher e mostrar a diagonal
        int impar=1;
        for(int linhas=0;linhas<10;linhas++){
            for(int cols=0;cols<10;cols++){
                matriz[linhas][cols]=impar;
                if (linhas==cols)
                    System.out.printf("%d\t",matriz[linhas][cols]);
                else
                    System.out.printf("0\t");
                impar+=2;
            }
            System.out.printf("\n");
        }

    }

}
