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
import javax.swing.JOptionPane;
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

/**
 *
 * @author duberport
 */
@ManagedBean(name = "productoVistav")
@RequestScoped
public class ProductoVista {
    
    private InputText txtcodigoProducto;
    private InputText txtnombreProducto;
    private Calendar txtfechaProducto;
    private InputText txtcategoria;

    //botones
    private CommandButton btnRegistrar;
    private CommandButton btnModificar;
    private CommandButton btnEliminar;
    private CommandButton btnLimpiar;

    //combobox de genero Producto 
    private SelectOneMenu cmbGenero;
    private ArrayList<SelectItem> opcionGenero;
    
    private InputText txtColorProducto;
    private InputText txtPrecioProducto;

    //combobox de Estado Producto 
    private SelectOneMenu cmbEstadoProducto;
    private ArrayList<SelectItem> opcionEstadoProducto;

    //listas Productos y Categoria
    private List<Producto> listaProductos;
    private List<Categoria> listaCategoriap;

    //esta linea es para el objeto seleccionado
    private Producto selecProducto;
    private Categoria selecCategoriap;
    
    @EJB
    private ProductoLogicaLocal productologica;
    
    @EJB
    private CategoriaLogicaLocal categorialogia;
    
    public ProductoVista() {
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
    
    public InputText getTxtcategoria() {
        return txtcategoria;
    }
    
    public void setTxtcategoria(InputText txtcategoria) {
        this.txtcategoria = txtcategoria;
    }
    
    public Categoria getSelecCategoriap() {
        return selecCategoriap;
    }
    
    public void setSelecCategoriap(Categoria selecCategoriap) {
        this.selecCategoriap = selecCategoriap;
    }
    
    public ProductoLogicaLocal getProductologica() {
        return productologica;
    }
    
    public void setProductologica(ProductoLogicaLocal productologica) {
        this.productologica = productologica;
    }
    
    public CategoriaLogicaLocal getCategorialogia() {
        return categorialogia;
    }
    
    public void setCategorialogia(CategoriaLogicaLocal categorialogia) {
        this.categorialogia = categorialogia;
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
    
    public Calendar getTxtfechaProducto() {
        return txtfechaProducto;
    }
    
    public void setTxtfechaProducto(Calendar txtfechaProducto) {
        this.txtfechaProducto = txtfechaProducto;
    }
    
    public SelectOneMenu getCmbGenero() {
        return cmbGenero;
    }
    
    public void setCmbGenero(SelectOneMenu cmbGenero) {
        this.cmbGenero = cmbGenero;
    }
    
    public ArrayList<SelectItem> getOpcionGenero() {
        /*   if(opcionGenero==null)
         {
         opcionGenero=new ArrayList<>();
         try {
         List<Producto>listap=productologica.consultarTodo();
         for (int i = 0; i <listap.size(); i++) {
         opcionGenero.add(new SelectItem(listap.get(i).getCodigoProducto(),listap.get(i).getGeneroProducto()));
         }
         } catch (Exception ex) {
         Logger.getLogger(ProductoVista.class.getName()).log(Level.SEVERE, null,"ERROR EN EL ARRAY LIS DE ESTADO-PRODUCTO"+ ex.getMessage());
         }
         }*/
        return opcionGenero;
    }
    
    public void setOpcionGenero(ArrayList<SelectItem> opcionGenero) {
        this.opcionGenero = opcionGenero;
    }
    
    public InputText getTxtColorProducto() {
        return txtColorProducto;
    }
    
    public void setTxtColorProducto(InputText txtColorProducto) {
        this.txtColorProducto = txtColorProducto;
    }
    
    public InputText getTxtPrecioProducto() {
        return txtPrecioProducto;
    }
    
    public void setTxtPrecioProducto(InputText txtPrecioProducto) {
        this.txtPrecioProducto = txtPrecioProducto;
    }
    
    public SelectOneMenu getCmbEstadoProducto() {
        return cmbEstadoProducto;
    }
    
    public void setCmbEstadoProducto(SelectOneMenu cmbEstadoProducto) {
        this.cmbEstadoProducto = cmbEstadoProducto;
    }
    
    public ArrayList<SelectItem> getOpcionEstadoProducto() {
        if (opcionEstadoProducto == null) {
            opcionEstadoProducto = new ArrayList<>();
            try {
                List<Producto> listap = productologica.consultarTodo();
                for (int i = 0; i < listap.size(); i++) {
                    opcionEstadoProducto.add(new SelectItem(listap.get(i).getCodigoProducto(), listap.get(i).getEstadoProducto()));
                }
            } catch (Exception ex) {
                Logger.getLogger(ProductoVista.class.getName()).log(Level.SEVERE, null, "ERROR EN EL ARRAY LIS DE ESTADO-PRODUCTO" + ex.getMessage());
            }
        }
        return opcionEstadoProducto;
    }
    
    public void setOpcionEstadoProducto(ArrayList<SelectItem> opcionEstadoProducto) {
        this.opcionEstadoProducto = opcionEstadoProducto;
    }
    
    public List<Producto> getListaProductos() {
        if (listaProductos == null) {
            
            try {
                listaProductos = productologica.consultarTodo();
            } catch (Exception ex) {
                Logger.getLogger(ProductoVista.class.getName()).log(Level.SEVERE, null, "ERROR LISTA PRODUCTO" + ex.getMessage());
            }            
        }
        return listaProductos;
    }
    
    public void setListaProductos(List<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }
    
    public List<Categoria> getListaCategoriap() {
        try {
            if (listaCategoriap == null) {
                listaCategoriap = categorialogia.consultarTodo();
            }
        } catch (Exception ex) {
            Logger.getLogger(CategoriaVista.class.getName()).log(Level.SEVERE, null, "ERROR LISTA CATEGORIA" + ex.getMessage());
        }
        return listaCategoriap;
    }
    
    public void setListaCategoriap(List<Categoria> listaCategoriap) {
        this.listaCategoriap = listaCategoriap;
    }
    
    public Producto getSelecProducto() {
        return selecProducto;
    }
    
    public void setSelecProducto(Producto selecProducto) {
        this.selecProducto = selecProducto;
    }
    
    public Categoria getSelecCategoria() {
        return selecCategoriap;
    }
    
    public void setSelecCategoria(Categoria selecCategoria) {
        this.selecCategoriap = selecCategoria;
    }
    
    public void accion_registrar() {
        try {
            Producto nuevoProducto = new Producto();
            Categoria nuevaCategoria = new Categoria();
            nuevoProducto.setCodigoProducto(Integer.parseInt(txtcodigoProducto.getValue().toString()));
            nuevoProducto.setNombreProducto(txtnombreProducto.getValue().toString());            
            nuevoProducto.setFechaIngresoProducto((Date) txtfechaProducto.getValue());
            nuevoProducto.setGeneroProducto(cmbGenero.getValue().toString());
            nuevoProducto.setEstadoProducto(cmbEstadoProducto.getValue().toString());
            nuevoProducto.setColorProducto(txtColorProducto.getValue().toString());
            nuevoProducto.setPrecioProducto(Double.parseDouble(txtPrecioProducto.getValue().toString()));
            nuevaCategoria.setCodigoCategoria(Integer.parseInt(txtcategoria.getValue().toString()));
            nuevoProducto.setCodigoCategoria(nuevaCategoria);

            productologica.crear(nuevoProducto);
             FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Informacion", "Se resgistro con exito"));
            // limpiar();
            listaProductos = null;
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Informacion", "NO SE REALIZO EL REGISTRO"));
        }
    }

    public void seleccionFila(SelectEvent evt) {
        Categoria objeCategoria = selecCategoriap;
        txtcategoria.setValue(objeCategoria.getCodigoCategoria());
        listaCategoriap = null;
    }

    public void seleccionFilaProducto(SelectEvent evt) {
        Producto objetoProducto = selecProducto;
        txtcodigoProducto.setValue(objetoProducto.getCodigoProducto());
        txtnombreProducto.setValue(objetoProducto.getNombreProducto());
        txtfechaProducto.setValue((Date) objetoProducto.getFechaIngresoProducto());
        cmbGenero.setValue(objetoProducto.getGeneroProducto());
        cmbGenero.setLabel(objetoProducto.getGeneroProducto());
        txtColorProducto.setValue(objetoProducto.getColorProducto());
        txtPrecioProducto.setValue(objetoProducto.getPrecioProducto());
        txtcategoria.setValue(objetoProducto.getCodigoCategoria().getCodigoCategoria());
        cmbEstadoProducto.setValue(objetoProducto.getEstadoProducto());
        btnRegistrar.setDisabled(true);
        btnModificar.setDisabled(false);
        btnEliminar.setDisabled(false);
        txtcategoria.setDisabled(true);
        listaProductos = null;
        /*  
         SelectItem genero;
         List<SelectItem>listagenero=new ArrayList<>();
         
         genero=new SelectItem();
         genero.setLabel(objetoProducto.getGeneroProducto());
         genero.setValue(objetoProducto.getGeneroProducto());
         listagenero.add(genero);
         combtipogeneros=listagenero;
         */
        
    }

    public void limpiar() {
        try{
        txtcodigoProducto.setValue("");
        txtnombreProducto.setValue("");
        txtfechaProducto = null;
        txtfechaProducto.setValue("");
        cmbGenero.setValue("seleccione");
        cmbEstadoProducto.setValue("seleccione");
        txtColorProducto.setValue("");
        txtPrecioProducto.setValue("");
        txtcategoria.setValue("");
        
        btnRegistrar.setDisabled(false);
        }catch(Exception ex){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Mensaje", "El formulario no se pudo limpiar  "+ex.getMessage()));
        }
    }
    public void modificarProducto(){
    
       try {
            Producto nuevoProducto = new Producto();
            Categoria nuevaCategoria = new Categoria();
            nuevoProducto.setCodigoProducto(Integer.parseInt(txtcodigoProducto.getValue().toString()));
            nuevoProducto.setNombreProducto(txtnombreProducto.getValue().toString());            
            nuevoProducto.setFechaIngresoProducto((Date) txtfechaProducto.getValue());
            nuevoProducto.setGeneroProducto(cmbGenero.getValue().toString());
            nuevoProducto.setColorProducto(txtColorProducto.getValue().toString());
            nuevoProducto.setPrecioProducto(Double.parseDouble(txtPrecioProducto.getValue().toString()));
            nuevaCategoria.setCodigoCategoria(Integer.parseInt(txtcategoria.getValue().toString()));
            nuevoProducto.setCodigoCategoria(nuevaCategoria);
            nuevoProducto.setEstadoProducto(cmbEstadoProducto.getValue().toString());
            productologica.modificar(nuevoProducto);
            // limpiar();
             FacesContext.getCurrentInstance().addMessage("Mensaje", new FacesMessage(FacesMessage.SEVERITY_INFO, "Informacion", "Se modifico con exito"));
            listaProductos = null;
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage("Mensaje", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Informacion", "No se modificó con Éxito  "+ex.getMessage()));
        }
    }
    public void accion_eliminar(){
     try {
        Producto productoEliminado = new Producto();
        productoEliminado.setCodigoProducto(Integer.parseInt(txtcodigoProducto.getValue().toString()));
        productologica.eliminar(productoEliminado);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Mensaje", "El pruducto se elimino correctamente"));
        listaProductos = null;
    } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Mensaje", "El producto no se pudo eliminar"+ex.getMessage()));
    }
     
}
}
