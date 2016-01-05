/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.proyectodishome.servicios;

import ec.edu.espe.distribuidas.proyectodishome.dao.LoginDao;
import ec.edu.espe.distribuidas.proyectodishome.exceptions.ValidacionException;
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
    public List<Login> obtenertodos(){
        return this.logindao.findAll();
        
    }
    public void crearUsuario(Login usuario) throws ValidacionException {
        Login usuariotmp = this.obtenerusuario(usuario.getUsuario());
        if (usuariotmp == null) {
            this.logindao.insert(usuario);
        } else {
            throw new ValidacionException("El usuario " + usuario.getUsuario() + " ya existe");
        }
    }
    
        public void actualizarUsuario(Login usuario) {
        this.logindao.update(usuario);
    }
         public void eliminarUsuario(String usuario) {
        try {
            Login usuariotmp = this.obtenerusuario(usuario);
            this.logindao.remove(usuariotmp);
        } catch (Exception e) {
            throw new ValidacionException("El Usuario " + usuario + " esta asociada a una reservacion");
        }
    }
}
