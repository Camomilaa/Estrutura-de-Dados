package Aula_8.Exercicios;

public class BSTNode {
    BSTNode esquerda, direita;
    int chave;

    public BSTNode()
    {
        esquerda = null;
        direita = null;
        chave = 0;
    }
    public BSTNode(int n)
    {
        esquerda = null;
        direita = null;
        chave = n;
    }
    /* Seta no nodo esquerdo */
    public void setEsquerda(BSTNode n)
    {
        esquerda = n;
    }
    /* Seta o nodo direito */
    public void setDireita(BSTNode n)
    {
        direita = n;
    }
    /* Pega nodo esquerdo */
    public BSTNode getEsquerda()
    {
        return esquerda;
    }
    /* Pega nodo direito */
    public BSTNode getDireita()
    {
        return direita;
    }
    /* Seta valor ao nodo */
    public void setChave(int d)
    {
        chave = d;
    }
    /* Pega valor do nodo */
    public int getChave()
    {
        return chave;
    }
}
