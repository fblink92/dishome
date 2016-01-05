/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.proyectodishome.web;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;

/**
 *
 * @author Freddy
 */
@ViewScoped
@ManagedBean
public class BaseBean implements Serializable{

    private boolean enNuevo;
    private boolean enModificar;

    public void nuevo() {
        this.enNuevo = true;
        this.enModificar=false;
    }

    public void modificar() {
        this.enModificar = true;
        this.enNuevo=false;
    }

    public void cancelar() {
        this.reset();
    }

    public void reset() {
        this.enModificar = false;
        this.enNuevo = false;
    }

    public boolean isEnNuevo() {
        return enNuevo;
    }

    public void setEnNuevo(boolean enNuevo) {
        this.enNuevo = enNuevo;
    }

    public boolean isEnModificar() {
        return enModificar;
    }

    public void setEnModificar(boolean enModificar) {
        this.enModificar = enModificar;
    }

}
