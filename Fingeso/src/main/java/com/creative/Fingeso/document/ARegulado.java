package com.creative.Fingeso.document;

import java.util.Random;
import com.sun.istack.internal.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.io.Serializable;

@Document(collection = "ARegulado")
public class ARegulado extends Aviso{
    /**
     * Constructor de Aviso
     *
     * @param fono
     * @param tiempoR
     */
    public ARegulado(int fono, int tiempoR) {
        super(fono, tiempoR);
    }

    public String Mostrar(){
        return "EsperApp.cl\n" +
                "¡La cola ha avanzado!\n "  +
                "En " + tiempoRestante + " minutos puedes ingresar al local."+'\n';
    }
}
