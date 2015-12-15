/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.proyectodishome.servicios;

import ec.edu.espe.distribuidas.proyectodishome.dao.LoginDao;
import ec.edu.espe.distribuidas.proyectodishome.model.Cliente;
import ec.edu.espe.distribuidas.proyectodishome.model.Login;
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
public class LoginServicio {
    
    @EJB
    private LoginDao logindao;
    
    public Login obtenerusuario(String usuario){
        List<Login> usuarios;
        Login login;
        Login tmp=new Login();
        tmp.setUsuario(usuario);
        usuarios=this.logindao.find(tmp);
        if(usuarios.size()==1){
            login=usuarios.get(0);
            return login;
        }else{
            login=null;
            return login;
        }
        
        
    }
}
