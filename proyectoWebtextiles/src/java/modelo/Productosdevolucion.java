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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author duberport
 */
@Entity
@Table(name = "productosdevolucion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Productosdevolucion.findAll", query = "SELECT p FROM Productosdevolucion p"),
    @NamedQuery(name = "Productosdevolucion.findByCantidad", query = "SELECT p FROM Productosdevolucion p WHERE p.cantidad = :cantidad"),
    @NamedQuery(name = "Productosdevolucion.findByCodigoProducto", query = "SELECT p FROM Productosdevolucion p WHERE p.productosdevolucionPK.codigoProducto = :codigoProducto"),
    @NamedQuery(name = "Productosdevolucion.findByCodigoDevolucion", query = "SELECT p FROM Productosdevolucion p WHERE p.productosdevolucionPK.codigoDevolucion = :codigoDevolucion"),
    @NamedQuery(name = "Productosdevolucion.findByObservaciones", query = "SELECT p FROM Productosdevolucion p WHERE p.observaciones = :observaciones")})
public class Productosdevolucion implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ProductosdevolucionPK productosdevolucionPK;
    @Column(name = "cantidad")
    private Integer cantidad;
    @Size(max = 50)
    @Column(name = "observaciones")
    private String observaciones;
    @JoinColumn(name = "codigoDevolucion", referencedColumnName = "codigoDevolucion", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Devolucion devolucion;
    @JoinColumn(name = "codigoProducto", referencedColumnName = "codigoProducto", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Producto producto;

    public Productosdevolucion() {
    }

    public Productosdevolucion(ProductosdevolucionPK productosdevolucionPK) {
        this.productosdevolucionPK = productosdevolucionPK;
    }

    public Productosdevolucion(int codigoProducto, int codigoDevolucion) {
        this.productosdevolucionPK = new ProductosdevolucionPK(codigoProducto, codigoDevolucion);
    }

    public ProductosdevolucionPK getProductosdevolucionPK() {
        return productosdevolucionPK;
    }

    public void setProductosdevolucionPK(ProductosdevolucionPK productosdevolucionPK) {
        this.productosdevolucionPK = productosdevolucionPK;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Devolucion getDevolucion() {
        return devolucion;
    }

    public void setDevolucion(Devolucion devolucion) {
        this.devolucion = devolucion;
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
        hash += (productosdevolucionPK != null ? productosdevolucionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Productosdevolucion)) {
            return false;
        }
        Productosdevolucion other = (Productosdevolucion) object;
        if ((this.productosdevolucionPK == null && other.productosdevolucionPK != null) || (this.productosdevolucionPK != null && !this.productosdevolucionPK.equals(other.productosdevolucionPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Productosdevolucion[ productosdevolucionPK=" + productosdevolucionPK + " ]";
    }
    
}
