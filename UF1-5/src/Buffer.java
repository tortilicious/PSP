import org.w3c.dom.ls.LSOutput;

import java.util.LinkedList;
import java.util.Queue;

public class Buffer {

    private Queue<Mail> mailList;
    private int capacity;

    public Buffer() {
        this.mailList = new LinkedList<>();
        this.capacity = 10;
    }

    synchronized public void addMail(Mail mail) {
        // Esperar mientras el buffer esté lleno
        while (mailList.size() == capacity) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        if (mail.getDestinatario().equals("pikachu@gmail.com")) {
            System.out.println("No se pueden enviar correos a esta dirección.");
        } else {
            mailList.add(mail);
            // Notificar a los consumidores que hay un nuevo mail disponible
            notifyAll();
        }
    }

    synchronized public Mail getMail() {
        // Esperar mientras el buffer esté vacío
        while (mailList.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        Mail mail = mailList.remove();
        // Notificar a los productores que hay espacio disponible
        notifyAll();
        return mail;
    }


}
