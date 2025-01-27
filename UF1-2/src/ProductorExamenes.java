import java.time.LocalDateTime;

public class ProductorExamenes implements Runnable {

    private BufferExamenes buffer;
    private static int numeroExamen = 1;
    private Thread hilo;


    public ProductorExamenes(BufferExamenes buffer) {
        numeroExamen++;
        this.hilo = new Thread(this);
        this.buffer = buffer;
        hilo.setName("E" + numeroExamen);
        hilo.start();
    }

    @Override
    public void run() {
        int aa = LocalDateTime.now().getYear();

        // Generación del código de examen.
        String codigo = this.hilo.getName() + "-" + aa;

        buffer.fabricarNuevoExamen(codigo);
    }

}