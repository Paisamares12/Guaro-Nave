package Controlador;

import Modelo.Usuarios;
import Vista.Ingresar;
import Vista.Interfaz;
import Vista.Puntajes;
import Modelo.Ranking;
import Vista.Assets;
import Vista.VentanaJuego;
import java.util.List;

public class AbrirNuevasVentanas {
    
    public void Ingreso(){
        Usuarios u = new Usuarios();
        Ingresar i = new Ingresar();
        RegistroUsuarios c = new RegistroUsuarios(u, i);
        i.setControlador(c);
        i.setVisible(true);
        i.setLocationRelativeTo(null);
    }
    
    public void Interfaz(){
        Interfaz i = new Interfaz();
        i.setVisible(true);
        i.setLocationRelativeTo(null);
    }
    
    public void Jugar(String nombre){
        Assets.init();
        Assets.init2();
        VentanaJuego vj = new VentanaJuego(nombre);
        vj.lanzarJuego();
    }
    
    public void Puntajes(){
        Ranking r = new Ranking();
        List<Usuarios> lista = r.obtenerRanking();
        Puntajes p = new Puntajes(lista);
        p.setVisible(true);
        p.setLocationRelativeTo(null); 
    }
    
}
