package proyecto;

import java.awt.Dimension;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Tablero extends javax.swing.JFrame {

    boolean ModoTutorial;
    int G_UserIndex;
    int tutorial = 0;
    ArrayList<Usuario> Todos_Usuarios;
    int JugadorVillano = -1;
    int JugadorHeroe = -1;
    Logica_Tablero ControladorTablero;
    ArrayList<Logs> Todoslos_Logs;
    Dimension CoordHeroe = new Dimension(-1, -1);
    Dimension CoordVillano = new Dimension(-1, -1);

    Dimension CoordTablero_Viejas = new Dimension(-1, -1);

    public Tablero(int UserIndex, ArrayList<Usuario> UsuariosObtenidos, boolean ModoJuego, ArrayList<Logs> Todoslos_Logs_A) {

        ModoJuego = ModoJuego;
        G_UserIndex = UserIndex;
        Todos_Usuarios = UsuariosObtenidos;
        ControladorTablero = new Logica_Tablero(true);
        Todoslos_Logs = new ArrayList<Logs>();
        if (Todoslos_Logs_A != null) {
            Todoslos_Logs = Todoslos_Logs_A;
        }
        initComponents();
        this.setResizable(false);

        String[] buttons = {"Villano", "Heroe"};
        int returnValue = JOptionPane.showOptionDialog(null, "Bandos: ", "Elija un Bando",
                JOptionPane.WARNING_MESSAGE, 0, null, buttons, buttons[0]);
        System.out.println("Return Value: " + returnValue);

        int CONTADOR = 0;

        for (int i = 0; i < UsuariosObtenidos.size(); i++) {
            if (UserIndex != i && UsuariosObtenidos.get(i).isActivo()) {
                CONTADOR++;
            }
        }

        String[] UsuariosAEscoger = new String[CONTADOR];
        int Posicion = 0;
        for (int i = 0; i < UsuariosObtenidos.size(); i++) {
            if (UserIndex != i && UsuariosObtenidos.get(i).isActivo()) {
                UsuariosAEscoger[Posicion] = UsuariosObtenidos.get(i).getUser();
                Posicion++;
            }
        }

        if (returnValue != -1) {
            String input = (String) JOptionPane.showInputDialog(null, "Escoja segundo Jugador",
                    "Jugador 2", JOptionPane.QUESTION_MESSAGE, null,
                    UsuariosAEscoger,
                    UsuariosAEscoger[0]);
            System.out.println("input: " + input);
            if (input != null) {
                int Indice_segundoPlayer = -1;
                for (int i = 0; i < UsuariosObtenidos.size(); i++) {
                    if (UsuariosObtenidos.get(i).getUser() == input) {
                        Indice_segundoPlayer = i;
                    }
                }

                if (returnValue == 0) { //Villano
                    JugadorVillano = UserIndex;
                    JugadorHeroe = Indice_segundoPlayer;
                } else {
                    JugadorHeroe = UserIndex;
                    JugadorVillano = Indice_segundoPlayer;
                }
                this.setSize(1066, 716);
                this.setLocationRelativeTo(null);

                if (ModoTutorial == false) {
                    int JugadasH = this.Todos_Usuarios.get(JugadorHeroe).getPartidasHeroe();
                    this.Todos_Usuarios.get(JugadorHeroe).setPartidasHeroe(JugadasH + 1);

                    int JugadasV = this.Todos_Usuarios.get(JugadorVillano).getPartidasVillano();
                    this.Todos_Usuarios.get(JugadorVillano).setPartidasVillano(JugadasV + 1);
                }
                ActualizarTablero(ControladorTablero.getMatrizTablero(), ControladorTablero.getMatrizHeroe(), ControladorTablero.getMatrizVillano());
            } else {
                dispose();
            }
        } else {
            dispose();
        }
        System.out.println("Continua");
        System.out.println("Villano: " + JugadorVillano);
        System.out.println("Heroe: " + JugadorHeroe);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton3 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setBackground(new java.awt.Color(51, 153, 255));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton3.setBackground(new java.awt.Color(51, 102, 255));
        jButton3.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 12)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Rendirse");
        jButton3.setBorder(null);
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 20, 100, 40));

        jLabel7.setFont(new java.awt.Font("Segoe UI Symbol", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("(Heroe/Villano)");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 10, 110, 30));

        jLabel8.setBackground(new java.awt.Color(204, 204, 204));
        jLabel8.setFont(new java.awt.Font("Segoe UI Symbol", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("(UsuarioActual)");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 50, -1, -1));

        jLabel1.setFont(new java.awt.Font("Segoe UI Symbol", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("   Heroe");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 20, 80, 40));

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setBackground(new java.awt.Color(204, 204, 255));
        jLabel2.setFont(new java.awt.Font("Segoe UI Symbol", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("   Villano");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 20, 80, 40));

        jButton2.setBackground(new java.awt.Color(255, 102, 102));
        jButton2.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 12)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Rendirse");
        jButton2.setBorder(null);
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 110, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1070, 80));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        String[] buttons = {"Si", "No"};
        int returnValue = JOptionPane.showOptionDialog(null, "Seguro de Admitir su Derrota?", "Elija una Opcion",
                JOptionPane.WARNING_MESSAGE, 0, null, buttons, buttons[0]);

        if (returnValue == 0) {

            // HEROES
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();
            JOptionPane.showMessageDialog(null, this.Todos_Usuarios.get(this.JugadorHeroe).getUser() + " usando HEROES ha ganado ya que " + this.Todos_Usuarios.get(this.JugadorVillano).getUser() + " usando VILLANOS se ha retirado del juego – " + dtf.format(now));
            if (ModoTutorial == false) {
                double PuntosdelJugador = this.Todos_Usuarios.get(this.JugadorHeroe).getPuntos();
                this.Todos_Usuarios.get(this.JugadorHeroe).setPuntos(PuntosdelJugador + 3);

                Todoslos_Logs.add(new Logs(this.Todos_Usuarios.get(this.JugadorHeroe).getUser(),
                        this.Todos_Usuarios.get(this.JugadorVillano).getUser(),
                        this.Todos_Usuarios.get(this.JugadorHeroe).getUser() + " usando HEROES ha ganado ya que " + this.Todos_Usuarios.get(this.JugadorVillano).getUser() + " usando VILLANOS se ha retirado del juego – " + dtf.format(now), true));
            }
            MenuPrincipal ObjetoMenuPrincipal = new MenuPrincipal(G_UserIndex, this.Todos_Usuarios, ModoTutorial, this.Todoslos_Logs);
            ObjetoMenuPrincipal.setVisible(true);

            this.setVisible(false);
        }

    }//GEN-LAST:event_jButton2MouseClicked

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked
        // VILLANOS

        String[] buttons = {"Si", "No"};
        int returnValue = JOptionPane.showOptionDialog(null, "Seguro de Admitir su Derrota?", "Elija una Opcion",
                JOptionPane.WARNING_MESSAGE, 0, null, buttons, buttons[0]);

        if (returnValue == 0) {

            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();
            JOptionPane.showMessageDialog(null, this.Todos_Usuarios.get(this.JugadorVillano).getUser() + " usando VILLANOS ha ganado ya que " + this.Todos_Usuarios.get(this.JugadorHeroe).getUser() + " usando HEROES se ha retirado del juego – " + dtf.format(now));
            if (ModoTutorial == false) {
                double PuntosdelJugador = this.Todos_Usuarios.get(this.JugadorVillano).getPuntos();
                this.Todos_Usuarios.get(this.JugadorVillano).setPuntos(PuntosdelJugador + 3);

                Todoslos_Logs.add(new Logs(this.Todos_Usuarios.get(this.JugadorVillano).getUser(),
                        this.Todos_Usuarios.get(this.JugadorHeroe).getUser(),
                        this.Todos_Usuarios.get(this.JugadorVillano).getUser() + " usando VILLANOS ha ganado ya que " + this.Todos_Usuarios.get(this.JugadorHeroe).getUser() + " usando HEROES se ha retirado del juego – " + dtf.format(now), false));
            }
            MenuPrincipal ObjetoMenuPrincipal = new MenuPrincipal(G_UserIndex, this.Todos_Usuarios, ModoTutorial, this.Todoslos_Logs);
            ObjetoMenuPrincipal.setVisible(true);
            this.setVisible(false);

        }


    }//GEN-LAST:event_jButton3MouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        if (JugadorHeroe == -1 || JugadorVillano == -1) {
            this.setVisible(false);
            MenuPrincipal ObjetoMenuInicial = new MenuPrincipal(G_UserIndex, Todos_Usuarios, ModoTutorial, Todoslos_Logs);
            ObjetoMenuInicial.setVisible(true);
            JOptionPane.showMessageDialog(this, "Debe elegir el bando y el contrincante para jugar");
        }
    }//GEN-LAST:event_formWindowClosed

    //Handler Tablero
    private void Handler(java.awt.event.MouseEvent evt, Dimension Coordenadas) {

        if (ControladorTablero.Movimiento(Coordenadas, CoordHeroe, CoordVillano)) {
            ActualizarTablero(ControladorTablero.getMatrizTablero(), ControladorTablero.getMatrizHeroe(), ControladorTablero.getMatrizVillano());

            CoordHeroe = new Dimension(-1, -1);
            if (this.ControladorTablero.getGanadorPorBandera() == 1) {
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
                LocalDateTime now = LocalDateTime.now();
                JOptionPane.showMessageDialog(null, this.Todos_Usuarios.get(this.JugadorHeroe).getUser() + " VENCEDOR usando los HEROES ha SALVADO la TIERRA! Venciendo a " + this.Todos_Usuarios.get(this.JugadorVillano).getUser() + " – " + dtf.format(now));

                double PuntosdelJugador = this.Todos_Usuarios.get(this.JugadorHeroe).getPuntos();
                this.Todos_Usuarios.get(this.JugadorHeroe).setPuntos(PuntosdelJugador + 3);

                Todoslos_Logs.add(new Logs(this.Todos_Usuarios.get(this.JugadorHeroe).getUser(),
                        this.Todos_Usuarios.get(this.JugadorVillano).getUser(),
                        this.Todos_Usuarios.get(this.JugadorHeroe).getUser() + " VENCEDOR usando los HEROES ha SALVADO la TIERRA! Venciendo a " + this.Todos_Usuarios.get(this.JugadorVillano).getUser() + " – " + dtf.format(now), true));

                MenuPrincipal ObjetoMenuPrincipal = new MenuPrincipal(G_UserIndex, this.Todos_Usuarios, ModoTutorial, this.Todoslos_Logs);
                ObjetoMenuPrincipal.setVisible(true);

                this.setVisible(false);

            } else if (this.ControladorTablero.getGanadorPorBandera() == 2) {
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
                LocalDateTime now = LocalDateTime.now();
                JOptionPane.showMessageDialog(null, this.Todos_Usuarios.get(this.JugadorVillano).getUser() + " VENCEDOR usando los VILLANOS ha CAPTURADO la TIERRA! Venciendo a " + this.Todos_Usuarios.get(this.JugadorHeroe).getUser() + " – " + dtf.format(now));
                double PuntosdelJugador = this.Todos_Usuarios.get(this.JugadorVillano).getPuntos();
                this.Todos_Usuarios.get(this.JugadorVillano).setPuntos(PuntosdelJugador + 3);

                Todoslos_Logs.add(new Logs(this.Todos_Usuarios.get(this.JugadorVillano).getUser(),
                        this.Todos_Usuarios.get(this.JugadorHeroe).getUser(),
                        this.Todos_Usuarios.get(this.JugadorVillano).getUser() + " VENCEDOR usando los VILLANOS ha CAPTURADO la TIERRA! Venciendo a " + this.Todos_Usuarios.get(this.JugadorHeroe).getUser() + " – " + dtf.format(now), false));

                MenuPrincipal ObjetoMenuPrincipal = new MenuPrincipal(G_UserIndex, this.Todos_Usuarios, ModoTutorial, this.Todoslos_Logs);
                ObjetoMenuPrincipal.setVisible(true);

                this.setVisible(false);
            }

            int Validacionde_NoQuedanMovimientos = this.ControladorTablero.SinMovimientos();

            if (Validacionde_NoQuedanMovimientos == 2) {
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
                LocalDateTime now = LocalDateTime.now();

                JOptionPane.showMessageDialog(null, this.Todos_Usuarios.get(this.JugadorHeroe).getUser() + " PERDEDOR usando HEROES ha perdido por no tener movimientos validos disponibles ante " + this.Todos_Usuarios.get(this.JugadorVillano).getUser() + " – " + dtf.format(now));
                double PuntosdelJugador = this.Todos_Usuarios.get(this.JugadorHeroe).getPuntos();
                this.Todos_Usuarios.get(this.JugadorHeroe).setPuntos(PuntosdelJugador + 3);

                Todoslos_Logs.add(new Logs(this.Todos_Usuarios.get(this.JugadorHeroe).getUser(),
                        this.Todos_Usuarios.get(this.JugadorVillano).getUser(),
                        this.Todos_Usuarios.get(this.JugadorHeroe).getUser()
                        + " PERDEDOR usando HEROES ha perdido por no tener movimientos validos disponibles ante "
                        + this.Todos_Usuarios.get(this.JugadorVillano).getUser() + " – "
                        + dtf.format(now), true));

                MenuPrincipal ObjetoMenuPrincipal = new MenuPrincipal(G_UserIndex, this.Todos_Usuarios, ModoTutorial, this.Todoslos_Logs);
                ObjetoMenuPrincipal.setVisible(true);
                this.setVisible(false);

            } else if (Validacionde_NoQuedanMovimientos == 3) {
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
                LocalDateTime now = LocalDateTime.now();
                JOptionPane.showMessageDialog(null, this.Todos_Usuarios.get(this.JugadorVillano).getUser() + " PERDEDOR usando VILLANOS ha perdido por no tener movimientos validos disponibles ante " + this.Todos_Usuarios.get(this.JugadorVillano).getUser() + " – " + dtf.format(now));
                double PuntosdelJugador = this.Todos_Usuarios.get(this.JugadorVillano).getPuntos();
                this.Todos_Usuarios.get(this.JugadorVillano).setPuntos(PuntosdelJugador + 3);

                Todoslos_Logs.add(new Logs(this.Todos_Usuarios.get(this.JugadorVillano).getUser(),
                        this.Todos_Usuarios.get(this.JugadorHeroe).getUser(),
                        this.Todos_Usuarios.get(this.JugadorVillano).getUser()
                        + " PERDEDOR usando VILLANOS ha perdido por no tener movimientos validos disponibles ante "
                        + this.Todos_Usuarios.get(this.JugadorHeroe).getUser() + " – "
                        + dtf.format(now), false));

                MenuPrincipal ObjetoMenuPrincipal = new MenuPrincipal(G_UserIndex, this.Todos_Usuarios, ModoTutorial, this.Todoslos_Logs);
                ObjetoMenuPrincipal.setVisible(true);
                this.setVisible(false);

            } else if (Validacionde_NoQuedanMovimientos == 4) {
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
                LocalDateTime now = LocalDateTime.now();
                JOptionPane.showMessageDialog(null,
                        "EMPATE!! – " + dtf.format(now));

                double PuntosdelJugador = this.Todos_Usuarios.get(this.JugadorVillano).getPuntos();
                this.Todos_Usuarios.get(this.JugadorVillano).setPuntos(PuntosdelJugador + 1.5);
                PuntosdelJugador = this.Todos_Usuarios.get(this.JugadorHeroe).getPuntos();
                this.Todos_Usuarios.get(this.JugadorHeroe).setPuntos(PuntosdelJugador + 1.5);

                Todoslos_Logs.add(new Logs(this.Todos_Usuarios.get(this.JugadorHeroe).getUser(),
                        this.Todos_Usuarios.get(this.JugadorVillano).getUser(),
                        this.Todos_Usuarios.get(this.JugadorHeroe).getUser() + " y " + this.Todos_Usuarios.get(this.JugadorVillano).getUser() + " QUEDARON EMPATADOS "
                        + dtf.format(now), true));

                Todoslos_Logs.add(new Logs(this.Todos_Usuarios.get(this.JugadorVillano).getUser(),
                        this.Todos_Usuarios.get(this.JugadorHeroe).getUser(),
                        this.Todos_Usuarios.get(this.JugadorHeroe).getUser() + " y " + this.Todos_Usuarios.get(this.JugadorVillano).getUser() + " QUEDARON EMPATADOS "
                        + dtf.format(now), false));

                MenuPrincipal ObjetoMenuPrincipal = new MenuPrincipal(G_UserIndex, this.Todos_Usuarios, ModoTutorial, this.Todoslos_Logs);
                ObjetoMenuPrincipal.setVisible(true);
                this.setVisible(false);

            }

        }

    }

    //Handler Heroe
    private void HandlerHeroe(java.awt.event.MouseEvent evt, Dimension Coordenadas) {

        CoordHeroe = new Dimension(Coordenadas.height, Coordenadas.width);

    }

    //Handler Villano
    private void HandlerVillano(java.awt.event.MouseEvent evt, Dimension Coordenadas) {

        CoordVillano = new Dimension(Coordenadas.height, Coordenadas.width);

    }

    //OBTENER MATRIZES Y MOSTRARLAS
    public void ActualizarTablero(Personaje[][] MatrizTablero, Personaje[][] MatrizHeroes, Personaje[][] MatrizVillano) {
        //Genera Tablero
        System.out.println("Actualizando Tablero");

        for (int i = 0; i < MatrizTablero.length; i++) {
            for (int j = 0; j < MatrizTablero[0].length; j++) {

                JLabel jLabel12 = new JLabel();
                jLabel12.setVisible(true);

                Dimension Coord = new Dimension(j, i);
                jLabel12.addMouseListener(new java.awt.event.MouseAdapter() {
                    public void mouseClicked(java.awt.event.MouseEvent evt) {
                        Handler(evt, Coord);
                    }
                });

                if (MatrizTablero[i][j] == null) {

                    jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/Tablero/amarillo.png")));
                } else if (MatrizTablero[i][j].getRango() == -1) {
                    jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/Tablero/morado.png")));
                } else {

                    if (MatrizTablero[i][j].isHeroe_Villano()) {
                        if (ControladorTablero.isTurnoHeroe() || ModoTutorial) {
                            jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/Tablero/Heroes/" + MatrizTablero[i][j].getID() + ".jpg")));
                        } else {
                            jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/Tablero/azulclaro.jpg")));
                        }

                    } else {

                        if ((!ControladorTablero.isTurnoHeroe()) || ModoTutorial) {
                            jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/Tablero/Villanos/" + MatrizTablero[i][j].getID() + ".jpg")));
                        } else {
                            jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/Tablero/rojo.jpg")));
                        }

                    }
                }

                // System.out.println(getContentPane().findComponentAt(240 + (55*j), 95+ (55*i)));
                if (getContentPane().findComponentAt(240 + (55 * j), 95 + (55 * i)) != null) {
                    getContentPane().remove(getContentPane().getComponentAt(240 + (55 * j), 95 + (55 * i)));
                    getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(240 + (55 * j), 95 + (55 * i), -1, -1));

                } else {
                    getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(240 + (55 * j), 95 + (55 * i), -1, -1));

                }

            }
            System.out.println("");
        }
        System.out.println("LISTO");

        //Genera Heroes
        for (int i = 0; i < MatrizHeroes.length; i++) {
            for (int j = 0; j < MatrizHeroes[0].length; j++) {

                JLabel jLabel12 = new JLabel();
                jLabel12.setVisible(true);
                jLabel12.setPreferredSize(new Dimension(50, 50));
                Dimension Coord = new Dimension(i, j);
                jLabel12.addMouseListener(new java.awt.event.MouseAdapter() {
                    public void mouseClicked(java.awt.event.MouseEvent evt) {
                        HandlerHeroe(evt, Coord);
                    }
                });

                if (MatrizHeroes[i][j].isVivo()) {
                    jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/Tablero/azulclaro.jpg")));
                } else {
                    jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/Tablero/Heroes/" + MatrizHeroes[i][j].getID() + ".jpg")));
                }

                // jPanel2.add(jLabel12);
                if (getContentPane().findComponentAt(800 + (55 * j), 75 + (55 * i)) != null) {
                    getContentPane().remove(getContentPane().getComponentAt(800 + (55 * j), 75 + (55 * i)));
                    getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(800 + (55 * j), 75 + (55 * i), -1, -1));

                } else {
                    getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(800 + (55 * j), 75 + (55 * i), -1, -1));

                }

            }

        }

        //Genera Villanos
        for (int i = 0; i < MatrizVillano.length; i++) {
            for (int j = 0; j < MatrizVillano[0].length; j++) {

                JLabel jLabel12 = new JLabel();
                jLabel12.setVisible(true);
                jLabel12.setPreferredSize(new Dimension(50, 50));
                Dimension Coord = new Dimension(i, j);
                jLabel12.addMouseListener(new java.awt.event.MouseAdapter() {
                    public void mouseClicked(java.awt.event.MouseEvent evt) {
                        System.out.println("Manin");
                        HandlerVillano(evt, Coord);
                    }
                });

                if (MatrizVillano[i][j].isVivo()) {
                    jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/Tablero/rojo.jpg")));
                } else {
                    jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/Tablero/Villanos/" + MatrizVillano[i][j].getID() + ".jpg")));
                }

                if (getContentPane().findComponentAt(10 + (55 * j), 75 + (55 * i)) != null) {
                    getContentPane().remove(getContentPane().getComponentAt(10 + (55 * j), 75 + (55 * i)));
                    getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10 + (55 * j), 75 + (55 * i), -1, -1));

                } else {
                    getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10 + (55 * j), 75 + (55 * i), -1, -1));

                }

            }

        }

        try {
            if (this.ControladorTablero.isTurnoHeroe()) {
                jLabel7.setText("HEROE");
                jLabel8.setText("" + this.Todos_Usuarios.get(this.JugadorHeroe).getUser());
            } else {
                jLabel7.setText("VILLANO");
                jLabel8.setText("" + this.Todos_Usuarios.get(this.JugadorVillano).getUser());
            }
        } catch (Exception e) {
            System.out.println(e + "Indice Vacio al Inicio");
        }

        System.out.println("Tablero Actualizado");

    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
