/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.proyectodishome.dao;

import ec.edu.espe.distribuidas.dao.DefaultGenericDAOImple;
import ec.edu.espe.distribuidas.proyectodishome.model.Login;
import java.io.Serializable;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 *
 * @author Freddy
 */
@LocalBean
@Stateless
public class LoginDao extends DefaultGenericDAOImple<Login, String>{

    public LoginDao() {
        super(Login.class);
    }
    
    
}
