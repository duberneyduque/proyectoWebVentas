/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modelo.Inventarioproducto;

/**
 *
 * @author duberport
 */
@Stateless
public class InventarioproductoFacade extends AbstractFacade<Inventarioproducto> implements InventarioproductoFacadeLocal {
    @PersistenceContext(unitName = "proyectoWebtextilesPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public InventarioproductoFacade() {
        super(Inventarioproducto.class);
    }
    
}
