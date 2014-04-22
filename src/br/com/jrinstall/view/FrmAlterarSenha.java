/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * FrmCadastroAuxiliares.java
 *
 * Created on 14/07/2011, 21:27:56
 */
package br.com.jrinstall.view;
import br.com.jrinstall.helper.Criptografia;
import br.com.jrinstall.helper.MetodosUteis;
import br.com.jrinstall.service.UsuarioService;
import javax.swing.JDesktopPane;

/**
 *
 * @author FernandoMelo
 */
public class FrmAlterarSenha extends javax.swing.JInternalFrame {

    private UsuarioService service;  

    /** Creates new form FrmCadastroAuxiliares */
    public FrmAlterarSenha(JDesktopPane dsk) {
        initComponents();
        service = new UsuarioService();
        jLabelUsuario.setText(Principal.getUsuarioLogado().getUsuario());
    }

      public FrmAlterarSenha() {
           initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelUsuario = new javax.swing.JLabel();
        jPasswordAntigo = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();
        jButtonSalvar1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jPasswordNovo = new javax.swing.JPasswordField();
        jLabel13 = new javax.swing.JLabel();

        setClosable(true);
        setResizable(true);
        setTitle("Alterar Senha");

        jLabelUsuario.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabelUsuario.setText("Usu·rio");

        jLabel2.setText("Senha antiga");

        jButtonSalvar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/jrinstall/icon/salvar-24.png"))); // NOI18N
        jButtonSalvar1.setText("Alterar");
        jButtonSalvar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalvar1ActionPerformed(evt);
            }
        });

        jLabel3.setText("Nova senha ");

        jLabel13.setText("Usu·rio");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addComponent(jLabelUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(jLabel2)
                        .addGap(8, 8, 8)
                        .addComponent(jPasswordAntigo, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(jLabel3)
                        .addGap(11, 11, 11)
                        .addComponent(jPasswordNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(jButtonSalvar1, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(82, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jLabel13))
                    .addComponent(jLabelUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jPasswordAntigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel3))
                    .addComponent(jPasswordNovo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(jButtonSalvar1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(45, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonSalvar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalvar1ActionPerformed

        if (Principal.getUsuarioLogado().getSenha().equalsIgnoreCase(Criptografia.criptografar(String.copyValueOf(jPasswordAntigo.getPassword())))) {
            Principal.getUsuarioLogado().setSenha(Criptografia.criptografar(String.copyValueOf(jPasswordNovo.getPassword())));
            if (service.Save(Principal.getUsuarioLogado())!=null) {
                MetodosUteis.showMsg("Altera√ß√£o realizada com sucesso!");
                this.dispose();
            }
        }else{
                MetodosUteis.showMsg("Senha antiga n√£o confere!");            
        }

        
    }//GEN-LAST:event_jButtonSalvar1ActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonSalvar1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabelUsuario;
    private javax.swing.JPasswordField jPasswordAntigo;
    private javax.swing.JPasswordField jPasswordNovo;
    // End of variables declaration//GEN-END:variables
}
