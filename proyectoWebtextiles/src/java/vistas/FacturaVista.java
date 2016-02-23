/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

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
import logica.FacturaLogicaLocal;
import logica.UsuarioLogicaLocal;
import modelo.Cliente;
import modelo.Factura;
import modelo.Usuario;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.component.selectonemenu.SelectOneMenu;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author Estudiante
 */
@ManagedBean (name= "facturavista")
@RequestScoped
public class FacturaVista {

     
    private InputText txtCodigoFactura;
    private InputText txtFechafactura;
    private InputText txtTipopagofactura;
    private InputText txtValortotalfactura;
    //combox cliente
    private SelectOneMenu cmbCliente;
    private ArrayList<SelectItem> opcionesCliente;
    private Cliente selectcliente;
    // combox usuario
    private SelectOneMenu cmbusuario;
    private ArrayList<SelectItem> opcionesusuario;
    private Usuario selectusuario;
    
    private List<Factura> listaFactura;
    private Factura selectfactura;
    private CommandButton btnRegistrar;
    private CommandButton btnModificar;
    private CommandButton btnEliminar;
    private CommandButton btnLimpiar;
    
    @EJB
    private ClienteLogicaLocal clienteLogica;
    
    @EJB
    private UsuarioLogicaLocal usuarioLogica;
    @EJB
    private FacturaLogicaLocal facturaLogica;
    

    /**
     * Creates a new instance of MateriaVista
     */
   public FacturaVista() {
    }
    

    public InputText getTxtCodigoFactura() {
        return txtCodigoFactura;
    }

    public void setTxtCodigoFactura(InputText txtCodigoFactura) {
        this.txtCodigoFactura = txtCodigoFactura;
    }

    public InputText getTxtFechafactura() {
        return txtFechafactura;
    }

    public void setTxtFechafactura(InputText txtFechafactura) {
        this.txtFechafactura = txtFechafactura;
    }

    public InputText getTxtTipopagofactura () {
        return txtTipopagofactura;
    }

    public void setTxtTipopagofactura(InputText txtTipopagofactura) {
        this.txtTipopagofactura = txtTipopagofactura;
    }

    public SelectOneMenu getCmbCliente() {
        return cmbCliente;
    }

    public void setCmbCliente(SelectOneMenu cmbCliente) {
        this.cmbCliente = cmbCliente;
    }
      public SelectOneMenu getCmbUsuario() {
        return cmbusuario;
    }

    public void setCmbUsuario(SelectOneMenu cmbusuario) {
        this.cmbusuario = cmbusuario;
    }

