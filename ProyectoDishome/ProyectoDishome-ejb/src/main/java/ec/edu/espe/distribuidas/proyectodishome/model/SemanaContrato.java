/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.proyectodishome.model;

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
@Table(name="SEMANA_CONTRATO_07")
public class SemanaContrato {
    
    @Id
    @Column(name="COD_SEMANA", nullable=false)
    private String cod_semana;
    
    @Column(name="NRO_SEMANA")
    private Integer nro_semana;
    
    @Column(name="ANIO_DISPONIBLE")
    private Integer anio_disponible;

    /**
     * @return the cod_semana
     */
    public String getCod_semana() {
        return cod_semana;
    }

    /**
     * @param cod_semana the cod_semana to set
     */
    public void setCod_semana(String cod_semana) {
        this.cod_semana = cod_semana;
    }

    /**
     * @return the nro_semana
     */
    public Integer getNro_semana() {
        return nro_semana;
    }

    /**
     * @param nro_semana the nro_semana to set
     */
    public void setNro_semana(Integer nro_semana) {
        this.nro_semana = nro_semana;
    }

    /**
     * @return the anio_disponible
     */
    public Integer getAnio_disponible() {
        return anio_disponible;
    }

    /**
     * @param anio_disponible the anio_disponible to set
     */
    public void setAnio_disponible(Integer anio_disponible) {
        this.anio_disponible = anio_disponible;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + Objects.hashCode(this.cod_semana);
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
        final SemanaContrato other = (SemanaContrato) obj;
        if (!Objects.equals(this.cod_semana, other.cod_semana)) {
            return false;
        }
        return true;
    }
    
    
}
