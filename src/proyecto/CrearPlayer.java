package proyecto;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class CrearPlayer extends javax.swing.JFrame {

    ArrayList<Logs> Todoslos_Logs;
    ArrayList<Usuario> Usuarios;
    boolean CT_Nombre_Clickeado = false;
    boolean CT_Pass_Clickeado = false;

    public CrearPlayer(ArrayList UsuariosObtenidos, ArrayList<Logs> Todoslos_Logs_A) {

        Usuarios = new ArrayList<Usuario>();

        if (UsuariosObtenidos != null) {
            Usuarios = UsuariosObtenidos;
        }

        Todoslos_Logs = new ArrayList<Logs>();
        if (Todoslos_Logs_A != null) {
            Todoslos_Logs = Todoslos_Logs_A;
        }

     
        initComponents();
        this.setResizable(false);
        this.setSize(800, 500);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jPasswordField1 = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField1.setBackground(new java.awt.Color(0, 0, 0));
        jTextField1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(255, 255, 255));
        jTextField1.setText("Nombre");
        jTextField1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField1MouseClicked(evt);
            }
        });
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 150, 220, 50));

        jPasswordField1.setBackground(new java.awt.Color(0, 0, 0));
        jPasswordField1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jPasswordField1.setForeground(new java.awt.Color(255, 255, 255));
        jPasswordField1.setText("jPasswordField1");
        jPasswordField1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPasswordField1MouseClicked(evt);
            }
        });
        getContentPane().add(jPasswordField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 150, 220, 50));

        jButton1.setBackground(new java.awt.Color(0, 0, 0));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Crear");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 240, 200, 70));

        jButton2.setBackground(new java.awt.Color(0, 0, 0));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Volver");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 330, 200, 70));

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Crea tu cuenta");
        jPanel1.add(jLabel2);

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 20, 280, 60));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/crearcuenta1.png"))); // NOI18N
        jLabel1.setText("Crea tu cuenta");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 490));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
         MusicPlayer.playSoundEffect("./servant-bell-ring-2-211683.wav");

        String Nombre = jTextField1.getText();
        String Pass = new String(jPasswordField1.getPassword());

        if (Pass.length() < 5) {
            JOptionPane.showMessageDialog(null, "Error, la contraseña debe ser de al menos 5 caracteres.");
            return;
        }
        for (int i = 0; i < Usuarios.size(); i++) {
            if (Usuarios.get(i).getUser().equals(Nombre)) {
                JOptionPane.showMessageDialog(null, "Error, el usuario ya existe");
                return;
            }
        }
        Usuario UsuarioCreado = new Usuario(Nombre, Pass);
        Usuarios.add(UsuarioCreado);
        JOptionPane.showMessageDialog(null, "Usuario Creado Exitosamente");

        MenuInicial ObjetoMenuInicial = new MenuInicial(Usuarios, this.Todoslos_Logs);
        ObjetoMenuInicial.setVisible(true);
        this.dispose();

    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
         MusicPlayer.playSoundEffect("./servant-bell-ring-2-211683.wav");

        //Creamos un Jframe y lo hacemos visible
        MenuInicial ObjetoMenuInicial = new MenuInicial(Usuarios, this.Todoslos_Logs);
        ObjetoMenuInicial.setVisible(true);

        //Cerramos el Jframe actual
        this.dispose();
    }//GEN-LAST:event_jButton2MouseClicked

    private void jTextField1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField1MouseClicked

        //Si no se ha dado clic en el cuadro de texto, se borrara su contenido inicial
        if (!CT_Nombre_Clickeado) {
            jTextField1.setText("");
            CT_Nombre_Clickeado = true;
        }
    }//GEN-LAST:event_jTextField1MouseClicked

    private void jPasswordField1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPasswordField1MouseClicked

        //Si no se ha dado clic en el cuadro de texto, se borrara su contenido inicial
        if (!CT_Pass_Clickeado) {
            jPasswordField1.setText("");
            CT_Pass_Clickeado = true;
        }
    }//GEN-LAST:event_jPasswordField1MouseClicked

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
            java.util.logging.Logger.getLogger(CrearPlayer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CrearPlayer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CrearPlayer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CrearPlayer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CrearPlayer(null, null).setVisible(true);
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
