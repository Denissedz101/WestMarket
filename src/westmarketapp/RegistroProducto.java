package westmarketapp;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class RegistroProducto {
	
	private ArrayList<Producto> listaProducto;
   
	
	public RegistroProducto (){
		listaProducto = new ArrayList<>();
	
	}
	
	public void registrarProducto(int codigop, String descripcion, int precio, int stock, String categoria, int codigo) {
        Producto nuevoProducto= new Producto(codigop, descripcion, precio, stock, codigo, categoria);
        listaProducto.add(nuevoProducto);
    }

  
  public static void registrarProducto(ArrayList<Producto> listaProductos) {
	  

        } 
  
 
}
