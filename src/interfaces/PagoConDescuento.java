package interfaces;

public interface PagoConDescuento extends Pago {
    /** Aplica un descuento al monto total. */
    double aplicarDescuento(double monto);
}