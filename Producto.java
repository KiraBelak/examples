// Modelo
public class Producto {
    private String nombre;
    private double precio;

    // Constructor, getters y setters
    // ...
}

// Vista (Ejemplo simplificado en consola)
public class ProductoView {
    public void mostrarDetallesProducto(String nombre, double precio) {
        System.out.println("Producto: " + nombre + " - Precio: $" + precio);
    }
}

// Controlador
public class ProductoController {
    private Producto modelo;
    private ProductoView vista;

    public ProductoController(Producto modelo, ProductoView vista) {
        this.modelo = modelo;
        this.vista = vista;
    }

    public void actualizarNombreProducto(String nuevoNombre) {
        modelo.setNombre(nuevoNombre);
    }

    public void actualizarPrecioProducto(double nuevoPrecio) {
        modelo.setPrecio(nuevoPrecio);
    }

    public void mostrarProducto() {
        vista.mostrarDetallesProducto(modelo.getNombre(), modelo.getPrecio());
    }
}

// Uso
public class Main {
    public static void main(String[] args) {
        Producto modelo = new Producto("Teclado", 29.99);
        ProductoView vista = new ProductoView();
        ProductoController controlador = new ProductoController(modelo, vista);

        controlador.mostrarProducto(); // Muestra "Teclado - $29.99"

        controlador.actualizarNombreProducto("Teclado Mecánico");
        controlador.actualizarPrecioProducto(59.99);
        controlador.mostrarProducto(); // Muestra "Teclado Mecánico - $59.99"
    }
}
