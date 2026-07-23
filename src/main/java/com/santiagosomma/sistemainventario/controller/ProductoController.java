package com.santiagosomma.sistemainventario.controller;

import com.santiagosomma.sistemainventario.exception.ProductoNoEncontradoException;
import com.santiagosomma.sistemainventario.exception.StockInsuficienteException;
import com.santiagosomma.sistemainventario.model.Producto;
import com.santiagosomma.sistemainventario.service.InventarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    private final InventarioService service;

    public ProductoController(InventarioService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Producto>> obtenerTodos() {
        return ResponseEntity.ok(service.listarProductos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Producto> obtenerPorId(@PathVariable String id) throws ProductoNoEncontradoException {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<Producto> crearProducto(@RequestBody Producto producto) {
        Producto creado = service.registrarProducto(producto);
        return new ResponseEntity<>(creado, HttpStatus.CREATED);
    }

    @PostMapping("/{id}/venta")
    public ResponseEntity<Producto> realizarVenta(
            @PathVariable String id, 
            @RequestParam int cantidad) throws ProductoNoEncontradoException, StockInsuficienteException {
        Producto actualizado = service.procesarVenta(id, cantidad);
        return ResponseEntity.ok(actualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarProducto(@PathVariable String id) throws ProductoNoEncontradoException {
        service.eliminarProducto(id);
        return ResponseEntity.noContent().build();
    }
}