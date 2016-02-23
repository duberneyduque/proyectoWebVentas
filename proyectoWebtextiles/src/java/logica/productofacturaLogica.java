/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import modelo.Inventarioproducto;
import modelo.Productofactura;
import persistencia.ProductofacturaFacadeLocal;

/**
 *
 * @author Estudiante
 */
@Stateless
public class productofacturaLogica implements productofacturaLogicaLocal {
@EJB private ProductofacturaFacadeLocal productofacturaDAO;
    @Override
    public void crear(Productofactura productofactura) throws Exception {
        Productofactura objproductofactura = productofacturaDAO.find(productofactura.getProductofacturaPK().getCodigoFactura());
        if(productofactura!=null){
        if(productofactura.getCantidad()==null){
            throw new Exception("la cantidad es obligatoria");
        }else if (productofactura.getProducto()==null || productofactura.getProducto().equals("")){
         throw new Exception("el producto es obligatorio");
        }
        
        }else{
        throw new Exception("El producto de la factura no tiene informacion");
    }
    if(objproductofactura==null){
        productofacturaDAO.create(productofactura);
    }else{
        throw new Exception("La cantidad  ya esta registrado");
    }
    }
    

    @Override
    public void modificar(Productofactura productofactura) throws Exception {
       Productofactura objproductofactura = productofacturaDAO.find(productofactura.getProductofacturaPK().getCodigoFactura());
        if(productofactura!=null){
        if(productofactura.getCantidad()==null){
            throw new Exception("la cantidad es obligatoria");
        }else if (productofactura.getProducto()==null || productofactura.getProducto().equals("")){
         throw new Exception("el producto es obligatorio");
        }
        
        }else{
        throw new Exception("El producto de la factura no tiene informacion");
    }
    if(objproductofactura==null){
        productofacturaDAO.edit(productofactura);
    }else{
        throw new Exception("La cantidad  ya esta registrado");
    }
         
    }

    @Override
    public void eliminar(Productofactura productofactura) throws Exception {
         Productofactura objproductofactura = productofacturaDAO.find(productofactura.getProductofacturaPK().getCodigoFactura());
    if(productofactura!=null){
        if(productofactura.getProducto()==null){
            throw new Exception("el codigo de la factura es obligatorio"); 
        }
    }else{
        throw new Exception("En la base de datos la cantidad  a eliminar no existe");
    }
    if(objproductofactura==null){
         throw new Exception("La cantidad no existe, no se puede eliminar");
    }else{
       
        productofacturaDAO.remove(productofactura);
    }
    }

    @Override
    public Productofactura consultarPorCodigo(Productofactura productofactura) throws Exception {
      if(productofactura.getProducto()!=null){
           return productofacturaDAO.find(productofactura);
       }else{
           throw new Exception("el codigo  para consultar es obligatorio");
       }  
    }

    @Override
    public List<Productofactura> consultarTodo() throws Exception {
        return productofacturaDAO.findAll();
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
