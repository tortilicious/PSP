import java.time.LocalDateTime;

public class ProductorExamenes implements Runnable {

    private BufferExamenes buffer;
    private int idExamen;
    private Thread hilo;
    private int cantidadExamenes;


    public ProductorExamenes(BufferExamenes buffer,int idExamen, int cantidadExamenes) {
        this.hilo = new Thread(this);
        this.buffer = buffer;
        this.cantidadExamenes = cantidadExamenes;
        this.idExamen = idExamen;
        hilo.setName("E" + idExamen);
        hilo.start();
    }

    @Override
    public void run() {
        int aa = LocalDateTime.now().getYear();

        // Generación del código de examen.
        String codigo = this.hilo.getName() + "-" + aa;

        // Introducimos tantos examenes al buffer como alumnos vayan a examinarse
        for (int i = 0 ; i < this.cantidadExamenes; i++) {
            buffer.fabricarNuevoExamen(codigo);
        }

    }

}