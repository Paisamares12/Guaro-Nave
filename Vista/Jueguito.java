package Vista;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import javax.swing.JFrame;

public class Jueguito extends JFrame implements Runnable {

    public static final int WIDTH = 800, HEIGHT = 600;
    private Canvas canvas;
    private Thread thread;
    private boolean running = false;

    private BufferStrategy bs;
    private Graphics g;

    private final int FPS = 60;
    private double TARGETTIME = 1000000000 / FPS;
    private double delta = 0;
    private int AVERAGEFPS = FPS;

    public Jueguito() {
        setTitle("Guaro Nave");
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);

        canvas = new Canvas();
        canvas.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        canvas.setFocusable(true);

        add(canvas);
        pack(); // Ajusta la ventana al tamaño del canvas
        setVisible(true); // Debe ir después de pack()
    }

    private void update() {
        // lógica del juego (próxima)
    }

    private void draw() {
        bs = canvas.getBufferStrategy();

        if (bs == null) {
            canvas.createBufferStrategy(3);
            return;
        }

        g = bs.getDrawGraphics();

        // Fondo negro
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, WIDTH, HEIGHT);

        // Fondo desde Assets
        if (Assets.fondo != null) {
            g.drawImage(Assets.fondo, 0, 0, WIDTH, HEIGHT, null);
        } else {
            g.setColor(Color.RED);
            g.drawString("Fondo no cargado", 100, 100);
        }

        // Guarito
        if (Assets.guarito != null) {
            g.drawImage(Assets.guarito, 350, 500, null);
        } else {
            g.setColor(Color.YELLOW);
            g.drawString("Guarito no cargado", 100, 120);
        }

        // FPS
        g.setColor(Color.WHITE);
        g.drawString("FPS: " + AVERAGEFPS, 10, 20);

        g.dispose();
        bs.show();
    }

    private void init() {
        System.out.println("Inicializando recursos...");
        Assets.init();
        Assets.init2();

        System.out.println("Guarito cargado: " + (Assets.guarito != null));
        System.out.println("Fondo cargado: " + (Assets.fondo != null));

        canvas.requestFocus();
    }

    @Override
    public void run() {
        init(); // Carga imágenes y enfoca canvas

        long now;
        long lastTime = System.nanoTime();
        int frames = 0;
        long time = 0;

        while (running) {
            now = System.nanoTime();
            delta += (now - lastTime) / TARGETTIME;
            time += (now - lastTime);
            lastTime = now;

            if (delta >= 1) {
                update();
                draw();
                delta--;
                frames++;
            }

            if (time >= 1000000000) {
                AVERAGEFPS = frames;
                frames = 0;
                time = 0;
            }
        }

        stop();
    }

    public void start() {
        if (running) return; // evita múltiples inicios
        running = true;
        thread = new Thread(this);
        thread.start();
    }

    private void stop() {
        try {
            thread.join();
            running = false;
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}
