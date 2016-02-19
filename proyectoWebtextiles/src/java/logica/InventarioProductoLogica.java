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
            throw new Exception("Codigo de la talla  es obligatorio"); 
        }else if(inventarioproducto.getProducto()==null || inventarioproducto.getProducto().equals("")){
            throw new Exception("el producto es obligatorio");
        }
    }else{
        throw new Exception("El inventario no tiene informacion");
    }
    if(objinventarioproducto==null){
        inventarioproductoDAO.create(inventarioproducto);
    }else{
        throw new Exception("La talla  ya esta registrado");
    }
    }

    @Override
    public void modificar(Inventarioproducto inventarioproducto) throws Exception {
        Inventarioproducto objinventarioproducto = inventarioproductoDAO.find(inventarioproducto.getInventarioproductoPK().getTallaInventario());
    if(inventarioproducto!=null){
        if(inventarioproducto.getInventarioproductoPK().getTallaInventario()==null){
            throw new Exception("Codigo de la talla  es obligatorio"); 
        }else if(inventarioproducto.getProducto()==null || inventarioproducto.getProducto().equals("")){
            throw new Exception("el producto es obligatorio");
        }
    }else{
        throw new Exception("El inventario no tiene informacion");
    }
    if(objinventarioproducto==null){
        inventarioproductoDAO.edit(inventarioproducto);
    }else{
        throw new Exception("La talla  ya esta registrado");
    }
    }

    @Override
    public void eliminar(Inventarioproducto inventarioproducto) throws Exception {
          Inventarioproducto objinventarioproducto = inventarioproductoDAO.find(inventarioproducto.getInventarioproductoPK().getTallaInventario());
    if(inventarioproducto!=null){
        if(inventarioproducto.getInventarioproductoPK().getTallaInventario()==null){
            throw new Exception("La talla de iventario es obligatorio"); 
        }
    }else{
        throw new Exception("En la base de datos la talla  a eliminar no existe");
    }
    if(objinventarioproducto==null){
         throw new Exception("La talla no existe, no se puede eliminar");
    }else{
       
        inventarioproductoDAO.remove(inventarioproducto);
    }
    }

    @Override
    public Inventarioproducto consultarPorCodigo(Inventarioproducto inventarioproducto) throws Exception {
        if(inventarioproducto.getInventarioproductoPK().getTallaInventario()!=null){
           return inventarioproductoDAO.find(inventarioproducto);
       }else{
           throw new Exception("La talla  para consultar es obligatorio");
       }
    }

    @Override
    public List<Inventarioproducto> consultarTodo() throws Exception {
       return inventarioproductoDAO.findAll();
    }

  
}
