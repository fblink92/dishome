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
@Table(name="SEMANA_HABITACION_07")
@IdClass(SemanahabitacionPK.class)
public class Semanahabitacion implements Serializable{
    
    @Id
    @Column(name="COD_SEMANA", nullable=false)
    private String cod_semana;
    
    @Id
    @Column(name="COD_HABITACION", nullable=false)
    private String cod_habitacion;
    
    @Column(name="TEMPORADA")
    private String temporada;
    
    @Column(name="TARIFA_TEMPORADA")
    private BigDecimal tarifa_temporada;

    @JoinColumn(name="COD_HABITACION", referencedColumnName = "COD_HABITACION", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Habitacion habitacion;
    
    @JoinColumn(name="COD_SEMANA", referencedColumnName = "COD_SEMANA", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private SemanaContrato semanacontrato;
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
     * @return the temporada
     */
    public String getTemporada() {
        return temporada;
    }

    /**
     * @param temporada the temporada to set
     */
    public void setTemporada(String temporada) {
        this.temporada = temporada;
    }

    /**
     * @return the tarifa_temporada
     */
    public BigDecimal getTarifa_temporada() {
        return tarifa_temporada;
    }

    /**
     * @param tarifa_temporada the tarifa_temporada to set
     */
    public void setTarifa_temporada(BigDecimal tarifa_temporada) {
        this.tarifa_temporada = tarifa_temporada;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + Objects.hashCode(this.cod_semana);
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
        final Semanahabitacion other = (Semanahabitacion) obj;
        if (!Objects.equals(this.cod_semana, other.cod_semana)) {
            return false;
        }
        if (!Objects.equals(this.cod_habitacion, other.cod_habitacion)) {
            return false;
        }
        return true;
    }
    
}
