package com.aluraCursos.screenmatch.exceptions;

public class ErrorFechaLanzamientoUndefined extends RuntimeException {
    private String mensaje;
    public ErrorFechaLanzamientoUndefined(String mensaje) {
        this.mensaje = mensaje;

    }

    @Override
    public String getMessage() {
        return this.mensaje;
    }
}
