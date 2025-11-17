package interfaces;

import java.util.ArrayList;
import java.util.List;

public class Pedido implements Pagable {
    private List<Producto> productos;
    private Cliente cliente;
    private String estado;

    public Pedido(Cliente cliente) {
        this.productos = new ArrayList<>();
        this.cliente = cliente;
        this.estado = "PENDIENTE";
        // Notificar al cliente al crear el pedido
        notificarCambioEstado();
    }

    public void agregarProducto(Producto p) {
        this.productos.add(p);
    }

    public void setEstado(String nuevoEstado) {
        this.estado = nuevoEstado;
        notificarCambioEstado();
    }

    private void notificarCambioEstado() {
        String mensaje = "Su pedido ahora está en estado: " + this.estado;
        if (cliente != null) {
            cliente.notificar(mensaje); // La clase Cliente implementa Notificable
        }
    }

    @Override
    public double calcularTotal() {
        double total = 0;
        for (Producto p : productos) {
            total += p.calcularTotal();
        }
        return total;
    }

    public Cliente getCliente() {
        return cliente;
    }
}