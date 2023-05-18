package Modelo.ClasesObjetos;

import java.time.LocalDate;

public class XML {
    private String xml;
    private LocalDate fechaExpiracion;

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
