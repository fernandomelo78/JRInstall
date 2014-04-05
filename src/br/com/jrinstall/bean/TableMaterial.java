/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jrinstall.bean;

import br.com.jrinstall.entity.Cliente;
import br.com.jrinstall.entity.ClienteTelefone;
import br.com.jrinstall.entity.Material;
import br.com.jrinstall.entity.TelefoneOperadora;
import br.com.jrinstall.helper.MetodosUteis;
import br.com.jrinstall.service.ClienteService;
import br.com.jrinstall.service.MaterialService;
import br.com.jrinstall.view.FrmCadastroMaterial;
import br.com.jrinstall.view.FrmCliente;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Fernando
 */
public class TableMaterial extends AbstractTableModel {

    private ArrayList<Material> linhas = null;
    private String[] colunas = null;
    private List<Material> listaMaterial;
    private Material material;
    private MaterialService service = new MaterialService();
    private FrmCadastroMaterial frmMaterial = new FrmCadastroMaterial();
    private static final int DESCRICAO = 0;
    private static final int VALOR = 1;
    private boolean permiteEditarCelula = true;

    public void setFrmCliente(FrmCadastroMaterial frmMat) {
        this.frmMaterial = frmMat;
    }

    public TableMaterial(ArrayList dados, String[] col, List<Material> lista) {
        setLinhas(dados);
        setColunas(col);
        setListaMaterial(lista);
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
        if (permiteEditarCelula) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        // Pega o sócio referente a linha especificada.
        material = new Material();
        material = getMaterial(rowIndex);
        String[] linha = (String[]) getLinhas().get(rowIndex);

        switch (columnIndex) {
            case DESCRICAO:
                material.setDescricaomaterial((String) aValue);
                break;
            case VALOR:
                try {
                    material.setValorPadrao(Double.valueOf((String) aValue));
                } catch (Exception e) {
                    MetodosUteis.showMsg("Erro ao alterar valor: " + e.getMessage());

                }

        }

        service.Save(material);

    }

    public void setLista(List<Material> lista) {
        this.listaMaterial = lista;
    }

    public Material getMaterial(int row) {
        return listaMaterial.get(row);
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    private void setListaMaterial(List<Material> lista) {
        listaMaterial = lista;
    }

    public void setPermiteEditarCelula(boolean permiteEditarCelula) {
        this.permiteEditarCelula = permiteEditarCelula;
    }

}
