//package red;
//
//import java.io.*;
//import java.net.Socket;
//
//
//public class HiloEscuchador implements Runnable {
//    private Thread hilo;
//    private static int numCliente = 1;
//    private Socket enchufeAlCliente;
//    private GestorSolicitudes gestorSolicitudes;
//
//
//    public HiloEscuchador(Socket cliente, GestorSolicitudes gestorSolicitudes) {
//        hilo = new Thread(this, "Cliente"+ numCliente++);
//        this.enchufeAlCliente = cliente;
//        this.gestorSolicitudes = gestorSolicitudes;
//        hilo.start();
//    }
//
//
//    @Override
//    public void run() {
//        System.out.println("Estableciendo comunicación con " + hilo.getName());
//        try {
//            //  Establecemos los flujos de entrada y salida del hilo
//            //  Como vamos a trabajar con objetos usaremos ObjectOutput y ObjectInputStreams
//            ObjectInputStream entrada = new ObjectInputStream(enchufeAlCliente.getInputStream());
//            ObjectOutputStream salida = new ObjectOutputStream(enchufeAlCliente.getOutputStream());
//            while (true) {
//                //  Recibimos la Solicitud del cliente
//                Solicitud solicitud = (Solicitud) entrada.readObject();
//                //  Le encargamos al GestorSolicitudes que la procese y recogemos la respuesta
//                Respuesta respuesta = gestorSolicitudes.procesarSolicitud(solicitud);
//
//                if (solicitud.getTipo() == TipoSolicitud.SALIR) {
//                    System.out.println("Terminando conexión con el cliente " + hilo.getName());
//                    salida.writeObject(respuesta.getMensajeRespuesta()); // Contestamos al cliente y salimos del bucle
//                    break;
//                }
//
//                //  Devolvemos la respusta al cliente
//                salida.writeObject(respuesta);
//            }
//
//            //  Cerramos los flujos de conexión y terminamos con el hilo
//            entrada.close();
//            salida.close();
//            enchufeAlCliente.close();
//            System.out.println("Conexión finalizada con el cliente " + hilo.getName());
//        } catch (IOException e) {
//            System.out.println(e.getMessage());
//        } catch (ClassNotFoundException e) {
//            throw new RuntimeException(e);
//        }
//    }
//}