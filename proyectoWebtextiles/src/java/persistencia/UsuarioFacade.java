/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import modelo.Usuario;

/**
 *
 * @author duberport
 */
@Stateless
public class UsuarioFacade extends AbstractFacade<Usuario> implements UsuarioFacadeLocal {
    @PersistenceContext(unitName = "proyectoWebtextilesPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioFacade() {
        super(Usuario.class);
    }

    @Override
    public String consultarTipousuario(int documento, String clave) {
         String consulta = "select u.tipoUsuario from Usuario u where u.idUsuario="+documento+"and u.claveUsuario="+clave+"";
       try{
       Query query= em.createQuery(consulta);
        return (String) query.getSingleResult();
       }catch(NoResultException nre){
       return null;
       }
    }

   
    
    
}
