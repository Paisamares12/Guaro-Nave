package Vista;

import javax.swing.JFrame;

public class VentanaJuego {
    
    private String nombreJugador;

    public VentanaJuego(String nombreJugador) {
        this.nombreJugador = nombreJugador;
    }

    public void lanzarJuego() {
        JFrame frame = new JFrame("Guaro Nave");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

        // Pasa el nombre aquí
        PanelJuego panel = new PanelJuego(800, 600, nombreJugador);
        frame.add(panel);
        frame.pack();
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
