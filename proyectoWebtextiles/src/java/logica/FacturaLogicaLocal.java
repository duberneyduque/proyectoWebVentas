/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.List;
import javax.ejb.Local;
import modelo.Factura;
import modelo.Producto;

/**
 *
 * @author Estudiante
 */
@Local
public interface FacturaLogicaLocal {
    void crear(Factura factura) throws Exception;

    void modificar(Factura factura) throws Exception;

    void eliminar(Factura factura) throws Exception;

    Factura consultarPorCodigo(Integer codigoFactura) throws Exception;
    
    List<Factura> consultarTodo() throws Exception;
}
