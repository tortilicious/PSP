package red;

import model.Constelacion;
import model.Planeta;
import service.ConstelacionRMI;
import service.PlanetaRMI;
import ui.ClienteCLI;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;

public class ClienteRMI {
    public static void main(String[] args) {

        ClienteCLI clienteCLI = new ClienteCLI();
        String clientOption;
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 4000);

            do {
                clienteCLI.showMenu();
                clientOption = clienteCLI.askInput().toLowerCase();

                switch (clientOption) {
                    case "1": // Constelaciones
                        ConstelacionRMI constelacionService = (ConstelacionRMI) registry.lookup("ConstelacionService");
                        String constelacionOption; // Variable para el submenú de constelaciones

                        do { // Bucle para el submenú de constelaciones
                            clienteCLI.showMenuConstelaciones();
                            constelacionOption = clienteCLI.askInput().toLowerCase();

                            switch (constelacionOption) {
                                case "1":
                                    String nombreConstelacion = clienteCLI.askName();
                                    String constelacionInfo = constelacionService.getInfo(nombreConstelacion);
                                    if (!constelacionInfo.isEmpty()) {
                                        System.out.println(constelacionInfo);
                                    } else {
                                        System.out.println("Introduzca el nombre de una constelación");

                                    }
                                    System.out.println();
                                    break;

                                case "2":
                                    System.out.println("Lista de constelaciones: ");
                                    List<Constelacion> listaConstelaciones = constelacionService.getAll();
                                    listaConstelaciones.forEach(System.out::println);
                                    System.out.println();
                                    break;

                                case "salir":
                                    break; // Sale del submenú de constelaciones

                                default:
                                    System.out.println("Opción incorrecta");
                                    System.out.println();
                            }
                        } while (!constelacionOption.equals("salir"));
                        break; // Sale del case "1" y vuelve al menú principal


                    case "2": // Planetas (estructura similar)
                        PlanetaRMI planetaService = (PlanetaRMI) registry.lookup("PlanetaService");
                        String planetaOption;

                        do {
                            clienteCLI.showMenuPlanetas();
                            planetaOption = clienteCLI.askInput().toLowerCase();
                            switch (planetaOption) {
                                case "1":
                                    String nombrePlaneta = clienteCLI.askName();
                                    String planetaInfo = planetaService.getInfo(nombrePlaneta);
                                    if (!planetaInfo.isEmpty()) {
                                        System.out.println(planetaInfo);
                                    } else {
                                        System.out.println("Introduzca el nombre del planeta");
                                    }
                                    System.out.println();
                                    break;

                                case "2":
                                    System.out.println("Lista de planetas: ");
                                    List<Planeta> listaPlanetas = planetaService.getAll();
                                    listaPlanetas.forEach(System.out::println);
                                    System.out.println();
                                    break;

                                case "salir":
                                    break; // Sale del submenú de planetas
                                default:
                                    System.out.println("Opción incorrecta");
                                    System.out.println();
                            }
                        } while (!planetaOption.equals("salir"));
                        break; // Sale del case "2" y vuelve al menú principal

                    case "fin":
                        System.out.println("Saliendo del programa.");
                        break; // Sale del bucle principal
                    default:
                        System.out.println("Introduzca una opción valida.");
                }
            } while (!clientOption.equals("fin"));


        } catch (RemoteException | NotBoundException e) {
            throw new RuntimeException(e);
        }

    }
}
