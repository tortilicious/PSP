Enunciado

Requerimiento 1

Realiza un programa en Java que genere una simulación de una cadena de procesamiento de correos electrónicos o emails.
Los emails tendrán un id, un destinatario, un remitente, un asunto y un cuerpo del mensaje.

Las cartas de correo no se quieren enviar directamente a los destinatarios ya que se quiere registrar cuantos correos se
mandan en determinadas franjas horarias. Por lo tanto, las cartas se depositarán en un buffer que tendrá una capacidad
de 5 cartas como máximo, por temas de espacio de memoria.

Por otro lado, habrá 3 hilos que producirán 10 emails cada uno, cada uno de ellos tendrá un destinatario, un remitente,
un asunto y un cuerpo de mensaje diferente, e irán poniendo los emails en el buffer cada 0,5 segundos, imprimiendo por
pantalla cada vez que meta dicho mail en el buffer su nombre y el id del email metido.

Del mismo modo, habrá 2 hilos que consuman los emails del buffer siempre que haya email disponible. Cada vez que un
consumidor coja un email, simulará su envío simplemente imprimiendo por pantalla los datos del email, así como el nombre
del hilo consumidor que ha cogido dicho email.

Requerimiento 2

En nuestra empresa queremos evitar que se envíen mails a pikachu@gmail.com, por lo que no se deben meter en el buffer
aquellos email lo tengan como destinatario. Se deberá imprimir por pantalla cada vez que hagamos este descarte.