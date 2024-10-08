package proyecto;

import java.util.ArrayList;

public class Ranking extends javax.swing.JFrame {

    ArrayList<Usuario> Usaurios;
    int G_Indice;
    ArrayList<Logs> Todoslos_Logs;

    public Ranking(ArrayList<Usuario> UsuariosObtenidos, int Indice, ArrayList<Logs> Todoslos_Logs_A) {
        Usaurios = UsuariosObtenidos;
        G_Indice = Indice;

        Todoslos_Logs = new ArrayList<Logs>();
        if (Todoslos_Logs_A != null) {
            Todoslos_Logs = Todoslos_Logs_A;
        }

        initComponents();
        this.setResizable(false);
        this.setSize(800, 500);

        int CONTADOR = 0;
        for (int i = 0; i < UsuariosObtenidos.size(); i++) {
            if (UsuariosObtenidos.get(i).isActivo()) {
                CONTADOR++;
            }
        }
        String[] ListaUsuarios = new String[CONTADOR];

        int Posicion = 0;
        for (int i = 0; i < UsuariosObtenidos.size(); i++) {

            if (UsuariosObtenidos.get(i).isActivo()) {
                ListaUsuarios[Posicion] = UsuariosObtenidos.get(i).getUser() + " - " + UsuariosObtenidos.get(i).getPuntos();
                Posicion++;
            }
        }

        for (int i = 0; i < ListaUsuarios.length; i++) {
            System.out.println(ListaUsuarios[i]);
        }

        for (int i = 0; i < Posicion - 1; i++) {
            int maxIndex = i;
            for (int j = i + 1; j < Posicion; j++) {
                Double puntos1 = getPuntosFromUsuario(ListaUsuarios[maxIndex]);
                Double puntos2 = getPuntosFromUsuario(ListaUsuarios[j]);
                if (puntos2 > puntos1) {
                    maxIndex = j;
                }
            }
            // Intercambiar elementos
            String temp = ListaUsuarios[i];
            ListaUsuarios[i] = ListaUsuarios[maxIndex];
            ListaUsuarios[maxIndex] = temp;
        }
        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            //  String[] strings = { "awdwdd 1", "Itadwawdadem 2", "Item wdw3", "Item 4awd", "Item 5" };
            public int getSize() {
                return ListaUsuarios.length;
            }

            public String getElementAt(int i) {
                return (i + 1) + " - " + ListaUsuarios[i];
            }
        });
    }

    private Double getPuntosFromUsuario(String usuario) {
        // Analizar el usuario para extraer los puntos
        int separadorIndex = usuario.lastIndexOf(" - ");
        String puntosString = usuario.substring(separadorIndex + 3);
        return Double.parseDouble(puntosString);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jList1.setBackground(new java.awt.Color(0, 0, 0));
        jList1.setBorder(null);
        jList1.setForeground(new java.awt.Color(255, 255, 255));
        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 80, 410, 230));

        jButton1.setBackground(new java.awt.Color(0, 0, 0));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Volver");
        jButton1.setBorder(null);
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 340, 200, 60));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Rank");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/batallas.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 810, 550));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
                 MusicPlayer.playSoundEffect("./servant-bell-ring-2-211683.wav");

        MenuPrincipal ObjMenuPrincipal = new MenuPrincipal(this.G_Indice, this.Usaurios, true, this.Todoslos_Logs);
        ObjMenuPrincipal.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(Ranking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ranking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ranking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ranking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ranking(null, -1, null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JList<String> jList1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
