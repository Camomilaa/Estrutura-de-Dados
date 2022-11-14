package Aula_8.Exercicios;

class BST
{
    private BSTNode raiz;

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
}
