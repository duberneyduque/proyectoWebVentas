/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.List;
import javax.ejb.Local;
import modelo.Inventarioproducto;

/**
 *
 * @author duberport
 */
@Local
public interface InventarioproductoFacadeLocal {

    void create(Inventarioproducto inventarioproducto);

    void edit(Inventarioproducto inventarioproducto);

    void remove(Inventarioproducto inventarioproducto);

    Inventarioproducto find(Object id);

    List<Inventarioproducto> findAll();

    List<Inventarioproducto> findRange(int[] range);

    int count();
    
}
