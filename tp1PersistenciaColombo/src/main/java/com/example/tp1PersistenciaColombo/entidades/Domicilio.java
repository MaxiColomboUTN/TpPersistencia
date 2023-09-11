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

public class Domicilio extends BaseEntidad{

    private String calle;
    private String numero;
    private String localidad;

//********DOMICILIO - PEDIDO  ONE TO MANY*******
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.EAGER)
    @JoinColumn(name = "pedido_id_domicilio")
    @Builder.Default //SI NO LO PONEMOS TIRA ERROR LA VERDAD NO SE PARA QUE FUNCIONA
    private List<Pedido> pedidosDomicilio = new ArrayList<>();


//********DOMICILIO - CLIENTE  MANY TO ONE **********
    @ManyToOne(cascade = CascadeType.PERSIST,fetch = FetchType.EAGER)
    @JoinColumn(name = "domicilio_cliente")
    //@Builder.Default COMENTADO POR QUE TIRA ERROR BUILDER LINEA 15
    private Cliente cliente;

    public void agregarPedidoDomicilio(Pedido pedido){
        pedidosDomicilio.add(pedido);
    }

    public void mostrarPedidoCliente() {
        System.out.println("Calle: " + calle + "numero: " + numero + "localidad: " + localidad);
        for (Pedido pedido : pedidosDomicilio) {
            System.out.println("Fecha : " + pedido.getFecha() + ", Total: " + pedido.getTotal());
        }


    }





}
