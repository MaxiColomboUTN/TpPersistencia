package com.example.tp1PersistenciaColombo.repositorios;

import com.example.tp1PersistenciaColombo.entidades.Cliente;
import com.example.tp1PersistenciaColombo.entidades.DetallePedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetallePedidoRepository extends JpaRepository<DetallePedido,Long> {
}
