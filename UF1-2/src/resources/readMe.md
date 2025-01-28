Enunciado:

Esta práctica consiste en el desarrollo de un programa que simulará la gestión de un centro de exámenes, donde podrán
examinarse varios alumnos. El programa lanzará varios hilos de ejecución, cada uno de los cuales representa un alumno
que se está examinando.

Debes crear un proyecto en Intellij con el nombre ActividadUF1-2, atendiendo a las especificaciones que se indican en
este documento.
Empaquetarás el proyecto en un archivo .zip que entregarás a tu tutor, junto con un documento en formato Word o PDF en
el que harás una exposición sobre lo que has ido realizando y pegarás las partes principales del código.
Especificaciones:

Comienza por crear un proyecto Intellij con el nombre ActividadUF1-2.
Para que te resulte más sencillo, te daremos parte del código ya desarrollado. Solo tendrás que completar las partes que
faltan para sustituir los comentarios que aparecen en color rojo.
Para comenzar, aquí tienes todo el código de la clase Principal con su método main(), que arrancará el programa:

public class Principal {

public static void main(String[] args) throws InterruptedException {

BufferExamenes generador = new BufferExamenes();

new ProductorExamenes(generador);

new Examinado("Rosa", generador);

new ProductorExamenes(generador);

new Examinado("Miguel", generador);

new ProductorExamenes(generador);

new Examinado("Carlos", generador);

}

}

Para cada alumno que va a examinarse se debe imprimir un examen, que tendrá un código diferenciado. La clase
BufferExamenes mantiene una cola (objeto LinkedList) de códigos de examen. Para cada alumno se extrae un examen de la
cola.
import java.util.LinkedList;

import java.util.Queue;

public class BufferExamenes {

private Queue<String> colaExamenes;

public BufferExamenes() {

colaExamenes = new LinkedList<String>();

}

public synchronized void fabricarNuevoExamen(String codigo) {

// Aquí se fabrica un nuevo examen.

// Un hilo de la clase ProductorExamenes

// se encargará de fabricarlo

// y pasarlo como argumento a este método.

// Añade el código pasado como argumento a la cola

// y libera el hilo que está intentando consumir

// un nuevo examen.

}

public synchronized String consumirExamen() {

// Este método se encargará de suministrar un examen

// a cada hilo de tipo Examinador que lo solicite.

// Para suministrar el examen habrá antes que esperar

// hasta que haya algún examen para consumir en la cola.

// Haz aquí una pausa hasta que se haya fabricado algún examen.

// Si la cola sigue sin estar vacía, saca un examen y

// entrégalo como retorno de esta función.

}

}

La clase ProductorExamenes se encargará de generar exámenes, asignándole a cada uno un código que estará formado por la
letra E seguida del número de examen, un guión y el año, por ejemplo: “E2-2024 (segundo examen del año 2024).” El número
de examen se establece a partir de la variable estática numeroExamen.

import java.time.LocalDateTime;

public class ProductorExamenes implements Runnable {

private BufferExamenes buffer;

private static int numeroExamen = 0;

private Thread hilo;

public ProductorExamenes(BufferExamenes buffer) {

// Incrementa el contador de exámenes (variable numeroExamen).

// Construye el hilo. El nombre será la letra E seguida

// del valor de la variable numeroExamen.

// Establece el valor de la propiedad buffer

// Inicia el hilo.

}

@Override

public void run() {

int aa = LocalDateTime.now().getYear();

// Generación del código de examen.

String codigo = this.hilo.getName() + "-" +aa;

// Añade el nuevo código al buffer de exámenes.

// Muestra un mensaje en consola informando sobre el

// código del examen que se acaba de producir.

}

}

La clase Examinado se lanza cada vez que un alumno va a examinarse, simulando la realización del examen por parte del
alumno. Un ejemplo de salida de examen podría ser:

E2-2024;Miguel; Pregunta 1;C

E2-2024;Miguel; Pregunta 2;-

E2-2024;Miguel; Pregunta 3;A

E2-2024;Miguel; Pregunta 4;C

E2-2024;Miguel; Pregunta 5;D

E2-2024;Miguel; Pregunta 6;-

E2-2024;Miguel; Pregunta 7;-

E2-2024;Miguel; Pregunta 8;B

E2-2024;Miguel; Pregunta 9;D

E2-2024;Miguel; Pregunta 10;-

Esta salida en pantalla representa la realización del examen con código E2-2024, que corresponde al alumno Miguel. El
examen consta de 10 preguntas, cuyas respuestas se han seleccionado al azar en los valores A, B, C, D o guión (sin
responder).

Puesto que varios alumnos se examinan simultáneamente, podrán entremezclarse líneas de la respuesta del examen de un
alumno con las del examen de otro. Pero las respuestas del examen de un mismo alumno siempre tendrán el mismo código.

public class Examinado implements Runnable {

private Thread hilo;

BufferExamenes buffer;

public Thread getHilo() {

return hilo;

}

public Examinado(String alumno, BufferExamenes generador) {

// Construye el hilo. El nombre será el nombre del alumno.

// Establece el valor de la propiedad buffer

// Inicia el hilo.

}

@Override

public synchronized void run() {

String codigoExamen = this.buffer.consumirExamen();

if (codigoExamen != null) {

// Simula aquí un examen de 10 preguntas

// cuyas respuestas se seleccionarán al azar

// entre A, B, C, D o – (sin contestar).

}

else {

System.out.println("Agotado tiempo de espera y " +

"no hay más exámenes");

}

}

}

La ejecución completa del programa debe ofrecer una salida similar a esta:
Producido examen E2-2018

Producido examen E2-2024

E1-2024;Carlos; Pregunta 1;B

E1-2024;Carlos; Pregunta 2;B

E2-2024;Rosa; Pregunta 1;A

E2-2024;Rosa; Pregunta 2;A

Producido examen E3-2024

E2-2024;Rosa; Pregunta 3;C

E2-2024;Rosa; Pregunta 4;-

E3-2024;Miguel; Pregunta 1;C

Producido examen E1-2024

E1-2024;Carlos; Pregunta 3;-

E1-2024;Carlos; Pregunta 4;D

E3-2024;Miguel; Pregunta 2;-

E2-2024;Rosa; Pregunta 5;D

E3-2024;Miguel; Pregunta 3;D

E1-2024;Carlos; Pregunta 5;C

E3-2024;Miguel; Pregunta 4; B

E2-2024;Rosa; Pregunta 6;-

E3-2024;Miguel; Pregunta 5;B

E1-2024;Carlos; Pregunta 6;D

E3-2024;Miguel; Pregunta 6;C

E2-2024;Rosa; Pregunta 7;-

E3-2024;Miguel; Pregunta 7;-

E1-2024;Carlos; Pregunta 7;C

E3-2024;Miguel; Pregunta 8;B

E2-2024;Rosa; Pregunta 8;A

E3-2024;Miguel; Pregunta 9;C

E1-2024;Carlos; Pregunta 8;D

E3-2024;Miguel; Pregunta 10;A

E2-2024;Rosa; Pregunta 9;C

E2-2024;Rosa; Pregunta 10;A

E1-2024;Carlos; Pregunta 9;B

E1-2024;Carlos; Pregunta 10;-