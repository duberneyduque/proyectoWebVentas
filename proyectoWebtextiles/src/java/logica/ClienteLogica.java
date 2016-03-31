/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import modelo.Cliente;
import persistencia.ClienteFacadeLocal;

/**
 *
 * @author Estudiante
 */
@Stateless
public class ClienteLogica implements ClienteLogicaLocal {

    @EJB
    private ClienteFacadeLocal clienteDAO;

    @Override
    public void create(Cliente cliente) throws Exception {
        Cliente objCliente = clienteDAO.find(cliente.getCedulaCliente());
        if(cliente!=null){
            if(cliente.getCedulaCliente()==null){
                throw new Exception("El correo es  Obligatorio");                
            }else if(cliente.getNombreCliente()==null || cliente.getNombreCliente().equals("")){
                throw new Exception("El nombre es obligatorio");
            }
        }else{
            throw new Exception("El cliente no tiene información");
        }
        
        if(objCliente==null){
            clienteDAO.create(cliente);
        }else{
            throw new Exception("El cliente  ya esta registrada");
        }
    }

    @Override
    public void edit(Cliente cliente) throws Exception {
           Cliente objCliente = clienteDAO.find(cliente.getCedulaCliente());
        if(cliente!=null){
            if(cliente.getCedulaCliente()==null){
                throw new Exception("La cedula del cliente es Obligatorio");                
            }else if(cliente.getNombreCliente()==null || cliente.getNombreCliente().equals("")){
                throw new Exception("El nombre es obligatorio");
            }
        }else{
            throw new Exception("El cliente  no tiene información");
        }
        
        if(objCliente==null){
            throw new Exception("El cliente no existe. No se puede modificar");
        }else{
            clienteDAO.edit(cliente);
        }
    }

    @Override
    public void remove(Cliente cliente) throws Exception {
        Cliente objCliente = clienteDAO.find(cliente.getCedulaCliente());
        if(cliente==null){
            throw new Exception("El cliente no tiene información");                                                    
        }
        
        if(objCliente==null){
            throw new Exception("El cliente no existe. No se puede modificar");
        }else{
            clienteDAO.remove(cliente);
        }
    }

    @Override
    public Cliente find(Long cedulacliente) throws Exception {
         if(cedulacliente!=null){
            return clienteDAO.find(cedulacliente);
        }else{
            throw new Exception("la cedula  para consultar es obligatorio");
        }
    }

    @Override
    public List<Cliente> findAll() throws Exception {
          return clienteDAO.findAll();
    }
    
}
