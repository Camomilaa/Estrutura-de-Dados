package Aula_8.Exercicios;

import java.util.ArrayList;
import java.util.List;

public class Tree {
    public class Node {
        private int valor;
        private Node esquerda;
        private Node direita;

        public Node(int valor) {
            this.valor = valor;
        }

        @Override
        public String toString() {
            return "Node=" + valor;
        }
    }

    private Node raiz;

    public void inserir(int valor) {
        var node = new Node(valor);

        if (raiz == null) {
            raiz = node;
            return;
        }

        var atual = raiz;
        while (true) {
            if (valor < atual.valor) {
                if (atual.esquerda == null) {
                    atual.esquerda = node;
                    break;
                }
                atual = atual.esquerda;
            }
            else {
                if (atual.direita == null) {
                    atual.direita = node;
                    break;
                }
                atual = atual.direita;
            }
        }
    }

    public boolean vazio()
    {
        return raiz == null;
    }

    public boolean encontrar(int value) {
        var atual = raiz;
        while (atual != null) {
            if (value < atual.valor)
                atual = atual.esquerda;
            else if (value > atual.valor)
                atual = atual.direita;
            else
                return true;
        }
        return false;
    }

    public void traverseInOrder() {
        traverseInOrder(raiz);
    }

    private void traverseInOrder(Node raiz) {
        if (raiz == null)
            return;

        traverseInOrder(raiz.esquerda);
        System.out.println(raiz.valor);
        traverseInOrder(raiz.direita);
    }

    public void traversePreOrder() {
        traversePreOrder(raiz);
    }

    private void traversePreOrder(Node raiz) {
        if (raiz == null)
            return;

        System.out.println(raiz.valor);
        traversePreOrder(raiz.esquerda);
        traversePreOrder(raiz.direita);
    }

    public void traversePostOrder() {
        traversePostOrder(raiz);
    }

    private void traversePostOrder(Node raiz) {
        if (raiz == null)
            return;

        traversePostOrder(raiz.esquerda);
        traversePostOrder(raiz.direita);
        System.out.println(raiz.valor);
    }

    public int altura() {
        return altura(raiz);
    }

    private int altura(Node raiz) {
        if (raiz == null)
            return -1;

        if (eFolha(raiz))
            return 0;

        return 1 + Math.max(altura(raiz.esquerda), altura(raiz.direita));
    }

    // O(log n)
    public int min() {
        if (raiz == null)
            throw new IllegalStateException();

        var atual = raiz;
        var ultimo = atual;
        while (atual != null) {
            ultimo = atual;
            atual = atual.esquerda;
        }
        return ultimo.valor;
    }

    //O👎
    private int min(Node raiz) {
        if (eFolha(raiz))
            return raiz.valor;

        var esq = min(raiz.esquerda);
        var dir = min(raiz.direita);

        return Math.min(Math.min(esq,dir),raiz.valor);
    }

    public boolean equals(Tree outra) {
        if (outra == null)
            return false;

        return equals(raiz,outra.raiz);
    }

    private boolean equals(Node primeiro, Node segundo) {
        if (primeiro == null && segundo == null)
            return true;

        if (primeiro != null && segundo != null)
            return primeiro.valor == segundo.valor
                    && equals(primeiro.esquerda, segundo.esquerda)
                    && equals(primeiro.direita, segundo.direita);

        return false;
    }

    public boolean isBinarySearchTree() {
        return isBinarySearchTree(raiz,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }

    private boolean isBinarySearchTree(Node root, int min, int max) {
        if (root == null)
            return true;

        if (root.valor < min || root.valor > max)
            return false;

        return isBinarySearchTree(root.esquerda, min, root.valor - 1)
                && isBinarySearchTree(root.direita, root.valor + 1, max);
    }

    public ArrayList<Integer> getNodesAtDistance(int distance) {
        var list = new ArrayList<Integer>();
        getNodesAtDistance(raiz,distance,list);
        return list;
    }

    public void getNodesAtDistance(Node root, int distance, ArrayList<Integer> list) {
        if (root == null)
            return;

        if (distance == 0) {
            list.add(root.valor);
            return;
        }

        getNodesAtDistance(root.esquerda,distance - 1, list);
        getNodesAtDistance(root.direita, distance - 1, list);
    }

    public void traverseLevelOrder() {
        for (int i = 0; i <= altura(); i++) {
            for (var value : getNodesAtDistance(i))
                System.out.println(value);
        }
    }

    public int tamanho() {
        return tamanho(raiz);
    }

    private int tamanho(Node raiz) {
        if (raiz == null)
            return 0;

        if (eFolha(raiz))
            return 1;

        return 1 + tamanho(raiz.esquerda) + tamanho(raiz.direita);
    }

    public int contarFolhas() {
        return contarFolhas(raiz);
    }

    private int contarFolhas(Node root) {
        if (root == null)
            return 0;

        if (eFolha(root))
            return 1;

        return contarFolhas(root.esquerda) + contarFolhas(root.direita);
    }

    public int max() {
        if (raiz == null)
            throw new IllegalStateException();

        return max(raiz);
    }

    private int max(Node root) {
        if (root.direita == null)
            return root.valor;

        return max(root.direita);
    }

    public boolean contains(int value) {
        return contains(raiz, value);
    }

    private boolean contains(Node root, int value) {
        if (root == null)
            return false;

        if (root.valor == value)
            return true;

        return contains(root.esquerda, value) || contains(root.direita, value);
    }

    public boolean areSibling(int first, int second) {
        return areSibling(raiz, first, second);
    }

    private boolean areSibling(Node root, int first, int second) {
        if (root == null)
            return false;

        var areSibling = false;
        if (root.esquerda != null && root.direita != null) {
            areSibling = (root.esquerda.valor == first && root.direita.valor == second) ||
                    (root.direita.valor == first && root.esquerda.valor == second);
        }

        return areSibling ||
                areSibling(root.esquerda, first, second) ||
                areSibling(root.direita, first, second);
    }

    public List<Integer> getAncestors(int value) {
        var list = new ArrayList<Integer>();
        getAncestors(raiz, value, list);
        return list;
    }

    private boolean getAncestors(Node root, int value, List<Integer> list) {
        // We should traverse the tree until we find the target value. If
        // find the target value, we return true without adding the current node
        // to the list; otherwise, if we ask for ancestors of 5, 5 will be also
        // added to the list.
        if (root == null)
            return false;

        if (root.valor == value)
            return true;

        // If we find the target value in the left or right sub-trees, that means
        // the current node (root) is one of the ancestors. So we add it to the list.
        if (getAncestors(root.esquerda, value, list) ||
                getAncestors(root.direita, value, list)) {
            list.add(root.valor);
            return true;
        }

        return false;
    }

    public boolean eBalanceada() {
        return eBalanceada(raiz);
    }

    private boolean eBalanceada(Node raiz) {
        if (raiz == null)
            return true;

        var balanceFactor = altura(raiz.esquerda) - altura(raiz.direita);

        return Math.abs(balanceFactor) <= 1 &&
                eBalanceada(raiz.esquerda) &&
                eBalanceada(raiz.direita);
    }

    public boolean ePerfeita() {
        return tamanho() == (Math.pow(2, altura() + 1) - 1);
    }

    private boolean eFolha(Node node) {
        return node.esquerda == null && node.direita == null;
    }
}