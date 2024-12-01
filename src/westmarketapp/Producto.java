package westmarketapp;
import java.util.ArrayList;


public class Producto {
	
    private int codigop;
    private String descripcion;
    private int precio;
    private int stock;
    private String Categoria;
    private int codigo;

     private ArrayList<Producto> listaProductos;
    
    public Producto(int codigop, String descripcion, int precio, int stock, int codigo1, String Categoria) {

        listaProductos = new ArrayList<>();
        this.codigop = codigop;
        this.descripcion = descripcion;
        this.precio = precio;
        this.stock = stock;
        this.Categoria = Categoria;
        this.codigo = codigo;
        
    }
   
	
     //Para la interfaz es más util solo los get

    public int getCodigop() {
        return codigop;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getPrecio() {
        return precio;
    }

    public int getStock() {
        return stock;
    }

    public String getCategoria() {
        return Categoria;
    }

    public int getCodigo() {
        return codigo;
    }

    public ArrayList<Producto> getListaProductos() {
        return listaProductos;
    }


    
    // Métodos para gestionar la lista de productos
    public void agregarProducto(Producto producto) {
        listaProductos.add(producto);
    }

    @Override
    public String toString() {
        return "Producto{" + "Codigo Producto=" + codigop + ", Descripcion=" + descripcion + ", Precio=" + precio + ", stock=" + stock + ", Categoria=" + Categoria + ", Ccodigo Categoria=" + codigo + '}';
    }

    

    //metodos
    
     public void imprimirListado() {
        System.out.println("\n Codigo: " + codigo);
        System.out.println("\n Descripcion: " + descripcion);
        System.out.println("\n Precio: " + precio);
        System.out.println("\n Stock: " + stock);
        System.out.println("--------------------------------------------");
    }

    public void imprimirListadoSimple() {
        System.out.println("\n Codigo: " + codigo);
        System.out.println("\n Descripcion: " + descripcion);
        System.out.println("--------------------------------------------");
    }

    
}
    

   

