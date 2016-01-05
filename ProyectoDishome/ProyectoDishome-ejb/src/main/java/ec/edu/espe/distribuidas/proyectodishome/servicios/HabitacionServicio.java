/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.proyectodishome.servicios;

import ec.edu.espe.distribuidas.proyectodishome.dao.HabitacionDao;
import ec.edu.espe.distribuidas.proyectodishome.exceptions.ValidacionException;
import ec.edu.espe.distribuidas.proyectodishome.model.Habitacion;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 *
 * @author Freddy
 */
@LocalBean
@Stateless
public class HabitacionServicio {
    
    @EJB
    private HabitacionDao habitaciondao;
    
    public Habitacion obtenerhabitacionID(String codigo){
        return this.habitaciondao.findById(codigo, false);
    }
    
    public List<Habitacion> obtenertodas(){
        return this.habitaciondao.findAll();
    }
    
       public void crearhabitacion(Habitacion habitacion) throws ValidacionException {
        Habitacion habitaciontmp = this.obtenerhabitacionID(habitacion.getCod_habitacion());
        if (habitaciontmp == null) {
            this.habitaciondao.insert(habitacion);
        } else {
            throw new ValidacionException("El codigo es " + habitacion.getCod_habitacion() + " ya existe");
        }
    }

    public void actualizarHabitacion(Habitacion habitacion) {
        this.habitaciondao.update(habitacion);
    }

    public void eliminarHabitacion(String codigohabitacion) {
        try {
            Habitacion habitaciontmp = this.obtenerhabitacionID(codigohabitacion);
            this.habitaciondao.remove(habitaciontmp);
        } catch (Exception e) {
            throw new ValidacionException("El cliente " + codigohabitacion + " esta asociada a una reservacion");
        }
    } 
}
