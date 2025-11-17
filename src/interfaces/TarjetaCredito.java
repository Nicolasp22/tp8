package interfaces;


public class TarjetaCredito implements PagoConDescuento {
    private static final double TASA_DESCUENTO = 0.05; // 5% de descuento

    @Override
    public void procesarPago(double monto) {
        System.out.println("Procesando pago con Tarjeta de Crédito por $" + monto);
        System.out.println("Pago con Tarjeta de Crédito exitoso.");
    }

    @Override
    public double aplicarDescuento(double monto) {
        System.out.println("Aplicando descuento de " + (TASA_DESCUENTO * 100) + "%...");
        return monto * (1 - TASA_DESCUENTO);
    }
}

