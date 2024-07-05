package Principal;

import Banco.Tarjetas;
import Tienda.Productos;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class MainTienda {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        var listaProductos = new ArrayList<Productos>();
        int saldo;
        String nombreP;
        int precioP;
        int totalCompra = 0;
        int sigo = 1;
        System.out.println("Escriba el saldo de la tarjeta: ");
        saldo=teclado.nextInt();
        Tarjetas tarjetaUsuario = new Tarjetas(saldo);
        while( sigo == 1){
            System.out.println("Escriba el nombre del producto");
            nombreP = teclado.next();
            System.out.println("Escriba el precio del producto");
            precioP = teclado.nextInt();
            if( saldo >= (totalCompra+precioP) ){
                listaProductos.add(new Productos(nombreP,precioP));
                System.out.println("Compra Realizada Con Exito!!!");
                totalCompra += precioP;
            }else{
                System.out.println("Imposible Realizar La Compra, Saldo Insuficiente");
            }
            System.out.println("Escriba 0 para salir o 1 para seguir comprando");
            sigo = teclado.nextInt();
        }

        System.out.println("compra de los Productos, Saldo:"+saldo);
        listaProductos.forEach(o-> System.out.println(o.toString()));
        listaProductos.sort(Comparator.comparing(Productos::getPrecio));
        System.out.println("Orden de compra de los Productos, Saldo:"+saldo);
        listaProductos.forEach(o-> System.out.println(o.toString()));




    }
}
