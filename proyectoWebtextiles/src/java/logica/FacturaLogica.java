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
import modelo.Producto;
import persistencia.FacturaFacadeLocal;

/**
 *
 * @author Estudiante
 */
@Stateless
public class FacturaLogica implements FacturaLogicaLocal {
@EJB
private FacturaFacadeLocal facturaDAO;
    @Override
    public void crear(Factura factura) throws Exception {
       Factura objFactura = facturaDAO.find(factura.getCodigoFactura());
    if(factura!=null){
        if(factura.getCodigoFactura()==null){
            throw new Exception("Codigo de la factura  es obligatorio"); 
        }else if(factura.getCedulaCliente()==null || factura.getCedulaCliente().equals("")){
            throw new Exception("La cedula  es obligatorio");
        }
    }else{
        throw new Exception("La factura no tiene informacion");
    }
    if(objFactura==null){
        facturaDAO.create(factura);
    }else{
        throw new Exception("La factura ya esta registrado");
    }
    }
    

    @Override
    public void modificar(Factura factura) throws Exception {
          Factura objFactura = facturaDAO.find(factura.getCodigoFactura());
    if(factura!=null){
        if(factura.getCodigoFactura()==null){
            throw new Exception("Codigo de la factura  es obligatorio"); 
        }else if(factura.getCedulaCliente()==null || factura.getCedulaCliente().equals("")){
            throw new Exception("La cedula  es obligatorio");
        }
    }else{
        throw new Exception("La factura no tiene informacion");
    }
    if(objFactura==null){
        facturaDAO.edit(factura);
    }else{
        throw new Exception("La factura ya esta registrado");
    }
    }

    @Override
    public void eliminar(Factura factura) throws Exception {
         Factura objFactura = facturaDAO.find(factura.getCodigoFactura());
    if(factura!=null){
        if(factura.getCedulaCliente()==null){
            throw new Exception("Codigo de la factura obligatorio"); 
        }
    }else{
        throw new Exception("En la base de datos la factura a eliminar no existe");
    }
    if(objFactura==null){
         throw new Exception("La factura no existe, no se puede eliminar");
    }else{
       
        facturaDAO.remove(factura);
    }
    }

    @Override
    public Factura consultarPorCodigo(Integer codigoFactura) throws Exception {
         if(codigoFactura!=null){
           return facturaDAO.find(codigoFactura);
       }else{
           throw new Exception("El codigo para consultar es obligatorio");
       }
    }

    @Override
    public List<Factura> consultarTodo() throws Exception {
       return facturaDAO.findAll();
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
