/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.List;
import javax.ejb.Local;
import modelo.Productofactura;

/**
 *
 * @author Estudiante
 */
@Local
public interface productofacturaLogicaLocal {
     void crear(Productofactura productofactura) throws Exception;

    void modificar(Productofactura productofactura) throws Exception;

    void eliminar(Productofactura productofactura) throws Exception;

    Productofactura consultarPorCodigo(Productofactura productofactura) throws Exception;
    
    List<Productofactura> consultarTodo() throws Exception;
    
}
