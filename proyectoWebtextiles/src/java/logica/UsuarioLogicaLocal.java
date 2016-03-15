/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.List;
import javax.ejb.Local;
import modelo.Usuario;

/**
 *
 * @author Estudiante
 */
@Local
public interface UsuarioLogicaLocal {
     void crear(Usuario usuario) throws Exception;
   void modificar(Usuario usuario)throws Exception;
   void eliminar(Usuario usuario)throws Exception;
   Usuario consultarPorCodigo(Integer idUsuario)throws Exception;
    List<Usuario>consultarTodo()throws Exception;
     String  consultarTipousuario(int documento,String clave);
}
