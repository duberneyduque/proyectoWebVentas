/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.List;
import javax.ejb.Local;
import modelo.Productofactura;

/**
 *
 * @author duberport
 */
@Local
public interface ProductofacturaFacadeLocal {

    void create(Productofactura productofactura);

    void edit(Productofactura productofactura);

    void remove(Productofactura productofactura);

    Productofactura find(Object id);

    List<Productofactura> findAll();

    List<Productofactura> findRange(int[] range);

    int count();
    
}
