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
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.SelectItem;
import logica.CategoriaLogica;
import logica.CategoriaLogicaLocal;
import logica.ProductoLogica;
import logica.ProductoLogicaLocal;
import modelo.Categoria;
import modelo.Producto;
import org.primefaces.component.calendar.Calendar;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.component.selectonemenu.SelectOneMenu;
import org.primefaces.event.SelectEvent;
import persistencia.CategoriaFacadeLocal;

/**
 *
 * @author duberport
 */
@ManagedBean(name = "productoVistav")
@RequestScoped
public class ProductoVista {
   
    private InputText txtcodigoProducto;
    private InputText txtnombreProducto;
    private Date txtfechaProducto;
    private InputText txtgeneroProducto;
    private SelectOneMenu cmbgeneroProducto;
    private InputText txtcolorProducto;
    private InputText txtPrecioProducto;
    private InputText txtcodigoCategoria;
    private SelectOneMenu cmbCategoria;
    private ArrayList<SelectItem> opcionesProducto;
    private List<Producto> ListaProductos;
    private List<Categoria>listacategoriap;
    private Producto selecProducto;
    private CommandButton btnRegistrar;
    private CommandButton btnModificar;
    private CommandButton btnEliminar;
    private CommandButton btnLimpiar;
    private Categoria selectecategoria;
@EJB
private ProductoLogicaLocal productologica;

@EJB
private CategoriaLogicaLocal categoriaLogica;

    public ProductoVista() {
    }

    public SelectOneMenu getCmbgeneroProducto() {
        return cmbgeneroProducto;
    }

    public void setCmbgeneroProducto(SelectOneMenu cmbgeneroProducto) {
        this.cmbgeneroProducto = cmbgeneroProducto;
    }

    public Categoria getSelectecategoria() {
        return selectecategoria;
    }

    public void setSelectecategoria(Categoria selectecategoria) {
        this.selectecategoria = selectecategoria;
    }

    public InputText getTxtcodigoProducto() {
        return txtcodigoProducto;
    }

    public void setTxtcodigoProducto(InputText txtcodigoProducto) {
        this.txtcodigoProducto = txtcodigoProducto;
    }

    public InputText getTxtnombreProducto() {
        return txtnombreProducto;
    }

    public void setTxtnombreProducto(InputText txtnombreProducto) {
        this.txtnombreProducto = txtnombreProducto;
    }

    public Date getTxtfechaProducto() {
        return txtfechaProducto;
    }

    public void setTxtfechaProducto(Date txtfechaProducto) {
        this.txtfechaProducto = txtfechaProducto;
    }

    public InputText getTxtgeneroProducto() {
        return txtgeneroProducto;
    }

    public void setTxtgeneroProducto(InputText txtgeneroProducto) {
        this.txtgeneroProducto = txtgeneroProducto;
    }

    public InputText getTxtcolorProducto() {
        return txtcolorProducto;
    }

    public void setTxtcolorProducto(InputText txtcolorProducto) {
        this.txtcolorProducto = txtcolorProducto;
    }

    public InputText getTxtPrecioProducto() {
        return txtPrecioProducto;
    }

    public void setTxtPrecioProducto(InputText txtPrecioProducto) {
        this.txtPrecioProducto = txtPrecioProducto;
    }

    public InputText getTxtcodigoCategoria() {
        return txtcodigoCategoria;
    }

    public void setTxtcodigoCategoria(InputText txtcodigoCategoria) {
        this.txtcodigoCategoria = txtcodigoCategoria;
    }

    public SelectOneMenu getCmbCategoria() {
        return cmbCategoria;
    }

    public void setCmbCategoria(SelectOneMenu cmbCategoria) {
        this.cmbCategoria = cmbCategoria;
    }

    public ArrayList<SelectItem> getOpcionesProducto() {
        return opcionesProducto;
    }

    public void setOpcionesProducto(ArrayList<SelectItem> opcionesProducto) {
        this.opcionesProducto = opcionesProducto;
    }

    public List<Producto> getListaProductos() {
         if(ListaProductos==null){
            try {
                ListaProductos = productologica.consultarTodo();
            } catch (Exception ex) {
                Logger.getLogger(ProductoVista.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return ListaProductos;
    }

    public void setListaProductos(List<Producto> ListaProductos) {
        this.ListaProductos = ListaProductos;
    }

    public Producto getSelecProducto() {
        return selecProducto;
    }

    public void setSelecProducto(Producto selecProducto) {
        this.selecProducto = selecProducto;
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

    public ProductoLogicaLocal getProductologica() {
        return productologica;
    }

    public void setProductologica(ProductoLogicaLocal productologica) {
        this.productologica = productologica;
    }

    public CategoriaLogicaLocal getCategoriaLogica() {
        return categoriaLogica;
    }

    public void setCategoriaLogica(CategoriaLogicaLocal categoriaLogica) {
        this.categoriaLogica = categoriaLogica;
    }

    public List<Categoria> getListacategoriap() {
     try {
                if(listacategoriap==null){
                listacategoriap=categoriaLogica.consultarTodo();
                }
            } catch (Exception ex) {
                Logger.getLogger(CategoriaVista.class.getName()).log(Level.SEVERE, null, ex.getMessage());
            }
        
        return listacategoriap;
    }

    public void setListacategoriap(List<Categoria> listacategoriap) {
        this.listacategoriap = listacategoriap;
    }
    
     public void accion_registrar(){
        try {
            Producto nuevoProducto = new Producto();
            Categoria nuevaCategoria = new Categoria();
            nuevoProducto.setCodigoProducto(Integer.parseInt(txtcodigoProducto.getValue().toString()));
            nuevoProducto.setNombreProducto(txtnombreProducto.getValue().toString());
            nuevoProducto.setFechaIngresoProducto(txtfechaProducto);
            nuevoProducto.setGeneroProducto(txtgeneroProducto.getValue().toString());
            nuevoProducto.setColorProducto(txtcolorProducto.getValue().toString());
            nuevoProducto.setPrecioProducto(Double.parseDouble(txtPrecioProducto.getValue().toString()));
            nuevaCategoria.setCodigoCategoria(Integer.parseInt(txtcodigoCategoria.getValue().toString()));
            nuevoProducto.setCodigoCategoria(nuevaCategoria);
            nuevoProducto.setEstadoProducto(cmbCategoria.getValue().toString());
 
            productologica.crear(nuevoProducto);
           // limpiar();
            ListaProductos =null;
        } catch (Exception ex) {
            Logger.getLogger(ProductoVista.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
public void seleccionFila(SelectEvent evt){
    Categoria objeCategoria=selectecategoria;
    txtcodigoCategoria.setValue(objeCategoria.getCodigoCategoria());
    listacategoriap=null;
}
}
