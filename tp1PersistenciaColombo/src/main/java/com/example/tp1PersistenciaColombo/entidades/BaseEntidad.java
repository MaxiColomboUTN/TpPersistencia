package com.example.tp1PersistenciaColombo.entidades;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@MappedSuperclass
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaseEntidad implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //INCREMENTAL Y AUTONUMERICO EL IDENTITY
    private Long id;
}
