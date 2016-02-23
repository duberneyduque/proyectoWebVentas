/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import javax.ejb.Local;
import modelo.Usuario;

/**
 *
 * @author Estudiante
 */
@Local
public interface SessionLogicaLocal {
    
    public Usuario iniciarSesionAdministrador(Integer idUsuario, String claveUsuario) throws Exception;
    public Usuario iniciarSesionVendedor(Integer idUsuario, String claveUsuario) throws Exception;
    
}
