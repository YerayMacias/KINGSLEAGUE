package Modelo.ClasesObjetos;

import java.time.LocalDate;
/**
 * @author Explotacion de Iker
 * @version 1.0
 */
public class XML {
    /**
     * String del XML para convertir
     */
    private String xml;
    /**
     * Fecha en la que expira el XML
     */
    private LocalDate fechaExpiracion;

    /**
     * Constructor completo de XML
     * @param xml
     * @param fechaExpiracion
     */
    public XML(String xml, LocalDate fechaExpiracion) {
        this.xml = xml;
        this.fechaExpiracion = fechaExpiracion;
    }

    public String getXml() {
        return xml;
    }

    public void setXml(String xml) {
        this.xml = xml;
    }

    public LocalDate getFechaExpiracion() {
        return fechaExpiracion;
    }

    public void setFechaExpiracion(LocalDate fechaExpiracion) {
        this.fechaExpiracion = fechaExpiracion;
    }
}
