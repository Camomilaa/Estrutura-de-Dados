package Aula_6.Exercicios;

import java.util.Stack;

public class Questao1 {
	
	public static boolean validandoOperador(String c) {
		if(c.equals("+")||c.equals("-")||c.equals("/")||c.equals("*"))
			return true;
		else
			return false;
	}
	
	public static int operacaoMatematica(int a, String operador, int b) {
		if(operador.equals("*")) {
			return a*b;
		} else if(operador.equals("/")) {
			return a/b;
		}else if(operador.equals("+")) {
			return a+b;
		} else {
			return a-b;
		}
	}
	
	public static int notacaoPolonesa(String[] vetor) {
			Stack<Integer> pilha = new Stack();
			String unindoNumeros = "", operador = "";
			int num1=0, num2=0, resultado =0, contador =0;
			
			for(String c: vetor) {
				contador++;
				if(validandoOperador(c)) {
					pilha.add(Integer.parseInt(unindoNumeros));
					unindoNumeros = "";
					if(pilha.size()<=1) {
						operador = c;
						continue;
					}
					if(!operador.isEmpty()) {
						num1 = pilha.pop();
						num2 = pilha.pop();
						System.out.println(num2 + operador + num1);
						resultado = operacaoMatematica(num2, operador, num1);
						pilha.push(resultado);
						if(pilha.size()<=1) {
							operador = c;
							continue;
						} else {
							operador = "";
						}
					}
					
					num1 = pilha.pop();
					num2 = pilha.pop();
					resultado = operacaoMatematica(num2, operador, num1);
					pilha.push(resultado);
				} else {
					if(contador == vetor.length-1) {
						break;
					} else {
						unindoNumeros += c;
					}
				}
			}
			
			if(pilha.size() == 2) {
				num1 = pilha.pop();
				num2 = pilha.pop();
				resultado = operacaoMatematica(num2, operador, num1);
				pilha.push(resultado);
			}
			
			return pilha.pop();
		}

	public static void main(String[] args) {
		String expressao = "10/2-3*1";
		String[] expressaoVetor = expressao.split("");
		System.out.println(notacaoPolonesa(expressaoVetor));
	}

}
