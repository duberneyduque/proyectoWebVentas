/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.List;
import javax.ejb.Local;
import modelo.Ciudad;


/**
 *
 * @author duberport
 */
@Local
public interface CiudadLogicaLocal {
   void crear(Ciudad ciudad) throws Exception;
   void modificar(Ciudad ciudad)throws Exception;
   void eliminar(Ciudad ciudad)throws Exception;
   Ciudad consultarPorCodigo(Integer codigoCiudad)throws Exception;
    List<Ciudad>consultarTodo()throws Exception;
}
