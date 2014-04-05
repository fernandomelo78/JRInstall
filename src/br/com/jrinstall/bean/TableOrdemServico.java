/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jrinstall.bean;

import br.com.jrinstall.entity.Material;
import br.com.jrinstall.entity.OrdemServico;
import br.com.jrinstall.service.OrdemDeServicoService;
import br.com.jrinstall.view.FrmOrdemDeServico;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Fernando
 */
public class TableOrdemServico extends AbstractTableModel {

    private ArrayList<OrdemServico> linhas = null;
    private String[] colunas = null;
    private List<OrdemServico> lista;
    private OrdemServico ordemServico;
    private OrdemDeServicoService service = new OrdemDeServicoService();
    private FrmOrdemDeServico frmOrdemDeServico = new FrmOrdemDeServico();

    public void setFrmOrdemDeServico(FrmOrdemDeServico frmOrdem) {
        this.frmOrdemDeServico = frmOrdem;
    }

    public TableOrdemServico(ArrayList dados, String[] col, List<OrdemServico> lista) {
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
        return false;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {     
        
    }

    public void setLista(List<OrdemServico> list) {
        this.lista = list;
    }

    public OrdemServico getOrdemServico(int row) {
        return lista.get(row);
    }

    public void setOrdemServico(OrdemServico os) {
        this.ordemServico = os;
    }


}
