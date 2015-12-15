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
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Freddy
 */
@Entity
@Table(name="DETALLE_RESERVACION_07")
@IdClass(DetalleReservacionPK.class)
public class DetalleReservacion implements Serializable{
    
    @Id
    @Column(name="COD_RESERVACION", nullable = false)
    private String cod_reservacion;
    
    @Id
    @Column(name="COD_HABITACION", nullable = false)
    private String cod_habitacion;
    
    @Column(name="NRO_NOCHES")
    private Integer nro_noches;
    
    @Column(name="IVA")
    private BigDecimal iva;
    
    @Column(name="DESCUENTO")
    private BigDecimal descuento;
    
    @Column(name="TOTAL")
    private BigDecimal total;
    
    @JoinColumn(name="COD_RESERVACION", referencedColumnName = "COD_RESERVACION", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Reservacion reservacion;
    
    @JoinColumn(name="COD_HABITACION", referencedColumnName = "COD_HABITACION", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Habitacion habitacion;

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

    /**
     * @return the nro_noches
     */
    public Integer getNro_noches() {
        return nro_noches;
    }

    /**
     * @param nro_noches the nro_noches to set
     */
    public void setNro_noches(Integer nro_noches) {
        this.nro_noches = nro_noches;
    }

    /**
     * @return the iva
     */
    public BigDecimal getIva() {
        return iva;
    }

    /**
     * @param iva the iva to set
     */
    public void setIva(BigDecimal iva) {
        this.iva = iva;
    }

    /**
     * @return the descuento
     */
    public BigDecimal getDescuento() {
        return descuento;
    }

    /**
     * @param descuento the descuento to set
     */
    public void setDescuento(BigDecimal descuento) {
        this.descuento = descuento;
    }

    /**
     * @return the total
     */
    public BigDecimal getTotal() {
        return total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + Objects.hashCode(this.cod_reservacion);
        hash = 53 * hash + Objects.hashCode(this.cod_habitacion);
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
        final DetalleReservacion other = (DetalleReservacion) obj;
        if (!Objects.equals(this.cod_reservacion, other.cod_reservacion)) {
            return false;
        }
        if (!Objects.equals(this.cod_habitacion, other.cod_habitacion)) {
            return false;
        }
        return true;
    }
    
    
    
}
