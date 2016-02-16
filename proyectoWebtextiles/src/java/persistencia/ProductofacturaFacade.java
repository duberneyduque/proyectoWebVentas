/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modelo.Productofactura;

/**
 *
 * @author duberport
 */
@Stateless
public class ProductofacturaFacade extends AbstractFacade<Productofactura> implements ProductofacturaFacadeLocal {
    @PersistenceContext(unitName = "proyectoWebtextilesPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProductofacturaFacade() {
        super(Productofactura.class);
    }
    
}
