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
import logica.CategoriaLogicaLocal;
import modelo.Categoria;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author duberport
 */
@ManagedBean(name = "categoriaVistav")
@RequestScoped
public class CategoriaVista {
  private InputText txtcodigoCategoria;
  private InputText txtnombreCategoria;
  private InputText txtcodigoBuscar;
  private CommandButton btnRegistrar;
  private CommandButton btnModificar;
  private CommandButton btnEliminar;
  private CommandButton btnLimpiar;
  private List<Categoria> listaCategoria;
  private Categoria selecteCategoria;
  
  @EJB
  private CategoriaLogicaLocal categoriaLogica;
    /**
     * Creates a new instance of CategoriaVista
     */
    public CategoriaVista() {
    }

    public CommandButton getBtnLimpiar() {
        return btnLimpiar;
    }

    public void setBtnLimpiar(CommandButton btnLimpiar) {
        this.btnLimpiar = btnLimpiar;
    }

    public InputText getTxtcodigoCategoria() {
        return txtcodigoCategoria;
    }

    public void setTxtcodigoCategoria(InputText txtcodigoCategoria) {
        this.txtcodigoCategoria = txtcodigoCategoria;
    }

    public InputText getTxtnombreCategoria() {
        return txtnombreCategoria;
    }

    public void setTxtnombreCategoria(InputText txtnombreCategoria) {
        this.txtnombreCategoria = txtnombreCategoria;
    }

    public InputText getTxtcodigoBuscar() {
        return txtcodigoBuscar;
    }

    public void setTxtcodigoBuscar(InputText txtcodigoBuscar) {
        this.txtcodigoBuscar = txtcodigoBuscar;
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

    public List<Categoria> getListaCategoria() {
        
            try {
                if(listaCategoria==null){
                listaCategoria=categoriaLogica.consultarTodo();
                }
            } catch (Exception ex) {
                Logger.getLogger(CategoriaVista.class.getName()).log(Level.SEVERE, null, ex.getMessage());
            }
        
        return listaCategoria;
    }

    public void setListaCategoria(List<Categoria> listaCategoria) {
        this.listaCategoria = listaCategoria;
    }

    public Categoria getSelecteCategoria() {
        return selecteCategoria;
    }

    public void setSelecteCategoria(Categoria selecteCategoria) {
        this.selecteCategoria = selecteCategoria;
    }
public void accion_registrar(){
     
        try {
            Categoria ObjetoCategoria=new Categoria();
            ObjetoCategoria.setCodigoCategoria(Integer.parseInt(txtcodigoCategoria.getValue().toString()));
            ObjetoCategoria.setNombreCategoria(txtnombreCategoria.getValue().toString());
            categoriaLogica.crear(ObjetoCategoria);
            listaCategoria=null;// sino la pongo null no la refresca por que ya la tomaria como llena            
            //limpiar();
            //Ambientedeaprendizaje ambiente=new Ambientedeaprendizaje();
            //ambiente.setCodigoambiente(Integer.parseInt(txtcodigoambiente.getValue().toString()));
            //ObjetoReserva.setCodigoambiente(ambiente);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Informacion", "Mesaje informativo SE REGISTRO."));
            } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Informacion", ex.getMessage()));
        }
}
public void accion_modificar(){
     try {
        Categoria nuevocategoria = new Categoria();
        nuevocategoria.setCodigoCategoria(Integer.parseInt(txtcodigoCategoria.getValue().toString()));
        nuevocategoria.setNombreCategoria(txtnombreCategoria.getValue().toString());
        categoriaLogica.modificar(nuevocategoria);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Mensaje", "la categoria se  modifico correctamente"));
        listaCategoria = null;
    } catch (Exception ex) {
        Logger.getLogger(CategoriaVista.class.getName()).log(Level.SEVERE, null, ex);
    }
}

public void limpiar(){
    txtcodigoCategoria.setValue("");
    txtnombreCategoria.setValue("");
    btnRegistrar.setDisabled(false);
    btnModificar.setDisabled(true);
    btnEliminar.setDisabled(true);
    txtcodigoCategoria.setDisabled(false);
}
public void seleccionFila(SelectEvent evt){
    Categoria objecategoria=selecteCategoria;
    txtcodigoCategoria.setValue(objecategoria.getCodigoCategoria());
    txtnombreCategoria.setValue(objecategoria.getNombreCategoria());
     btnRegistrar.setDisabled(true);
    btnModificar.setDisabled(false);
    btnEliminar.setDisabled(false);
    txtcodigoCategoria.setDisabled(true);
}
public void accion_eliminar(){
     try {
        Categoria categoriaeliminada = new Categoria();
        categoriaeliminada.setCodigoCategoria(Integer.parseInt(txtcodigoCategoria.getValue().toString()));
        categoriaLogica.eliminar(categoriaeliminada);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Mensaje", "la categoria se elimino correctamente"));
        listaCategoria = null;
    } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Mensaje", "la categoria no se pudo eliminar"));
    }
     
}
}
