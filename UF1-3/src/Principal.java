public class Principal {
    private static int contador = 1;

    public static void main(String[] args) throws InterruptedException {
        // Verifica si se han proporcionado argumentos
        if (args.length == 0) {
            System.out.println("Debes proporcionar al menos un nombre de alumno como argumento.");
            return;
        }

        // Recogemos el primer argumento del lanzador como el numero identificador de examen.
        int idExamen = Integer.parseInt(args[0]);

        // Obtenemos un substring con el resto de argumentos que pertenecen a los nombres de los alumnos que se van a examinar
        String[] nombresAlumnos = new String[args.length - 1];
        System.arraycopy(args, 1, nombresAlumnos, 0, args.length - 1);

        // Crea el buffer de exámenes
        BufferExamenes generador = new BufferExamenes();

        /* Generamos el productor pasandole el id del examen que corresponde al primer argumento del comando del lanzador
        y establecemos el numero de examenes que tiene que generar en funcion de la cantidad de argumentos que se pasen como alumnos.*/
        new ProductorExamenes(generador, idExamen, nombresAlumnos.length) ;

        // Crea un hilo Examinado cada nombre proporcionado en los argumentos
        for (String alumno : nombresAlumnos) {
            new Examinado(alumno, generador);
        }
    }
}