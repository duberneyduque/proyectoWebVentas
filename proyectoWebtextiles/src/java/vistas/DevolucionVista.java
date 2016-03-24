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
import logica.ClienteLogicaLocal;
import logica.DevolucionLogicaLocal;
import modelo.Cliente;
import modelo.Devolucion;
import org.primefaces.component.calendar.Calendar;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.component.inputtextarea.InputTextarea;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author Estudiante
 */
@ManagedBean  (name="DevolucionVista")
@RequestScoped
public class DevolucionVista {

private InputText txtCodigoDevolucion;
private Calendar txtFecha;
private InputTextarea txtobservaciones;
private InputText txtCedulaCliente;
private Cliente selecteClienteD;
private Devolucion selecteDevolucionD;

//LISTADO
private List<Devolucion>listaDevolucion;
private List<Cliente>listaClientes;

//BOTONES
private CommandButton btnRegistrar;
private CommandButton btnModificar;
private CommandButton btnLimpiar;
private CommandButton btnEliminar;


@EJB 
private DevolucionLogicaLocal devolucionLogica;
@EJB
private ClienteLogicaLocal clienteLogica;

 public DevolucionVista() {
    }
//GET Y SET
    public InputText getTxtCodigoDevolucion() {
        return txtCodigoDevolucion;
    }

    public void setTxtCodigoDevolucion(InputText txtCodigoDevolucion) {
        this.txtCodigoDevolucion = txtCodigoDevolucion;
    }

    public Calendar getTxtFecha() {
        return txtFecha;
    }

    public void setTxtFecha(Calendar txtFecha) {
        this.txtFecha = txtFecha;
    }

    public InputTextarea getTxtobservaciones() {
        return txtobservaciones;
    }

    public void setTxtobservaciones(InputTextarea txtobservaciones) {
        this.txtobservaciones = txtobservaciones;
    }

    public InputText getTxtCedulaCliente() {
        return txtCedulaCliente;
    }

    public void setTxtCedulaCliente(InputText txtCedulaCliente) {
        this.txtCedulaCliente = txtCedulaCliente;
    }

    public Cliente getSelecteClienteD() {
        return selecteClienteD;
    }

    public void setSelecteClienteD(Cliente selecteClienteD) {
        this.selecteClienteD = selecteClienteD;
    }

    public Devolucion getSelecteDevolucionD() {
        return selecteDevolucionD;
    }

    public void setSelecteDevolucionD(Devolucion selecteDevolucionD) {
        this.selecteDevolucionD = selecteDevolucionD;
    }

    public List<Devolucion> getListaDevolucion() {
        if(listaDevolucion==null){
            try{
            listaDevolucion=devolucionLogica.consultar();
            }catch(Exception ex){
                Logger.getLogger(DevolucionVista.class.getName()).log(Level.SEVERE, null,"error de lista"+ ex.getMessage());
            }
        }
        return listaDevolucion;
    }

    public void setListaDevolucion(List<Devolucion> listaDevolucion) {
        this.listaDevolucion = listaDevolucion;
    }

    public List<Cliente> getListaClientes() {
          if(listaClientes==null){
            try{
            listaClientes=clienteLogica.findAll();
            }catch(Exception ex){
                Logger.getLogger(DevolucionVista.class.getName()).log(Level.SEVERE, null,"error de lista"+ ex.getMessage());
            }
        }
        return listaClientes;
    }

