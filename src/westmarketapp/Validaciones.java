package westmarketapp;

import java.util.List;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Validaciones {
   

    public static int leerCodigo(String mensaje, int intentos) {
    while (intentos > 0) {
        String input = JOptionPane.showInputDialog(null, mensaje, "Entrada de Código", JOptionPane.PLAIN_MESSAGE);
        if (input != null && input.matches("\\d{3,}")) {
            return Integer.parseInt(input);
        } else {
            JOptionPane.showMessageDialog(null, "Código inválido. Debe tener al menos 3 dígitos.", "Error", JOptionPane.ERROR_MESSAGE);
            intentos--;
        }
    }
    JOptionPane.showMessageDialog(null, "Has alcanzado el máximo de intentos permitidos.", "Error", JOptionPane.ERROR_MESSAGE);
    System.exit(0);
    return -1;
}


    public static int leerCodigoUnico(String mensaje, int intentos, List<Producto> productos) {
    while (intentos > 0) {
        String input = JOptionPane.showInputDialog(null, mensaje, "Entrada de Código Único", JOptionPane.PLAIN_MESSAGE);
        if (input != null && input.matches("\\d{3,}")) {
            int codigo = Integer.parseInt(input);
            boolean existe = productos.stream().anyMatch(p -> p.getCodigo() == codigo);
            if (!existe) {
                return codigo;
            } else {
                JOptionPane.showMessageDialog(null, "Código ya existe. Ingrese uno diferente.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Código inválido. Debe tener al menos 3 dígitos.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        intentos--;
    }
    JOptionPane.showMessageDialog(null, "Has alcanzado el máximo de intentos permitidos.", "Error", JOptionPane.ERROR_MESSAGE);
    System.exit(0);
    return -1;
}


   public static String leerDescripcion(String mensaje, int intentos) {
    while (intentos > 0) {
        String input = JOptionPane.showInputDialog(null, mensaje, "Entrada de Descripción", JOptionPane.PLAIN_MESSAGE);
        if (input != null && input.matches("[a-zA-Z ]{3,}")) {
            return input;
        } else {
            JOptionPane.showMessageDialog(null, "Descripción no válida. Debe contener solo letras y al menos 3 caracteres.", "Error", JOptionPane.ERROR_MESSAGE);
            intentos--;
        }
    }
    JOptionPane.showMessageDialog(null, "Has alcanzado el máximo de intentos permitidos.", "Error", JOptionPane.ERROR_MESSAGE);
    System.exit(0);
    return "";
}


    public static int leerPrecio(String mensaje, int intentos) {
    while (intentos > 0) {
        String input = JOptionPane.showInputDialog(null, mensaje, "Entrada de Precio", JOptionPane.PLAIN_MESSAGE);
        if (input != null && input.matches("\\d+")) {
            return Integer.parseInt(input);
        } else {
            JOptionPane.showMessageDialog(null, "Precio inválido. Debe contener solo números enteros.", "Error", JOptionPane.ERROR_MESSAGE);
            intentos--;
        }
    }
    JOptionPane.showMessageDialog(null, "Has alcanzado el máximo de intentos permitidos.", "Error", JOptionPane.ERROR_MESSAGE);
    System.exit(0);
    return -1;
}


    public static int leerStock(String mensaje, int intentos) {
    while (intentos > 0) {
        String input = JOptionPane.showInputDialog(null, mensaje, "Entrada de Stock", JOptionPane.PLAIN_MESSAGE);
        if (input != null && input.matches("\\d+")) {
            int stock = Integer.parseInt(input);
            if (stock > 0) {
                return stock;
            } else {
                JOptionPane.showMessageDialog(null, "El stock debe ser mayor a 0.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Stock inválido. Debe contener solo números enteros.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        intentos--;
    }
    JOptionPane.showMessageDialog(null, "Has alcanzado el máximo de intentos permitidos.", "Error", JOptionPane.ERROR_MESSAGE);
    System.exit(0);
    return -1;
}


    public static int leerCategoria(String mensaje) {
    while (true) {
        String input = JOptionPane.showInputDialog(null, mensaje, "Entrada de Categoría", JOptionPane.PLAIN_MESSAGE);
        if (input != null && input.matches("\\d+")) {
            return Integer.parseInt(input);
        } else {
            JOptionPane.showMessageDialog(null, "Opción inválida. Ingrese una categoría válida.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}

}
