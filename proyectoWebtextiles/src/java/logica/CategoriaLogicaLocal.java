/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.List;
import javax.ejb.Local;
import modelo.Categoria;

/**
 *
 * @author duberport
 */
@Local
public interface CategoriaLogicaLocal {
      void crear(Categoria categoria) throws Exception;

    void modificar(Categoria categoria) throws Exception;

    void eliminar(Categoria categoria) throws Exception;

    Categoria consultarPorCodigo(Integer codigoCategoria) throws Exception;

    List<Categoria> consultarTodo() throws Exception;
}
