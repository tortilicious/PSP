import java.util.LinkedList;
import java.util.Queue;


public class BufferExamenes {

    private Queue<String> colaExamenes;


    public BufferExamenes() {
        colaExamenes = new LinkedList<>();
    }

    public synchronized void fabricarNuevoExamen(String codigo) {
        // Como vamos a generar tantos examenes como argumentos pase al programa no necesito hacer comprobaciones aquí
        colaExamenes.add(codigo);
        System.out.println("Se ha generado el examen " + codigo);
        notifyAll(); // Notifica a los consumidores
    }

    public synchronized String consumirExamen() {
        while (colaExamenes.isEmpty()) {
            try {
                wait(); // Espera a que se introduzca algun examen al buffer
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        String examen = colaExamenes.remove();
        notifyAll();
        return examen;
    }

}
