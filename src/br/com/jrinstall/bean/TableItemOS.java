/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jrinstall.bean;

import br.com.jrinstall.entity.OrdemServicoItem;
import br.com.jrinstall.helper.MetodosUteis;
import br.com.jrinstall.service.OrdemDeServicoService;
import br.com.jrinstall.view.FrmOrdemDeServico;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Fernando
 */
public class TableItemOS extends AbstractTableModel {
    
    private ArrayList<OrdemServicoItem> linhas = null;
    private String[] colunas = null;
    private List<OrdemServicoItem> lista;
    private OrdemServicoItem ordemItem;

    private OrdemDeServicoService service = new OrdemDeServicoService();
    private FrmOrdemDeServico frmOS = new FrmOrdemDeServico();
    private static final int QUANTIDADE = 1;
    private static final int EXCLUIR = 4;
    
    public void setFrmCliente(FrmOrdemDeServico frm) {
        this.frmOS = frm;
    }
    
    public TableItemOS(ArrayList dados, String[] col, List<OrdemServicoItem> lista) {
        setLinhas(dados);
        setColunas(col);
        setLista(lista);
    }
    
    @Override
    public int getRowCount() {
        return getLinhas().size();
    }
    
    @Override
    public int getColumnCount() {
        return getColunas().length;
    }
    
    @Override
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
    
    public void setLinhas(ArrayList li) {
        this.linhas = li;
    }
    
    public String[] getColunas() {
        return colunas;
    }
    
    public void setColunas(String[] col) {
        this.colunas = col;
    }
    
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        if (QUANTIDADE == columnIndex) {
            return true;
        } else {
            return false;
        }
        
    }
    
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        // Pega o sócio referente a linha especificada.
        ordemItem = new OrdemServicoItem();
        ordemItem = lista.get(rowIndex);
        String[] linha = (String[]) getLinhas().get(rowIndex);
        
        switch (columnIndex) {
            case QUANTIDADE:
                ordemItem.setQuantidade(Integer.parseInt(aValue.toString()));
                ordemItem.setValorTotal((ordemItem.getQuantidade() * ordemItem.getValorUnitario()));
                break;
            case EXCLUIR:
            
        }
        try {
            service.SaveItem(ordemItem);
            linha[columnIndex] = String.valueOf(aValue);
             linha[3] = String.valueOf(MetodosUteis.formataMoeda(ordemItem.getValorTotal()));
            fireTableCellUpdated(rowIndex, columnIndex);
             fireTableCellUpdated(rowIndex, 3);
        } catch (Exception e) {
            MetodosUteis.showMsg("Erro ao salvar Item: " + e.getMessage());
        }
    }
    
    

    public void setLista(List<OrdemServicoItem> list) {
        this.lista = list;
    }
    
    public OrdemServicoItem getOrdemItem(int row) {
        return lista.get(row);
    }
    
    public void setOrdemItem(OrdemServicoItem item) {
        this.ordemItem = item;
    }
    
}
