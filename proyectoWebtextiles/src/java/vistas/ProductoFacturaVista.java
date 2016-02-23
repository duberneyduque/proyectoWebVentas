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
import logica.FacturaLogicaLocal;
import logica.ProductoLogicaLocal;
import logica.productofacturaLogicaLocal;
import modelo.Devolucion;
import modelo.Factura;
import modelo.Producto;
import modelo.Productofactura;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.component.selectonemenu.SelectOneMenu;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author Estudiante
 */
@ManagedBean (name="productofacturavista")
@RequestScoped
public class ProductoFacturaVista {

      // combox producto
    private SelectOneMenu cmbProducto;
    private ArrayList<SelectItem> opcionesProducto;
    private Producto selectproducto;
    //combox devolucion
    private SelectOneMenu cmbFactura;
    private ArrayList<SelectItem> opcionesFactura;
    private Factura  selectfactura;
    private InputText txtcantidad;
    private List<Productofactura> listaProductofa;
    private  Productofactura selectproductosfa;
    private CommandButton btnRegistrar;
    private CommandButton btnModificar;
    private CommandButton btnEliminar;
    private CommandButton btnLimpiar;
    
    @EJB
    private ProductoLogicaLocal productologica;
    
    @EJB
    private FacturaLogicaLocal facturalogica;
    
    @EJB
    private productofacturaLogicaLocal productosfalogica;
    
    public ProductoFacturaVista() {
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
     public SelectOneMenu getCmbFactura() {
        return cmbFactura;
    }

    public void setCmbFactura(SelectOneMenu cmbFactura) {
        this.cmbFactura = cmbFactura;
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
                Logger.getLogger(ProductoFacturaVista.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        return opcionesProducto;
    }
      public ArrayList<SelectItem> getOpcionesFactura() {
        if(opcionesFactura==null){
            try {
                opcionesFactura = new ArrayList<>();
                List<Factura> listafactura = facturalogica.consultarTodo();
                for (int i = 0; i < listafactura.size(); i++) {
                    opcionesFactura.add(new SelectItem(listafactura.get(i).getCodigoFactura(), listafactura.get(i).getTipopagoFactura()));
                }
            } catch (Exception ex) {
                Logger.getLogger(ProductoFacturaVista.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        return opcionesFactura;
    }
        public void setOpcionesFactura(ArrayList<SelectItem> opcionesFactura) {
        this.opcionesFactura = opcionesFactura;
    }
    public void setOpcionesProducto(ArrayList<SelectItem> opcionesproducto) {
        this.opcionesProducto = opcionesproducto;
    }
    
 
     public List<Productofactura> getListadecolucion() {
        if(listaProductofa==null){
            try {
                listaProductofa = productosfalogica.consultarTodo();
            } catch (Exception ex) {
                Logger.getLogger(InventarioProductoVista.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return listaProductofa;
    }

    public void setListaProductoFactura(List<Productofactura> listaproductofa) {
        this.listaProductofa = listaproductofa;
    }

    public Productofactura getSelectProductoFactura() {
        return selectproductosfa;
    }

    public void setSelectProductodevolucion(Productofactura selectproductofactura) {
        this.selectproductosfa = selectproductofactura;
    }
     public Factura getSelectFactura() {
        return selectfactura;
    }

    public void setSelectFactura(Factura selectfactura) {
        this.selectfactura= selectfactura;
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
            Productofactura nuevopro = new Productofactura();
            Factura nuevadefac = new Factura();
            Producto nuevoproducto = new Producto();
           // InventarioproductoPK pk = new InventarioproductoPK();
            //pk.setTallaInventario(txtTallainventario.getValue().toString());
            nuevopro.setCantidad(Integer.parseInt(txtcantidad.getValue().toString()));    
            nuevadefac.setCodigoFactura(Integer.parseInt(cmbFactura.getValue().toString()));
            nuevopro.setFactura(nuevadefac);
            nuevoproducto.setCodigoProducto(Integer.parseInt(cmbProducto.getValue().toString()));
            nuevopro.setProducto(nuevoproducto);
            productosfalogica.consultarPorCodigo(nuevopro);
            limpiar();
            listaProductofa =null;
        } catch (Exception ex) {
            Logger.getLogger(InventarioProductoVista.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public void limpiar(){
        txtcantidad.setValue("");
        cmbFactura.setValue("seleccione");
        cmbProducto.setValue("seleccione");
        btnRegistrar.setDisabled(false);
        btnModificar.setDisabled(true);
        btnEliminar.setDisabled(true);
    
    }
    
    public void onRowSelect(SelectEvent evt){
        Productofactura m = selectproductosfa;
        txtcantidad.setValue(m.getCantidad());
        cmbFactura.setValue(m.getFactura().getCodigoFactura());
        cmbProducto.setValue(m.getProducto().getCodigoProducto());
        btnRegistrar.setDisabled(true);
        btnModificar.setDisabled(false);
        btnEliminar.setDisabled(false);
      
    }
    
    public void modificar(){
        try {
           Productofactura m = new Productofactura();
            //InventarioproductoPK pk = new InventarioproductoPK();
            //pk.setTallaInventario(txtTallainventario.getValue().toString());
            m.setCantidad( Integer.parseInt( txtcantidad.getValue().toString()));
            Factura c = new Factura();
            c.setCodigoFactura(Integer.parseInt(cmbFactura.getValue().toString()));
            m.setFactura(c);
            Producto p = new Producto();
            p.setCodigoProducto(Integer.parseInt(cmbProducto.getValue().toString()));
            m.setProducto(p);
            productosfalogica.modificar(m);
             limpiar();
            listaProductofa =null;
            FacesContext.getCurrentInstance().addMessage("Mensaje", new FacesMessage(FacesMessage.SEVERITY_INFO, "Informacion", "El producto factura se modificó con Éxito"));
        } catch (Exception ex) {
            Logger.getLogger(InventarioProductoVista.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
   
    
}
