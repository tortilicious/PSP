public class Main {
    public static void main(String[] args) {

        Buffer buffer = new Buffer();
        MailProducer mailProducer1 = new MailProducer(buffer);
        MailProducer mailProducer2 = new MailProducer(buffer);
        MailProducer mailProducer3 = new MailProducer(buffer);
        MailConsumer mailConsumer1 = new MailConsumer(buffer);
        MailConsumer mailConsumer2 = new MailConsumer(buffer);

    }

}
