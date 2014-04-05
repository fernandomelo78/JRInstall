/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jrinstall.helper;

/**
 *
 * @author fernando
 */
public class Validacao {

    public static Boolean campoPreenchido(String valor) {
        if (valor.length() == 0){
            return false;
        } else {
            return true;
        }
    }

    public static Boolean campoBranco(String valor) {
        if (valor.length() == 0){
            return true;
        } else {
            return false;
        }
    }

}