    public void setListaClientes(List<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
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

    public DevolucionLogicaLocal getDevolucionLogica() {
        return devolucionLogica;
    }

    public void setDevolucionLogica(DevolucionLogicaLocal devolucionLogica) {
        this.devolucionLogica = devolucionLogica;
    }

    public ClienteLogicaLocal getClienteLogica() {
        return clienteLogica;
    }

    public void setClienteLogica(ClienteLogicaLocal clienteLogica) {
        this.clienteLogica = clienteLogica;
    }
    
 //LOS METODOS PARA SER LLAMOS EN LAS PAGINAS WEB
    
    public void accion_registrar() {
        
        try {
            Devolucion nuevaDevolucion = new Devolucion();
            Cliente nuevocliente = new Cliente();
            if(txtCodigoDevolucion.getValue().equals("") || txtFecha.getValue().equals("") || txtobservaciones.getValue().equals("") || txtCedulaCliente.getValue().equals("")){
                 txtCodigoDevolucion.setPlaceholder("Debe llenar el campo");
                 txtFecha.setPlaceholder("Debe llenar el campo");
                  txtobservaciones.setPlaceholder("Debe llenar el campo");
                 txtCedulaCliente.setPlaceholder("Debe llenar el campo");
           }else{
            nuevaDevolucion.setCodigoDevolucion(Integer.parseInt(txtCodigoDevolucion.getValue().toString().toUpperCase()));
            nuevaDevolucion.setFechaDevolucion((Date)txtFecha.getValue());
            nuevaDevolucion.setObservacionDevolucion(txtobservaciones.getValue().toString().toUpperCase());
            nuevocliente.setCedulaCliente(Long.parseLong(txtCedulaCliente.getValue().toString()));
            nuevaDevolucion.setCedulaCliente(nuevocliente);
           }
           devolucionLogica.create(nuevaDevolucion);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Mensaje", "La Devolucion  se a registro correctamente"));
            listaDevolucion = null;
            listaClientes=null;
         } catch (NumberFormatException ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "El codigo   debe ser un numero y no letras"));
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "El codigo ya esta registrado"+"\n o debe llenar todos los campos"+ex.getMessage()));
        }
        
    }

    public void limpiar() {
        txtCodigoDevolucion.setValue("");
        txtFecha.setValue(null);
        txtFecha.setLabel("");
        txtobservaciones.setValue("");
        txtCedulaCliente.setValue(null);
        txtCedulaCliente.setLabel("");
        btnRegistrar.setDisabled(false);
        btnModificar.setDisabled(true);
        btnEliminar.setDisabled(true);
    }
     public void seleccionFilaDevolucion(SelectEvent evt){
       Devolucion d=selecteDevolucionD;
       txtCodigoDevolucion.setValue(d.getCodigoDevolucion().toString());
       txtFecha.setValue((Date)d.getFechaDevolucion());
       txtobservaciones.setValue(d.getObservacionDevolucion());
       txtCedulaCliente.setValue(d.getCedulaCliente().getCedulaCliente().toString());
       btnRegistrar.setDisabled(true);
       btnModificar.setDisabled(false);
       btnEliminar.setDisabled(false);
       btnLimpiar.setDisabled(false);
       listaDevolucion=null;
       listaClientes=null;
       
    }
 public void seleccionFilaCliente(SelectEvent evt) {
        Cliente objeCliente = selecteClienteD;
        txtCedulaCliente.setValue(objeCliente.getCedulaCliente().toString());
        listaClientes= null;
    }
  public void modificar(){
    try {
        Devolucion nuevaDevolucion = new Devolucion();
        Cliente nuevocliente = new Cliente();
        nuevaDevolucion.setCodigoDevolucion(Integer.parseInt(txtCodigoDevolucion.getValue().toString()));
        nuevaDevolucion.setFechaDevolucion((Date)txtFecha.getValue());
        nuevaDevolucion.setObservacionDevolucion(txtobservaciones.getValue().toString());
        nuevocliente.setCedulaCliente(Long.parseLong(txtCedulaCliente.getValue().toString()));
        nuevaDevolucion.setCedulaCliente(nuevocliente);
        devolucionLogica.edit(nuevaDevolucion);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Mensaje", "La devolucion se  modifico correctamente"));
        listaDevolucion = null;
    } catch (Exception ex) {
        Logger.getLogger(DevolucionVista.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
     
    public void eliminar(){
        try {
            Devolucion devolucionEliminada = new Devolucion();
            devolucionEliminada.setCodigoDevolucion(Integer.parseInt(txtCodigoDevolucion.getValue().toString()));            
            devolucionLogica.remove(devolucionEliminada);
              FacesContext.getCurrentInstance().addMessage("Mensaje", new FacesMessage(FacesMessage.SEVERITY_INFO, "Informacion", "la devolucion  se eliminó con Éxito"));
            listaDevolucion =null;
           
        } catch (Exception ex) {
            Logger.getLogger(ClienteVista.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
}
