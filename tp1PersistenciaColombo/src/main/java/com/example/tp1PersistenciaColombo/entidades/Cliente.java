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
public class Cliente extends BaseEntidad{

private String nombre;
private String apellido;
private String telefono;
private String email;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.EAGER)
    @JoinColumn(name = "pedido_id_cliente")
    @Builder.Default //SI NO LO PONEMOS TIRA ERROR LA VERDAD NO SE PARA QUE FUNCIONA
    private List<Pedido> pedidosCliente = new ArrayList<>();

    public void agregarPedidoCliente(Pedido pedido){
        pedidosCliente.add(pedido);
    }

    public void mostrarPedidoCliente() {
        System.out.println("Pedido de " + nombre + " " + apellido + ": ");
        for (Pedido pedido : pedidosCliente) {
            System.out.println("Fecha : " + pedido.getFecha() + ", Total: " + pedido.getTotal());
        }


    }


}
