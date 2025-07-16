package Vista;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;

public class Loader {

    public static BufferedImage ImageLoader(String path) {
        try {
            URL url = Loader.class.getResource(path);

            if (url == null) {
                System.err.println("Recurso no encontrado: " + path);
                return null;
            }

            return ImageIO.read(url);

        } catch (IOException ex) {
            System.err.println(" Error al leer imagen: " + path);
            ex.printStackTrace();
            return null;
        } catch (IllegalArgumentException e) {
            System.err.println(" Ruta inválida: " + path);
            return null;
        }
    }
}
