/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jrinstall.helper;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author FernandoMelo
 */
public class Arquivo {

    public static Scanner lerArquivo(File file) {
        String linha = null;
        Scanner scan = null;
        try {
            FileInputStream fis = new FileInputStream(file.getAbsolutePath() + "");
            scan = new Scanner(fis);
        } catch (FileNotFoundException ex) {
            MetodosUteis.showMsg("Arquivo náo localizado");
        }

        return scan;
    }

    public static void gravaArquivo(File file, String[] vetor) {
        String linha = null;
        try { 
            PrintWriter pw = new PrintWriter(new FileOutputStream(file));
           deletaArquivo(file);
            for (String s : vetor) {
                pw.println(s);
            }

            pw.close();

        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Arquivo não encontrado");
        }
    }
    
     public static Boolean arquivoExiste(File file) {        
         return file.exists();
    }

    public static void deletaArquivo(File file) {
        if (file.exists()) {
            file.delete();
        }
    }
    
    
}
