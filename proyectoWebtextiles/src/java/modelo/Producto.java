/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.primefaces.component.calendar.Calendar;

/**
 *
 * @author duberport
 */
@Entity
@Table(name = "producto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Producto.findAll", query = "SELECT p FROM Producto p"),
    @NamedQuery(name = "Producto.findByCodigoProducto", query = "SELECT p FROM Producto p WHERE p.codigoProducto = :codigoProducto"),
    @NamedQuery(name = "Producto.findByNombreProducto", query = "SELECT p FROM Producto p WHERE p.nombreProducto = :nombreProducto"),
    @NamedQuery(name = "Producto.findByFechaIngresoProducto", query = "SELECT p FROM Producto p WHERE p.fechaIngresoProducto = :fechaIngresoProducto"),
    @NamedQuery(name = "Producto.findByGeneroProducto", query = "SELECT p FROM Producto p WHERE p.generoProducto = :generoProducto"),
    @NamedQuery(name = "Producto.findByColorProducto", query = "SELECT p FROM Producto p WHERE p.colorProducto = :colorProducto"),
    @NamedQuery(name = "Producto.findByPrecioProducto", query = "SELECT p FROM Producto p WHERE p.precioProducto = :precioProducto"),
    @NamedQuery(name = "Producto.findByEstadoProducto", query = "SELECT p FROM Producto p WHERE p.estadoProducto = :estadoProducto")})
public class Producto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "codigoProducto")
    private Integer codigoProducto;
    @Size(max = 50)
    @Column(name = "nombreProducto")
    private String nombreProducto;
    @Column(name = "fechaIngresoProducto")
    @Temporal(TemporalType.DATE)
    private Date fechaIngresoProducto;
    @Size(max = 50)
    @Column(name = "generoProducto")
    private String generoProducto;
    @Size(max = 50)
    @Column(name = "colorProducto")
    private String colorProducto;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "precioProducto")
    private Double precioProducto;
    @Size(max = 50)
    @Column(name = "estadoProducto")
    private String estadoProducto;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "producto")
    private List<Productosdevolucion> productosdevolucionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "producto")
    private List<Inventarioproducto> inventarioproductoList;
    @JoinColumn(name = "codigoCategoria", referencedColumnName = "codigoCategoria")
    @ManyToOne
    private Categoria codigoCategoria;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "producto")
    private List<Productofactura> productofacturaList;

    public Producto() {
    }

    public Producto(Integer codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public Integer getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(Integer codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public Date getFechaIngresoProducto() {
        return fechaIngresoProducto;
    }

    public void setFechaIngresoProducto(Date fechaIngresoProducto) {
        this.fechaIngresoProducto = fechaIngresoProducto;
    }

    public String getGeneroProducto() {
        return generoProducto;
    }

    public void setGeneroProducto(String generoProducto) {
        this.generoProducto = generoProducto;
    }

    public String getColorProducto() {
        return colorProducto;
    }

    public void setColorProducto(String colorProducto) {
        this.colorProducto = colorProducto;
    }

    public Double getPrecioProducto() {
        return precioProducto;
    }

    public void setPrecioProducto(Double precioProducto) {
        this.precioProducto = precioProducto;
    }

    public String getEstadoProducto() {
        return estadoProducto;
    }

    public void setEstadoProducto(String estadoProducto) {
        this.estadoProducto = estadoProducto;
    }

    @XmlTransient
    public List<Productosdevolucion> getProductosdevolucionList() {
        return productosdevolucionList;
    }

    public void setProductosdevolucionList(List<Productosdevolucion> productosdevolucionList) {
        this.productosdevolucionList = productosdevolucionList;
    }

    @XmlTransient
    public List<Inventarioproducto> getInventarioproductoList() {
        return inventarioproductoList;
    }

    public void setInventarioproductoList(List<Inventarioproducto> inventarioproductoList) {
        this.inventarioproductoList = inventarioproductoList;
    }

    public Categoria getCodigoCategoria() {
        return codigoCategoria;
    }

    public void setCodigoCategoria(Categoria codigoCategoria) {
        this.codigoCategoria = codigoCategoria;
    }

    @XmlTransient
    public List<Productofactura> getProductofacturaList() {
        return productofacturaList;
    }

    public void setProductofacturaList(List<Productofactura> productofacturaList) {
        this.productofacturaList = productofacturaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoProducto != null ? codigoProducto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Producto)) {
            return false;
        }
        Producto other = (Producto) object;
        if ((this.codigoProducto == null && other.codigoProducto != null) || (this.codigoProducto != null && !this.codigoProducto.equals(other.codigoProducto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Producto[ codigoProducto=" + codigoProducto + " ]";
    }

    public void setFechaIngresoProducto(Calendar txtfechaProducto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
