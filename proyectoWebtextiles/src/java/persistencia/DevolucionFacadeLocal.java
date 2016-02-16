/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.List;
import javax.ejb.Local;
import modelo.Devolucion;

/**
 *
 * @author duberport
 */
@Local
public interface DevolucionFacadeLocal {

    void create(Devolucion devolucion);

    void edit(Devolucion devolucion);

    void remove(Devolucion devolucion);

    Devolucion find(Object id);

    List<Devolucion> findAll();

    List<Devolucion> findRange(int[] range);

    int count();
    
}
