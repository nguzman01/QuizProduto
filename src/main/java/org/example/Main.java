package org.example;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        List<Producto> productos = new ArrayList<>();
        Scanner teclado = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("Menu");
            System.out.println("1. Crear Producto ");
            System.out.println("2. Vender Producto");
            System.out.println("3. Reponer Stock");
            System.out.println("4. Aplicar Descuentos");
            System.out.println("5. Mostrar Información");
            System.out.println("6. Aumentar Precio");
            System.out.println("7. Calcular Valor Total de Inventario");
            System.out.println("8. Eliminar Productos por Codigo");
            System.out.println("9. Salir");
            opcion = teclado.nextInt();
            teclado.nextLine();

            switch (opcion){
                case 1:
                    System.out.println("Ingrese el codigo del producto");
                    String codigoProducto = teclado.nextLine();
                    System.out.println("Ingrese el nombre del producto");
                    String nombreProducto = teclado.nextLine();
                    System.out.println("Ingrese el precio ");
                    double precioProducto = teclado.nextDouble();
                    System.out.println(" Ingrese la cantidad en el Stock");
                    int cantidadStock = teclado.nextInt();
                    productos.add (new Producto(codigoProducto, nombreProducto, precioProducto,cantidadStock));

                    break;
                case 2:
                    System.out.println("Ingrese el codigo del producto a la ventata ");
                    String codigoVenta = teclado.nextLine();
                    System.out.println("Ingrese las unidaddes a vender");
                    int cantidadVenta = teclado.nextInt();
                    for (Producto prod : productos){

                        if(prod.getCodigoProducto().equals(codigoVenta)){

                            prod.venderProducto(cantidadVenta);
                            break;
                        }
                    }

                    break;
                case 3:
                    System.out.println("Ingrese el codigo del producto a reponer");
                    String codigoReponer = teclado.nextLine();
                    System.out.println("Ingrese las unidades a reponer ");
                    int cantidadReponer = teclado.nextInt();
                    for (Producto prod : productos){

                        if(prod.getCodigoProducto().equals(codigoReponer)){

                            prod.reponerStock(cantidadReponer);
                            break;
                        }
                    }


                    break;
                case 4:
                    System.out.println(" Aplicar Descuento ");
                    System.out.println(" ingrese el codigo del producto ");
                    String codigoDescuento = teclado.nextLine();
                    for (Producto prod : productos){

                        if(prod.getCodigoProducto().equals(codigoDescuento)){

                            prod.aplicarDescuento(2);
                            break;
                        }
                    }

                    break;
                case 5:
                    System.out.println("Ingrese el codigo del producto para mostar información");
                    String codigoInform = teclado.nextLine();
                    for (Producto prod : productos){

                        if(prod.getCodigoProducto().equals(codigoInform)){

                            prod.mostrarInformacion();
                            break;
                        }
                    }
                    break;
                case 6:
                    System.out.println("ingrese el codigo del producto ");
                    String codigoAumento = teclado.nextLine();
                    for (Producto prod : productos){

                        if(prod.getCodigoProducto().equals(codigoAumento)){

                            prod.aumentarPrecio(6);
                            break;
                        }
                    }
                    break;
                case 7:
                    double totalInventario = 0;
                    for (Producto prod : productos){
                        totalInventario += prod.calculaValorTotalInventario();
                    }
                    System.out.println("El valor total en el Inventario es: " +totalInventario);

                    break;
                case 8:
                    System.out.println("Ingrese el codigo del producto a eliminar");
                    String codigoEliminar = teclado.nextLine();
                    Iterator<Producto>iterator = productos.iterator();
                    boolean encontrado = false;
                    while(iterator.hasNext()){

                        Producto prod = iterator.next();
                        if(prod.getCodigoProducto().equals(codigoEliminar)){
                            iterator.remove();
                            System.out.println("El producto con codigo : " + codigoEliminar + "fue  eliminado");
                            encontrado = true;
                            break;
                        }
                    }
                    if (!encontrado){
                        System.out.println("El producto no fue encontrado");
                    }
                    break;
                case 9:
                    System.out.println("Saliste ");
                    break;

                default:
                    System.out.println("Opcion no validad vuelva a intentarlo");
                    break;


            }

        } while (opcion != 9);

teclado.close();
    }
}