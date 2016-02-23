/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import logica.SessionLogicaLocal;
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
        
    
}
