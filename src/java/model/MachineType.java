/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Collection;
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
 * @author USUARIO
 */
@Entity
@Table(name = "machinetype")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MachineType.findAll", query = "SELECT m FROM MachineType m")
    , @NamedQuery(name = "MachineType.findById", query = "SELECT m FROM MachineType m WHERE m.id = :id")
    , @NamedQuery(name = "MachineType.findByDescription", query = "SELECT m FROM MachineType m WHERE m.description = :description")})
public class MachineType implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "description")
    private String description;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "machineType")
    private Collection<Award> awardCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "machineType")
    private Collection<Machine> machineCollection;

    public MachineType() {
    }

    public MachineType(Integer id) {
        this.id = id;
    }

    public MachineType(Integer id, String description) {
        this.id = id;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @XmlTransient
    public Collection<Award> getAwardCollection() {
        return awardCollection;
    }

    public void setAwardCollection(Collection<Award> awardCollection) {
        this.awardCollection = awardCollection;
    }

    @XmlTransient
    public Collection<Machine> getMachineCollection() {
        return machineCollection;
    }

    public void setMachineCollection(Collection<Machine> machineCollection) {
        this.machineCollection = machineCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MachineType)) {
            return false;
        }
        MachineType other = (MachineType) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.MachineType[ id=" + id + " ]";
    }
    
}
