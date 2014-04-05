/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.jrinstall.bean;

import javax.swing.DefaultCellEditor;
import javax.swing.JFormattedTextField;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author FernandoMelo
 */
public class CellEditorDataFormat extends DefaultCellEditor {

    public CellEditorDataFormat(MaskFormatter dt) {
        super(new JFormattedTextField(dt));
    }
    
    
}
