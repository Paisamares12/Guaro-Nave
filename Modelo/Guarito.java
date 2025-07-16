package Modelo;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import Vista.Assets;

public class Guarito {
    private int x, y;
    private final int ancho = 45;
    private final int alto = 100;
    private final int velocidad = 10;
    private BufferedImage imagen;

    public Guarito(int x, int y) {
        this.x = x;
        this.y = y;
        this.imagen = Assets.guarito;
    }

    public void moverIzquierda() {
        x -= velocidad;
        if (x < 0) x = 0;
    }

    public void moverDerecha(int anchoVentana) {
        x += velocidad;
        if (x + ancho > anchoVentana) x = anchoVentana - ancho;
    }

    public void dibujar(Graphics g) {
        if (imagen != null) {
            g.drawImage(imagen, x, y, ancho, alto, null);
        } else {
            g.fillRect(x, y, ancho, alto);
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getAncho() {
        return ancho;
    }

    public int getAlto() {
        return alto;
    }
}
