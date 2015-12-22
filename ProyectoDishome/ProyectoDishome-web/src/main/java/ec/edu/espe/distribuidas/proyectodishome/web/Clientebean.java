/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.proyectodishome.web;

import ec.edu.espe.distribuidas.proyectodishome.model.Cliente;
import ec.edu.espe.distribuidas.proyectodishome.model.Login;
import ec.edu.espe.distribuidas.proyectodishome.servicios.ClienteServicio;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.servlet.http.HttpServletRequest;
import javax.sql.rowset.serial.SerialArray;
import org.apache.commons.beanutils.BeanUtils;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author Freddy
 */
@ViewScoped
@ManagedBean
public class Clientebean extends BaseBean implements Serializable {

    @EJB
    private ClienteServicio clienteservicio;

    private List<Cliente> cliente;
    private Cliente cliente1 = new Cliente();
    private Cliente clienteselected;

    /**
     * @return the cliente
     */
    public List<Cliente> getCliente() {
        return cliente;
    }

    /**
     * @param cliente the cliente to set
     */
    public void setCliente(List<Cliente> cliente) {
        this.cliente = cliente;
    }

    public Cliente getCliente1() {
        return cliente1;
    }

    public void setCliente1(Cliente cliente1) {
        this.cliente1 = cliente1;
    }

    public Cliente getClienteselected() {
        return clienteselected;
    }

    public void setClienteselected(Cliente clienteselected) {
        this.clienteselected = clienteselected;
    }

    @PostConstruct
    public void inicializar() {
        cliente = clienteservicio.obtenerTodos();
    }

    @Override
    public void nuevo() {
        super.nuevo();
    }

    @Override
    public void modificar() {
        super.modificar();
        this.cliente1 = new Cliente();
        try {
            BeanUtils.copyProperties(this.cliente1, this.clienteselected);
        } catch (Exception e) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error no controlado", e.getMessage()));
        }
    }

    public void aceptar() {
        FacesContext context = FacesContext.getCurrentInstance();
        if (super.isEnNuevo()) {
            try {
                //Login usuario = (Login)((HttpServletRequest)context.getExternalContext().getRequest()).getSession().getAttribute("usuario");
                this.clienteservicio.crearCliente(this.cliente1);
                this.cliente.add(0, this.cliente1);
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Se registro el cliente: " + this.cliente1.toString(), null));
            } catch (Exception e) {

                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), null));
            }
        } else {
            try {
                //Llamar a modificar no a crear
                this.clienteservicio.actualizarCliente(this.cliente1);
                BeanUtils.copyProperties(this.clienteselected, this.cliente1);
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Se registro el cliente: " + this.cliente1.toString(), null));
            } catch (Exception e) {

                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), null));
            }
        }
        this.reset();
    }

}
