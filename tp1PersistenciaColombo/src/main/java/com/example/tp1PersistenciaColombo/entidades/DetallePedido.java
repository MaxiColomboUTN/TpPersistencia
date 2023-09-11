package com.example.tp1PersistenciaColombo.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data

public class DetallePedido extends BaseEntidad{

    private int cantidad;
    private Double subtotal;

    @ManyToOne(cascade = CascadeType.PERSIST,fetch = FetchType.EAGER)
    @JoinColumn(name = "producto_detalle_id")
    //@Builder.Default COMENTADO POR QUE TIRA ERROR BUILDER LINEA 15
    private Producto producto;

    public void mostrarPrdocuto(){
        System.out.println("Tipo : " + producto.getTipo() + " Stock Actual: " + producto.getStockActual() + " Strock Minimo: " + producto.getStockMinimo() +  " Precio Compra: " + producto.getPrecioCompra() + " Precio Venta: " + producto.getPrecioVenta());
    }

}
