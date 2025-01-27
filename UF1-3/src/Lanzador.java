import java.io.File;
import java.io.IOException;

public class Lanzador {

    public static void main(String[] args) {
        try {
            // Ruta del classpath que contiene las clases compiladas
            String classpath = "out/production/UF1-3";

            String[] comandoExamen1 = {
                    "java", "-cp", classpath, "Principal", "1", "Pepe", "Juan", "Luis"
            };

            String[] comandoExamen2 = {
                    "java", "-cp", classpath, "Principal", "2", "Rosa", "Miguel", "Pedro"
            };

            // Configuramos los archivos de salida de los procesos
            File salidaExamen1 = new File("src/examen1.txt");
            File salidaExamen2 = new File("src/examen2.txt");

            // Lanzar el primer proceso
            Process proceso1 = new ProcessBuilder(comandoExamen1)
                    .redirectOutput(salidaExamen1)
                    .start();

            // Lanzar el segundo proceso
            Process proceso2 = new ProcessBuilder(comandoExamen2)
                    .redirectOutput(salidaExamen2)
                    .start();

            // Esperar a que ambos procesos terminen
            proceso1.waitFor();
            proceso2.waitFor();

            System.out.println("Ambos procesos han finalizado.");
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
