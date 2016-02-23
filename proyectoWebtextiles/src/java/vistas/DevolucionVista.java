/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import logica.ClienteLogicaLocal;
import logica.DevolucionLogicaLocal;
import modelo.Cliente;
import modelo.Devolucion;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.component.selectonemenu.SelectOneMenu;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author Estudiante
 */
@ManagedBean  (name="DevolucionVista")
@RequestScoped
public class DevolucionVista {

private InputText txtCodigoDevolucion;
private InputText txtFechaDevolucion;
private InputText txtObservacionesDevolucion;
private InputText txtCedulacliente;
private SelectOneMenu cmbCliente;
 private ArrayList<SelectItem> opcionesCliente;
private CommandButton btnRegistrar;
private CommandButton btnModificar;
private CommandButton btnLimpiar;
private CommandButton btnEliminar;
private List<Devolucion> listaDevolucion;
private List<Cliente> listaCliente;
private List<Cliente> listaClienteSeleccionadas;
private Devolucion selectedDevolucion;
private Cliente selectedcliente;
   
@EJB
private DevolucionLogicaLocal devolucionlogica;

@EJB
private ClienteLogicaLocal clienteLogica;

    public DevolucionVista() {
    }
     public InputText getTxtCodigoDevolucion() {
        return txtCodigoDevolucion;
    }

    public void setTxtCodigoDevolucion(InputText txtCodigoDevolucion) {
        this.txtCodigoDevolucion = txtCodigoDevolucion;
    }

    public InputText getTxtFechaDevolucion() {
        return txtFechaDevolucion;
    }

    public void setTxtFechaDevolucion(InputText txtFechaDevolucion) {
        this.txtFechaDevolucion = txtFechaDevolucion;
    }

    public InputText getTxtObservacionesDevolucion() {
        return txtObservacionesDevolucion;
    }

    public void setTxtObservacionesDevolucion(InputText txtObservacionesDevolucion) {
        this.txtObservacionesDevolucion = txtObservacionesDevolucion;
    }

    public InputText getTxtCedulacliente(){
       return txtCedulacliente;
    }
    public void setTxCedulacliente(InputText txtCedulacliente){
        this.txtCedulacliente = txtCedulacliente;
    }
    
    public SelectOneMenu getCmbCliente() {
        return cmbCliente;
    }

