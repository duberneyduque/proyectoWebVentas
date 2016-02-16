/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author duberport
 */
@Embeddable
public class ProductosdevolucionPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "codigoProducto")
    private int codigoProducto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "codigoDevolucion")
    private int codigoDevolucion;

    public ProductosdevolucionPK() {
    }

    public ProductosdevolucionPK(int codigoProducto, int codigoDevolucion) {
        this.codigoProducto = codigoProducto;
        this.codigoDevolucion = codigoDevolucion;
    }

    public int getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(int codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public int getCodigoDevolucion() {
        return codigoDevolucion;
    }

    public void setCodigoDevolucion(int codigoDevolucion) {
        this.codigoDevolucion = codigoDevolucion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codigoProducto;
        hash += (int) codigoDevolucion;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductosdevolucionPK)) {
            return false;
        }
        ProductosdevolucionPK other = (ProductosdevolucionPK) object;
        if (this.codigoProducto != other.codigoProducto) {
            return false;
        }
        if (this.codigoDevolucion != other.codigoDevolucion) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.ProductosdevolucionPK[ codigoProducto=" + codigoProducto + ", codigoDevolucion=" + codigoDevolucion + " ]";
    }
    
}
