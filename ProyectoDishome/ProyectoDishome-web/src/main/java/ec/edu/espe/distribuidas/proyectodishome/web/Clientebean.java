/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.proyectodishome.web;

import ec.edu.espe.distribuidas.proyectodishome.model.Cliente;
import ec.edu.espe.distribuidas.proyectodishome.servicios.ClienteServicio;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;

/**
 *
 * @author Freddy
 */
@ViewScoped
@ManagedBean
public class Clientebean {
    
    @EJB
    private ClienteServicio clienteservicio;
    
    private List<Cliente> cliente;

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
    @PostConstruct
    public void inicializar(){
    cliente=clienteservicio.obtenerTodos();
   }
}
