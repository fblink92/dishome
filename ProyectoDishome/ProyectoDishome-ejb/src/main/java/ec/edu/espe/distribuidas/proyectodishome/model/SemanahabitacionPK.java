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
public class SemanahabitacionPK implements Serializable{
    
    protected String cod_semana;
    protected String cod_habitacion;

    public String getCod_semana() {
        return cod_semana;
    }

    public void setCod_semana(String cod_semana) {
        this.cod_semana = cod_semana;
    }

    public String getCod_habitacion() {
        return cod_habitacion;
    }

    public void setCod_habitacion(String cod_habitacion) {
        this.cod_habitacion = cod_habitacion;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 31 * hash + Objects.hashCode(this.cod_semana);
        hash = 31 * hash + Objects.hashCode(this.cod_habitacion);
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
        final SemanahabitacionPK other = (SemanahabitacionPK) obj;
        if (!Objects.equals(this.cod_semana, other.cod_semana)) {
            return false;
        }
        if (!Objects.equals(this.cod_habitacion, other.cod_habitacion)) {
            return false;
        }
        return true;
    }
   
}
