/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jrinstall.bean;

import br.com.jrinstall.entity.Cliente;
import br.com.jrinstall.entity.ClienteTelefone;
import br.com.jrinstall.entity.TelefoneOperadora;
import br.com.jrinstall.service.ClienteService;
import br.com.jrinstall.view.FrmCliente;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Fernando
 */
public class TableTelefone extends AbstractTableModel {

    private ArrayList<ClienteTelefone> linhas = null;
    private String[] colunas = null;
    private List<ClienteTelefone> listaTelefone;
    private List<TelefoneOperadora> operadoras;
    private Cliente cliente;
    private static final int NUMERO = 0;
    private static final int OPERADORA = 1;
    private ClienteService service = new ClienteService();
    private FrmCliente frmCliente = new FrmCliente();

    public void setFrmCliente(FrmCliente frmCliente) {
        this.frmCliente = frmCliente;
    }

    public TableTelefone(ArrayList dados, String[] col, List<ClienteTelefone> lista) {
        setLinhas(dados);
        setColunas(col);
        setListaTelefone(lista);
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

    /**
     * @return the listaCliente
     */
    public List<ClienteTelefone> getListaTelefone() {
        return listaTelefone;
    }

    /**
     * @param listaTelefone the listaCliente to set
     */
    public void setListaTelefone(List<ClienteTelefone> listaTelefone) {
        this.listaTelefone = listaTelefone;
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

    public ClienteTelefone getClienteTelefone(int row) {
        return getListaTelefone().get(row);
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case NUMERO:
                return true;
            case OPERADORA:
                if (getValueAt(rowIndex, columnIndex).equals("Novo")) {
                    return false;
                } else {
                    return true;
                }
            default:
                return false;
        }
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        // Pega o sócio referente a linha especificada.
        ClienteTelefone telefone = getClienteTelefone(rowIndex);
        String[] linha = (String[]) getLinhas().get(rowIndex);
        boolean novoFone = false;

        switch (columnIndex) {
            case NUMERO:
                telefone.setNumero((String) aValue);
                if (telefone.getIdCliente() == null) {//Novo Telefone
                    if (cliente.getTelefones() == null) {
                        cliente.setTelefones(new ArrayList<ClienteTelefone>());
                    }
                    telefone.setIdCliente(cliente.getIdCliente());
                    telefone.setOperadora(new TelefoneOperadora(5, "Definir"));//Operadora a definir
                    cliente.getTelefones().remove(rowIndex);
                    cliente.getTelefones().add(telefone);
                    novoFone = true;
                }
                service.SaveTelefone(telefone);
                if (novoFone) {
                    frmCliente.montaTabelaFones(cliente.getTelefones());
                } else {
                    linha[columnIndex] = (String) aValue;
                    fireTableCellUpdated(rowIndex, columnIndex); // Notifica a atualização da célula

                }

                break;
            case OPERADORA:
                for (TelefoneOperadora op : operadoras) {
                    if (op.getDescricaoOperadora() == aValue) {
                        telefone.setOperadora(op);
                    }
                }
                service.SaveTelefone(telefone);
                linha[columnIndex] = (String) aValue;
                fireTableCellUpdated(rowIndex, columnIndex); // Notifica a atualização da célula
                break;
            default:
                // Não deve ocorrer, pois só existem 2 validas
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
    }

    public void setOperadoras(List<TelefoneOperadora> operadoras) {
        this.operadoras = operadoras;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

}
