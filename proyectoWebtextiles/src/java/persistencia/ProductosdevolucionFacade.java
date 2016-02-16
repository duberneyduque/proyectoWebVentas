/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modelo.Productosdevolucion;

/**
 *
 * @author duberport
 */
@Stateless
public class ProductosdevolucionFacade extends AbstractFacade<Productosdevolucion> implements ProductosdevolucionFacadeLocal {
    @PersistenceContext(unitName = "proyectoWebtextilesPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProductosdevolucionFacade() {
        super(Productosdevolucion.class);
    }
    
}
