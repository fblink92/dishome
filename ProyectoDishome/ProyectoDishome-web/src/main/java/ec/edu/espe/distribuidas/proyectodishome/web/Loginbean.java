/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.proyectodishome.web;

import ec.edu.espe.distribuidas.proyectodishome.model.Login;
import ec.edu.espe.distribuidas.proyectodishome.servicios.LoginServicio;
import java.io.IOException;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.faces.application.FacesMessage;
import org.primefaces.context.RequestContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Freddy
 */
@ViewScoped
@ManagedBean
public class Loginbean {

    @EJB
    private LoginServicio loginservicio;
    private Login loginuser;
    private String username;
    private String password;
    private Boolean loggedIn;

    public Login getLoginuser() {
        return loginuser;
    }

    public void setLoginuser(Login loginuser) {
        this.loginuser = loginuser;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean estaLogeado() {
        return loggedIn;
    }

    public void login(ActionEvent event) throws IOException {
        RequestContext context = RequestContext.getCurrentInstance();
        FacesMessage message = null;

        if (username != null && password != null) {
            this.loginuser = loginservicio.obtenerusuario(username);
            if (this.loginuser != null && this.loginuser.getUsuario().equals(username) && this.loginuser.getPassword().equals(password)) {
                loggedIn = true;
                message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Welcome", username);
            } else {
                loggedIn = false;
                message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Loggin Error", "Invalid credentials");
            }

        }

        FacesContext.getCurrentInstance().addMessage(null, message);
        context.addCallbackParam("estaLogeado", loggedIn);
        if (loggedIn) {
            context.addCallbackParam("view", "faces/Principal.xhtml");
            //FacesContext.getCurrentInstance().getExternalContext().redirect("faces/Principal.xhtml");
        } else {
            //FacesContext.getCurrentInstance().getExternalContext().redirect("faces/index.xhtml");
            context.addCallbackParam("view", "faces/index.xhtml");
        }
    }

    public void logout() {
        RequestContext context = RequestContext.getCurrentInstance();
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
                .getExternalContext().getSession(false);
        session.invalidate();
        loggedIn = false;
        context.addCallbackParam("view", "faces/index.xhtml");
    }
}
