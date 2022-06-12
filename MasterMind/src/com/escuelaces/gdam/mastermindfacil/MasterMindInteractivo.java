package com.escuelaces.gdam.mastermindfacil;

import java.util.Random;
import java.util.Scanner;

public class MasterMindInteractivo {
	public static void main(String[] args) {
		System.out.println("Bienvenido al MasterMind Interactivo");
		Partida p = new Partida(generateObjetivo(Integer.valueOf(args[0])));
		System.out.println("Observa la partida, jugando con las bolas: " 
				+ Partida.pintarFichasPermitidas());
        Scanner sc = new Scanner(System.in);
		while (!p.isTerminada()) {
			p.jugar(sc.nextLine());
		}
		if (p.isTerminada()) {
			System.out.println("¡Adivinado! " + p.getObjetivo());
		}
        sc.close();
	}

    public static String generateObjetivo(int length) {
        String res = "";
        Random rm = new Random();
        for (int i = 0; i < length; i++) {
            res += Partida.FICHAS[rm.nextInt(Partida.FICHAS.length)];
        }
        return res;
    }
}