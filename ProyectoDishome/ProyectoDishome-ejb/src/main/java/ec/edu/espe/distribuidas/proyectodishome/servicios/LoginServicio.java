/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.proyectodishome.servicios;

import ec.edu.espe.distribuidas.proyectodishome.dao.LoginDao;
import ec.edu.espe.distribuidas.proyectodishome.model.Login;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 *
 * @author Freddy
 */
@LocalBean
@Stateless
public class LoginServicio {
    
    @EJB
    private LoginDao logindao;
    
    public Login obtenerusuario(String usuario){
        return this.logindao.findById(usuario, true);
    }
}
