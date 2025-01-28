public class MailConsumer implements Runnable {

    private Buffer buffer;
    private Thread thread;
    private String name;
    private static int threadCounter = 1;

    public MailConsumer(Buffer buffer){
        this.buffer = buffer;
        this.thread = new Thread(this);
        this.name = "HiloConsumidor-" + threadCounter++;
        this.thread.start();
    }



    @Override
    public void run() {
        while (true){
            Mail mail = buffer.getMail();
            String mailData = String.format("""
                    Hilo: %s,
                    idCorreo: %d,
                    destinatario: %s,
                    remitente: %s,
                    asunto: %s,
                    mensaje: %s                    
                    """, name, mail.getId(),mail.getDestinatario(), mail.getRemitente(), mail.getAsunto(), mail.getMensaje());
            System.out.println(mailData);
        }
    }
}
