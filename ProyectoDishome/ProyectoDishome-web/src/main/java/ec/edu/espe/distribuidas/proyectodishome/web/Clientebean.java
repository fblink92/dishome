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
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.view.ViewScoped;
import javax.servlet.http.HttpServletRequest;
import javax.sql.rowset.serial.SerialArray;
import org.apache.commons.beanutils.BeanUtils;
import org.primefaces.context.RequestContext;
import org.primefaces.event.RowEditEvent;
import org.primefaces.event.SelectEvent;

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
    private Cliente cliente1;
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
        this.cliente1=new Cliente();

    }

    @Override
    public void nuevo() {
       
        super.nuevo();
        this.cliente1=new Cliente();
    }

    @Override
    public void modificar() {
        
        super.modificar();
        this.cliente1 = new Cliente();
        

        try {
            BeanUtils.copyProperties(this.cliente1, this.clienteselected);
            if(super.isEnModificar()){
            System.out.println(""+ this.cliente1.getNombre());
            }
        } catch (Exception e) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error no controlado", e.getMessage()));
        }
    }

        public void eliminar()
    {
        this.cliente1=new Cliente();
        try {
            BeanUtils.copyProperties(this.cliente1, this.clienteselected);
            this.clienteservicio.eliminarCliente(this.cliente1.getCodigo_cliente());
            this.cliente.remove(this.cliente1);
            this.setClienteselected(null);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Registro Eliminado Corectamente"));

        } catch (Exception e) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error no controlado", e.getMessage()));
        } 
        this.reset();
    }

    public void crearmodificar()
    {
        if (this.isEnNuevo()) {
            clienteservicio.crearCliente(this.cliente1);
            this.cliente.add(0, cliente1);

        } else {
            clienteservicio.actualizarCliente(this.cliente1);
            try {
                BeanUtils.copyProperties(this.clienteselected, this.cliente1);
            } catch (Exception e ) {
                
            }

        }
        RequestContext.getCurrentInstance().execute("PF('dlg').hide()");
        this.reset();
    }
}
