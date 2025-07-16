package Vista;

import java.awt.image.BufferedImage;

public class Assets {
    public static BufferedImage guarito;
    public static BufferedImage fondo;
    public static BufferedImage asteroide;

    public static void init() {
        BufferedImage original = Loader.ImageLoader("/Imagenes/Guarito.png");
        guarito = new BufferedImage(45, 100, BufferedImage.TYPE_INT_ARGB);
        var g = guarito.createGraphics();
        g.drawImage(original, 0, 0, 45, 100, null);
        g.dispose();
    }

    public static void init2() {
        BufferedImage original = Loader.ImageLoader("/Imagenes/Fondo.jpg");
        fondo = new BufferedImage(800, 600, BufferedImage.TYPE_INT_ARGB);
        var g = fondo.createGraphics();
        g.drawImage(original, 0, 0, 800, 600, null);
        g.dispose();
    }

    public static void init3() {
        BufferedImage original = Loader.ImageLoader("/Imagenes/image-removebg-preview.png");
        asteroide = new BufferedImage(40, 40, BufferedImage.TYPE_INT_ARGB);
        var g = asteroide.createGraphics();
        g.drawImage(original, 0, 0, 40, 40, null);
        g.dispose();
    }
}
