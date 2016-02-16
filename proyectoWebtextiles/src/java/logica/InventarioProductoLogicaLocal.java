/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.List;
import javax.ejb.Local;
import modelo.Factura;
import modelo.Inventarioproducto;

/**
 *
 * @author Estudiante
 */
@Local
public interface InventarioProductoLogicaLocal {
     void crear(Inventarioproducto inventarioproducto) throws Exception;

    void modificar(Inventarioproducto inventarioproducto) throws Exception;

    void eliminar(Inventarioproducto inventarioproducto) throws Exception;

    Inventarioproducto consultarPorCodigo(Inventarioproducto inventarioproducto) throws Exception;
    
    List<Inventarioproducto> consultarTodo() throws Exception;
}
