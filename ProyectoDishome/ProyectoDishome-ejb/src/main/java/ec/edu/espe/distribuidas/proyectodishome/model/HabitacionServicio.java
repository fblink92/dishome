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
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Entity;

/**
 *
 * @author Freddy
 */

@Entity
@Table(name="HABITACION_SERVICIOS_07")
@IdClass(HabitacionServicioPK.class)
public class HabitacionServicio implements Serializable{
    
    @Id
    @Column(name="COD_HABITACION")
    private String cod_habitacion;
    
    @Id
    @Column(name="COD_SERVICIOS")
    private String cod_servicios;
    
    @Column(name="GASTOS_ADICIONALES")
    private BigDecimal gastos_varios;
    
    @JoinColumn(name="COD_SERVICIOS", referencedColumnName = "COD_SERVICIOS", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Servicios servicios;
    
    @JoinColumn(name="COD_HABITACION", referencedColumnName = "COD_HABITACION", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Habitacion habitacion;

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
     * @return the cod_servicios
     */
    public String getCod_servicios() {
        return cod_servicios;
    }

    /**
     * @param cod_servicios the cod_servicios to set
     */
    public void setCod_servicios(String cod_servicios) {
        this.cod_servicios = cod_servicios;
    }

    /**
     * @return the gastos_varios
     */
    public BigDecimal getGastos_varios() {
        return gastos_varios;
    }

    /**
     * @param gastos_varios the gastos_varios to set
     */
    public void setGastos_varios(BigDecimal gastos_varios) {
        this.gastos_varios = gastos_varios;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + Objects.hashCode(this.cod_habitacion);
        hash = 89 * hash + Objects.hashCode(this.cod_servicios);
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
        final HabitacionServicio other = (HabitacionServicio) obj;
        if (!Objects.equals(this.cod_habitacion, other.cod_habitacion)) {
            return false;
        }
        if (!Objects.equals(this.cod_servicios, other.cod_servicios)) {
            return false;
        }
        return true;
    }
    
}
