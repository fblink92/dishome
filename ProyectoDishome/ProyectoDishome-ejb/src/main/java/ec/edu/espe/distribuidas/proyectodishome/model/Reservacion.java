/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.proyectodishome.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.*;

/**
 *
 * @author Freddy
 */
@Entity
@Table(name="RESERVACION_07")
public class Reservacion  implements Serializable{
    
    @Id
    @Column(name="COD_RESERVACION", nullable = false)
    private String codigo_reservacion;
    
    @Column(name="COD_CLIENTE")
    private String codigo_cliente;
    
    @Temporal(TemporalType.DATE)
    @Column(name="FECHA_RESERVACION")
    private Date fecha_reservacion;

    @JoinColumn(name="COD_CLIENTE", referencedColumnName = "COD_CLIENTE", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Cliente cliente;
    /**
     * @return the codigo_reservacion
     */
    public String getCodigo_reservacion() {
        return codigo_reservacion;
    }

    /**
     * @param codigo_reservacion the codigo_reservacion to set
     */
    public void setCodigo_reservacion(String codigo_reservacion) {
        this.codigo_reservacion = codigo_reservacion;
    }

    /**
     * @return the codigo_cliente
     */
    public String getCodigo_cliente() {
        return codigo_cliente;
    }

    /**
     * @param codigo_cliente the codigo_cliente to set
     */
    public void setCodigo_cliente(String codigo_cliente) {
        this.codigo_cliente = codigo_cliente;
    }

    public Date getFecha_reservacion() {
        return fecha_reservacion;
    }

    public void setFecha_reservacion(Date fecha_reservacion) {
        this.fecha_reservacion = fecha_reservacion;
    }

    /**
     * @return the fecha_reservacion
     */

    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.codigo_reservacion);
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
        final Reservacion other = (Reservacion) obj;
        if (!Objects.equals(this.codigo_reservacion, other.codigo_reservacion)) {
            return false;
        }
        return true;
    }
    
}
