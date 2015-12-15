/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.proyectodishome.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Freddy
 */
@Entity
@Table(name="HABITACION_07")
public class Habitacion implements Serializable{
    
    @Id
    @Column(name="COD_HABITACION", nullable = false)
    private String cod_habitacion;
    
    @Column(name="TIPO")
    private String tipo;
    
    @Column(name="NRO_PERSONAS_MIN")
    private Integer nro_personas_min;
    
    @Column(name="NRO_PERSONAS_MAX")
    private Integer nro_personas_max;
    
    @Column(name="PRECIO_NOCHE")
    private BigDecimal precio_noche;
    
    @Column(name="ESTADO_HABITACION")
    private String estado_habitacion;

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
     * @return the tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * @return the nro_personas_min
     */
    public Integer getNro_personas_min() {
        return nro_personas_min;
    }

    /**
     * @param nro_personas_min the nro_personas_min to set
     */
    public void setNro_personas_min(Integer nro_personas_min) {
        this.nro_personas_min = nro_personas_min;
    }

    /**
     * @return the nro_personas_max
     */
    public Integer getNro_personas_max() {
        return nro_personas_max;
    }

    /**
     * @param nro_personas_max the nro_personas_max to set
     */
    public void setNro_personas_max(Integer nro_personas_max) {
        this.nro_personas_max = nro_personas_max;
    }

    /**
     * @return the precio_noche
     */
    public BigDecimal getPrecio_noche() {
        return precio_noche;
    }

    /**
     * @param precio_noche the precio_noche to set
     */
    public void setPrecio_noche(BigDecimal precio_noche) {
        this.precio_noche = precio_noche;
    }

    /**
     * @return the estado_habitacion
     */
    public String getEstado_habitacion() {
        return estado_habitacion;
    }

    /**
     * @param estado_habitacion the estado_habitacion to set
     */
    public void setEstado_habitacion(String estado_habitacion) {
        this.estado_habitacion = estado_habitacion;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.cod_habitacion);
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
        final Habitacion other = (Habitacion) obj;
        if (!Objects.equals(this.cod_habitacion, other.cod_habitacion)) {
            return false;
        }
        return true;
    }
    
}
