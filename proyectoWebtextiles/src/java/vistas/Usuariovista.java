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
import logica.UsuarioLogicaLocal;
import modelo.Categoria;
import modelo.Usuario;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.component.selectonemenu.SelectOneMenu;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author duberport
 */
@ManagedBean(name = "usuarioVistav")
@RequestScoped
public class Usuariovista {
  private InputText txtidUsuario;
  private InputText txtnombreUsuario;
  private InputText txtapellidoUsuario;
  private InputText txttelefonoUsuario;
  private InputText txtcorreoUsuario;
  private InputText txttipoUsuario;
  private InputText txtclaveUsuario;
  private InputText txtcodigoBuscar;
  private CommandButton btnRegistrar;
  private CommandButton btnModificar;
  private CommandButton btnEliminar;
  private CommandButton btnLimpiar;
  private List<Usuario> listaUsuario;
  private Usuario selecteUsuario;
  private SelectOneMenu cmbtipoUsuario;
  
  @EJB
  private UsuarioLogicaLocal usuarioLogica;

    public Usuariovista() {
    }

    public InputText getTxtidUsuario() {
        return txtidUsuario;
    }

    public void setTxtidUsuario(InputText txtidUsuario) {
        this.txtidUsuario = txtidUsuario;
    }

    public InputText getTxtnombreUsuario() {
        return txtnombreUsuario;
    }

    public void setTxtnombreUsuario(InputText txtnombreUsuario) {
        this.txtnombreUsuario = txtnombreUsuario;
    }

    public InputText getTxtapellidoUsuario() {
        return txtapellidoUsuario;
    }

    public void setTxtapellidoUsuario(InputText txtapellidoUsuario) {
        this.txtapellidoUsuario = txtapellidoUsuario;
    }

    public InputText getTxttelefonoUsuario() {
        return txttelefonoUsuario;
    }

    public void setTxttelefonoUsuario(InputText txttelefonoUsuario) {
        this.txttelefonoUsuario = txttelefonoUsuario;
    }

    public InputText getTxtcorreoUsuario() {
        return txtcorreoUsuario;
    }

    public void setTxtcorreoUsuario(InputText txtcorreoUsuario) {
        this.txtcorreoUsuario = txtcorreoUsuario;
    }

    public InputText getTxttipoUsuario() {
        return txttipoUsuario;
    }

    public void setTxttipoUsuario(InputText txttipoUsuario) {
        this.txttipoUsuario = txttipoUsuario;
    }

    public InputText getTxtclaveUsuario() {
        return txtclaveUsuario;
    }

