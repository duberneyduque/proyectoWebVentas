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

/**
 *
 * @author duberport
 */
@Entity
@Table(name = "devolucion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Devolucion.findAll", query = "SELECT d FROM Devolucion d"),
    @NamedQuery(name = "Devolucion.findByCodigoDevolucion", query = "SELECT d FROM Devolucion d WHERE d.codigoDevolucion = :codigoDevolucion"),
    @NamedQuery(name = "Devolucion.findByFechaDevolucion", query = "SELECT d FROM Devolucion d WHERE d.fechaDevolucion = :fechaDevolucion"),
    @NamedQuery(name = "Devolucion.findByObservacionDevolucion", query = "SELECT d FROM Devolucion d WHERE d.observacionDevolucion = :observacionDevolucion")})
public class Devolucion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "codigoDevolucion")
    private Integer codigoDevolucion;
    @Column(name = "fechaDevolucion")
    @Temporal(TemporalType.DATE)
    private Date fechaDevolucion;
    @Size(max = 50)
    @Column(name = "observacionDevolucion")
    private String observacionDevolucion;
    @JoinColumn(name = "cedulaCliente", referencedColumnName = "cedulaCliente")
    @ManyToOne
    private Cliente cedulaCliente;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "devolucion")
    private List<Productosdevolucion> productosdevolucionList;

    public Devolucion() {
    }

    public Devolucion(Integer codigoDevolucion) {
        this.codigoDevolucion = codigoDevolucion;
    }

    public Integer getCodigoDevolucion() {
        return codigoDevolucion;
    }

    public void setCodigoDevolucion(Integer codigoDevolucion) {
        this.codigoDevolucion = codigoDevolucion;
    }

    public Date getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(Date fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    public String getObservacionDevolucion() {
        return observacionDevolucion;
    }

    public void setObservacionDevolucion(String observacionDevolucion) {
        this.observacionDevolucion = observacionDevolucion;
    }

    public Cliente getCedulaCliente() {
        return cedulaCliente;
    }

    public void setCedulaCliente(Cliente cedulaCliente) {
        this.cedulaCliente = cedulaCliente;
    }

    @XmlTransient
    public List<Productosdevolucion> getProductosdevolucionList() {
        return productosdevolucionList;
    }

    public void setProductosdevolucionList(List<Productosdevolucion> productosdevolucionList) {
        this.productosdevolucionList = productosdevolucionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoDevolucion != null ? codigoDevolucion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Devolucion)) {
            return false;
        }
        Devolucion other = (Devolucion) object;
        if ((this.codigoDevolucion == null && other.codigoDevolucion != null) || (this.codigoDevolucion != null && !this.codigoDevolucion.equals(other.codigoDevolucion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Devolucion[ codigoDevolucion=" + codigoDevolucion + " ]";
    }
    
}
