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
import logica.UsuarioLogicaLocal;
import modelo.Usuario;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.component.password.Password;
import persistencia.UsuarioFacade;
import persistencia.UsuarioFacadeLocal;

/**
 *
 * @author Estudiante
 */
@ManagedBean(name = "sesionVista")
@RequestScoped
public class SesionVista {

    @EJB
    private UsuarioLogicaLocal usuariologica;
    @EJB
    private SessionLogicaLocal sesionLogica;
    @EJB
    private UsuarioFacadeLocal usuariofacade;
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

    
    public void ingresar() {
        try {
            FacesContext contex = FacesContext.getCurrentInstance();
            ExternalContext extcontex = contex.getExternalContext();
            String urlA = "";
            String urlV = "";

            urlV = extcontex.encodeActionURL(contex.getApplication().getViewHandler().getActionURL(contex, "/vendedor/gestionProductoVE.xhtml"));
            urlA = extcontex.encodeActionURL(contex.getApplication().getViewHandler().getActionURL(contex, "/administrador/gestionProductoAD.xhtml"));
            Integer documento = Integer.parseInt(txtUsuario.getValue().toString());
            String clave = txtclave.getValue().toString();

            Usuario usuario = usuariologica.consultarPorCodigo(Integer.parseInt(txtUsuario.getValue().toString()));
            if (usuario == null) {
               
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "error", "el usuario no existe"));
            } else {
                if (usuario.getClaveUsuario().equals(clave)) {
                    if (usuario.getTipoUsuario().equals("administrador")) {
                        extcontex.getSessionMap().put("Usuario",usuario);
                        extcontex.getSessionMap().put("tipo", "administrador");
                        extcontex.redirect(urlA);
                    }else if(usuario.getTipoUsuario().equals("vendedor")){ 
                         extcontex.getSessionMap().put("Usuario",usuario);
                        extcontex.getSessionMap().put("tipo", "vendedor");
                        extcontex.redirect(urlV);
                    }
                } else {
                   
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "error", "Contraseña incorrecta"));
                }
            }
        } catch (Exception ex) {
           // Logger.getLogger(SesionVista.class.getName()).log(Level.SEVERE, null, ex);
             FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "error", "el usuario tiene que ser en numeros"));
        }

    }

    public void cerrarSesion_action() {
        try {
            FacesContext context = FacesContext.getCurrentInstance();
            ExternalContext extContext = context.getExternalContext();
            extContext.getSessionMap().remove("tipo");
            extContext.getSessionMap().remove("Usuario");
            String url = extContext.encodeActionURL(context.getApplication().getViewHandler().getActionURL(context, "/gestionLogeo.xhtml"));
            extContext.redirect(url);
        } catch (IOException ex) {
            Logger.getLogger(SesionVista.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
