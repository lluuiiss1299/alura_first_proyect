package Tienda;

public class Productos implements Comparable<Productos>{
    private String nombre;
    private int precio;
    private String descripcion;

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getPrecio() {
        return precio;
    }

    public Productos(String nombre, int precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    @Override
    public String toString() {
        return
                "Producto: '" + nombre + '\n' +
                "Precio: " + precio;
    }

    @Override
    public int compareTo(Productos otroProducto) {
        return this.getNombre().compareTo(otroProducto.getNombre());
    }
}
