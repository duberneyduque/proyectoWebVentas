/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import logica.SessionLogicaLocal;
import modelo.Usuario;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.component.password.Password;

/**
 *
 * @author Estudiante
 */
@ManagedBean(name = "sesionVista")
@RequestScoped
public class SesionVista {
    @EJB
    private SessionLogicaLocal sesionLogica;
    
    private InputText txtUsuario;
    private Password txtclave;
    private CommandButton btnIngresar;
    
        public SesionVista() {
    }

    public SessionLogicaLocal getSesionLogica() {
        return sesionLogica;
    }

    public void setSesionLogica(SessionLogicaLocal sesionLogica) {
        this.sesionLogica = sesionLogica;
    }

    public InputText getTxtUsuario() {
        return txtUsuario;
    }

    public void setTxtUsuario(InputText txtUsuario) {
        this.txtUsuario = txtUsuario;
    }

    public Password getTxtclave() {
        return txtclave;
    }

    public void setTxtclave(Password txtclave) {
        this.txtclave = txtclave;
    }

    public CommandButton getBtnIngresar() {
        return btnIngresar;
    }

    public void setBtnIngresar(CommandButton btnIngresar) {
        this.btnIngresar = btnIngresar;
    }
   
    public void ingresar (){
        FacesContext contex = FacesContext.getCurrentInstance();
        ExternalContext extcontex =contex.getExternalContext();
        String urlA=""; String urlV="";
      try {
          urlA = extcontex.encodeActionURL(contex.getApplication().getViewHandler().getActionURL(contex,"/gestionInforme.xhtml"));
          urlV = extcontex.encodeActionURL(contex.getApplication().getViewHandler().getActionURL(contex,"/gestionMonitor.xhtml"));
          Integer documento = Integer.parseInt(txtUsuario.getValue().toString());
          String clave = txtclave.getValue().toString();
          Usuario vendendorlogeado = sesionLogica.iniciarSesionVendedor(documento, clave);
          Usuario administradorlogeado = null;
          if (vendendorlogeado==null){
             administradorlogeado = sesionLogica.iniciarSesionAdministrador(documento, clave);
             if (administradorlogeado==null){
                 FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"error","el usuario no existe"));
             }else{
                 // funcionari administrador
                 extcontex.getSessionMap().put("Usuario",administradorlogeado);
                  extcontex.getSessionMap().put("tipo", "funcionario");
                  extcontex.redirect(urlA);
             }
          }else {
                 // vendedor logeado
              extcontex.getSessionMap().put("Usuario", vendendorlogeado);
                  extcontex.getSessionMap().put("tipo", "monitor");
                  extcontex.redirect(urlV);
          }
      } catch (Exception ex) {
           FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"error",ex.getMessage()));
      }
    }
     public void cerrarSesion_action()
    {
        try {
            FacesContext context = FacesContext.getCurrentInstance();
            ExternalContext extContext= context.getExternalContext();
            extContext.getSessionMap().remove("tipo");
            extContext.getSessionMap().remove("usuario");
            String url=extContext.encodeActionURL(context.getApplication().getViewHandler().getActionURL(context,"/index.xhtml"));
            extContext.redirect(url);
        } catch (IOException ex) {
            Logger.getLogger(SesionVista.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
