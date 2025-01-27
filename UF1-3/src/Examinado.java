import java.util.Random;

public class Examinado implements Runnable {

    private Thread hilo;
    BufferExamenes buffer;

    public Examinado(String alumno, BufferExamenes buffer) {
        this.buffer = buffer;
        hilo = new Thread(this);
        hilo.setName(alumno);
        hilo.start();
    }

    @Override
    public synchronized void run() {
        String codigoExamen = buffer.consumirExamen();
        if (codigoExamen != null) {
            Random random = new Random();
            int randomInt;

            for (int i = 1; i <= 10; i++) {

                randomInt = random.nextInt(4);  // Genera un número aleatorio entre 0 y 3
                String respuesta = switch (randomInt) {
                    case 0 -> "A";
                    case 1 -> "B";
                    case 2 -> "C";
                    case 3 -> "D";
                    default -> null;
                };
                System.out.printf("%s; %s; Pregunta%d: %s\n", codigoExamen, hilo.getName(), i, respuesta);
            }
        } else {
            System.out.println("Agotado tiempo de espera y " + "no hay más exámenes");
        }
    }
}

