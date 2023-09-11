package com.example.tp1PersistenciaColombo.repositorios;

import com.example.tp1PersistenciaColombo.entidades.Cliente;
import com.example.tp1PersistenciaColombo.entidades.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido,Long> {
}
