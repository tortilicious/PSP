import java.util.concurrent.atomic.AtomicInteger;

import static java.lang.Thread.sleep;

public class MailProducer implements Runnable {

    private Thread thread;
    private Buffer buffer;
    private static int threadCounter = 1;

    // genera un contador atomico para evitar las carreras entre hilos accediendo al contador a la vez
    private static AtomicInteger mailCounter = new AtomicInteger(1);
    private String name;


    public MailProducer(Buffer buffer)  {
        this.buffer = buffer;
        this.thread = new Thread(this);
        this.name = "HiloProductor-" + threadCounter++;
        thread.start();
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i <= 10; ++i) {

                // Obtiene e incrementa el contador atomico
                int currentMailId = mailCounter.getAndIncrement();
                Mail mail = new Mail(
                        currentMailId,
                        "destinatario" + currentMailId + "@correo.com",
                        "remitente" + currentMailId + "@correo.com",
                        "asunto " + currentMailId,
                        "mensaje " + currentMailId
                );
                ++currentMailId;
                buffer.addMail(mail);
                System.out.printf("%s: idCorreo: %d\n", name, mail.getId());
                sleep(500);
            }
        } catch (InterruptedException e) {
            System.out.println(name + " interrumpido");
        }


    }
}
