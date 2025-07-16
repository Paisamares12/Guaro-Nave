package Vista;

import Controlador.AbrirNuevasVentanas;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.JOptionPane;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.JPopupMenu;
import javax.swing.JMenuItem;

import Modelo.Guarito;
import Modelo.Asteroides;
import Modelo.Usuarios;

public class PanelJuego extends JPanel implements ActionListener, KeyListener {

    private Timer timer;
    private Guarito nave;
    private Image fondo;
    private int anchoVentana, altoVentana;
    
    private boolean enPausa = false;
    private JPopupMenu menuPausa;
    private boolean mostrarInstruccion = true;
    private String nombreJugador;
    private String nivelActual = "Fácil";
    private boolean avisoMedioMostrado = false;
    private boolean avisoDificilMostrado = false;



    private java.util.List<Asteroides> asteroides = new ArrayList<>();
    private int puntaje = 0;
    private int vidas = 3;
    private int tiempo = 0;

    public PanelJuego(int ancho, int alto, String nombreJugador) {
        
        this.nombreJugador = nombreJugador;
        this.anchoVentana = ancho;
        this.altoVentana = alto;

        setFocusable(true);
        setBackground(Color.BLACK);
        addKeyListener(this);

        fondo = Assets.fondo;
        nave = new Guarito(ancho / 2 - 40, alto - 100);

        // Hilo que genera asteroides con control de cantidad
        new Thread(() -> {
            while (true) {
                int x = (int) (Math.random() * (anchoVentana - 40));

                // Parámetros según el tiempo
                int tam;
                double vel;

                if (tiempo < 30) { // Nivel fácil
                    tam = 20;
                    vel = 3 + Math.random();
                } else if (tiempo < 60) { // Nivel medio
                    tam = 30;
                    vel = 4 + Math.random() * 1.5;
                } else { // Nivel difícil
                    tam = 40;
                    vel = 5 + Math.random() * 2;
                }

                synchronized (asteroides) {
                    if (asteroides.size() < 50) { // ← Limita a 50 asteroides simultáneos
                        asteroides.add(new Asteroides(x, -tam, tam, vel));
                    }
                }

                try {
                    Thread.sleep(1500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();



        // Hilo 1: contador de tiempo por segundos
        new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(1000);
                    tiempo++;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        // Hilo 2: también espera 1 segundo, no afecta al tiempo
        new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        
        new Thread(() -> {
            try {
                Thread.sleep(5000);
                mostrarInstruccion = false;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        
        crearMenuPausa();
        timer = new Timer(20, this); // actualiza cada 20 ms (~50 fps)
        timer.start();
    }
    
    


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (fondo != null) {
            g.drawImage(fondo, 0, 0, anchoVentana, altoVentana, this);
        } else {
            g.setColor(Color.BLACK);
            g.fillRect(0, 0, anchoVentana, altoVentana);
        }

        nave.dibujar(g);
        synchronized (asteroides) {
            for (Asteroides a : asteroides) {
                a.dibujar(g);
            }
        }


        g.setColor(Color.WHITE);
        g.setFont(new Font("Monospaced", Font.BOLD, 18));
        g.drawString("Puntaje: " + puntaje, 10, 20);
        g.drawString("Vidas: " + vidas, 10, 40);
        g.drawString("Nivel: " + nivelActual, 10, 80);

        
        if (mostrarInstruccion) {
            String mensaje = "Usa las flechas ← → para moverte | Presiona 'P' para pausar";

            g.setColor(Color.YELLOW);
            g.setFont(new Font("Monospaced", Font.BOLD, 18));

            // Calcular el ancho del texto
            int textoAncho = g.getFontMetrics().stringWidth(mensaje);

            // Centrar horizontalmente
            int x = (anchoVentana - textoAncho) / 2;
            int y = altoVentana / 2;

            g.drawString(mensaje, x, y);
        }

        g.setColor(Color.white);
        g.drawString("Tiempo: " + tiempo + " s", 10, 60);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (enPausa) return;
        
        synchronized (asteroides) {
        Iterator<Asteroides> it = asteroides.iterator();
            while (it.hasNext()) {
                Asteroides a = it.next();
                a.mover();

                if (a.colisionaCon(nave)) {
                    it.remove();
                    vidas--;

                    if (vidas <= 0) {
                        timer.stop();
                        int opcion = JOptionPane.showConfirmDialog(
                            this,
                            "¡Perdiste! Tu puntaje fue: " + puntaje + " en " + tiempo + " segundos.\n¿Deseas jugar de nuevo?",
                            "Fin del juego",
                            JOptionPane.YES_NO_OPTION
                        );

                        if (opcion == JOptionPane.YES_OPTION) {
                            reiniciarJuego();
                        } else {
                            AbrirNuevasVentanas anv = new AbrirNuevasVentanas();
                            java.awt.Window ventana = javax.swing.SwingUtilities.getWindowAncestor(this);
                            if (ventana != null) {
                                ventana.dispose();
                                anv.Interfaz();
                            }
                        }

                        Usuarios u = new Usuarios();
                        u.setUsuario(nombreJugador);
                        u.setMax_Puntaje(puntaje);
                        u.guardarOActualizarPuntaje();

                        return;
                    } else {
                        nave = new Guarito(anchoVentana / 2 - 40, altoVentana - 100);
                    }
                }

                if (a.fueraDePantalla(altoVentana)) {
                    it.remove();
                    puntaje += 10;
                }
            }
        }
        
         if (tiempo >= 30 && !nivelActual.equals("Difícil")) {
            nivelActual = "Difícil";
            if (!avisoDificilMostrado) {
                JOptionPane.showMessageDialog(this, "¡Nivel Difícil!");
                avisoDificilMostrado = true;
            }
        } else if (tiempo >= 15 && !nivelActual.equals("Medio")) {
            nivelActual = "Medio";
            if (!avisoMedioMostrado) {
                JOptionPane.showMessageDialog(this, "¡Nivel Medio!");
                avisoMedioMostrado = true;
            }
        }
        
        repaint();
    }

    public void reiniciarJuego() {
        enPausa = false;
        timer.stop(); // Detén el timer antes de reiniciar
        asteroides.clear();
        puntaje = 0;
        vidas = 3;
        tiempo = 0;
        mostrarInstruccion = true;

        // Reinicia la instrucción después de 5 seg
        new Thread(() -> {
            try {
                Thread.sleep(5000);
                mostrarInstruccion = false;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        nave = new Guarito(anchoVentana / 2 - 40, altoVentana - 100);
        timer.start();
    }

    
    private void crearMenuPausa() {
        menuPausa = new JPopupMenu();

        JMenuItem reanudar = new JMenuItem("Reanudar");
        reanudar.addActionListener(e -> {
            enPausa = false;
            timer.start();
            menuPausa.setVisible(false);
        });

        JMenuItem reiniciar = new JMenuItem("Reiniciar");
        reiniciar.addActionListener(e -> {
            menuPausa.setVisible(false);
            reiniciarJuego();
        });
        
        AbrirNuevasVentanas anv = new AbrirNuevasVentanas();
        
        JMenuItem salir = new JMenuItem("Salir");
        salir.addActionListener(e -> {
            java.awt.Window ventana = javax.swing.SwingUtilities.getWindowAncestor(this);
            if (ventana != null) {
                ventana.dispose();
                anv.Interfaz();
            }
            
        });

        menuPausa.add(reanudar);
        menuPausa.add(reiniciar);
        menuPausa.add(salir);
    }

    
    @Override
    public void keyPressed(KeyEvent e) {
        int tecla = e.getKeyCode();
        if (tecla == KeyEvent.VK_LEFT) {
            nave.moverIzquierda();
        } else if (tecla == KeyEvent.VK_RIGHT) {
            nave.moverDerecha(anchoVentana);
        }else if (tecla == KeyEvent.VK_P) {
            if (!enPausa) {
                enPausa = true;
                timer.stop();
                menuPausa.show(this, anchoVentana / 2 - 50, altoVentana / 2 - 50);
            }
        }
    }
    

    @Override public void keyReleased(KeyEvent e) {}
    @Override public void keyTyped(KeyEvent e) {}
}
