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
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "award")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Award.findAll", query = "SELECT a FROM Award a")
    , @NamedQuery(name = "Award.findById", query = "SELECT a FROM Award a WHERE a.awardPK.id = :id")
    , @NamedQuery(name = "Award.findByPrice", query = "SELECT a FROM Award a WHERE a.awardPK.price = :price")
    , @NamedQuery(name = "Award.findByDescription", query = "SELECT a FROM Award a WHERE a.description = :description")})
public class Award implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AwardPK awardPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "description")
    private String description;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "award")
    private Collection<GameHistory> gameHistoryCollection;
    @JoinColumn(name = "machineType", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private MachineType machineType;

    public Award() {
    }

    public Award(AwardPK awardPK) {
        this.awardPK = awardPK;
    }

    public Award(AwardPK awardPK, String description) {
        this.awardPK = awardPK;
        this.description = description;
    }

    public Award(int id, float price) {
        this.awardPK = new AwardPK(id, price);
    }

    public AwardPK getAwardPK() {
        return awardPK;
    }

    public void setAwardPK(AwardPK awardPK) {
        this.awardPK = awardPK;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
        hash += (awardPK != null ? awardPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Award)) {
            return false;
        }
        Award other = (Award) object;
        if ((this.awardPK == null && other.awardPK != null) || (this.awardPK != null && !this.awardPK.equals(other.awardPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Award[ awardPK=" + awardPK + " ]";
    }
    
}
