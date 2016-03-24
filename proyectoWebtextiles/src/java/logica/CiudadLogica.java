/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import modelo.Ciudad;
import persistencia.CiudadFacadeLocal;

/**
 *
 * @author duberport
 */
@Stateless
public class CiudadLogica implements CiudadLogicaLocal {
   @EJB
       private CiudadFacadeLocal CiudadDAO;
   
    @Override
    public void crear(Ciudad ciudad) throws Exception {
        Ciudad objCiudad = CiudadDAO.find(ciudad.getCodigoCiudad());
    if(ciudad!=null){
        if(ciudad.getCodigoCiudad()==null){
            throw new Exception("Codigo de ciudad obligatorio"); 
        }else if(ciudad.getNombreCiudad()==null || ciudad.getNombreCiudad().equals("")){
            throw new Exception("El nombre es obligatorio");
        }
    }else{
        throw new Exception("La ciudad no tiene informacion");
    }
    if(objCiudad==null){
        CiudadDAO.create(ciudad);
    }else{
        throw new Exception("La ciudad ya esta registrada");
    }
    }

    @Override
    public void modificar(Ciudad ciudad) throws Exception {
        Ciudad objCiudad= CiudadDAO.find(ciudad.getCodigoCiudad());
        if(ciudad.getCodigoCiudad()!=null){
            if(ciudad.getCodigoCiudad()==null){
                throw new Exception("codigo de ciudad obligatorio");
            }else if(ciudad.getNombreCiudad()==null || ciudad.getNombreCiudad().equals("")){
            throw new Exception("El nombre es obligatorio");
        }
        }else{
            throw new Exception("la base de datos no contiene esta ciudad");
        }
        if(objCiudad==null){
            throw new Exception("Ciudad no existe, no se puede modificar!");
        }else{
            CiudadDAO.edit(ciudad);
        }
    }

    @Override
    public void eliminar(Ciudad ciudad) throws Exception {
          Ciudad objCiudad= CiudadDAO.find(ciudad.getCodigoCiudad());
        if(ciudad.getCodigoCiudad()!=null){
            if(ciudad.getCodigoCiudad()==null){
                throw new Exception("codigo de ciudad obligatorio");
            //else if(ciudad.getNombreCiudad()==null || ciudad.getNombreCiudad().equals("")){
            //throw new Exception("El nombre es obligatorio");
        }
        }else{
            throw new Exception("la base de datos no contiene esta ciudad");
        }
        if(objCiudad==null){
            throw new Exception("Ciudad no existe, no se puede Eliminar!");
        }else{
            CiudadDAO.remove(ciudad);
        }
    }

    @Override
    public Ciudad consultarPorCodigo(Integer codigoCiudad) throws Exception {
       if(codigoCiudad!=null){
           return CiudadDAO.find(codigoCiudad);
       }else{
           throw new Exception("El codigo para consultar es obligatorio");
       }
    }

    @Override
    public List<Ciudad> consultarTodo() throws Exception {
        return CiudadDAO.findAll();
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
