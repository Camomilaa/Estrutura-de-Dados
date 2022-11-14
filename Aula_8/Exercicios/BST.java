package Aula_8.Exercicios;

class BST
{
    private BSTNode raiz;
    public int menor = Integer.MAX_VALUE;
    public int maior = Integer.MIN_VALUE;
    public int alturaDireita = 0;
    public int alturaEsquerda = 0;


    public BST()
    {
        raiz = null;
    }

    public boolean vazio()
    {
        return raiz == null;
    }

    public void inserir(int chave)
    {
        raiz = inserir(raiz, chave);
    }

    private BSTNode inserir(BSTNode node, int chave)
    {
        if (node == null)
            node = new BSTNode(chave);
        else
        {
            if (chave <= node.getChave())
                node.esquerda = inserir(node.esquerda, chave);
            else
                node.direita = inserir(node.direita, chave);
        }
        return node;
    }

    public void deletar(int k)
    {
        if (vazio())
            System.out.println("Arvore Vazia");
        else if (procurar(k) == false)
            System.out.println("Desculpe, "+ k +" não foi encontrado");
        else
        {
            raiz = deletar(raiz, k);
            System.out.println(k+ " deletado da arvore");
        }
    }
    private BSTNode deletar(BSTNode raiz, int k)
    {
        BSTNode p, p2, n;
        if (raiz.getChave() == k)
        {
            BSTNode lt, rt;
            lt = raiz.getEsquerda();
            rt = raiz.getDireita();
            if (lt == null && rt == null)
                return null;
            else if (lt == null)
            {
                p = rt;
                return p;
            }
            else if (rt == null)
            {
                p = lt;
                return p;
            }
            else
            {
                p2 = rt;
                p = rt;
                while (p.getEsquerda() != null)
                    p = p.getEsquerda();
                p.setEsquerda(lt);
                return p2;
            }
        }
        if (k < raiz.getChave())
        {
            n = deletar(raiz.getEsquerda(), k);
            raiz.setEsquerda(n);
        }
        else
        {
            n = deletar(raiz.getDireita(), k);
            raiz.setDireita(n);
        }
        return raiz;
    }

    public int contarNodos()
    {
        return contarNodos(raiz);
    }

    private int contarNodos(BSTNode r)
    {
        if (r == null)
            return 0;
        else
        {
            int l = 1;
            l += contarNodos(r.getEsquerda());
            l += contarNodos(r.getDireita());
            return l;
        }
    }

    public boolean procurar(int val)
    {
        return procurar(raiz, val);
    }

    private boolean procurar(BSTNode r, int val)
    {
        boolean encontrado = false;
        while ((r != null) && !encontrado)
        {
            int rval = r.getChave();
            if (val < rval)
                r = r.getEsquerda();
            else if (val > rval)
                r = r.getDireita();
            else
            {
                encontrado = true;
                break;
            }
            encontrado = procurar(r, val);
        }
        return encontrado;
    }

    public void inorder()
    {
        inorder(raiz);
    }
    private void inorder(BSTNode r)
    {
        if (r != null)
        {
            inorder(r.getEsquerda());
            System.out.print(r.getChave() +" ");
            inorder(r.getDireita());
        }
    }

    public void preorder()
    {
        preorder(raiz);
    }
    private void preorder(BSTNode r)
    {
        if (r != null)
        {
            System.out.print(r.getChave() +" ");
            preorder(r.getEsquerda());
            preorder(r.getDireita());
        }
    }

    public void postorder()
    {
        postorder(raiz);
    }
    private void postorder(BSTNode r)
    {
        if (r != null)
        {
            postorder(r.getEsquerda());
            postorder(r.getDireita());
            System.out.print(r.getChave() +" ");
        }
    }

    public int maior(){
        maior = Integer.MIN_VALUE;
        return maior(raiz);
    }

    private int maior(BSTNode r){
        if(r.getChave() > maior){
            maior = r.getChave();
            if(r.direita != null){
                maior = maior(r.direita);
            }
        }
        return maior;
    }

    public int menor(){
        menor = Integer.MAX_VALUE;
        return menor(raiz);
    }
    private int menor(BSTNode r){
        if(r.getChave() < menor){
            menor = r.getChave();
            if(r.esquerda != null){
                menor = menor(r.esquerda);
            }
        }
        return menor;
    }

    public int altura(){
        alturaDireita = 0;
        alturaEsquerda = 0;
        return altura(raiz);
    }

    private int alturaEsquerda(BSTNode r){
        if(r.esquerda != null){
            alturaEsquerda++;
            alturaEsquerda(r.esquerda);
        } else{
            alturaEsquerda++;
        }
        return alturaEsquerda;
    }

    private int alturaDireita(BSTNode r){
        if(r.direita != null){
            alturaDireita++;
            alturaDireita(r.direita);
        } else{
            alturaDireita++;
        }
        return alturaDireita;
    }

    private int altura(BSTNode r){
        alturaEsquerda = alturaEsquerda(r);
        alturaDireita = alturaDireita(r);
        if(alturaEsquerda > alturaDireita){
            return alturaEsquerda;
        } else if(alturaDireita > alturaEsquerda){
            return alturaDireita;
        } else{
            return alturaEsquerda;
        }
    }

    public void balanceada(){
        alturaDireita = 0;
        alturaEsquerda = 0;
        balanceada(raiz);
    }
    private void balanceada(BSTNode r){
        alturaEsquerda = alturaEsquerda(r);
        alturaDireita = alturaDireita(r);
        if(alturaEsquerda > alturaDireita){
            System.out.println("Desbalanceada para esquerda");
        } else if(alturaDireita > alturaEsquerda){
            System.out.println("Desbalanceada para direita");
        } else{
            System.out.println("Balanceada");
        }
    }
}
