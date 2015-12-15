/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.proyectodishome.servicios;

import ec.edu.espe.distribuidas.proyectodishome.dao.ClienteDao;
import ec.edu.espe.distribuidas.proyectodishome.exceptions.ValidacionException;
import ec.edu.espe.distribuidas.proyectodishome.model.Cliente;
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
public class ClienteServicio {

    @EJB
    private ClienteDao clientedao;

    public List<Cliente> obtenerTodos() {
        return this.clientedao.findAll();
    }

    public Cliente obtenerPorID(String codigocliente) {
        return this.clientedao.findById(codigocliente, false);
    }

    public void crearCliente(Cliente cliente) throws ValidacionException {
        Cliente clientetmp = this.obtenerPorID(cliente.getCodigo_cliente());
        if (clientetmp == null) {
            this.clientedao.insert(cliente);
        } else {
            throw new ValidacionException("El codigo es " + cliente.getCodigo_cliente() + " ya existe");
        }
    }

}
