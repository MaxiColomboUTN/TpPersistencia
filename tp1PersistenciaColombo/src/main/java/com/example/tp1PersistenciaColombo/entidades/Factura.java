package com.example.tp1PersistenciaColombo.entidades;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data

public class Factura extends BaseEntidad{

    private String fecha;
    private int numero;
    private Double descuento;
    //private String[] formaPago = {"efectivo","etc"};
    //enum formaPago {Efectivo,Etc}
    private String formaPago;
    private int total;

    public void MostrarFactura(){

    }


}
