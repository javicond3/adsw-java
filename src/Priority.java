package es.upm.dit.adsw.ej5;

/**
 * Prioridad relativa de los paquetes de datos.
 * @author jose a. manas
 * @version 18.3.2016
 */
public enum Priority {
    BAJA, MEDIA, ALTA;

    /**
     * Elige aleatoriamente.
     * @return una prioridad.
     */
    public static Priority random() {
        Priority[] values = values();
        int random = (int) (Math.random() * values.length);
        return values[random];
    }
}
