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
@Table(name = "factura")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Factura.findAll", query = "SELECT f FROM Factura f"),
    @NamedQuery(name = "Factura.findByCodigoFactura", query = "SELECT f FROM Factura f WHERE f.codigoFactura = :codigoFactura"),
    @NamedQuery(name = "Factura.findByFechaFactura", query = "SELECT f FROM Factura f WHERE f.fechaFactura = :fechaFactura"),
    @NamedQuery(name = "Factura.findByTipopagoFactura", query = "SELECT f FROM Factura f WHERE f.tipopagoFactura = :tipopagoFactura"),
    @NamedQuery(name = "Factura.findByValortotalFactura", query = "SELECT f FROM Factura f WHERE f.valortotalFactura = :valortotalFactura")})
public class Factura implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "codigoFactura")
    private Integer codigoFactura;
    @Column(name = "fechaFactura")
    @Temporal(TemporalType.DATE)
    private Date fechaFactura;
    @Size(max = 50)
    @Column(name = "tipopagoFactura")
    private String tipopagoFactura;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valortotalFactura")
    private Double valortotalFactura;
    @JoinColumn(name = "cedulaCliente", referencedColumnName = "cedulaCliente")
    @ManyToOne
    private Cliente cedulaCliente;
    @JoinColumn(name = "idUsuario", referencedColumnName = "idUsuario")
    @ManyToOne
    private Usuario idUsuario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "factura")
    private List<Productofactura> productofacturaList;

    public Factura() {
    }

    public Factura(Integer codigoFactura) {
        this.codigoFactura = codigoFactura;
    }

    public Integer getCodigoFactura() {
        return codigoFactura;
    }

    public void setCodigoFactura(Integer codigoFactura) {
        this.codigoFactura = codigoFactura;
    }

    public Date getFechaFactura() {
        return fechaFactura;
    }

    public void setFechaFactura(Date fechaFactura) {
        this.fechaFactura = fechaFactura;
    }

    public String getTipopagoFactura() {
        return tipopagoFactura;
    }

    public void setTipopagoFactura(String tipopagoFactura) {
        this.tipopagoFactura = tipopagoFactura;
    }

    public Double getValortotalFactura() {
        return valortotalFactura;
    }

    public void setValortotalFactura(Double valortotalFactura) {
        this.valortotalFactura = valortotalFactura;
    }

    public Cliente getCedulaCliente() {
        return cedulaCliente;
    }

    public void setCedulaCliente(Cliente cedulaCliente) {
        this.cedulaCliente = cedulaCliente;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
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
        hash += (codigoFactura != null ? codigoFactura.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Factura)) {
            return false;
        }
        Factura other = (Factura) object;
        if ((this.codigoFactura == null && other.codigoFactura != null) || (this.codigoFactura != null && !this.codigoFactura.equals(other.codigoFactura))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Factura[ codigoFactura=" + codigoFactura + " ]";
    }
    
}
