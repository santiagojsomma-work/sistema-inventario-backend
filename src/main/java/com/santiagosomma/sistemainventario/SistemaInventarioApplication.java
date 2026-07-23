package com.santiagosomma.sistemainventario;

import com.santiagosomma.sistemainventario.model.Producto;
import com.santiagosomma.sistemainventario.repository.ProductoRepository;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@OpenAPIDefinition(
    info = @Info(
        title = "Sistema de Gestión de Inventario API",
        version = "1.0",
        description = "Documentación interactiva de la API REST para el control de inventario y procesamiento de ventas."
    )
)
public class SistemaInventarioApplication {

    public static void main(String[] args) {
        SpringApplication.run(SistemaInventarioApplication.class, args);
    }

    @Bean
    public CommandLineRunner initData(ProductoRepository repository) {
        return args -> {
            repository.save(new Producto("P001", "Monitor LG 27", 250.0, 10));
            repository.save(new Producto("P002", "Teclado Mecanico", 85.0, 15));
            System.out.println("--- DATOS DE PRUEBA CARGADOS CORRECTAMENTE ---");
        };
    }
}