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
public static void agregarEvento() {
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
public static void listarEventos() {
    if (nombresEventos.isEmpty()) {
        System.out.println("No hay eventos registrados.");
        return;
    }

    System.out.println("\nLista de eventos:");
    for (int i = 0; i < nombresEventos.size(); i++) {
        System.out.println((i + 1) + ". " + nombresEventos.get(i) + " - " + fechasEventos.get(i) + " - " + lugaresEventos.get(i));
    }
}
private static void inscribirseEvento() {
    if (nombresEventos.isEmpty()) {
        System.out.println("No hay eventos disponibles para inscripción.");
        return;
    }

    scanner.nextLine();
    System.out.print("Ingrese su nombre: ");
    String nombreUsuario = scanner.nextLine();
    
    listarEventos();
    System.out.print("Ingrese el número del evento: ");
    
    int eventoIndex = obtenerOpcion() - 1;
    scanner.nextLine();
    
    if (eventoIndex >= 0 && eventoIndex < nombresEventos.size()) {
        String nombreEvento = nombresEventos.get(eventoIndex);

        if (!inscripciones.get(nombreEvento).contains(nombreUsuario)) {
            inscripciones.get(nombreEvento).add(nombreUsuario);
            System.out.println("Inscripción exitosa en " + nombreEvento);
        } else {
            System.out.println("Ya estás inscrito en este evento.");
        }
    } else {
        System.out.println("Número de evento inválido.");
    }
}
public static void mostrarInscripciones() {
    if (inscripciones.isEmpty()) {
        System.out.println("No hay inscripciones registradas.");
        return;
    }

    System.out.println("\nInscripciones por evento:");
    for (int i = 0; i < nombresEventos.size(); i++) {
        String nombreEvento = nombresEventos.get(i);
        System.out.println(nombreEvento + " - " + fechasEventos.get(i) + " - " + lugaresEventos.get(i) + ": " + inscripciones.get(nombreEvento));
    }
}

