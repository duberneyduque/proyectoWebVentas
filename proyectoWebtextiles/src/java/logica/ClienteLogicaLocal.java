/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.List;
import javax.ejb.Local;
import modelo.Cliente;

/**
 *
 * @author Estudiante
 */
@Local
public interface ClienteLogicaLocal {
      void create(Cliente cliente) throws Exception;
        void edit (Cliente cliente) throws Exception;
        void remove (Cliente cliente) throws Exception;
        Cliente find(Long cedulacliente) throws Exception;
        List<Cliente> findAll() throws Exception;   
}
