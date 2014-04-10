/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jrinstall.helper;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author FernandoMelo
 */
public class Relatorio {

    /**
     * - Utiliza o JRBEanCollectionDataSource
     * - Mostra o relatÃ³rio solicitado
     * @param lista
     * @param parametro
     * @param relatorio 
     */
    public static void carregaRelatorio(List lista, Map parametro, String relatorio) {

        JRDataSource jrds = new JRBeanCollectionDataSource(lista);
        try {
            InputStream fs = new FileInputStream(new File(relatorio));
            JasperPrint print = JasperFillManager.fillReport(fs, parametro, jrds);
            JasperViewer view = new JasperViewer(print, false);
            view.setVisible(true);
        } catch (Exception ex) {
            MetodosUteis.showMsg("Erro ao abrir relatório:\n" + ex.getMessage());
        }

    }
}
