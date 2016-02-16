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
@Table(name = "productofactura")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Productofactura.findAll", query = "SELECT p FROM Productofactura p"),
    @NamedQuery(name = "Productofactura.findByCodigoFactura", query = "SELECT p FROM Productofactura p WHERE p.productofacturaPK.codigoFactura = :codigoFactura"),
    @NamedQuery(name = "Productofactura.findByCodigoProducto", query = "SELECT p FROM Productofactura p WHERE p.productofacturaPK.codigoProducto = :codigoProducto"),
    @NamedQuery(name = "Productofactura.findByCantidad", query = "SELECT p FROM Productofactura p WHERE p.cantidad = :cantidad")})
public class Productofactura implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ProductofacturaPK productofacturaPK;
    @Column(name = "cantidad")
    private Integer cantidad;
    @JoinColumn(name = "codigoFactura", referencedColumnName = "codigoFactura", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Factura factura;
    @JoinColumn(name = "codigoProducto", referencedColumnName = "codigoProducto", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Producto producto;

    public Productofactura() {
    }

    public Productofactura(ProductofacturaPK productofacturaPK) {
        this.productofacturaPK = productofacturaPK;
    }

    public Productofactura(int codigoFactura, int codigoProducto) {
        this.productofacturaPK = new ProductofacturaPK(codigoFactura, codigoProducto);
    }

    public ProductofacturaPK getProductofacturaPK() {
        return productofacturaPK;
    }

    public void setProductofacturaPK(ProductofacturaPK productofacturaPK) {
        this.productofacturaPK = productofacturaPK;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
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
        hash += (productofacturaPK != null ? productofacturaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Productofactura)) {
            return false;
        }
        Productofactura other = (Productofactura) object;
        if ((this.productofacturaPK == null && other.productofacturaPK != null) || (this.productofacturaPK != null && !this.productofacturaPK.equals(other.productofacturaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Productofactura[ productofacturaPK=" + productofacturaPK + " ]";
    }
    
}
