package com.santiagosomma.sistemainventario.exception;


public class StockInsuficienteException extends Exception {
    public StockInsuficienteException(String mensaje) {
        super(mensaje);
    }
}