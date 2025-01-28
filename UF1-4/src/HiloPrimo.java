import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.Duration;
import java.time.LocalDateTime;

public class HiloPrimo implements Runnable {

    private static int contador = 1;
    private String nombreHilo;
    private Thread thread;
    private int num;
    private boolean primo;
    private boolean guardado;


    public HiloPrimo(int num, boolean guardado) {
        this.num = num;
        this.nombreHilo = "Hilo" + contador;
        ++contador;
        this.guardado = guardado;
        primo = false;
        thread = new Thread(this);
        thread.start();
    }


    @Override
    public void run() {
        LocalDateTime inicioProceso = LocalDateTime.now();  // Guardamos el momento en el que arranca el hilo
        primo = esPrimo(num);
        LocalDateTime finProceso = LocalDateTime.now(); // Guardamos el momento en el que termina el cálculo del numero primo
        Duration duracion = Duration.between(inicioProceso, finProceso);
        long diff = duracion.toMillis(); // Calculamos el tiempo que ha tardado el hilo en calcular

        String salida = String.format("%s - numero: %d - duracion: %d ms - primo: %s", nombreHilo, num, diff, primo);
        System.out.println(salida);

        if (guardado) {
            String filePath = "src/registro.txt";
            try (PrintWriter pw = new PrintWriter(new FileWriter(filePath, true))) {
                pw.println(salida);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public boolean esPrimo(int numero) {
        // Los números menores o iguales a 1 no son primos
        if (numero <= 1) {
            return false;
        }
        // Comprobamos divisibilidad desde 2 hasta la raíz cuadrada del número
        for (int i = 2; i <= Math.sqrt(numero); i++) {
            if (numero % i == 0) {
                return false; // Si es divisible, no es primo
            }
        }
        return true; // Si no es divisible por ningún número, es primo
    }
}
