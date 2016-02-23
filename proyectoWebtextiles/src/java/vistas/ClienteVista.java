/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
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
    private InputText txtDireccionCliente;
    private InputText txtCorreoCliente;
    private InputText txtTelefonocliente;
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
    public InputText getTxtCedulaCliente() {
        return txtCedulaCliente;
    }

    public void setTxtCedulaCliente(InputText txtCedulaCliente) {
        this.txtCedulaCliente = txtCedulaCliente;
    }

    public InputText getTxtNombreCliente() {
        return txtNombreCliente;
    }

    public void setTxtNombreCliente(InputText txtNombreCliente) {
        this.txtNombreCliente = txtNombreCliente;
    
    }
    
     public InputText getTxtDireccionCliente() {
        return txtDireccionCliente;
    }

    public void setTxtDireccionCliente(InputText txtDireccionCliente) {
        this.txtDireccionCliente = txtDireccionCliente;
    }
     public InputText getTxtCorreoCliente() {
        return txtCorreoCliente;
    }

    public void setTxtCorreoCliente(InputText txtCorreoClientge) {
        this.txtCorreoCliente = txtCorreoClientge;
    }
    

    public CommandButton getBtnRegistrar() {
        return btnRegistrar;
    }

    public void setBtnRegistrar(CommandButton btnRegistrar) {
        this.btnRegistrar = btnRegistrar;
    }

    public CommandButton getBtnModificar() {
        return btnModificar;
    }

    public void setBtnModificar(CommandButton btnModificar) {
        this.btnModificar = btnModificar;
    }

    public CommandButton getBtnEliminar() {
        return btnEliminar;
    }

    public void setBtnEliminar(CommandButton btnEliminar) {
        this.btnEliminar = btnEliminar;
    }

    public CommandButton getBtnLimpiar() {
        return btnLimpiar;
    }

    public void setBtnLimpiar(CommandButton btnLimpiar) {
        this.btnLimpiar = btnLimpiar;
    }

    public List<Cliente> getListaCliente() {
        if(listaClientes==null){
            try {
                listaClientes = clientelogica.findAll();
            } catch (Exception ex) {
                Logger.getLogger(ClienteVista.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return listaClientes;
    }

    public void setListaCliente(List<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }

    public Cliente getSelectedCliente() {
        return selectedCliente;
    }

    public void setSelectedCliente(Cliente selectedCliente) {
        this.selectedCliente = selectedCliente;
    }
    
    
    public void accion_registrar(){
        try {
            Cliente nuevocliente = new Cliente();
            nuevocliente.setCedulaCliente(Long.parseLong(txtCedulaCliente.getValue().toString()));
            nuevocliente.setNombreCliente(txtNombreCliente.getValue().toString());
            nuevocliente.setDireccionCliente(txtDireccionCliente.getValue().toString());
            nuevocliente.setCorreoCliente(txtCorreoCliente.getValue().toString());
            nuevocliente.setCelularCliente(txtTelefonocliente.getValue().toString());
            clientelogica.create(nuevocliente);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Mensaje", "El cliente se registró correctamente."));
            listaClientes = null;
            limpiar();
        }catch(NumberFormatException e){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "El número del cliente debe ser numerico"));
        }catch (Exception  ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", ex.getMessage()));
        }
    }
    
    public void limpiar(){
        txtCedulaCliente.setValue("");
        txtNombreCliente.setValue("");
        txtDireccionCliente.setValue("");
        txtCorreoCliente.setValue("");
        txtTelefonocliente.setValue("");
        btnRegistrar.setDisabled(false);
        btnModificar.setDisabled(true);
        btnEliminar.setDisabled(true);
    }
      public void modificar(){
        try {
            Cliente m = new Cliente();
            m.setCedulaCliente(Long.parseLong(txtCedulaCliente.getValue().toString()));
            m.setNombreCliente(txtNombreCliente.getValue().toString());
            m.setDireccionCliente(txtDireccionCliente.getValue().toString());
            m.setCorreoCliente(txtCorreoCliente.getValue().toString());
            m.setCelularCliente(txtTelefonocliente.getValue().toString());
           clientelogica.edit(m);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Mensaje", "El cliente se  modifico correctamente"));
        listaClientes = null;
        } catch (Exception ex) {
            Logger.getLogger(ClienteVista.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public void eliminar(){
        try {
            Cliente m = new Cliente();
            m.setCedulaCliente(Long.parseLong(txtCedulaCliente.getValue().toString()));            
            clientelogica.remove(m);
             limpiar();
            listaClientes =null;
            FacesContext.getCurrentInstance().addMessage("Mensaje", new FacesMessage(FacesMessage.SEVERITY_INFO, "Informacion", "El cliente se eliminó con Éxito"));
        } catch (Exception ex) {
            Logger.getLogger(ClienteVista.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
}