    public void setTxtclaveUsuario(InputText txtclaveUsuario) {
        this.txtclaveUsuario = txtclaveUsuario;
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

    public CommandButton getBtnLimpiar() {
        return btnLimpiar;
    }

    public void setBtnLimpiar(CommandButton btnLimpiar) {
        this.btnLimpiar = btnLimpiar;
    }

    public List<Usuario> getListaUsuario() {
          try {
                if(listaUsuario==null){
                listaUsuario=usuarioLogica.consultarTodo();
                }
            } catch (Exception ex) {
                Logger.getLogger(CategoriaVista.class.getName()).log(Level.SEVERE, null, ex.getMessage());
            }
        
        
        return listaUsuario;
    }

    public void setListaUsuario(List<Usuario> listaUsuario) {
        this.listaUsuario = listaUsuario;
    }

    public Usuario getSelecteUsuario() {
        return selecteUsuario;
    }

    public void setSelecteUsuario(Usuario selecteUsuario) {
        this.selecteUsuario = selecteUsuario;
    }

    public UsuarioLogicaLocal getUsuarioLogica() {
        return usuarioLogica;
    }

    public void setUsuarioLogica(UsuarioLogicaLocal usuarioLogica) {
        this.usuarioLogica = usuarioLogica;
    }

    public SelectOneMenu getCmbtipoUsuario() {
        return cmbtipoUsuario;
    }

    public void setCmbtipoUsuario(SelectOneMenu cmbtipoUsuario) {
        this.cmbtipoUsuario = cmbtipoUsuario;
    }
    
    
       
public void accion_registrar(){
     
        try {
            Usuario ObjetoUsuario=new Usuario();
            ObjetoUsuario.setIdUsuario(Integer.parseInt(txtidUsuario.getValue().toString()));
            ObjetoUsuario.setNombreUsuario((txtnombreUsuario.getValue().toString()));
            ObjetoUsuario.setApellidoUsuario((txtapellidoUsuario.getValue().toString()));
            ObjetoUsuario.setTelefonoUsuario((txttelefonoUsuario.getValue().toString()));
            ObjetoUsuario.setCorreoUsuario((txtcorreoUsuario.getValue().toString()));
            ObjetoUsuario.setTipoUsuario((cmbtipoUsuario.getValue().toString()));
            ObjetoUsuario.setClaveUsuario((txtclaveUsuario.getValue().toString()));
            usuarioLogica.crear(ObjetoUsuario);
            listaUsuario=null;// sino la pongo null no la refresca por que ya la tomaria como llena            
            //limpiar();
            //Ambientedeaprendizaje ambiente=new Ambientedeaprendizaje();
            //ambiente.setCodigoambiente(Integer.parseInt(txtcodigoambiente.getValue().toString()));
            //ObjetoReserva.setCodigoambiente(ambiente);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Informacion", "Mesaje informativo SE REGISTRO."));
            } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Informacion", ex.getMessage()));
        }
}
public void modificarUsuario(){
     try {
         Usuario Usuariomodificar=new Usuario();
            Usuariomodificar.setIdUsuario(Integer.parseInt(txtidUsuario.getValue().toString()));
            Usuariomodificar.setNombreUsuario((txtnombreUsuario.getValue().toString()));
            Usuariomodificar.setApellidoUsuario((txtapellidoUsuario.getValue().toString()));
            Usuariomodificar.setTelefonoUsuario((txttelefonoUsuario.getValue().toString()));
            Usuariomodificar.setCorreoUsuario((txtcorreoUsuario.getValue().toString()));
            Usuariomodificar.setTipoUsuario((cmbtipoUsuario.getValue().toString()));
            Usuariomodificar.setClaveUsuario((txtclaveUsuario.getValue().toString()));
        usuarioLogica.modificar(Usuariomodificar);
        listaUsuario = null;
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Mensaje", "el usuario  se  modifico correctamente")); 
    } catch (Exception ex) {
        Logger.getLogger(Usuariovista.class.getName()).log(Level.SEVERE, null, ex);
    }
}

public void limpiar(){
    txtidUsuario.setValue("");
    txtnombreUsuario.setValue("");
    txtapellidoUsuario.setValue("");
    txttelefonoUsuario.setValue("");
    txtcorreoUsuario.setValue("");
    cmbtipoUsuario.setValue(null);
    cmbtipoUsuario.setLabel("seleccione");
    txtclaveUsuario.setValue("");
    btnRegistrar.setDisabled(false);
    btnModificar.setDisabled(true);
    btnEliminar.setDisabled(true);
    txtidUsuario.setDisabled(false);
}
public void seleccionFila(SelectEvent evt){
    Usuario objusuario=selecteUsuario;
    
    txtidUsuario.setValue(objusuario.getIdUsuario());
    txtnombreUsuario.setValue(objusuario.getNombreUsuario());
    txtapellidoUsuario.setValue(objusuario.getApellidoUsuario());
    txttelefonoUsuario.setValue(objusuario.getTelefonoUsuario());
    txtcorreoUsuario.setValue(objusuario.getCorreoUsuario());
   cmbtipoUsuario.setValue(objusuario.getTipoUsuario());
    txtclaveUsuario.setValue(objusuario.getClaveUsuario());
    
     btnRegistrar.setDisabled(true);
    btnModificar.setDisabled(false);
    btnEliminar.setDisabled(false);
    txtidUsuario.setDisabled(true);
}

public void accion_eliminar(){
    try {
        Usuario ObjetoUsuario=new Usuario();
        ObjetoUsuario.setIdUsuario(Integer.parseInt(txtidUsuario.getValue().toString()));
        usuarioLogica.eliminar(ObjetoUsuario);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Mensaje", "el usuario se elimino correctamente"));
        listaUsuario = null;
    } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Mensaje", "el usuario no se pudo eliminar"));
    }
     
}
}

