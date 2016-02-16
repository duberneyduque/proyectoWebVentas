/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.List;
import javax.ejb.Local;
import modelo.Productosdevolucion;

/**
 *
 * @author duberport
 */
@Local
public interface ProductosdevolucionFacadeLocal {

    void create(Productosdevolucion productosdevolucion);

    void edit(Productosdevolucion productosdevolucion);

    void remove(Productosdevolucion productosdevolucion);

    Productosdevolucion find(Object id);

    List<Productosdevolucion> findAll();

    List<Productosdevolucion> findRange(int[] range);

    int count();
    
}
