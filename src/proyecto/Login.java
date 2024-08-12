
package proyecto;

import java.util.ArrayList;
import javax.swing.JOptionPane;

//verificacion de cuentas
public class Login extends javax.swing.JFrame {
ArrayList<Logs> Todoslos_Logs;
    ArrayList<Usuario> Usuarios;
boolean CT_Nombre_Clickeado= false;
boolean CT_Pass_Clickeado= false;
    /**
     * Creates new form Login
     */
    public Login(ArrayList UsuariosObtenidos, ArrayList<Logs> Todoslos_Logs_A) {
        Usuarios = new ArrayList<Usuario>();
        if (UsuariosObtenidos != null) {
            Usuarios = UsuariosObtenidos;
        }
        
         Todoslos_Logs = new ArrayList<Logs>();
        if(Todoslos_Logs_A != null){
            Todoslos_Logs= Todoslos_Logs_A;
        }
 
      /*
          // Crear cuentas de prueba automáticamente factor de prueba
        Usuario prueba1 = new Usuario("prueba1", "12345");
        Usuario prueba2 = new Usuario("prueba2", "12345");
        Usuarios.add(prueba1);
        Usuarios.add(prueba2);
        
        
        */
        initComponents();
         this.setResizable(false);
          this.setSize(900, 542);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jPasswordField1 = new javax.swing.JPasswordField();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setBackground(new java.awt.Color(0, 0, 0));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Aceptar");
        jButton1.setBorder(null);
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton1MouseEntered(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 320, 170, 60));

        jTextField1.setBackground(new java.awt.Color(0, 0, 0));
        jTextField1.setForeground(new java.awt.Color(255, 255, 255));
        jTextField1.setText("Nombre");
        jTextField1.setBorder(null);
        jTextField1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField1MouseClicked(evt);
            }
        });
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 190, 186, 50));

        jPasswordField1.setBackground(new java.awt.Color(0, 0, 0));
        jPasswordField1.setForeground(new java.awt.Color(255, 255, 255));
        jPasswordField1.setText("jPasswordField1");
        jPasswordField1.setBorder(null);
        jPasswordField1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPasswordField1MouseClicked(evt);
            }
        });
        jPasswordField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordField1ActionPerformed(evt);
            }
        });
        getContentPane().add(jPasswordField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 200, 186, 50));

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Login");
        jPanel1.add(jLabel2);

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, 280, 80));

        jButton2.setBackground(new java.awt.Color(0, 0, 0));
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Volver");
        jButton2.setBorder(null);
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 410, 170, 60));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/crearcuenta.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 510));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        MusicPlayer.playSoundEffect("./servant-bell-ring-2-211683.wav");

        MenuInicial ObjetoMenuInicial = new MenuInicial(Usuarios, this.Todoslos_Logs);
        ObjetoMenuInicial.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton2MouseClicked

    private void jPasswordField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPasswordField1ActionPerformed

    }//GEN-LAST:event_jPasswordField1ActionPerformed

    private void jPasswordField1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPasswordField1MouseClicked
        if(!CT_Pass_Clickeado){
            jPasswordField1.setText("");
            CT_Pass_Clickeado= true;
        }
    }//GEN-LAST:event_jPasswordField1MouseClicked

    private void jTextField1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField1MouseClicked
        if(!CT_Nombre_Clickeado){
            jTextField1.setText("");
            CT_Nombre_Clickeado= true;
        }

    }//GEN-LAST:event_jTextField1MouseClicked

    private void jButton1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseEntered
        MusicPlayer.playSoundEffect("./servant-bell-ring-2-211683.wav");
    }//GEN-LAST:event_jButton1MouseEntered

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        MusicPlayer.playSoundEffect("./servant-bell-ring-2-211683.wav");

        String Nombre = jTextField1.getText();
        String Pass = jPasswordField1.getText();

        for (int i = 0; i < Usuarios.size(); i++) {
            if (Usuarios.get(i).getUser().equals(Nombre) && Usuarios.get(i).isActivo()) {
                if (Usuarios.get(i).getContra().equals(Pass)) {

                    JOptionPane.showMessageDialog(null, "Inicio de Sesion Correcto");

                    MenuPrincipal ObjetoMenuPrincipal = new MenuPrincipal(i, Usuarios,true, this.Todoslos_Logs );
                    ObjetoMenuPrincipal.setVisible(true);

                    this.dispose();

                    return;

                } else {

                    JOptionPane.showMessageDialog(null, "Contraseña Incorrecta");
                    return;
                }
            }
        }

        JOptionPane.showMessageDialog(null, "El Usuario no Existe");

    }//GEN-LAST:event_jButton1MouseClicked

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login(null,null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
