/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author duberport
 */
@Entity
@Table(name = "ciudad")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ciudad.findAll", query = "SELECT c FROM Ciudad c"),
    @NamedQuery(name = "Ciudad.findByCodigoCiudad", query = "SELECT c FROM Ciudad c WHERE c.codigoCiudad = :codigoCiudad"),
    @NamedQuery(name = "Ciudad.findByNombreCiudad", query = "SELECT c FROM Ciudad c WHERE c.nombreCiudad = :nombreCiudad")})
public class Ciudad implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "codigoCiudad")
    private Integer codigoCiudad;
    @Size(max = 50)
    @Column(name = "nombreCiudad")
    private String nombreCiudad;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ciudad")
    private List<Inventarioproducto> inventarioproductoList;

    public Ciudad() {
    }

    public Ciudad(Integer codigoCiudad) {
        this.codigoCiudad = codigoCiudad;
    }

    public Integer getCodigoCiudad() {
        return codigoCiudad;
    }

    public void setCodigoCiudad(Integer codigoCiudad) {
        this.codigoCiudad = codigoCiudad;
    }

    public String getNombreCiudad() {
        return nombreCiudad;
    }

    public void setNombreCiudad(String nombreCiudad) {
        this.nombreCiudad = nombreCiudad;
    }

    @XmlTransient
    public List<Inventarioproducto> getInventarioproductoList() {
        return inventarioproductoList;
    }

    public void setInventarioproductoList(List<Inventarioproducto> inventarioproductoList) {
        this.inventarioproductoList = inventarioproductoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoCiudad != null ? codigoCiudad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ciudad)) {
            return false;
        }
        Ciudad other = (Ciudad) object;
        if ((this.codigoCiudad == null && other.codigoCiudad != null) || (this.codigoCiudad != null && !this.codigoCiudad.equals(other.codigoCiudad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Ciudad[ codigoCiudad=" + codigoCiudad + " ]";
    }
    
}
