package vistas;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.swing.text.html.HTMLEditorKit;
import logica.CiudadLogicaLocal;
import modelo.Ciudad;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author duberport
 */
@ManagedBean(name = "ciudadVistav")
@RequestScoped
public class CiudadVista {
   
    private InputText txtcodigociudad;
    private InputText txtnombreciudad;
    private CommandButton btnRegistrar;
    private CommandButton btnModificar;
    private CommandButton btnEliminar;
    private CommandButton btnLimpiar;
    private List<Ciudad> listaCiudad;
    private Ciudad selecteCiudad;

    @EJB
    private CiudadLogicaLocal ciudadLogica;
    public CiudadVista() {
    }

    public InputText getTxtcodigociudad() {
        return txtcodigociudad;
    }

    public void setTxtcodigociudad(InputText txtcodigociudad) {
        this.txtcodigociudad = txtcodigociudad;
    }

    public InputText getTxtnombreciudad() {
        return txtnombreciudad;
    }

    public void setTxtnombreciudad(InputText txtnombreciudad) {
        this.txtnombreciudad = txtnombreciudad;
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

    public List<Ciudad> getListaCiudad() {
        
                if(listaCiudad==null){
                    try {
                        listaCiudad=ciudadLogica.consultarTodo();
                          } catch (Exception ex) {
           FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Mensaje", "la ListaCiudad esta vacia"));
                    }
        }
        return listaCiudad;
    }

    public void setListaCiudad(List<Ciudad> listaCiudad) {
        this.listaCiudad = listaCiudad;
    }

    public Ciudad getSelecteCiudad() {
        return selecteCiudad;
    }

    public void setSelecteCiudad(Ciudad selecteCiudad) {
        this.selecteCiudad = selecteCiudad;
    }

    public CiudadLogicaLocal getCiudadLogica() {
        return ciudadLogica;
    }

    public void setCiudadLogica(CiudadLogicaLocal ciudadLogica) {
        this.ciudadLogica = ciudadLogica;
    }
public void accion_registrar(){
    
        try {
            Ciudad objetociudad=new Ciudad();
            
            if(txtcodigociudad.getValue().equals("")&& txtnombreciudad.getValue().equals("")){
                 txtcodigociudad.setPlaceholder("Debe llenar el campo");
                 txtnombreciudad.setPlaceholder("Debe llenar el campo");
            }else{
            objetociudad.setCodigoCiudad(Integer.parseInt(txtcodigociudad.getValue().toString()));
            objetociudad.setNombreCiudad(txtnombreciudad.getValue().toString().toUpperCase());
            txtcodigociudad.setPlaceholder(null);
            txtnombreciudad.setPlaceholder(null);
            }
            ciudadLogica.crear(objetociudad);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Mensaje", "la ciudad se registro con exito"));
            listaCiudad=null;
        } catch (Exception ex) {
           FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Mensaje", "la ciudad no se pudo registrar debe llenar los campos"));
        }
        
    }
public void accion_modificar(){
        try {
            Ciudad nuevociudad=new Ciudad();
            nuevociudad.setCodigoCiudad(Integer.parseInt(txtcodigociudad.getValue().toString()));
            nuevociudad.setNombreCiudad(txtnombreciudad.getValue().toString().toUpperCase());
            ciudadLogica.modificar(nuevociudad);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Mensaje", "la ciudad se  modifico correctamente"));
            listaCiudad = null;
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Mensaje", "la ciudad no se  modifico"));
        }

}
public void limpiar(){
txtcodigociudad.setValue("");
txtnombreciudad.setValue("");
    btnRegistrar.setDisabled(false);
    btnModificar.setDisabled(true);
    btnEliminar.setDisabled(true);
    txtcodigociudad.setDisabled(false);
}
public void seleccionFila(SelectEvent evt){
    Ciudad objeCiudad=selecteCiudad;
    txtcodigociudad.setValue(objeCiudad.getCodigoCiudad());
    txtnombreciudad.setValue(objeCiudad.getNombreCiudad());
    btnRegistrar.setDisabled(true);
    btnModificar.setDisabled(false);
    btnEliminar.setDisabled(false);
    txtcodigociudad.setDisabled(true);
    
}
public void accion_eliminar(){
        try {
            Ciudad ciudadEliminada=new Ciudad();
            ciudadEliminada.setCodigoCiudad(Integer.parseInt(txtcodigociudad.getValue().toString()));
            ciudadLogica.eliminar(ciudadEliminada);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Mensaje", "la ciudad se elimino correctamente"));
            listaCiudad=null;
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Mensaje", "la ciudad no se pudo eliminar"));
        }
   
}
}

