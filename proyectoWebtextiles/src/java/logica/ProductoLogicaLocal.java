/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.List;
import javax.ejb.Local;
import modelo.Producto;

/**
 *
 * @author duberport
 */
@Local
public interface ProductoLogicaLocal {

    void crear(Producto producto) throws Exception;

    void modificar(Producto producto) throws Exception;

    void eliminar(Producto producto) throws Exception;

    Producto consultarPorCodigo(Integer codigoProducto) throws Exception;

    List<Producto> consultarTodo() throws Exception;
    
    public void generarReporteProducto(String url) throws Exception;
}
