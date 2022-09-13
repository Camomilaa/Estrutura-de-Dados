package Aula_4.Exercicios;

import Aula_3.Exercicios.No;

public class NoDuplamenteEncadeado {
    public Object elemento;
    public NoDuplamenteEncadeado prox;
    public NoDuplamenteEncadeado ant;

    public NoDuplamenteEncadeado (Object elem){
        elemento = elem;
        prox = null;
        ant = null;
    }
}
