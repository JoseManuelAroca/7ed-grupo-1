package com.atm.buenas_practicas_java.enums;

public enum Status {
    WAITING("ESPERANDO"), ON_PROGRESS("EN PROGRESO"), EXPIRED("CADUCADO"), FINISHED("FINALIZADO");

    private final String description;

    Status(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
