//https://github.com/kowalskiCES/retake-codigo
package com.escuelaces.gdam.mastermindfacil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Partida {

    private static final String TEXT_PISTAS = "Pistas: ";
    private static final String TEXT_JUGADA = "Jugada:";
    public static final char[] FICHAS = {'@','#', '%', '&', '?', '+', '*', '-', '<', '>'};
    
    private  String textInvalid = "";
    private String objetivo;
    private boolean isTerminada;

    private List<Character> fichas = new ArrayList<Character>();

    public Partida(String objetivo) {
        this.objetivo = objetivo;
        isTerminada = false;
        textInvalid = "Combinación inválida usa solo " + objetivo.length() + " fichas de las permitidas: " + pintarFichasPermitidas();
        for ( int i = 0; i < FICHAS.length; i++ ) {
            fichas.add(FICHAS[i]);
        }
    }
    

    public void jugar(String intento) {
        System.out.println(TEXT_JUGADA + intento);
        if (!checkRepetido(intento) || intento.length() != objetivo.length()) {
            System.err.println(textInvalid);
        } else {
            String res = "";
            for (int i = 0; i < intento.length(); i++) {
                char letter = intento.charAt(i);
                if (objetivo.charAt(i) == letter) {
                    res += estadoEnum.OK.toString();
                } else if (objetivo.indexOf(letter) != -1) {
                    res += estadoEnum.REGULAR.toString();
                } else {
                    res += estadoEnum.BAD.toString();
                }
            }
            System.out.println(TEXT_PISTAS + res);
            if (intento.equals(objetivo)) {
                isTerminada = true;
            }
        }
    }


    public static String pintarFichasPermitidas() {
        String res = "";
        for (int i = 0; i < FICHAS.length; i++) {
            res += FICHAS[i];
        }
        return res;
    }

    public String getObjetivo() {
        return objetivo;
    }

    public boolean isTerminada() {
        return isTerminada;
    }

    public boolean checkRepetido(String string) {
        String temp = "";
        for (int i = 0; i < string.length(); i++) {
            char letter = string.charAt(i);
            if (temp.indexOf(letter) == -1) {
                temp += letter;
            } else {
                return false;
            }
        }
        return true;
    }
}
