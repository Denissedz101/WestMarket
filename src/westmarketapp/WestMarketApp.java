package westmarketapp;
import java.util.ArrayList;
import java.util.Scanner;

public class WestMarketApp {
	
    private static ArrayList<Producto> listaProductos = new ArrayList<>();
    

    public static void main(String[] args) {
		
        inicializarMenu();
        try (Scanner scanner = new Scanner(System.in)) {
            boolean salir = false;
            
            while (!salir) {
                System.out.println("\n--- West Market ---");
                System.out.println("\n1. Registrar producto");
                System.out.println("\n2. Imprimir productos");
                System.out.println("\n3. Eliminar producto");
                System.out.println("\n4. Salir");
                System.out.print("\n Seleccione una opcion: \n");
                
                int opcion = scanner.nextInt();
                scanner.nextLine();
                
                switch (opcion) {
                    case 1 -> RegistroProducto.registrarProducto(listaProductos);
                    case 2 -> {
                        System.out.println("\n--- Listado de productos ---");
                        for (Producto p : listaProductos) {
                            p.imprimirListado();
                        }
                    }
                    case 3 -> eliminarProducto();
                    case 4 -> {
                        salir = true;
                        System.out.println("\n Gracias por usar nuestro sistema!!!");
                        System.out.println("\n Saliendo...");
                    }
                    default -> System.out.println("\n Esta opcion no es valida.");
                }
            }
        }
    }

  
    private static void eliminarProducto() {
        System.out.println("\n--- Productos ingresados ---");
        for (Producto p : listaProductos) {
            p.imprimirListadoSimple();
        }
        int codigoEliminar = Validaciones.leerCodigo(null, 3);
        listaProductos.removeIf(p -> p.getCodigo() == codigoEliminar);
        System.out.println("\n *** Producto eliminado correctamente ***");
    }

    private static void inicializarMenu() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
