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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Freddy
 */
@Entity
@Table(name="PAGOS_MANTENIMIENTO_07")
public class PagosMantenimiento implements Serializable{
    
    @Id
    @Column(name="COD_PAGOS", nullable=false)
    private String cod_pagos;
    
    @Column(name="COD_HABITACION")
    private String cod_habitacion;
    
    @Column(name="DESCRIPCION")
    private String descripcion;
    
    @Column(name="VALOR")
    private BigDecimal valor;

   @JoinColumn(name="COD_HABITACION", referencedColumnName = "COD_HABITACION", insertable = false, updatable = false)
   @ManyToOne(optional = false)
   private Habitacion habitaicon;
    /**
     * @return the cod_pagos
     */
    public String getCod_pagos() {
        return cod_pagos;
    }

    /**
     * @param cod_pagos the cod_pagos to set
     */
    public void setCod_pagos(String cod_pagos) {
        this.cod_pagos = cod_pagos;
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
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * @return the valor
     */
    public BigDecimal getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.cod_pagos);
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
        final PagosMantenimiento other = (PagosMantenimiento) obj;
        if (!Objects.equals(this.cod_pagos, other.cod_pagos)) {
            return false;
        }
        return true;
    }
    
}
