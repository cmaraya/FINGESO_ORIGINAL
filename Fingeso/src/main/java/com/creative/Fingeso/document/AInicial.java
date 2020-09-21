package sample;

public class AInicial extends Aviso{

    public int personasRestantes;

    /**
     * Constructor de Aviso
     *
     * @param fono
     * @param tiempoR
     */
    public AInicial(int fono, int tiempoR){
        super(fono, tiempoR);
    }
    public String Mostrar(int personas){
        return "Nombre de Local\n" +
                 comunicado  + '\n'+
        "Tiempo estimado de ingreso\n" + tiempoRestante + '\n' +
        " Cantidad de personas en la cola\n" + personas +
        '\n';
    }





}
