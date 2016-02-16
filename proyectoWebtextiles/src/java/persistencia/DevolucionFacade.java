/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modelo.Devolucion;

/**
 *
 * @author duberport
 */
@Stateless
public class DevolucionFacade extends AbstractFacade<Devolucion> implements DevolucionFacadeLocal {
    @PersistenceContext(unitName = "proyectoWebtextilesPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DevolucionFacade() {
        super(Devolucion.class);
    }
    
}
