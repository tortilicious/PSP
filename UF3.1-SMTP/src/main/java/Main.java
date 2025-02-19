import java.util.Date;
import java.util.Properties;
import java.util.Scanner;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

//fovx vvqv upvr gtbt

public class Main {
    public static void main(String[] args) {
        // Solicitar al usuario la dirección de correo del destinatario
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese la dirección de correo del destinatario: ");
        String destinatario = scanner.nextLine().trim();
        scanner.close();

        // Configuración de las propiedades del correo
        Properties propiedades = new Properties();
        propiedades.put("mail.smtp.auth", "true");
        propiedades.put("mail.smtp.starttls.enable", "true");
        propiedades.put("mail.smtp.host", "smtp.gmail.com"); // Cambia a tu servidor SMTP
        propiedades.put("mail.smtp.port", "587");
        propiedades.put("mail.smtp.ssl.trust", "smtp.gmail.com"); // Cambia a tu servidor SMTP
        propiedades.put("mail.smtp.ssl.protocols", "TLSv1.2");

        // Crear la sesión con las propiedades configuradas
        Session sesion = Session.getInstance(propiedades);
        System.out.println("Sesión configurada con el servidor SMTP.");

        try {
            // Crear el mensaje de correo
            MimeMessage email = new MimeMessage(sesion);
            email.setRecipients(Message.RecipientType.TO, InternetAddress.parse(destinatario));
            email.setSubject("Mensaje importante desde Java");
            email.setSentDate(new Date());
            email.setText("Mensaje enviado desde Java");

            System.out.println("Mensaje de correo configurado.");

            // Transportar el mensaje
            Transport transport = sesion.getTransport("smtp");

            // Conexión con el servidor de correo
            String usuario = "miggg89@gmail.com"; // Reemplaza con tu email
            String contrasena = "fovx vvqv upvr gtbt"; // Reemplaza con tu contraseña de aplicación

            transport.connect(usuario, contrasena);
            System.out.println("Conexión establecida con el servidor SMTP.");

            // Enviar el mensaje
            transport.sendMessage(email, email.getAllRecipients());
            transport.close();
            System.out.println("El mensaje ha sido enviado con éxito a: " + destinatario);
        } catch (MessagingException e) {
            System.out.println("No se ha podido enviar el mensaje: " + e.getMessage());
        }
    }
}