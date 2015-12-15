/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.proyectodishome.dao;

import ec.edu.espe.distribuidas.dao.DefaultGenericDAOImple;
import ec.edu.espe.distribuidas.proyectodishome.model.HabitacionServicio;
import ec.edu.espe.distribuidas.proyectodishome.model.HabitacionServicioPK;
import java.io.Serializable;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 *
 * @author Freddy
 */
@LocalBean
@Stateless
public class HabitacionServicioDao extends DefaultGenericDAOImple<HabitacionServicio, HabitacionServicioPK>{
    
    public HabitacionServicioDao(){
        super(HabitacionServicio.class);
    }
}
