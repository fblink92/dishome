/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.proyectodishome.web;

import ec.edu.espe.distribuidas.proyectodishome.model.Login;
import ec.edu.espe.distribuidas.proyectodishome.servicios.LoginServicio;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import org.apache.commons.beanutils.BeanUtils;
import org.primefaces.context.RequestContext;

/**
 *
 * @author Freddy
 */
@ViewScoped
@ManagedBean
public class UsuarioBean extends BaseBean implements Serializable{
    
    @EJB 
    private LoginServicio usuarioservicio;


    
    private List<Login> usuarios;
    private Login usuario;
    private Login usuarioSelected;
    
    
    @PostConstruct
    public void inicializar() {
        usuarios = usuarioservicio.obtenertodos();
        this.usuario=new Login();

    }
    
    public void nuevo(){
        super.nuevo();
        this.usuario=new Login();
    }
    
    public void modificar(){
        super.modificar();
        this.usuario=new Login();
                try {
            BeanUtils.copyProperties(this.usuario, this.usuarioSelected);
            if(super.isEnModificar()){
            
            }
        } catch (Exception e) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error no controlado", e.getMessage()));
        }
    }
    
    public void eliminar(){
        this.usuario=new Login();
        try {
            BeanUtils.copyProperties(this.usuario, this.usuarioSelected);
            this.usuarioservicio.eliminarUsuario(this.usuario.getUsuario());
            this.usuarios.remove(this.usuario);
            this.setUsuarioSelected(null);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Registro Eliminado Corectamente"));

        } catch (Exception e) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error no controlado", e.getMessage()));
        } 
        this.reset();
    }
    
    public void aceptar(){
        if (this.isEnNuevo()) {
            usuarioservicio.crearUsuario(this.usuario);
            this.usuarios.add(0, usuario);

        } else {
            usuarioservicio.actualizarUsuario(this.usuario);
            try {
                BeanUtils.copyProperties(this.usuarioSelected, this.usuario);
            } catch (Exception e ) {
                
            }

        }
        RequestContext.getCurrentInstance().execute("PF('dlg').hide()");
        this.reset();
    }
        public List<Login> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Login> usuarios) {
        this.usuarios = usuarios;
    }

    public Login getUsuario() {
        return usuario;
    }

    public void setUsuario(Login usuario) {
        this.usuario = usuario;
    }

    public Login getUsuarioSelected() {
        return usuarioSelected;
    }

    public void setUsuarioSelected(Login usuarioSelected) {
        this.usuarioSelected = usuarioSelected;
    }
    
    
}
