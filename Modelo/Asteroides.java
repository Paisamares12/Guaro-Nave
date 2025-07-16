
package Modelo;

import java.awt.*;
import javax.swing.ImageIcon;
import java.awt.image.BufferedImage;
import Vista.Assets;

public class Asteroides {
    private int x, y, tam;
    private double vel;
    private BufferedImage imagen;

    public Asteroides(int x, int y, int tam, double vel) {
        this.x = x;
        this.y = y;
        this.tam = tam;
        this.vel = vel;

        this.imagen = Assets.asteroide; // Imagen cargada desde Assets
    }

    public void mover() {
        y += vel;
    }

    public void dibujar(Graphics g) {
        if (imagen != null) {
            g.drawImage(imagen, x, y, tam, tam, null);
        } else {
            g.setColor(Color.GRAY);
            g.fillOval(x, y, tam, tam);
        }
    }

    public boolean colisionaCon(Guarito nave) {
        Rectangle r1 = new Rectangle(x, y, tam, tam);
        Rectangle r2 = new Rectangle(nave.getX(), nave.getY(), nave.getAncho(), nave.getAlto());
        return r1.intersects(r2);
    }

    public boolean fueraDePantalla(int altoVentana) {
        return y > altoVentana;
    }
}
