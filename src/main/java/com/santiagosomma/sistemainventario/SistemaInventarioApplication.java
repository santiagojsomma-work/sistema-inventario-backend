package com.santiagosomma.sistemainventario;

import com.santiagosomma.sistemainventario.model.Producto;
import com.santiagosomma.sistemainventario.repository.ProductoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
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