/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import logica.LogeoLogicaLocal;
import modelo.Usuario;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.component.password.Password;

/**
 *
 * @author duberport
 */
@ManagedBean(name="sessionVistav")
@RequestScoped
public class LogeoVista {
    
    
   private InputText txtUsuario;
   private Password txtClave;
   private CommandButton btningresar;
   @EJB
   private LogeoLogicaLocal logeologica;
   
   
    public LogeoVista() {
      
    }

    public InputText getTxtUsuario() {
        return txtUsuario;
    }

    public void setTxtUsuario(InputText txtUsuario) {
        this.txtUsuario = txtUsuario;
    }

    public Password getTxtClave() {
        return txtClave;
    }

    public void setTxtClave(Password txtClave) {
        this.txtClave = txtClave;
    }

    public CommandButton getBtningresar() {
        return btningresar;
    }

    public void setBtningresar(CommandButton btningresar) {
        this.btningresar = btningresar;
    }

    public LogeoLogicaLocal getLogeologica() {
        return logeologica;
    }

    public void setLogeologica(LogeoLogicaLocal logeologica) {
        this.logeologica = logeologica;
    }
    public void funcion_ingresar(){
       try {
           int idUsuario=Integer.parseInt(txtUsuario.getValue().toString());
           String clave=txtClave.getValue().toString();
           Usuario usuarioLogeo = logeologica.iniciarSesionUsuario(idUsuario, clave);
           if(usuarioLogeo==null){
           
           }
       } catch (Exception ex) {
           Logger.getLogger(LogeoVista.class.getName()).log(Level.SEVERE, null, ex);
       }
       
    
    }
}
