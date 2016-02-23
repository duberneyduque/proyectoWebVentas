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
import logica.CiudadLogicaLocal;
import logica.InventarioProductoLogicaLocal;
import logica.ProductoLogicaLocal;
import modelo.Ciudad;
import modelo.Inventarioproducto;
import modelo.InventarioproductoPK;
import modelo.Producto;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.component.selectonemenu.SelectOneMenu;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author Estudiante
 */
@ManagedBean (name="inventarioproductovista")
@RequestScoped
public class InventarioProductoVista {

     
    private InputText txtTallainventario;
    private InputText txtcantidad;
    // combox ciudad
    private SelectOneMenu cmbCiudad;
    private ArrayList<SelectItem> opcionesCiudad;
    private Ciudad selectciudad;
    //combox producto
    private SelectOneMenu cmbProducto;
    private ArrayList<SelectItem> opcionesProducto;
    private Producto selectproducto;
    
    private List<Inventarioproducto> listaInventario;
    private  Inventarioproducto selectinventario;
    private CommandButton btnRegistrar;
    private CommandButton btnModificar;
    private CommandButton btnEliminar;
    private CommandButton btnLimpiar;
    
    @EJB
    private CiudadLogicaLocal ciudadLogica;
    
    @EJB
    private ProductoLogicaLocal productoLogica;
    
    @EJB
    private InventarioProductoLogicaLocal invetariologica;
    
    
    public InventarioProductoVista() {
    }
     public InputText getTxtTallainvetario() {
        return txtTallainventario;
    }
    
    public void setTxtTallainvetario(InputText txtTallainvetario) {
        this.txtTallainventario = txtTallainvetario;
    }

    public InputText getTxtCantidad() {
        return txtcantidad;
    }

    public void setTxtCantidad(InputText txtCantidad) {
        this.txtcantidad = txtCantidad;
    }


    public SelectOneMenu getCmbCiudad() {
        return cmbCiudad;
    }

    public void setCmbCiudad(SelectOneMenu cmbCiudad) {
        this.cmbCiudad = cmbCiudad;
    }
     public SelectOneMenu getCmbProducto() {
        return cmbProducto;
    }

    public void setCmbProducto(SelectOneMenu cmbproducto) {
        this.cmbProducto = cmbproducto;
    }

