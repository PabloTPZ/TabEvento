package com.example.hola.eventotab.clases;

/**
 * Created by Ivan on 2/8/2016.
 */
public class Evento {
    String keyEvento;
    String tituloEvento;
    String horaEvento;
    String nombreExpositorEvento;
    String imagenEvento;

    public Evento(String keyEvento, String tituloEvento, String horaEvento, String nombreExpositorEvento, String imagenEvento) {
        this.keyEvento = keyEvento;
        this.tituloEvento = tituloEvento;
        this.horaEvento = horaEvento;
        this.nombreExpositorEvento = nombreExpositorEvento;
        this.imagenEvento = imagenEvento;
    }

    public String getKeyEvento() {
        return keyEvento;
    }

    public String getTituloEvento() {
        return tituloEvento;
    }

    public String getHoraEvento() {
        return horaEvento;
    }

    public String getNombreExpositorEvento() {
        return nombreExpositorEvento;
    }

    public String getImagenEvento() {
        return imagenEvento;
    }

    public void setKeyEvento(String keyEvento) {
        this.keyEvento = keyEvento;
    }

    public void setTituloEvento(String tituloEvento) {
        this.tituloEvento = tituloEvento;
    }

    public void setHoraEvento(String horaEvento) {
        this.horaEvento = horaEvento;
    }

    public void setNombreExpositorEvento(String nombreExpositorEvento) {
        this.nombreExpositorEvento = nombreExpositorEvento;
    }

    public void setImagenEvento(String imagenEvento) {
        this.imagenEvento = imagenEvento;
    }
}