    public void setCmbCliente(SelectOneMenu cmbCliente) {
        this.cmbCliente = cmbCliente;
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

    public CommandButton getBtnLimpiar() {
        return btnLimpiar;
    }

    public void setBtnLimpiar(CommandButton btnLimpiar) {
        this.btnLimpiar = btnLimpiar;
    }

    public CommandButton getBtnEliminar() {
        return btnEliminar;
    }

    public void setBtnEliminar(CommandButton btnEliminar) {
        this.btnEliminar = btnEliminar;
    }

    public List<Devolucion> getListaDevolucion() {
        if(listaDevolucion== null){
            try {
                listaDevolucion=devolucionlogica.findAll();
            } catch (Exception ex) {
                Logger.getLogger(DevolucionVista.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return listaDevolucion;
    }

    public void setListaDevolucion(List<Devolucion> listaDevolucions) {
        this.listaDevolucion = listaDevolucions;
    }

    public Devolucion getSelectedDevolucion() {
        return selectedDevolucion;
    }

    public void setSelectedDevolucion(Devolucion selectedDevolucion) {
        this.selectedDevolucion = selectedDevolucion;
    }
    public Cliente getSelectedCliente(){
        return selectedcliente;
    }
    public void setSelectedCliente (Cliente selectedCliente){
        this.selectedcliente = selectedCliente;
    }
    
     public void accion_registrar() {
        try {
            Devolucion nuevaDevolucion = new Devolucion();
            Cliente nuevocliente = new Cliente();
            nuevaDevolucion.setCodigoDevolucion(Integer.parseInt(txtCodigoDevolucion.getValue().toString()));
            nuevaDevolucion.setFechaDevolucion((Date)txtFechaDevolucion.getValue());
            nuevaDevolucion.setObservacionDevolucion(txtObservacionesDevolucion.getValue().toString());
            nuevocliente.setCedulaCliente(Long.parseLong(txtCedulacliente.getValue().toString()));
           devolucionlogica.create(nuevaDevolucion);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Mensaje", "La Devolucion  se a registro correctamente"));
            listaDevolucion = null;
        } catch (NumberFormatException ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "El codigo   debe ser un numero y no letras"));
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", ex.getMessage()));
        }
    }

    public void limpiar() {
        txtCodigoDevolucion.setValue("");
        txtFechaDevolucion.setValue("");
        txtObservacionesDevolucion.setValue("");
        txtCedulacliente.setValue("");
        btnRegistrar.setDisabled(false);
        btnModificar.setDisabled(true);
        btnEliminar.setDisabled(true);
    }
    
    public void seleccionar(SelectEvent e){
        Devolucion d = selectedDevolucion;
        Cliente c = selectedcliente;
        txtCodigoDevolucion.setValue(d.getCodigoDevolucion()+"");
        txtFechaDevolucion.setValue(d.getFechaDevolucion());
        txtObservacionesDevolucion.setValue(d.getObservacionDevolucion());
        txtCedulacliente.setValue(c.getCedulaCliente());
        btnModificar.setDisabled(false);
        btnEliminar.setDisabled(false);
        btnRegistrar.setDisabled(true);
    }
      public void onRowSelect(SelectEvent evt){
        Devolucion m = selectedDevolucion;
        txtCodigoDevolucion.setValue(m.getCodigoDevolucion());
        txtFechaDevolucion.setValue(m.getFechaDevolucion());
        txtObservacionesDevolucion.setValue(m.getObservacionDevolucion());
        cmbCliente.setValue(m.getCedulaCliente().getCedulaCliente());
        btnRegistrar.setDisabled(true);
        btnModificar.setDisabled(false);
        btnEliminar.setDisabled(false);
        txtCodigoDevolucion.setDisabled(true);
    }
    
    public void modificar(){
    try {
        Devolucion nuevaDevolucion = new Devolucion();
        Cliente nuevocliente = new Cliente();
        nuevaDevolucion.setCodigoDevolucion(Integer.parseInt(txtCodigoDevolucion.getValue().toString()));
        nuevaDevolucion.setFechaDevolucion((Date)txtFechaDevolucion.getValue());
        nuevaDevolucion.setObservacionDevolucion(txtObservacionesDevolucion.getValue().toString());
        nuevocliente.setCedulaCliente(Long.parseLong(txtCedulacliente.getValue().toString()));
        nuevaDevolucion.setClienteList(listaClienteSeleccionadas);
        devolucionlogica.edit(nuevaDevolucion);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Mensaje", "La devolucion se  modifico correctamente"));
        listaDevolucion = null;
    } catch (Exception ex) {
        Logger.getLogger(DevolucionVista.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
     
    public void eliminar(){
        try {
            Devolucion m = new Devolucion();
            m.setCodigoDevolucion(Integer.parseInt(txtCodigoDevolucion.getValue().toString()));            
            devolucionlogica.remove(m);
             limpiar();
            listaDevolucion =null;
            FacesContext.getCurrentInstance().addMessage("Mensaje", new FacesMessage(FacesMessage.SEVERITY_INFO, "Informacion", "la devolucion  se eliminó con Éxito"));
        } catch (Exception ex) {
            Logger.getLogger(ClienteVista.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }

    public List<Cliente> getListaCliente() {
        if(listaCliente==null){
            try {
                listaCliente = clienteLogica.findAll();
            } catch (Exception ex) {
                Logger.getLogger(DevolucionVista.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return listaCliente;
    }

    public void setListaClienteSeleccionadas(List<Cliente> listaClienteSeleccionadas) {
        this.listaClienteSeleccionadas = listaClienteSeleccionadas;
    }
    
}
