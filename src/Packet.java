package es.upm.dit.adsw.ej5;

/**
 * Un paquete de datos.
 *
 * @author jose a. manas
 * @version 15.3.2016
 */
public class Packet {
    private final Priority priority;
    private final int data;

    /**
     * Constructor.
     *
     * @param priority prioridad.
     * @param data     otros datos. No se usa.
     */
    public Packet(Priority priority, int data) {
        this.priority = priority;
        this.data = data;
    }

    /**
     * Getter.
     *
     * @return prioridad.
     */
    public Priority getPriority() {
        return priority;
    }

    /**
     * Getter.
     *
     * @return otros datos.
     */
    public int getData() {
        return data;
    }
}
