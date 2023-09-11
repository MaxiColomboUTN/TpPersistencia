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
public class Usuario extends BaseEntidad{

    private String nombre;
    private String password;
    private String rol;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.EAGER)
    @JoinColumn(name = "pedido_id_usuario") //fk
    @Builder.Default
    private List<Pedido> pedidosUsuario = new ArrayList<>();

//AGREGAR PEDIDO
    public void agregarPedidoUsuario(Pedido p1){
        pedidosUsuario.add(p1);
    }
//MOSTRAR EL PEDIDO
    public void mostrarPedidoUsuario() {

        System.out.println("Pedido de " +  nombre );

    }


}
