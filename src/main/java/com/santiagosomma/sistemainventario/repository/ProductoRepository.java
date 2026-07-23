package com.santiagosomma.sistemainventario.repository;

import com.santiagosomma.sistemainventario.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, String> {
}