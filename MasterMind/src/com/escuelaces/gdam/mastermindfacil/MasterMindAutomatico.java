package com.escuelaces.gdam.mastermindfacil;

public class MasterMindAutomatico {
	private static final String[] INTENTOS = {"%&?+", "*-<>", "<>@#", "A#%&", "+#%&", 
			"@@@", "@@@@@", "@@@@", "@&%#", "@#<&", "@#%&"};

	public static void main(String[] args) {
		System.out.println("Bienvenido al MasterMind Automático");
		Partida p = new Partida(INTENTOS[INTENTOS.length - 1]);
		System.out.println("Observa la partida, jugando con las bolas: " 
				+ Partida.pintarFichasPermitidas());
		int i = 0;
		while (!p.isTerminada()) {
			p.jugar(INTENTOS[i++]);
		}
		if (p.isTerminada()) {
			System.out.println("¡Adivinado! " + p.getObjetivo());
		}
	}
}
