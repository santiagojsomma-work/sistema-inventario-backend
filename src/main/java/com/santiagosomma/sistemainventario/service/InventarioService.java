package com.santiagosomma.sistemainventario.service;

import com.santiagosomma.sistemainventario.exception.ProductoNoEncontradoException;
import com.santiagosomma.sistemainventario.exception.StockInsuficienteException;
import com.santiagosomma.sistemainventario.model.Producto;
import com.santiagosomma.sistemainventario.repository.ProductoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class InventarioService {

    private final ProductoRepository repository;

    public InventarioService(ProductoRepository repository) {
        this.repository = repository;
    }

    public Producto registrarProducto(Producto producto) {
        if (producto == null) {
            throw new IllegalArgumentException("El producto no puede ser nulo.");
        }
        if (producto.getPrecio() <= 0) {
            throw new IllegalArgumentException("El precio del producto debe ser mayor a cero.");
        }
        if (producto.getStock() < 0) {
            throw new IllegalArgumentException("El stock inicial no puede ser negativo.");
        }
        return repository.save(producto);
    }

    public Producto buscarPorId(String id) throws ProductoNoEncontradoException {
        return repository.findById(id)
                .orElseThrow(() -> new ProductoNoEncontradoException("Producto no encontrado con el ID: " + id));
    }

    public List<Producto> listarProductos() {
        return repository.findAll();
    }

    @Transactional
    public Producto procesarVenta(String productoId, int cantidad) 
            throws ProductoNoEncontradoException, StockInsuficienteException {
        
        if (cantidad <= 0) {
            throw new IllegalArgumentException("La cantidad a vender debe ser mayor a cero.");
        }

        Producto producto = buscarPorId(productoId);

        if (producto.getStock() < cantidad) {
            throw new StockInsuficienteException(
                "Stock insuficiente para el producto: " + producto.getNombre() + 
                ". Disponible: " + producto.getStock() + ", Solicitado: " + cantidad
            );
        }

        producto.setStock(producto.getStock() - cantidad);
        return repository.save(producto);
    }

    public void eliminarProducto(String id) throws ProductoNoEncontradoException {
        Producto producto = buscarPorId(id);
        repository.delete(producto);
    }
}