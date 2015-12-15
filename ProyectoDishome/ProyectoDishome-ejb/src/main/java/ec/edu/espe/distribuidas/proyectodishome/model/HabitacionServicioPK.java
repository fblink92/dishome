/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.proyectodishome.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Freddy
 */
public class HabitacionServicioPK implements Serializable{
    
    protected String cod_habitacion;
    protected String cod_servicio;

    /**
     * @return the cod_habitacion
     */
    public String getCod_habitacion() {
        return cod_habitacion;
    }

    /**
     * @param cod_habitacion the cod_habitacion to set
     */
    public void setCod_habitacion(String cod_habitacion) {
        this.cod_habitacion = cod_habitacion;
    }

    /**
     * @return the cod_servicio
     */
    public String getCod_servicio() {
        return cod_servicio;
    }

    /**
     * @param cod_servicio the cod_servicio to set
     */
    public void setCod_servicio(String cod_servicio) {
        this.cod_servicio = cod_servicio;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.cod_habitacion);
        hash = 41 * hash + Objects.hashCode(this.cod_servicio);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final HabitacionServicioPK other = (HabitacionServicioPK) obj;
        if (!Objects.equals(this.cod_habitacion, other.cod_habitacion)) {
            return false;
        }
        if (!Objects.equals(this.cod_servicio, other.cod_servicio)) {
            return false;
        }
        return true;
    }
    
}
