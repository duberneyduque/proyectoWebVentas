/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import logica.DevolucionLogicaLocal;
import logica.ProductoLogicaLocal;
import logica.ProductosdevolucioLogicaLocal;
import modelo.Devolucion;
import modelo.Producto;
import modelo.Productosdevolucion;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.component.selectonemenu.SelectOneMenu;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author Estudiante
 */
@ManagedBean (name ="productodevolucionvista")
@RequestScoped
public class ProductoDevolucionVista {

    
    // combox producto
    private SelectOneMenu cmbProducto;
    private ArrayList<SelectItem> opcionesProducto;
    private Producto selectproducto;
    //combox devolucion
    private SelectOneMenu cmbDevolucion;
    private ArrayList<SelectItem> opcionesDevolucion;
    private Devolucion  selectdevolucion;
    private InputText txtcantidad;
    private InputText txtobservaciones;
    private List<Productosdevolucion> listaProductod;
    private  Productosdevolucion selectproductosd;
    private CommandButton btnRegistrar;
    private CommandButton btnModificar;
    private CommandButton btnEliminar;
    private CommandButton btnLimpiar;
    
    @EJB
    private ProductoLogicaLocal productologica;
    
    @EJB
    private DevolucionLogicaLocal devolucionlogica;
    
    @EJB
    private ProductosdevolucioLogicaLocal productosdlogica;
    
    public ProductoDevolucionVista() {
        
    }
          public InputText getTxtobservaciones() {
        return txtobservaciones;
    }
    
    public void setTxtobservaciones(InputText txtobservaciones) {
        this.txtobservaciones = txtobservaciones;
    }

    public InputText getTxtCantidad() {
        return txtcantidad;
    }

    public void setTxtCantidad(InputText txtCantidad) {
        this.txtcantidad = txtCantidad;
    }
    
    
    public SelectOneMenu getCmbProducto() {
        return cmbProducto;
    }

    public void setCmbProducto(SelectOneMenu cmbProducto) {
        this.cmbProducto = cmbProducto;
    }
     public SelectOneMenu getCmbDevolucion() {
        return cmbDevolucion;
    }

    public void setCmbDevolucion(SelectOneMenu cmbDevolucion) {
        this.cmbDevolucion = cmbDevolucion;
    }

