/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import modelo.Cliente;
import modelo.Devolucion;
import persistencia.ClienteFacadeLocal;
import persistencia.DevolucionFacadeLocal;

/**
 *
 * @author Estudiante
 */
@Stateless
public class DevolucionLogica implements DevolucionLogicaLocal {
@EJB
private DevolucionFacadeLocal devolucionDAO;
@EJB
private ClienteFacadeLocal clienteDAO;
    @Override
    public void create(Devolucion devolucion) throws Exception {
       devolucionDAO.create(devolucion);
    }

    @Override
    public void edit(Devolucion devolucion) throws Exception {
       devolucionDAO.edit(devolucion);
    }

    @Override
    public void remove(Devolucion devoluciona) throws Exception {
      devolucionDAO.remove(devoluciona);
    }

    @Override
    public List<Devolucion> consultar() throws Exception {
        return devolucionDAO.findAll();
    }
@Override
    public Devolucion consultarPorcodigoDevolucion(Integer codigodevolucion) throws Exception {
      return devolucionDAO.find(codigodevolucion);
    }
    

    @Override
    public List<Devolucion> consultarDevolucionCliente(Long cedulacliente) throws Exception {
           List<Cliente> cliente = clienteDAO.consultarDevolucionCliente(cedulacliente);
        List<Devolucion> listaD = new ArrayList<>();
        for (int i = 0; i < cliente.size(); i++) {
              listaD.addAll(cliente.get(i).getDevolucionList());
        }
        return listaD;
    }
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    

