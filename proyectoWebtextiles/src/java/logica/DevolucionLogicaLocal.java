/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.List;
import javax.ejb.Local;
import modelo.Devolucion;

/**
 *
 * @author Estudiante
 */
@Local
public interface DevolucionLogicaLocal {
    public void create (Devolucion devolucion) throws Exception;
    public void edit (Devolucion devolucion) throws Exception;
    public void remove (Devolucion devoluciona) throws Exception;
    public List<Devolucion> consultar() throws Exception;
    public Devolucion consultarPorcodigoDevolucion (Integer codigodevolucion) throws Exception;
    public List<Devolucion> consultarDevolucionCliente (Long cedulacliente) throws Exception;
}
