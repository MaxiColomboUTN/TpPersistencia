package com.example.tp1PersistenciaColombo.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Pedido extends BaseEntidad{
private String fecha;
//private String[] estado = {"iniciado", "preparacion", "entregado"};
private String estado;
private String horaEstimadaEntrega;
//private String[] tipoEnvio = {"delivery","retirada"};
private String tipoEnvio;
private Double total;
//****** PEDIDO - DETALLE PEDIDO ONE TO MANY UNI *****
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.EAGER)
    @JoinColumn(name = "detallePedido_id")
    @Builder.Default //SI NO LO PONEMOS TIRA ERROR LA VERDAD NO SE PARA QUE FUNCIONA
    private List<DetallePedido> detallePedido = new ArrayList<>();

//PEDIDO - FACTURA ONE TO ONE UNI *****
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "Factura_id")
    private Factura factura;

    public void agregarDetallePedido(DetallePedido detalles){
        detallePedido.add(detalles);
    }

    public void mostrarDetallePedido() {
        System.out.println("Fecha: " + fecha + " hora de entrega: " + horaEstimadaEntrega + " total: " + total );
        for (DetallePedido detalle : detallePedido) {
            System.out.println("Cantidad: " + detalle.getCantidad() + " subtotal: "+detalle.getSubtotal());

        }


    }

    public void mostrarFactura(){
        System.out.println("Numero: "  + factura.getNumero() + " Forma de pago: " + factura.getFormaPago() + " Total: " + factura.getTotal());
    }

}
