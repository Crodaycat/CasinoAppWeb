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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author USUARIO
 */
@Entity
@Table(name = "machine")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Machine.findAll", query = "SELECT m FROM Machine m")
    , @NamedQuery(name = "Machine.findBySerie", query = "SELECT m FROM Machine m WHERE m.serie = :serie")})
public class Machine implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "serie")
    private Integer serie;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "machineId")
    private Collection<GameHistory> gameHistoryCollection;
    @JoinColumn(name = "machineType", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private MachineType machineType;

    public Machine() {
    }

    public Machine(Integer serie) {
        this.serie = serie;
    }

    public Integer getSerie() {
        return serie;
    }

    public void setSerie(Integer serie) {
        this.serie = serie;
    }

    @XmlTransient
    public Collection<GameHistory> getGameHistoryCollection() {
        return gameHistoryCollection;
    }

    public void setGameHistoryCollection(Collection<GameHistory> gameHistoryCollection) {
        this.gameHistoryCollection = gameHistoryCollection;
    }

    public MachineType getMachineType() {
        return machineType;
    }

    public void setMachineType(MachineType machineType) {
        this.machineType = machineType;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (serie != null ? serie.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Machine)) {
            return false;
        }
        Machine other = (Machine) object;
        if ((this.serie == null && other.serie != null) || (this.serie != null && !this.serie.equals(other.serie))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Machine[ serie=" + serie + " ]";
    }
    
}
