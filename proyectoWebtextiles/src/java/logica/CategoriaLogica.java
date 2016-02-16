/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import modelo.Categoria;
import persistencia.CategoriaFacadeLocal;

/**
 *
 * @author duberport
 */
@Stateless
public class CategoriaLogica implements CategoriaLogicaLocal {
@EJB
private CategoriaFacadeLocal categoriaDAO;
    @Override
    public void crear(Categoria categoria) throws Exception {
       Categoria objCategoria = categoriaDAO.find(categoria.getCodigoCategoria());
    if(categoria!=null){
        if(categoria.getCodigoCategoria()==null){
            throw new Exception("Codigo de categoria obligatorio"); 
        }else if(categoria.getNombreCategoria()==null || categoria.getNombreCategoria().equals("")){
            throw new Exception("El nombre es obligatorio");
        }
    }else{
        throw new Exception("La Categoria no tiene informacion");
    }
    if(objCategoria==null){
        categoriaDAO.create(categoria);
    }else{
        throw new Exception("La categoria ya esta registrada");
    }  
    }

    @Override
    public void modificar(Categoria categoria) throws Exception {
            Categoria objCategoria = categoriaDAO.find(categoria.getCodigoCategoria());
    if(categoria!=null){
        if(categoria.getCodigoCategoria()==null){
            throw new Exception("Codigo de categoria obligatorio"); 
        }else if(categoria.getNombreCategoria()==null || categoria.getNombreCategoria().equals("")){
            throw new Exception("El nombre es obligatorio");
        }
    }else{
        throw new Exception("La Categoria no tiene informacion");
    }
    if(objCategoria==null){
        throw new Exception("La categoria no existe. no se puede modificar");
    }else{
        categoriaDAO.edit(categoria);
    }  
    }

    @Override
    public void eliminar(Categoria categoria) throws Exception {
                  Categoria objCategoria = categoriaDAO.find(categoria.getCodigoCategoria());
    if(categoria!=null){
        if(categoria.getCodigoCategoria()==null){
            throw new Exception("Codigo de categoria obligatorio"); 
        }
    }else{
        throw new Exception("La Categoria no tiene informacion");
    }
    if(objCategoria==null){
        throw new Exception("La categoria no existe. no se puede eliminar");
    }else{
        categoriaDAO.remove(categoria);
    }  
    }

    @Override
    public Categoria consultarPorCodigo(Integer codigoCategoria) throws Exception {
        if(codigoCategoria!=null){
           return categoriaDAO.find(codigoCategoria);
       }else{
           throw new Exception("El codigo para consultar es obligatorio");
       }
    }

    @Override
    public List<Categoria> consultarTodo() throws Exception {
       return categoriaDAO.findAll();
    }

}