    public ArrayList<SelectItem> getOpcionesCliente() {
        if(opcionesCliente==null){
            try {
                opcionesCliente = new ArrayList<>();
                List<Cliente> listaClientes = clienteLogica.findAll();
                for (int i = 0; i < listaClientes.size(); i++) {
                    opcionesCliente.add(new SelectItem(listaClientes.get(i).getCedulaCliente(), listaClientes.get(i).getNombreCliente()));
                }
            } catch (Exception ex) {
                Logger.getLogger(FacturaVista.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        return opcionesCliente;
    }
    
        public ArrayList<SelectItem> getOpcionesUsuario() {
        if(opcionesusuario==null){
            try {
                opcionesusuario = new ArrayList<>();
                List<Usuario> listausuario = usuarioLogica.consultarTodo();
                for (int i = 0; i < listausuario.size(); i++) {
                    opcionesusuario.add(new SelectItem(listausuario.get(i).getIdUsuario(), listausuario.get(i).getNombreUsuario()));
                }
            } catch (Exception ex) {
                Logger.getLogger(FacturaVista.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        return opcionesusuario;
    }


    public void setOpcionesCliente(ArrayList<SelectItem> opcionesCliente) {
        this.opcionesCliente = opcionesCliente;
    }

    public void setOpcionesusuario(ArrayList<SelectItem> opcionesusuario) {
        this.opcionesusuario = opcionesusuario;
    }
    
    public List<Factura> getListaFactura() {
        if(listaFactura==null){
            try {
                listaFactura = facturaLogica.consultarTodo();
            } catch (Exception ex) {
                Logger.getLogger(FacturaVista.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return listaFactura;
    }

    public void setListaFactura(List<Factura> listaFactura) {
        this.listaFactura = listaFactura;
    }

    public Factura getSelectFactura() {
        return selectfactura;
    }

    public void setSelectFactura(Factura selectFactura) {
        this.selectfactura = selectFactura;
    }
    public Cliente getSelectCliente() {
        return selectcliente;
    }

    public void setSelectcliente(Cliente selectcliente) {
        this.selectcliente = selectcliente;
    }
    public Usuario getSelectUsuario() {
        return selectusuario;
    }

    public void setSelectUsuario(Usuario selectUsuario) {
        this.selectusuario = selectUsuario;
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
    
    public void registrar(){
        try {
            Factura nuevafactura = new Factura();
            Cliente nuevaCliente = new Cliente();
            Usuario nuevousuario = new Usuario();
            nuevafactura.setCodigoFactura(Integer.parseInt(txtCodigoFactura.getValue().toString()));
            nuevafactura.setFechaFactura((Date)txtFechafactura.getValue());
            nuevafactura.setTipopagoFactura(txtTipopagofactura.getValue().toString());
            nuevafactura.setValortotalFactura(Double.parseDouble(txtValortotalfactura.getValue().toString()));
            nuevaCliente.setCedulaCliente(Long.parseLong(cmbCliente.getValue().toString()));
            nuevousuario.setIdUsuario(Integer.parseInt(cmbusuario.getValue().toString()));
            nuevafactura.setCedulaCliente(nuevaCliente);
            nuevafactura.setIdUsuario(nuevousuario);
            facturaLogica.crear(nuevafactura);
            limpiar();
            listaFactura =null;
        } catch (Exception ex) {
            Logger.getLogger(FacturaVista.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public void limpiar(){
        txtCodigoFactura.setValue("");
        txtFechafactura.setValue("");
        txtTipopagofactura.setValue("");
        txtValortotalfactura.setValue("");
        cmbCliente.setValue("seleccione");
        cmbusuario.setValue("seleccione");
        btnRegistrar.setDisabled(false);
        btnModificar.setDisabled(true);
        btnEliminar.setDisabled(true);
        txtCodigoFactura.setDisabled(false);
    
    }
    
    public void onRowSelect(SelectEvent evt){
        Factura m = selectfactura;
        txtCodigoFactura.setValue(m.getCodigoFactura());
        txtFechafactura.setValue(m.getFechaFactura());
        txtTipopagofactura.setValue(m.getTipopagoFactura());
        txtValortotalfactura.setValue(m.getValortotalFactura());
        cmbCliente.setValue(m.getCedulaCliente().getCedulaCliente());
        cmbusuario.setValue(m.getIdUsuario().getIdUsuario());
        btnRegistrar.setDisabled(true);
        btnModificar.setDisabled(false);
        btnEliminar.setDisabled(false);
        txtCodigoFactura.setDisabled(true);
    }
    
    public void modificar(){
        try {
            Factura m = new Factura();
            m.setCodigoFactura(Integer.parseInt(txtCodigoFactura.getValue().toString()));
            m.setFechaFactura((Date)txtFechafactura.getValue());
            m.setTipopagoFactura(txtTipopagofactura.getValue().toString());
            m.setValortotalFactura(Double.parseDouble(txtValortotalfactura.getValue().toString()));
            Cliente c = new Cliente();
            c.setCedulaCliente(Long.parseLong(cmbCliente.getValue().toString()));
            m.setCedulaCliente(c);
            clienteLogica.edit(c);
            Usuario u = new Usuario();
            u.setIdUsuario(Integer.parseInt(cmbusuario.getValue().toString()));
            m.setIdUsuario(u);
            usuarioLogica.modificar(u);
             limpiar();
            listaFactura =null;
            FacesContext.getCurrentInstance().addMessage("Mensaje", new FacesMessage(FacesMessage.SEVERITY_INFO, "Informacion", "La factura  se a  modificó con Éxito"));
        } catch (Exception ex) {
            Logger.getLogger(FacturaVista.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public void eliminar(){
        try {
            Factura m = new Factura();
            m.setCodigoFactura(Integer.parseInt(txtCodigoFactura.getValue().toString()));            
            facturaLogica.eliminar(m);
             limpiar();
            listaFactura =null;
            FacesContext.getCurrentInstance().addMessage("Mensaje", new FacesMessage(FacesMessage.SEVERITY_INFO, "Informacion", "La Factura se a eliminó con Éxito"));
        } catch (Exception ex) {
            Logger.getLogger(FacturaVista.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
