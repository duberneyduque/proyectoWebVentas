/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import modelo.Ciudad;
import modelo.Usuario;
import persistencia.UsuarioFacadeLocal;

/**
 *
 * @author Estudiante
 */
 
@Stateless
public class UsuarioLogica implements UsuarioLogicaLocal {
@EJB
private UsuarioFacadeLocal UsuarioDAO;
    @Override
    public void crear(Usuario usuario) throws Exception {
        Usuario objUsuario = UsuarioDAO.find(usuario.getIdUsuario()); 
        if(usuario!=null){
        if(usuario.getIdUsuario()==null){
            throw new Exception("ID del usuario es obligatorio"); 
        }else if(usuario.getNombreUsuario()==null || usuario.getNombreUsuario().equals("")){
            throw new Exception("El nombre es obligatorio");
        }
    }else{
        throw new Exception("El usuario no tiene informacion");
    }
    if(objUsuario==null){
        UsuarioDAO.create(usuario);
    }else{
        throw new Exception("El usuario ya esta registrada");
    }
    }

    @Override
    public void modificar(Usuario usuario) throws Exception {
      Usuario objUsuario = UsuarioDAO.find(usuario.getIdUsuario()); 
        if(objUsuario!=null){
        if(usuario.getIdUsuario()==null){
            throw new Exception("ID del usuario es obligatorio"); 
        }else if(usuario.getNombreUsuario()==null || usuario.getNombreUsuario().equals("")){
            throw new Exception("El nombre es obligatorio");
        }
    }else{
        throw new Exception("El usuario no tiene informacion");
    }
    if(objUsuario!=null){
        UsuarioDAO.edit(usuario);
    }else{
        throw new Exception("El usuario ya esta registrado");
    } 
    }

    @Override
    public void eliminar(Usuario usuario) throws Exception {
        Usuario objUsuario= UsuarioDAO.find(usuario.getIdUsuario());
        if(usuario.getIdUsuario()!=null){
            if(usuario.getIdUsuario()==null){
                throw new Exception("ID del  usuario es obligatorio");
            
        }
        }else{
            throw new Exception("la base de datos no contiene este usurio");
        }
        if(objUsuario==null){
            throw new Exception("El usuario no existe, no se puede Eliminar!");
        }else{
            UsuarioDAO.remove(usuario);
        }
    }

    @Override
    public Usuario consultarPorCodigo(Integer idUsuario) throws Exception {
        if(idUsuario!=null){
           return UsuarioDAO.find(idUsuario);
       }else{
           throw new Exception("El ID para consultar es obligatorio");
       }
    }

    @Override
    public List<Usuario> consultarTodo() throws Exception {
         return UsuarioDAO.findAll();
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public String consultarTipousuario(int documento, String clave) {
        Usuario usuario=UsuarioDAO.find(documento);
        if(usuario.getIdUsuario()==documento && usuario.getClaveUsuario().equals(clave)){
          String  tipoUsuario=usuario.getTipoUsuario();
          return tipoUsuario;
        }
      return null;
    }
}
