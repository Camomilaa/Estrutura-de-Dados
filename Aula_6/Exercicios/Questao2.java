package Aula_6.Exercicios;

import java.util.ArrayDeque;
import java.util.Deque;

public class Questao2 {
    public static void main(String[] args) {
        Deque<Pessoa> deque = new ArrayDeque<>();
        deque.addLast(new Pessoa("Sheila", "31999999999", "pessoa1@estruturadedados.com"));
        deque.addLast(new Pessoa("Sylas", "31999999999", "pessoa2@estruturadedados.com"));
        deque.addLast(new Pessoa("Marta", "31999999999", "pessoa3@estruturadedados.com"));
        deque.addLast(new Pessoa("Clara", "31999999999", "pessoa4@estruturadedados.com"));
        deque.addLast(new Pessoa("Tom", "31999999999", "pessoa5@estruturadedados.com"));
        deque.addLast(new Pessoa("Jerry", "31999999999", "pessoa6@estruturadedados.com"));
        deque.addLast(new Pessoa("John", "31999999999", "pessoa7@estruturadedados.com"));
        deque.addLast(new Pessoa("Leo", "31999999999", "pessoa8@estruturadedados.com"));
        deque.addLast(new Pessoa("Taylor", "31999999999", "pessoa9@estruturadedados.com"));
        deque.addLast(new Pessoa("Sam", "31999999999", "pessoa10@estruturadedados.com"));

        System.out.println("Ordem convencional");
        for (int i = 0; i < deque.size(); i++) {
            Pessoa temporaria = deque.pollFirst();
            System.out.println(temporaria);
            deque.addLast(temporaria);
        }
        System.out.println("Ordem não convencional");
        for (int i = 0; i < deque.size(); i++) {
            Pessoa temporaria = deque.pollLast();
            System.out.println(temporaria);
            deque.addFirst(temporaria);
        }

    }
}
