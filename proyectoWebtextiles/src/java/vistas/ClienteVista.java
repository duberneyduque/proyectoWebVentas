/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import logica.ClienteLogicaLocal;
import modelo.Cliente;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputtext.InputText;

/**
 *
 * @author Estudiante
 */
@ManagedBean(name="ClienteVista")
@RequestScoped
public class ClienteVista {
    private InputText txtCedulaCliente;
    private InputText txtNombreCliente;
    private CommandButton btnRegistrar;
    private CommandButton btnModificar;
    private CommandButton btnEliminar;
    private CommandButton btnLimpiar;
    private List<Cliente> listaClientes;
    private Cliente selectedCliente;  
    
    @EJB
    private ClienteLogicaLocal clientelogica;
   
    public ClienteVista() {
    }
    
    
    
}
