/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.List;
import javax.ejb.Local;
import modelo.Productofactura;
import modelo.Productosdevolucion;

/**
 *
 * @author Estudiante
 */
@Local
public interface ProductosdevolucioLogicaLocal {
    void crear(Productosdevolucion productosdevolucion) throws Exception;

    void modificar(Productosdevolucion productosdevolucion) throws Exception;

    void eliminar(Productosdevolucion productosdevolucion) throws Exception;

    Productosdevolucion consultarPorCodigo(Productosdevolucion productosdevolucion) throws Exception;
    
    List<Productosdevolucion> consultarTodo() throws Exception;
    
}