    public ArrayList<SelectItem> getOpcionesProducto() {
        if(opcionesProducto==null){
            try {
                opcionesProducto = new ArrayList<>();
                List<Producto> listaproducto = productologica.consultarTodo();
                for (int i = 0; i < listaproducto.size(); i++) {
                    opcionesProducto.add(new SelectItem(listaproducto.get(i).getCodigoProducto(), listaproducto.get(i).getNombreProducto()));
                }
            } catch (Exception ex) {
                Logger.getLogger(ProductoDevolucionVista.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        return opcionesProducto;
    }
      public ArrayList<SelectItem> getOpcionesDevolucion() {
        if(opcionesDevolucion==null){
            try {
                opcionesDevolucion = new ArrayList<>();
                List<Devolucion> listadevolucion = devolucionlogica.consultar();
                for (int i = 0; i < listadevolucion.size(); i++) {
                    opcionesDevolucion.add(new SelectItem(listadevolucion.get(i).getCodigoDevolucion(), listadevolucion.get(i).getObservacionDevolucion()));
                }
            } catch (Exception ex) {
                Logger.getLogger(ProductoDevolucionVista.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        return opcionesDevolucion;
    }
        public void setOpcionesDevolucion(ArrayList<SelectItem> opcionesDevolucion) {
        this.opcionesDevolucion = opcionesDevolucion;
    }
    public void setOpcionesProducto(ArrayList<SelectItem> opcionesproducto) {
        this.opcionesProducto = opcionesproducto;
    }
    
 
     public List<Productosdevolucion> getListadecolucion() {
        if(listaProductod==null){
            try {
                listaProductod = productosdlogica.consultarTodo();
            } catch (Exception ex) {
                Logger.getLogger(InventarioProductoVista.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return listaProductod;
    }

    public void setListaProductodevolucion(List<Productosdevolucion> listaproductod) {
        this.listaProductod = listaproductod;
    }

    public Productosdevolucion getSelectProductosdevolucion() {
        return selectproductosd;
    }

    public void setSelectProductodevolucion(Productosdevolucion selectproductodevolucion) {
        this.selectproductosd = selectproductodevolucion;
    }
     public Devolucion getSelectDevolucion() {
        return selectdevolucion;
    }

    public void setSelectDevolucion(Devolucion selectdevolucion) {
        this.selectdevolucion= selectdevolucion;
    }

     public Producto getSelectProducto() {
        return selectproducto;
    }

    public void setSelectProducto(Producto selectproducto) {
        this.selectproducto = selectproducto;
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
            Productosdevolucion nuevopro = new Productosdevolucion();
            Devolucion nuevadevo = new Devolucion();
            Producto nuevoproducto = new Producto();
           // InventarioproductoPK pk = new InventarioproductoPK();
            //pk.setTallaInventario(txtTallainventario.getValue().toString());
            nuevopro.setCantidad(Integer.parseInt(txtcantidad.getValue().toString()));
            nuevopro.setObservaciones(txtobservaciones.getValue().toString());
            nuevadevo.setCodigoDevolucion(Integer.parseInt(cmbDevolucion.getValue().toString()));
            nuevopro.setDevolucion(nuevadevo);
            nuevoproducto.setCodigoProducto(Integer.parseInt(cmbProducto.getValue().toString()));
            nuevopro.setProducto(nuevoproducto);
            productosdlogica.consultarPorCodigo(nuevopro);
            limpiar();
            listaProductod =null;
        } catch (Exception ex) {
            Logger.getLogger(InventarioProductoVista.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public void limpiar(){
        txtobservaciones.setValue("");
        txtcantidad.setValue("");
        cmbDevolucion.setValue("seleccione");
        cmbProducto.setValue("seleccione");
        btnRegistrar.setDisabled(false);
        btnModificar.setDisabled(true);
        btnEliminar.setDisabled(true);
    
    }
    
    public void onRowSelect(SelectEvent evt){
        Productosdevolucion m = selectproductosd;
        txtobservaciones.setValue(m.getObservaciones());
        txtcantidad.setValue(m.getCantidad());
        cmbDevolucion.setValue(m.getDevolucion().getCodigoDevolucion());
        cmbProducto.setValue(m.getProducto().getCodigoProducto());
        btnRegistrar.setDisabled(true);
        btnModificar.setDisabled(false);
        btnEliminar.setDisabled(false);
      
    }
    
    public void modificar(){
        try {
           Productosdevolucion m = new Productosdevolucion();
            //InventarioproductoPK pk = new InventarioproductoPK();
            //pk.setTallaInventario(txtTallainventario.getValue().toString());
            m.setCantidad( Integer.parseInt( txtcantidad.getValue().toString()));
            m.setObservaciones(txtobservaciones.getValue().toString());
            Devolucion c = new Devolucion();
            c.setCodigoDevolucion(Integer.parseInt(cmbDevolucion.getValue().toString()));
            m.setDevolucion(c);
            Producto p = new Producto();
            p.setCodigoProducto(Integer.parseInt(cmbProducto.getValue().toString()));
            m.setProducto(p);
            productosdlogica.modificar(m);
             limpiar();
            listaProductod =null;
            FacesContext.getCurrentInstance().addMessage("Mensaje", new FacesMessage(FacesMessage.SEVERITY_INFO, "Informacion", "El producto devolucion se modificó con Éxito"));
        } catch (Exception ex) {
            Logger.getLogger(InventarioProductoVista.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
 
    
}
