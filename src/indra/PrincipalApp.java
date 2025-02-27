package indra;

import java.util.*;


public class PrincipalApp {
	public static final Scanner scanner = new Scanner(System.in);
    public static final ArrayList<String> nombresEventos = new ArrayList<>();
    public static final ArrayList<String> fechasEventos = new ArrayList<>();
    public static final ArrayList<String> lugaresEventos = new ArrayList<>();
    public static final HashMap<String, ArrayList<String>> inscripciones = new HashMap<>();
}
public static void main(String[] args) {
    while (true) {
        mostrarMenu();
        int opcion = obtenerOpcion();
        
        switch (opcion) {
            case 1:
            	agregarEvento();
            	break;
            	
            case 2 : 
            	listarEventos();
            	break;
            case 3 :
            	inscribirseEvento();
            	break;
            	
            case 4:
            	mostrarInscripciones();
            	break;
            case 5:
            	salir();
            	break;
            default :
            	System.out.println("Opción no válida. Intente de nuevo.");
        }
    }
}
public static void mostrarMenu() {
    System.out.println("\n===== MENÚ PRINCIPAL =====");
    System.out.println("1. Agregar evento");
    System.out.println("2. Listar eventos");
    System.out.println("3. Inscribirse a un evento");
    System.out.println("4. Mostrar inscripciones");
    System.out.println("5. Salir");
    System.out.print("Seleccione una opción: ");
}
public static int obtenerOpcion() {
    try {
        return scanner.nextInt();
    } catch (InputMismatchException e) {
        System.out.println("Error: Debe ingresar un número válido.");
        scanner.nextLine();
        return -1;
    }
}
private static void agregarEvento() {
    scanner.nextLine();
    System.out.print("Ingrese el nombre del evento: ");
    String nombre = scanner.nextLine();
    
    System.out.print("Ingrese la fecha del evento (DD/MM/AAAA): ");
    String fecha = scanner.nextLine();

    System.out.print("Ingrese el lugar del evento: ");
    String lugar = scanner.nextLine();

    nombresEventos.add(nombre);
    fechasEventos.add(fecha);
    lugaresEventos.add(lugar);
    inscripciones.put(nombre, new ArrayList<>());

    System.out.println("Evento agregado con éxito.");
}
