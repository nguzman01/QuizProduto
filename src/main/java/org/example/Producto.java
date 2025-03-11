package org.example;

public class Producto {

    private String codigoProducto;
    private String nombreProducto;
    private double precioProducto;
    private int cantidadStock;

    // constructores


    public Producto() {
    }

    public Producto(String codigoProducto, String nombreProducto, double precioProducto, int cantidadStock) {
        this.codigoProducto = codigoProducto;
        this.nombreProducto = nombreProducto;
        this.precioProducto = precioProducto;
        this.cantidadStock = cantidadStock;
    }
// metodo get y set


    public String getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(String codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public double getPrecioProducto() {
        return precioProducto;
    }

    public void setPrecioProducto(double precioProducto) {
        this.precioProducto = precioProducto;
    }

    public int getCantidadStock() {
        return cantidadStock;
    }

    public void setCantidadStock(int cantidadStock) {
        this.cantidadStock = cantidadStock;
    }


    // metodos


    public boolean venderProducto(int unidades) {
        if (unidades <= cantidadStock) {
            cantidadStock -= unidades;
            System.out.println("Se vendieron " + unidades + " " + nombreProducto);
        } else {
            System.out.println("No hay suficiente Stock para vender ");

        }
        return false;
    }

    //
    public void reponerStock(int unidades){
        cantidadStock += unidades;
        System.out.println("Stock repuesto con "+ unidades + " unidades" + nombreProducto);
    }

    //
    public void aplicarDescuento(double porcentaje){
        precioProducto -= precioProducto *(porcentaje/100);
        System.out.println("se realizo un descuento del 2%");
    }
    //
    public void mostrarInformacion (){
        System.out.println("El codigo del producto es: "+ codigoProducto);
        System.out.println("Nombre: "+ nombreProducto);
        System.out.println("Precio: "+precioProducto);
        System.out.println("La cantidad en Stock es: "+cantidadStock);
    }

    //
    public void aumentarPrecio (double porcentaje){
        precioProducto += precioProducto *(porcentaje/100);
        System.out.println("se realizo un aumento del 6%");
    }

    //
    public double calculaValorTotalInventario (){
        return cantidadStock * precioProducto;
    }


}