    public ArrayList<SelectItem> getOpcionesCiudad() {
        if(opcionesCiudad==null){
            try {
                opcionesCiudad = new ArrayList<>();
                List<Ciudad> listaciudad = ciudadLogica.consultarTodo();
                for (int i = 0; i < listaciudad.size(); i++) {
                    opcionesCiudad.add(new SelectItem(listaciudad.get(i).getCodigoCiudad(), listaciudad.get(i).getNombreCiudad()));
                }
            } catch (Exception ex) {
                Logger.getLogger(InventarioProductoVista.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        return opcionesCiudad;
    }
      public ArrayList<SelectItem> getOpcionesProducto() {
        if(opcionesProducto==null){
            try {
                opcionesProducto = new ArrayList<>();
                List<Producto> listaproducto = productoLogica.consultarTodo();
                for (int i = 0; i < listaproducto.size(); i++) {
                    opcionesProducto.add(new SelectItem(listaproducto.get(i).getCodigoProducto(), listaproducto.get(i).getNombreProducto()));
                }
            } catch (Exception ex) {
                Logger.getLogger(InventarioProductoVista.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        return opcionesProducto;
    }


    public void setOpcionesCiudad(ArrayList<SelectItem> opcionesCiudad) {
        this.opcionesCiudad = opcionesCiudad;
    }
    public void setOpcionesProducto(ArrayList<SelectItem> opcionesproducto) {
        this.opcionesProducto = opcionesproducto;
    }

    public List<Inventarioproducto> getListaInventario() {
        if(listaInventario==null){
            try {
                listaInventario = invetariologica.consultarTodo();
            } catch (Exception ex) {
                Logger.getLogger(InventarioProductoVista.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return listaInventario;
    }

    public void setListaInventarioProducto(List<Inventarioproducto> listaInventario) {
        this.listaInventario = listaInventario;
    }

    public Inventarioproducto getSelectInventarioProducto() {
        return selectinventario;
    }

    public void setSelectInventarioProducto(Inventarioproducto selectinventario) {
        this.selectinventario = selectinventario;
    }
     public Ciudad getSelectCiudad() {
        return selectciudad;
    }

    public void setSelectCiudad(Ciudad selectciudad) {
        this.selectciudad = selectciudad;
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
            Inventarioproducto nuevoinvetario = new Inventarioproducto();
            Ciudad nuevaCiudad = new Ciudad();
            Producto nuevoproducto = new Producto();
            InventarioproductoPK pk = new InventarioproductoPK();
            pk.setTallaInventario(txtTallainventario.getValue().toString());
            nuevoinvetario.setCantidad(Integer.parseInt(txtcantidad.getValue().toString()));
            nuevaCiudad.setCodigoCiudad(Integer.parseInt(cmbCiudad.getValue().toString()));
            nuevoinvetario.setCiudad(nuevaCiudad);
            nuevoproducto.setCodigoProducto(Integer.parseInt(cmbProducto.getValue().toString()));
            nuevoinvetario.setProducto(nuevoproducto);
            invetariologica.consultarPorCodigo(nuevoinvetario);
            limpiar();
            listaInventario =null;
        } catch (Exception ex) {
            Logger.getLogger(InventarioProductoVista.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public void limpiar(){
        txtTallainventario.setValue("");
        txtcantidad.setValue("");
        cmbCiudad.setValue("seleccione");
        cmbProducto.setValue("seleccione");
        btnRegistrar.setDisabled(false);
        btnModificar.setDisabled(true);
        btnEliminar.setDisabled(true);
        txtTallainventario.setDisabled(false);
    
    }
    
    public void onRowSelect(SelectEvent evt){
        Inventarioproducto m = selectinventario;
        txtTallainventario.setValue(m.getInventarioproductoPK());
        txtcantidad.setValue(m.getCantidad());
        cmbCiudad.setValue(m.getCiudad().getCodigoCiudad());
        cmbProducto.setValue(m.getProducto().getCodigoProducto());
        btnRegistrar.setDisabled(true);
        btnModificar.setDisabled(false);
        btnEliminar.setDisabled(false);
        txtTallainventario.setDisabled(true);
    }
    
    public void modificar(){
        try {
            Inventarioproducto m = new Inventarioproducto();
            InventarioproductoPK pk = new InventarioproductoPK();
            pk.setTallaInventario(txtTallainventario.getValue().toString());
            m.setCantidad( Integer.parseInt( txtcantidad.getValue().toString()));
            Ciudad c = new Ciudad();
            c.setCodigoCiudad(Integer.parseInt(cmbCiudad.getValue().toString()));
            m.setCiudad(c);
            Producto p = new Producto();
            p.setCodigoProducto(Integer.parseInt(cmbProducto.getValue().toString()));
            m.setProducto(p);
            invetariologica.modificar(m);
             limpiar();
            listaInventario =null;
            FacesContext.getCurrentInstance().addMessage("Mensaje", new FacesMessage(FacesMessage.SEVERITY_INFO, "Informacion", "El invetario se modificó con Éxito"));
        } catch (Exception ex) {
            Logger.getLogger(InventarioProductoVista.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public void eliminar(){
        try {
            Inventarioproducto m = new Inventarioproducto();
            InventarioproductoPK p = new InventarioproductoPK();
            p.setTallaInventario(txtTallainventario.getValue().toString());            
            invetariologica.eliminar(m);
             limpiar();
            listaInventario=null;
            FacesContext.getCurrentInstance().addMessage("Mensaje", new FacesMessage(FacesMessage.SEVERITY_INFO, "Informacion", "El invetario se eliminó con Éxito"));
        } catch (Exception ex) {
            Logger.getLogger(InventarioProductoVista.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
