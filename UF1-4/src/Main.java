import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int number;
        List<Integer> list = new ArrayList<>();

        // Pedimos 4 numeros al usuario y los almacenamos
        for (int i = 1; i <= 4; ++i) {
            System.out.println("Por favor introduce un número entero: ");
            number = Integer.parseInt(scanner.nextLine());
            list.add(number);
        }

        System.out.println("Desea guardar los resultados en un archivo? (s/N)");
        String respuesta = scanner.nextLine().toLowerCase().trim();
        boolean guardado;
        guardado = respuesta.equals("s");

        for (int num : list) {
            new HiloPrimo(num, guardado);
        }

    }
}
