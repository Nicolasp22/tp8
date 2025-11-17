package interfaces;

public class DemoInterfaces {
    public static void main(String[] args) {
        // 1. Crear Cliente y Pedido
        Cliente cliente = new Cliente("Ana Torres", "ana.t@email.com");
        Pedido pedido = new Pedido(cliente);

        // 2. Agregar Productos
        pedido.agregarProducto(new Producto("Laptop", 100));
        pedido.agregarProducto(new Producto("Mouse Inalámbrico", 25.50));

        // 3. Calcular Total y Notificar
        double totalOriginal = pedido.calcularTotal();
        System.out.println("\n--- Total del Pedido ---");
        System.out.println("Total Original: $" + totalOriginal);
        
        // 4. Pago con Descuento (TarjetaCredito)
        TarjetaCredito pagoTC = new TarjetaCredito();
        double totalConDescuento = pagoTC.aplicarDescuento(totalOriginal);
        System.out.println("Total con Descuento: $" + totalConDescuento);
        pagoTC.procesarPago(totalConDescuento);
        
        // 5. Notificar cambio de estado
        pedido.setEstado("ENVIADO");
        
        // 6. Pago sin Descuento (PayPal)
        System.out.println("\n--- Nuevo Pedido con PayPal ---");
        Pedido pedido2 = new Pedido(new Cliente("Juan Pérez", "juan@mail.net"));
        pedido2.agregarProducto(new Producto("Libro Java", 40.00));
        
        double total2 = pedido2.calcularTotal();
        System.out.println("Total a pagar con PayPal: $" + total2);
        new PayPal().procesarPago(total2);
        pedido2.setEstado("ENTREGADO");
    }
}
