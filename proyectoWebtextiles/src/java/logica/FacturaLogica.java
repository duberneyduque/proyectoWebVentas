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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminar(Factura factura) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Factura consultarPorCodigo(Integer codigoFactura) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Factura> consultarTodo() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
