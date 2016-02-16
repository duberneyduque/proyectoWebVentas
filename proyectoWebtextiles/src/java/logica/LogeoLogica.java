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
 * @author duberport
 */
@Stateless
public class LogeoLogica implements LogeoLogicaLocal {

    @EJB 
   private UsuarioFacadeLocal usuarioDAO;

    @Override
    public Usuario iniciarSesionUsuario(Integer idUsuario, String claveUsuario) throws Exception {
     if(idUsuario==null || claveUsuario==null){
          throw new Exception("Los datos de ingresos son obligatorios");
     }
     if(claveUsuario.equals("")){
          throw new Exception("La clave es obligatoria");
     } 
     Usuario usuario=usuarioDAO.find(idUsuario);
     if(usuario!=null){
         if(!usuario.getClaveUsuario().equals(claveUsuario)){
             throw new Exception("La contraseña es incorrecta");
         }
     }
     return usuario;
}

}