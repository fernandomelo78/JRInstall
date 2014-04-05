/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jrinstall.bean;

/**
 *
 * @author fernando
 */
public enum Operadora {

    DEFINIR(0), VIVO(1), CLARO(2), TIM(3), FIXO(4);

    private final int VALOR;

    private Operadora(int valor) {
        VALOR = valor;
    }

    public int getValor() {
        return VALOR;
    }

}
