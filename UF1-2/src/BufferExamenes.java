import java.util.LinkedList;
import java.util.Queue;


public class BufferExamenes {

    private Queue<String> colaExamenes;

    public BufferExamenes() {
        colaExamenes = new LinkedList<String>();
    }


    public synchronized void fabricarNuevoExamen(String codigo) {

        /*
         Aquí se fabrica un nuevo examen.
         Un hilo de la clase ProductorExamenes
         se encargará de fabricarlo
         y pasarlo como argumento a este método.
         Añade el código pasado como argumento a la cola
         y libera el hilo que está intentando consumir
         un nuevo examen.
        */

        colaExamenes.add(codigo);
        System.out.println("Se ha generado el examen " + codigo);
        notifyAll();    // Alertamos al resto de hilos

    }

    public synchronized String consumirExamen() {
        while (colaExamenes.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        String examen = colaExamenes.remove();
        notifyAll();
        return examen;
    }

}
