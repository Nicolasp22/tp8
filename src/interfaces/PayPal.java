package interfaces;

// PayPal.java
public class PayPal implements Pago {
    @Override
    public void procesarPago(double monto) {
        System.out.println("Procesando pago con PayPal por $" + monto);
        // Lógica de integración con PayPal...
        System.out.println("Pago con PayPal exitoso.");
    }
}
