/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import modelo.Usuario;
import persistencia.UsuarioFacadeLocal;

/**
 *
 * @author Estudiante
 */
@Stateless
public class SessionLogica implements SessionLogicaLocal {
@EJB private UsuarioFacadeLocal UsuarioDAO;
    @Override
    public Usuario iniciarSesionAdministrador(Integer idUsuario, String claveUsuario ,String tipoUsuario) throws Exception {
        //if()
        if(idUsuario == null || claveUsuario== null){
            throw new Exception("Los datos de ingreso son obligatorios");
        }
        if(claveUsuario.equals("")){
            throw new Exception("La clave es obligatoria");
        }
        Usuario usuario = UsuarioDAO.find(idUsuario);
        if(usuario!=null){
            if(!usuario.getClaveUsuario().equals(claveUsuario)){
                throw new Exception("La contraseña es incorrecta");
            }
        }
        return usuario;  
    }

    @Override
    public Usuario iniciarSesionVendedor(Integer idUsuario, String claveUsuario, String tipoUsuario) throws Exception {
       if(idUsuario == null || claveUsuario== null){
            throw new Exception("Los datos de ingreso son obligatorios");
        }
        if(claveUsuario.equals("")){
            throw new Exception("La clave es obligatoria");
        }
        Usuario usuario = UsuarioDAO.find(idUsuario);
        if(usuario!=null){
            if(!usuario.getClaveUsuario().equals(claveUsuario)){
                throw new Exception("La contraseña es incorrecta");
            }
        }
        return usuario; 
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
