/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jrinstall.bean;

import br.com.jrinstall.entity.Cliente;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Fernando
 */
public class TableCliente extends AbstractTableModel {

    private ArrayList linhas = null;
    private String[] colunas = null;
    private List<Cliente> listaCliente;

    public TableCliente(ArrayList dados, String[] col, List<Cliente> lista) {
        setLinhas(dados);
        setColunas(col);
        setListaCliente(lista);
    }

    public int getRowCount() {
        return getLinhas().size();
    }

    public int getColumnCount() {
        return getColunas().length;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        String[] linha = (String[]) getLinhas().get(rowIndex);
        return linha[columnIndex];
    }

    /**
     * @return the linhas
     */
    public ArrayList getLinhas() {
        return linhas;
    }

    /**
     * @return the listaCliente
     */
    public List<Cliente> getListaCliente() {
        return listaCliente;
    }

    /**
     * @param listaCliente the listaCliente to set
     */
    public void setListaCliente(List<Cliente> listaCliente) {
        this.listaCliente = listaCliente;
    }

    /**
     * @param linhas the linhas to set
     */
    public void setLinhas(ArrayList li) {
        this.linhas = li;
    }

    /**
     * @return the colunas
     */
    public String[] getColunas() {
        return colunas;
    }

    /**
     * @param colunas the colunas to set
     */
    public void setColunas(String[] col) {
        this.colunas = col;
    }
    
    public Cliente getcliente(int row){
        return getListaCliente().get(row);
    }
}