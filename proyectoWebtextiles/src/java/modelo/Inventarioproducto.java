/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author duberport
 */
@Entity
@Table(name = "inventarioproducto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Inventarioproducto.findAll", query = "SELECT i FROM Inventarioproducto i"),
    @NamedQuery(name = "Inventarioproducto.findByCodigoCiudad", query = "SELECT i FROM Inventarioproducto i WHERE i.inventarioproductoPK.codigoCiudad = :codigoCiudad"),
    @NamedQuery(name = "Inventarioproducto.findByCodigoProducto", query = "SELECT i FROM Inventarioproducto i WHERE i.inventarioproductoPK.codigoProducto = :codigoProducto"),
    @NamedQuery(name = "Inventarioproducto.findByTallaInventario", query = "SELECT i FROM Inventarioproducto i WHERE i.inventarioproductoPK.tallaInventario = :tallaInventario"),
    @NamedQuery(name = "Inventarioproducto.findByCantidad", query = "SELECT i FROM Inventarioproducto i WHERE i.cantidad = :cantidad")})
public class Inventarioproducto implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected InventarioproductoPK inventarioproductoPK;
    @Column(name = "cantidad")
    private Integer cantidad;
    @JoinColumn(name = "codigoCiudad", referencedColumnName = "codigoCiudad", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Ciudad ciudad;
    @JoinColumn(name = "codigoProducto", referencedColumnName = "codigoProducto", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Producto producto;

    public Inventarioproducto() {
    }

    public Inventarioproducto(InventarioproductoPK inventarioproductoPK) {
        this.inventarioproductoPK = inventarioproductoPK;
    }

    public Inventarioproducto(int codigoCiudad, int codigoProducto, String tallaInventario) {
        this.inventarioproductoPK = new InventarioproductoPK(codigoCiudad, codigoProducto, tallaInventario);
    }

    public InventarioproductoPK getInventarioproductoPK() {
        return inventarioproductoPK;
    }

    public void setInventarioproductoPK(InventarioproductoPK inventarioproductoPK) {
        this.inventarioproductoPK = inventarioproductoPK;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Ciudad getCiudad() {
        return ciudad;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (inventarioproductoPK != null ? inventarioproductoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Inventarioproducto)) {
            return false;
        }
        Inventarioproducto other = (Inventarioproducto) object;
        if ((this.inventarioproductoPK == null && other.inventarioproductoPK != null) || (this.inventarioproductoPK != null && !this.inventarioproductoPK.equals(other.inventarioproductoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Inventarioproducto[ inventarioproductoPK=" + inventarioproductoPK + " ]";
    }
    
}
