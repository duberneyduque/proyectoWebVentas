/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import modelo.Producto;
import persistencia.ProductoFacadeLocal;

/**
 *
 * @author duberport
 */
@Stateless
public class ProductoLogica implements ProductoLogicaLocal {

    @EJB
    private ProductoFacadeLocal productoDAO;

    @Override
    public void crear(Producto producto) throws Exception {
        Producto objproducto = productoDAO.find(producto.getCodigoProducto());
        if (producto != null) {
            if (producto.getCodigoProducto() == null) {
                throw new Exception("Codigo de producto obligatorio");
            }//else if(producto.getNombreProducto()==null || producto.getNombreProducto().equals("")){
            // throw new Exception("El nombre es obligatorio");
            // }
        } else {
            throw new Exception("El producto no tiene informacion");
        }
        if (objproducto == null) {
            productoDAO.create(producto);
        } else {
            throw new Exception("EL producto ya esta registrado");
        }
    }

    @Override
    public void modificar(Producto producto) throws Exception {
        Producto objproducto = productoDAO.find(producto.getCodigoProducto());
        if (producto != null) {
            if (producto.getCodigoProducto() == null) {
                throw new Exception("Codigo de producto obligatorio");
            } else if (producto.getNombreProducto() == null || producto.getNombreProducto().equals("")) {
                throw new Exception("El nombre es obligatorio");
            }else if(producto.getFechaIngresoProducto()==null || producto.getFechaIngresoProducto().equals("")){
                 throw new Exception("La fecha es obligatoria");
            }else if(producto.getGeneroProducto()==null || producto.getGeneroProducto().equals("")){
               throw new Exception("El genero es obligatorio"); 
            }else if(producto.getColorProducto()==null || producto.getColorProducto().equals("")){
                throw new Exception("El color es ob es obligatorio");
            }else if(producto.getPrecioProducto()==null){
               throw new Exception("El precio es obligatorio");
            }else if(producto.getCodigoCategoria().getCodigoCategoria()==null){
                throw new Exception("El codigo de categoria es obligatorio");
            }else if(producto.getEstadoProducto()==null || producto.getEstadoProducto().equals("")){
                throw new Exception("El codigo de categoria es obligatorio");
            }
        }else{
            throw new Exception("El producto no tiene informacion");
        }
            
        if (objproducto == null) {
            throw new Exception("El producto no existe. no se puede modificar");
        } else {
            productoDAO.edit(producto);
        }
    }
    

    @Override
    public void eliminar(Producto producto) throws Exception {
        Producto objproducto = productoDAO.find(producto.getCodigoProducto());
        if (producto != null) {
            if (producto.getCodigoProducto() == null) {
                throw new Exception("Codigo de producto obligatorio");
            }
        } else {
            throw new Exception("En la base de datos el Producto a eliminar no existe");
        }
        if (objproducto == null) {
            throw new Exception("El producto no existe, no se puede eliminar");
        } else {

            productoDAO.remove(producto);
        }
    }

    @Override
    public Producto consultarPorCodigo(Integer codigoProducto) throws Exception {
        if (codigoProducto != null) {
            return productoDAO.find(codigoProducto);
        } else {
            throw new Exception("El codigo para consultar es obligatorio");
        }
    }

    @Override
    public List<Producto> consultarTodo() throws Exception {
        return productoDAO.findAll();
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
