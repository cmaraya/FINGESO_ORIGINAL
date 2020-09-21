package com.creative.Fingeso.document;

import java.util.Random;
import com.sun.istack.internal.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.io.Serializable;

@Document(collection = "Usuario")
public class Usuario {
    @id
    @NotNull
    public int telefono;
    public String nombre;
    public int ticket;

    /**
     * Constructor de Usuario
     */
    public Usuario(int telefono,String nombre, int ticket){

        this.telefono=telefono;
        this.nombre=nombre;
        this.ticket=0;
    }

    /**
     *SETTERS
     */
    public void setNombreUsuario(String nombre) { this.nombre = nombre; }
    public void setTelefono(int fono) { this.telefono = fono; }
    public void setTicket(int tick) { this.ticket = tick; }

    /**
     *GETTERS
     */
    public String getNombreUsuario() { return nombre; }
    public int getTelefono() { return telefono; }
    public int getTicket() { return ticket; }

    /**
     *METODOS
     */

    public Usuario solicitarIngresoCola (){
        Usuario user = local.solicitarIngresoCola(get.nombre(),get.telefono());
        return user;
    }


}
