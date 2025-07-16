package Controlador;

import Modelo.Usuarios;
import Vista.Ingresar;
import Modelo.Ranking;
import Vista.Puntajes;

import java.util.List;


public class RegistroUsuarios {
    private final Usuarios u;
    private final Ingresar i;
    private final Ranking r;

    public RegistroUsuarios(Usuarios u, Ingresar i) {
        this.u = u;
        this.i = i;
        this.r = new Ranking();
        i.setControlador(this);
    }

    public boolean procesarLogin(String nombre){
        if (nombre.trim().isEmpty()) {
            
            i.mostrarMensaje("El campo no puede estar vacío.", true);
            return false;
        }

        if (u.nombreYaExiste(nombre)) {
            i.mostrarMensaje("Ese nombre ya está registrado.", true);
            return false;
        }
        
        u.setUsuario(nombre);
        u.setMax_Puntaje(0);
        u.cargarUsuarios();
        AbrirNuevasVentanas anv = new AbrirNuevasVentanas();
        anv.Jugar(nombre);
        i.mostrarMensaje("¡Usuario registrado con éxito!", false);
        return true;
    }
    
    public boolean procesarIngresoExistente(String nombre) {
        if (nombre.isEmpty()) {
            i.mostrarMensaje("El campo no puede estar vacío", true);
            return false;
        } else if (!u.existeUsuario(nombre)) {
            i.mostrarMensaje("El usuario no existe", true);
            return false;
        } else {
            i.mostrarMensaje("¡Bienvenido de nuevo, " + nombre + "!", false);
            AbrirNuevasVentanas anv = new AbrirNuevasVentanas();
            anv.Jugar(nombre);
            return true;
        }
    }
    
    public void mostrarRanking() {
        List<Usuarios> lista = r.obtenerRanking();
        Puntajes p = new Puntajes(lista);
        p.setVisible(true);
        p.setLocationRelativeTo(null);
    }
    
    
    
}
