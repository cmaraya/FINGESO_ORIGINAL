package com.creative.Fingeso.document;

import java.util.ArrayList;
import java.util.*;
import java.util.Random;
import com.sun.istack.internal.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.io.Serializable;

@Document(collection = "Cola")
public class Cola {
    @id
    @NotNull
    public ArrayList<Usuario> usuariosCola;
    public int tamanoMaximo;
    public int tiempoPorUsuario;
    public int contador;

    /**
     * Constructor de Cola
     */
    public Cola(int tamanoMax, int tiempoUsu){
        this.usuariosCola= new ArrayList<Usuario>();
        this.tamanoMaximo=tamanoMax;
        this.tiempoPorUsuario=tiempoUsu;
        this.contador=0;
    }

    /**
     * SETTERS
     */
    public void setTamanoMaximo(int tamanoMax){this.tamanoMaximo=tamanoMax;}
    public void setTiempoPorUsuario (int tiempoUsu){this.tiempoPorUsuario=tiempoUsu;}
    public void setContador(int cont){this.contador=cont;}

    /**
     * GETTERS
     */
    private int getTamanoMaximo() { return tamanoMaximo; }
    private int  getTiempoPorUsuario(){return tiempoPorUsuario;}
    public int getContador(){return this.contador;}


    public int calculaTiempoUsuario(int ticketPersona){
        int posicion=0;
        for(int x=0;x<usuariosCola.size();x++) {
            if ((usuariosCola.get(x).ticket== ticketPersona)) {
               posicion=x;
            }
        }
        int calculo= tiempoPorUsuario*posicion;
        return(calculo);
    }
    public int calculaTiempoNuevoUsuario(){
        int calculo= (usuariosCola.size())*tiempoPorUsuario;
        return(calculo);
    }

    public void agregaUsuario(Usuario user) {
        usuariosCola.add(user);
        setContador(getContador()+1);
    }
    /**al iniciar un nuevo dia, la cola empieza la entrega de tickets con numero 0**/
    public void resetContador(){
        setContador(0);
    }

    public void quitarUsuario(Usuario user) {usuariosCola.remove(user);
    }

    public AInicial crearAvisoInicial(int telefono,String local){
        int tiempo=calculaTiempoNuevoUsuario();
        AInicial avisoInicial = new AInicial(telefono,tiempo);
        avisoInicial.setComunicado(local);
        return(avisoInicial);
    }

    public ARegulado crearAvisoRegulado(int telefono){
        int tiempo=0;
        for(int x=0;x<usuariosCola.size();x++) {
            if ((usuariosCola.get(x).telefono== telefono)) {
                tiempo =calculaTiempoUsuario(usuariosCola.get(x).ticket);
            }
        }
        ARegulado avisoRegulado =new ARegulado(telefono,tiempo);
        return (avisoRegulado);
    }

}
