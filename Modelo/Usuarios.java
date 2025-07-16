package Modelo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Usuarios {
    
    private String usuario; //Nombre del usuario
    private int Max_Puntaje; //Puntaje Maximo de cada usuario
    
    //Crear un archivo en el paquete jiji
    File registroUsuarios = new File("registroUsuarios.txt");

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public int getMax_Puntaje() {
        return Max_Puntaje;
    }

    public void setMax_Puntaje(int Max_Puntaje) {
        this.Max_Puntaje = Max_Puntaje;
    }
    
    public Usuarios() {
        //Si no se crea el archivo se hace el try
        if(!registroUsuarios.exists()){
            try{
                registroUsuarios.createNewFile();
            //Captura cualquier excepción
            }catch(IOException ex){
                ex.printStackTrace();
             }
        }
    }
    
    public void cargarUsuarios(){
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(registroUsuarios, true))){
            
            bw.write(usuario + "," + Max_Puntaje);
            bw.newLine();
        } catch(IOException ex) {
            ex.printStackTrace();
        }
    }
    
    public boolean nombreYaExiste(String nombreBuscado) {
        try (BufferedReader br = new BufferedReader(new FileReader(registroUsuarios))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");
                if (partes[0].equalsIgnoreCase(nombreBuscado)) {
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean existeUsuario(String nombre) {
        try (BufferedReader br = new BufferedReader(new FileReader("registroUsuarios.txt"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");
                if (partes[0].equalsIgnoreCase(nombre.trim())) {
                    this.usuario = partes[0];
                    this.Max_Puntaje = Integer.parseInt(partes[1]);
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
    
     public void guardarOActualizarPuntaje() {
        File temp = new File("registroUsuarios_temp.txt");
        boolean actualizado = false;

        try (
            BufferedReader br = new BufferedReader(new FileReader(registroUsuarios));
            BufferedWriter bw = new BufferedWriter(new FileWriter(temp))
        ) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");
                if (partes[0].equalsIgnoreCase(usuario.trim())) {
                    int puntajeActual = Integer.parseInt(partes[1]);
                    int nuevoPuntaje = Math.max(puntajeActual, Max_Puntaje);
                    bw.write(usuario + "," + nuevoPuntaje);
                    actualizado = true;
                } else {
                    bw.write(linea);
                }
                bw.newLine();
            }

            if (!actualizado) {
                bw.write(usuario + "," + Max_Puntaje);
                bw.newLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        if (registroUsuarios.delete()) {
            temp.renameTo(registroUsuarios);
        } else {
            System.err.println("No se pudo eliminar el archivo original.");
        }
    }
    
}
