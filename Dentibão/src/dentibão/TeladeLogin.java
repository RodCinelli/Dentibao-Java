/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package dentibão;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Rodrigo Cinelli
 */
public class TeladeLogin extends javax.swing.JFrame {

    /**
     * Creates new form TeladeLogin
     */
    public TeladeLogin() {
        initComponents();
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        user = new javax.swing.JTextField();
        pass = new javax.swing.JPasswordField();
        aqui = new javax.swing.JButton();
        voltar = new javax.swing.JButton();
        entrar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        user.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        user.setBorder(null);
        user.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userActionPerformed(evt);
            }
        });
        getContentPane().add(user, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 150, 230, 20));

        pass.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        pass.setBorder(null);
        pass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passActionPerformed(evt);
            }
        });
        getContentPane().add(pass, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 220, 230, -1));

        aqui.setContentAreaFilled(false);
        aqui.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        aqui.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aquiActionPerformed(evt);
            }
        });
        getContentPane().add(aqui, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 270, 30, 30));

        voltar.setContentAreaFilled(false);
        voltar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        voltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                voltarActionPerformed(evt);
            }
        });
        getContentPane().add(voltar, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 323, 100, 30));

        entrar.setContentAreaFilled(false);
        entrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        entrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                entrarActionPerformed(evt);
            }
        });
        getContentPane().add(entrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(402, 320, 100, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dentibão resourses/Tela de Login.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 540, 390));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
  
    private void aquiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aquiActionPerformed
        TeladeCadastro teladeCadastro = new TeladeCadastro();
        teladeCadastro.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_aquiActionPerformed

    private void voltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_voltarActionPerformed
        TelaInicial telaInicial = new TelaInicial();
        telaInicial.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_voltarActionPerformed

    private void entrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_entrarActionPerformed
        // Verifique se ambos os campos de texto estão preenchidos.
        
        if (user.getText().isEmpty() || new String(pass.getPassword()).isEmpty()) {
            
        // Se um ou mais campos estiverem vazios, exiba uma mensagem para o usuário e retorne.
        JOptionPane.showMessageDialog(null, "Todos os campos devem ser preenchidos.");
        return;
    }
        // Recupere as credenciais inseridas pelo usuário
        String username = user.getText();
        String password = pass.getText();

        // Conexão com o banco de dados e verificação das credenciais
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
    
        try {
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dentibao", "root", "");
        
        stmt = conn.prepareStatement("SELECT * FROM login WHERE usuario = ? AND senha = ?");
        stmt.setString(1, username);
        stmt.setString(2, password);
        
        rs = stmt.executeQuery();
        
        if (rs.next()) {
            // Se encontramos um usuário que corresponde às credenciais inseridas:
            TeladeLoginEfetuada telaLoginEfetuada = new TeladeLoginEfetuada();
            telaLoginEfetuada.setVisible(true);
            this.dispose(); // Fecha a tela de login.
        } else {
            // Caso contrário, informamos ao usuário que as credenciais estão incorretas.
            JOptionPane.showMessageDialog(null, "Usuário ou senha incorretos. Tente novamente.");
        }
        
    } catch (SQLException ex) {
        Logger.getLogger(TeladeLogin.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
        // Feche o ResultSet, PreparedStatement e Connection para liberar recursos
        try {
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(TeladeLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
  
    }//GEN-LAST:event_entrarActionPerformed

    private void userActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_userActionPerformed

    private void passActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TeladeLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TeladeLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TeladeLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TeladeLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new TeladeLogin().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aqui;
    private javax.swing.JButton entrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPasswordField pass;
    private javax.swing.JTextField user;
    private javax.swing.JButton voltar;
    // End of variables declaration//GEN-END:variables
}
