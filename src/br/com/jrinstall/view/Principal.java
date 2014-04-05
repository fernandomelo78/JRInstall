/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Principal.java
 *
 * Created on 01/05/2011, 12:03:57
 */
package br.com.jrinstall.view;

import br.com.jrinstall.entity.Usuario;
import br.com.jrinstall.helper.HibernateFactory;
import br.com.jrinstall.helper.MetodosUteis;
import br.com.jrinstall.service.UsuarioService;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author Fernando
 */
public class Principal extends javax.swing.JFrame {

    /**
     * Creates new form Principal
     */
    public static MaskFormatter maskData = new MaskFormatter();
    public static MaskFormatter maskFone = new MaskFormatter();
    public static MaskFormatter maskCPF = new MaskFormatter();
    public static MaskFormatter maskValor = new MaskFormatter();
    public static String caminhoFoto;
    public static String caminhoRelatorio;
    public static Usuario usuarioLogado;

    public static void main(String args[]) {
        HibernateFactory.OpenSessionFactory();
        // final StringBuffer mac = new StringBuffer(MetodosUteis.getMacAddress());
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                usuarioLogado = new Usuario();
                Principal lg = new Principal();
                lg.setBounds(800, 650, 400, 300);
                lg.setVisible(true);

                //usuarioLogado = new Usuario();
                usuarioLogado.setUsuario("Admin");
                usuarioLogado.setSenha("admin");
                UsuarioService usuarioService = new UsuarioService();
                usuarioService.validaLogin(usuarioLogado);

            }
        });
    }

    public Principal() {
        initComponents();
        setTitle("Sistema de Gest�o -  V1");
        caminhoRelatorio = System.getProperties().getProperty("user.dir") + "\\src\\br\\com\\jrinstall\\report\\";

        try {
            maskData = new MaskFormatter("##/##/####");
            maskFone = new MaskFormatter("(##)####-####");
            maskCPF = new MaskFormatter("###.###.###-##");
            maskValor = new MaskFormatter("##.#");
            jBCadastroUsuario.setVisible(true);
            jMenu1.setEnabled(true);
            this.setExtendedState(Principal.MAXIMIZED_BOTH);

            try {
                //  UIManager.setLookAndFeel(ch.randelshofer.quaqua.QuaquaManager.getLookAndFeel());
            } catch (Exception ex) {
                MetodosUteis.showMsg(ex.getMessage());
            }

        } catch (ParseException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane = new javax.swing.JDesktopPane();
        jBCliente = new javax.swing.JButton();
        jBOS = new javax.swing.JButton();
        jBCadastroUsuario = new javax.swing.JButton();
        jBAltSenha = new javax.swing.JButton();
        jMenuPrincipal = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jBCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/jrinstall/icon/cadastroAssociado.png"))); // NOI18N
        jBCliente.setText("Cliente");
        jBCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBClienteActionPerformed(evt);
            }
        });

        jBOS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/jrinstall/icon/sinc-24.png"))); // NOI18N
        jBOS.setText("Ordem de Servi�o");
        jBOS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBOSActionPerformed(evt);
            }
        });

        jBCadastroUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/jrinstall/icon/uses24.png"))); // NOI18N
        jBCadastroUsuario.setText("Usu�rios");
        jBCadastroUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBCadastroUsuarioActionPerformed(evt);
            }
        });

        jBAltSenha.setText("Alt senha");
        jBAltSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAltSenhaActionPerformed(evt);
            }
        });

        jMenu1.setText("Relat�rios");
        jMenu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu1MouseClicked(evt);
            }
        });
        jMenu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu1ActionPerformed(evt);
            }
        });
        jMenu1.addMenuKeyListener(new javax.swing.event.MenuKeyListener() {
            public void menuKeyPressed(javax.swing.event.MenuKeyEvent evt) {
                jMenu1MenuKeyPressed(evt);
            }
            public void menuKeyReleased(javax.swing.event.MenuKeyEvent evt) {
            }
            public void menuKeyTyped(javax.swing.event.MenuKeyEvent evt) {
            }
        });

        jMenu2.setText("Cadastro ");
        jMenu1.add(jMenu2);

        jMenuPrincipal.add(jMenu1);

        jMenu3.setText("Cadastros");
        jMenu3.setToolTipText("");
        jMenu3.setActionCommand("jMenuCadastros");

        jMenuItem1.setText("Material");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem1);

        jMenuPrincipal.add(jMenu3);

        setJMenuBar(jMenuPrincipal);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jBCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBOS, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
                    .addComponent(jBAltSenha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBCadastroUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jDesktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 821, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 660, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jBCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addComponent(jBOS, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jBAltSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jBCadastroUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(353, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBClienteActionPerformed

        FrmCliente jf = new FrmCliente(jDesktopPane);
        jf.setLocation(100, 50);
        jDesktopPane.add(jf);
        jf.toFront();
        jf.setVisible(true);

    }//GEN-LAST:event_jBClienteActionPerformed

    private void jBOSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBOSActionPerformed
        FrmOrdemDeServico jf = new FrmOrdemDeServico(jDesktopPane);
        jf.setLocation(100, 50);
        jDesktopPane.add(jf);
        jf.toFront();
        jf.setVisible(true);
    }//GEN-LAST:event_jBOSActionPerformed

    private void jBCadastroUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBCadastroUsuarioActionPerformed

    }//GEN-LAST:event_jBCadastroUsuarioActionPerformed

    private void jBAltSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAltSenhaActionPerformed

    }//GEN-LAST:event_jBAltSenhaActionPerformed

    private void jMenu1MenuKeyPressed(javax.swing.event.MenuKeyEvent evt) {//GEN-FIRST:event_jMenu1MenuKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenu1MenuKeyPressed

    private void jMenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu1ActionPerformed

    }//GEN-LAST:event_jMenu1ActionPerformed

    private void jMenu1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu1MouseClicked

    }//GEN-LAST:event_jMenu1MouseClicked

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        FrmCadastroMaterial jf = new FrmCadastroMaterial(jDesktopPane);
        jf.setLocation(100, 50);
        jDesktopPane.add(jf);
        jf.toFront();
        jf.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed
    /**
     * @param args the command line arguments
     *
     * public static void main(String args[]) {
     * java.awt.EventQueue.invokeLater(new Runnable() {
     *
     * public void run() { new Principal().setVisible(true); } }); }
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBAltSenha;
    private javax.swing.JButton jBCadastroUsuario;
    private javax.swing.JButton jBCliente;
    private javax.swing.JButton jBOS;
    private javax.swing.JDesktopPane jDesktopPane;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuBar jMenuPrincipal;
    // End of variables declaration//GEN-END:variables
}