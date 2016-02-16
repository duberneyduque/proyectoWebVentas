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
import javax.validation.constraints.Size;

/**
 *
 * @author duberport
 */
@Embeddable
public class InventarioproductoPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "codigoCiudad")
    private int codigoCiudad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "codigoProducto")
    private int codigoProducto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "tallaInventario")
    private String tallaInventario;

    public InventarioproductoPK() {
    }

    public InventarioproductoPK(int codigoCiudad, int codigoProducto, String tallaInventario) {
        this.codigoCiudad = codigoCiudad;
        this.codigoProducto = codigoProducto;
        this.tallaInventario = tallaInventario;
    }

    public int getCodigoCiudad() {
        return codigoCiudad;
    }

    public void setCodigoCiudad(int codigoCiudad) {
        this.codigoCiudad = codigoCiudad;
    }

    public int getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(int codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public String getTallaInventario() {
        return tallaInventario;
    }

    public void setTallaInventario(String tallaInventario) {
        this.tallaInventario = tallaInventario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codigoCiudad;
        hash += (int) codigoProducto;
        hash += (tallaInventario != null ? tallaInventario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InventarioproductoPK)) {
            return false;
        }
        InventarioproductoPK other = (InventarioproductoPK) object;
        if (this.codigoCiudad != other.codigoCiudad) {
            return false;
        }
        if (this.codigoProducto != other.codigoProducto) {
            return false;
        }
        if ((this.tallaInventario == null && other.tallaInventario != null) || (this.tallaInventario != null && !this.tallaInventario.equals(other.tallaInventario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.InventarioproductoPK[ codigoCiudad=" + codigoCiudad + ", codigoProducto=" + codigoProducto + ", tallaInventario=" + tallaInventario + " ]";
    }
    
}
