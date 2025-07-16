package org.alilopez.model;

public class Carrito {
    private int idCliente;
    private float total;

    public Carrito(int idCliente, float total) {
        this.idCliente = idCliente;
        this.total = total;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }
}
