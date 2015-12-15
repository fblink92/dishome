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
public class DetalleReservacionPK  implements Serializable{
   protected String cod_reservacion;
   protected String cod_habitacion;

    /**
     * @return the cod_reservacion
     */
    public String getCod_reservacion() {
        return cod_reservacion;
    }

    /**
     * @param cod_reservacion the cod_reservacion to set
     */
    public void setCod_reservacion(String cod_reservacion) {
        this.cod_reservacion = cod_reservacion;
    }

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

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + Objects.hashCode(this.cod_reservacion);
        hash = 37 * hash + Objects.hashCode(this.cod_habitacion);
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
        final DetalleReservacionPK other = (DetalleReservacionPK) obj;
        if (!Objects.equals(this.cod_reservacion, other.cod_reservacion)) {
            return false;
        }
        if (!Objects.equals(this.cod_habitacion, other.cod_habitacion)) {
            return false;
        }
        return true;
    }
   
}
