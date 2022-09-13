package Aula_4.Exercicios;

import java.io.IOException;

public class ListaLigadaDuplamenteEncadeada {

    private NoDuplamenteEncadeado primeiro, ultimo;

    public ListaLigadaDuplamenteEncadeada() {
        primeiro = null;
        ultimo = null;
    }

    public boolean listaVazia() {
        if (primeiro == null) {
            return true;
        } else {
            return false;
        }
    }

    public void inserirInicio(Object elemento) {
        NoDuplamenteEncadeado novoNo = new NoDuplamenteEncadeado(elemento);
        if (listaVazia()) {
            ultimo = novoNo;
        } else {
            novoNo.prox = primeiro;
            primeiro.ant = novoNo;
        }
        primeiro = novoNo;
    }

    public void inserirFinal(Object elemento) {
        NoDuplamenteEncadeado novoNo = new NoDuplamenteEncadeado(elemento);
        if (listaVazia()) {
            primeiro = novoNo;
        } else {
            ultimo.prox = novoNo;
            novoNo.ant = ultimo;
        }
        ultimo = novoNo;
    }

    public int contarNos() {
        int tamanho = 0;
        NoDuplamenteEncadeado noTemp = primeiro;
        while (noTemp != null) {
            tamanho = tamanho + 1;
            noTemp = noTemp.prox;
        }
        return tamanho;
    }

    public void inserirMeio(Object elemento, int posicao) {
        NoDuplamenteEncadeado novoNo = new NoDuplamenteEncadeado(elemento);
        NoDuplamenteEncadeado noTemp = primeiro;
        int nroNos, posAux = 1;
        nroNos = contarNos();
        if (posicao <= 1) {
            inserirInicio(novoNo);
        } else {
            if (posicao > nroNos) {
                inserirFinal(novoNo);
            } else {
                while (posAux < (posicao - 1)) {
                    noTemp = noTemp.prox;
                    posAux = posAux + 1;
                }
                novoNo.prox = noTemp.prox;
                novoNo.ant = noTemp;
                novoNo.prox.ant = novoNo;
                noTemp.prox = novoNo;
            }
        }
    }

    public void remover(Object elemento) {
        NoDuplamenteEncadeado noTemp = primeiro;
        NoDuplamenteEncadeado noAnt = null;
        if (primeiro.elemento.equals(elemento)) {
            primeiro = primeiro.prox;
            primeiro.ant = null;
        } else {
            while ((noTemp != null) && (!noTemp.elemento.equals(elemento))) {
                noAnt = noTemp;
                noTemp = noTemp.prox;
            }
            if (noTemp != null) {
                noAnt.prox = noTemp.prox;
                noAnt.prox.ant = noAnt;
            }
            if (noTemp == ultimo) {
                ultimo = noAnt;
                ultimo.prox = null;
            }
        }
    }

    public Object elementoInicio() throws IOException {
        if (!listaVazia()) {
            return primeiro.elemento;
        } else {
            throw new IOException();
        }
    }

    public Object elementoFinal() throws IOException {
        if (!listaVazia()) {
            return ultimo.elemento;
        } else {
            throw new IOException();
        }
    }

    public boolean buscaNo(Object elemento) {
        NoDuplamenteEncadeado noTemp = primeiro;
        boolean found = false;
        while ((noTemp != null) && (!found)) {
            if (noTemp.elemento.equals(elemento)) {
                found = true;
            } else {
                noTemp = noTemp.prox;
            }
        }
        return found;
    }

    public void mostrarLista() {
        int i = 1;
        NoDuplamenteEncadeado noTemp = primeiro;
        while (noTemp != null) {
            System.out.println("Elemento " + noTemp.elemento + " posição " + i);
            noTemp = noTemp.prox;
            i++;
        }
    }

    public int mostrarNum(int num) {
        NoDuplamenteEncadeado noTemp = primeiro;
        for (int i = 1; i <= num; i++) {
            if (i == num) {
                return (int) noTemp.elemento;
            }
            noTemp = noTemp.prox;
        }
        return -1;
    }

    public String mostrarItem(int num) {
        NoDuplamenteEncadeado noTemp = primeiro;
        for (int i = 1; i <= num; i++) {
            if (i == num) {
                return String.valueOf(noTemp.elemento);
            }
            noTemp = noTemp.prox;
        }
        return "-1";
    }

    public ListaLigadaDuplamenteEncadeada juntarListas(ListaLigadaDuplamenteEncadeada l1, ListaLigadaDuplamenteEncadeada l2) {
        ListaLigadaDuplamenteEncadeada listaJunta = new ListaLigadaDuplamenteEncadeada();
        for (int i = 1; i <= l1.contarNos(); i++) {
            listaJunta.inserirFinal(l1.mostrarItem(i));
        }
        for (int i = 1; i <= l2.contarNos(); i++) {
            listaJunta.inserirFinal(l2.mostrarItem(i));
        }
        return listaJunta;
    }
}
