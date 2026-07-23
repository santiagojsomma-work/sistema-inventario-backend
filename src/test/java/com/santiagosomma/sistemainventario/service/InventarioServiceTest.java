package com.santiagosomma.sistemainventario.service;

import com.santiagosomma.sistemainventario.exception.ProductoNoEncontradoException;
import com.santiagosomma.sistemainventario.exception.StockInsuficienteException;
import com.santiagosomma.sistemainventario.model.Producto;
import com.santiagosomma.sistemainventario.repository.ProductoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class InventarioServiceTest {

    @Mock
    private ProductoRepository repository;

    @InjectMocks
    private InventarioService service;

    private Producto productoPrueba;

    @BeforeEach
    void setUp() {
        productoPrueba = new Producto("P100", "Teclado Mecanico", 80.0, 10);
    }

    @Test
    void registrarProducto_Exitoso() {
        when(repository.save(any(Producto.class))).thenReturn(productoPrueba);

        Producto registrado = service.registrarProducto(productoPrueba);

        assertNotNull(registrado);
        assertEquals("Teclado Mecanico", registrado.getNombre());
        verify(repository, times(1)).save(productoPrueba);
    }

    @Test
    void registrarProducto_PrecioInvalido_LanzaExcepcion() {
        Producto productoInvalido = new Producto("P101", "Mouse", 0.0, 5);

        assertThrows(IllegalArgumentException.class, () -> {
            service.registrarProducto(productoInvalido);
        });

        verify(repository, never()).save(any());
    }

    @Test
    void procesarVenta_Exitoso() throws ProductoNoEncontradoException, StockInsuficienteException {
        when(repository.findById("P100")).thenReturn(Optional.of(productoPrueba));
        when(repository.save(any(Producto.class))).thenReturn(productoPrueba);

        Producto actualizado = service.procesarVenta("P100", 3);

        assertEquals(7, actualizado.getStock());
        verify(repository, times(1)).save(productoPrueba);
    }

    @Test
    void procesarVenta_StockInsuficiente_LanzaExcepcion() {
        when(repository.findById("P100")).thenReturn(Optional.of(productoPrueba));

        assertThrows(StockInsuficienteException.class, () -> {
            service.procesarVenta("P100", 20);
        });

        verify(repository, never()).save(any());
    }

    @Test
    void buscarPorId_ProductoNoEncontrado_LanzaExcepcion() {
        when(repository.findById("NO_EXISTE")).thenReturn(Optional.empty());

        assertThrows(ProductoNoEncontradoException.class, () -> {
            service.buscarPorId("NO_EXISTE");
        });
    }
}