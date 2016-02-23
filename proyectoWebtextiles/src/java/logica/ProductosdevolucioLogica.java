/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import modelo.Productofactura;
import modelo.Productosdevolucion;
import persistencia.ProductosdevolucionFacadeLocal;

/**
 *
 * @author Estudiante
 */
@Stateless
public class ProductosdevolucioLogica implements ProductosdevolucioLogicaLocal {
@EJB private ProductosdevolucionFacadeLocal productosdevolucionDAO;
    @Override
    public void crear(Productosdevolucion productosdevolucion) throws Exception {
        Productosdevolucion objproductodevolucion = productosdevolucionDAO.find(productosdevolucion.getProducto());
        if(productosdevolucion!=null){
        if(productosdevolucion.getCantidad()==null){
            throw new Exception("la cantidad es obligatoria");
        }else if (productosdevolucion.getProducto()==null || productosdevolucion.getProducto().equals("")){
         throw new Exception("el producto es obligatorio");
        }
        
        }else{
        throw new Exception("El producto de la factura no tiene informacion");
    }
    if(objproductodevolucion==null){
        productosdevolucionDAO.create(productosdevolucion);
    }else{
        throw new Exception("La cantidad  ya esta registrado");
    }
    }

    @Override
    public void modificar(Productosdevolucion productosdevolucion) throws Exception {
             Productosdevolucion objproductodevolucion = productosdevolucionDAO.find(productosdevolucion.getProducto());
        if(productosdevolucion!=null){
        if(productosdevolucion.getCantidad()==null){
            throw new Exception("la cantidad es obligatoria");
        }else if (productosdevolucion.getProducto()==null || productosdevolucion.getProducto().equals("")){
         throw new Exception("el producto es obligatorio");
        }
        
        }else{
        throw new Exception("El producto de la factura no tiene informacion");
    }
    if(objproductodevolucion==null){
        productosdevolucionDAO.edit(productosdevolucion);
    }else{
        throw new Exception("La cantidad  ya esta registrado");
    }
    }

    @Override
    public void eliminar(Productosdevolucion productosdevolucion) throws Exception {
        Productosdevolucion objproductodevolucion = productosdevolucionDAO.find(productosdevolucion.getProducto());
    if(productosdevolucion!=null){
        if(productosdevolucion.getProducto()==null){
            throw new Exception("el codigo de la factura es obligatorio"); 
        }
    }else{
        throw new Exception("En la base de datos la cantidad  a eliminar no existe");
    }
    if(objproductodevolucion==null){
         throw new Exception("La cantidad no existe, no se puede eliminar");
    }else{
       
        productosdevolucionDAO.remove(productosdevolucion);
    }  
    }

    @Override
    public Productosdevolucion consultarPorCodigo(Productosdevolucion productosdevolucion) throws Exception {
        if(productosdevolucion.getProducto()!=null){
           return productosdevolucionDAO.find(productosdevolucion);
       }else{
           throw new Exception("el codigo  para consultar es obligatorio");
       } 
    }

    @Override
    public List<Productosdevolucion> consultarTodo() throws Exception {
        return productosdevolucionDAO.findAll();
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
