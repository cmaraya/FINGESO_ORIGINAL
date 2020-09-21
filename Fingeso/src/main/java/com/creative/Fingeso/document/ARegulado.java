package sample;

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
