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
public class Rubro extends BaseEntidad{
    private String denominacion;

    @OneToMany(cascade = CascadeType.PERSIST, orphanRemoval = true,fetch = FetchType.EAGER)
    @JoinColumn(name = "producto_rubro_id")
    @Builder.Default //SI NO LO PONEMOS TIRA ERROR LA VERDAD NO SE PARA QUE FUNCIONA
    private List<Producto> productos = new ArrayList<>();


    public void agregarProducto(Producto producto){
        productos.add(producto);
    }

    public void mostrarRubro() {
        System.out.println("Denominacion: " + denominacion );
        for (Producto producto : productos) {
            System.out.println("Tipo : " + producto.getTipo() + " Stock Actual: " +  producto.getStockActual());

        }


    }
}
