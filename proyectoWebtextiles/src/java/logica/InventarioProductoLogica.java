/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import modelo.Factura;
import modelo.Inventarioproducto;
import persistencia.InventarioproductoFacadeLocal;

/**
 *
 * @author Estudiante
 */
@Stateless
public class InventarioProductoLogica implements InventarioProductoLogicaLocal {
@EJB private InventarioproductoFacadeLocal inventarioproductoDAO;
    @Override
    public void crear(Inventarioproducto inventarioproducto) throws Exception {
        Inventarioproducto objinventarioproducto = inventarioproductoDAO.find(inventarioproducto.getInventarioproductoPK().getTallaInventario());
    if(inventarioproducto!=null){
        if(inventarioproducto.getInventarioproductoPK().getTallaInventario()==null){
            throw new Exception("Codigo de la factura  es obligatorio"); 
        }else if(inventarioproducto.getProducto()==null || inventarioproducto.getProducto().equals("")){
            throw new Exception("La cedula  es obligatorio");
        }
    }else{
        throw new Exception("La factura no tiene informacion");
    }
    if(objinventarioproducto==null){
        inventarioproductoDAO.create(inventarioproducto);
    }else{
        throw new Exception("La factura ya esta registrado");
    }
    }

    @Override
    public void modificar(Inventarioproducto inventarioproducto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminar(Inventarioproducto inventarioproducto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Inventarioproducto consultarPorCodigo(Inventarioproducto inventarioproducto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Inventarioproducto> consultarTodo() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
