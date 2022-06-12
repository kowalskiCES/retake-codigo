package com.escuelaces.gdam.mastermindfacil;

public enum estadoEnum {
    OK("x"), REGULAR("o"), BAD(".");

    private String estado;

    private estadoEnum(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return estado;
    }
}
