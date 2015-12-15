/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.proyectodishome.model;

import java.io.Serializable;
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
@Table(name="SERVICIOS_07")
public class Servicios implements Serializable{
    
    @Id
    @Column(name="COD_SERVICIOS", nullable=false)
    private String cod_servicios;
    
    @Column(name="DESCRIPCION")
    private String descripcion;
    
    @Column(name = "ESTADO_SERVICIO")
    private String estado_servicio;
    
    @Column(name = "TARIFA")
    private String tarifa;

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
     * @return the estado_servicio
     */
    public String getEstado_servicio() {
        return estado_servicio;
    }

    /**
     * @param estado_servicio the estado_servicio to set
     */
    public void setEstado_servicio(String estado_servicio) {
        this.estado_servicio = estado_servicio;
    }

    /**
     * @return the tarifa
     */
    public String getTarifa() {
        return tarifa;
    }

    /**
     * @param tarifa the tarifa to set
     */
    public void setTarifa(String tarifa) {
        this.tarifa = tarifa;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 41 * hash + Objects.hashCode(this.cod_servicios);
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
        final Servicios other = (Servicios) obj;
        if (!Objects.equals(this.cod_servicios, other.cod_servicios)) {
            return false;
        }
        return true;
    }
    
}
