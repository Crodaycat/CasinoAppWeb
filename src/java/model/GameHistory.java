/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author USUARIO
 */
@Entity
@Table(name = "GameHistory")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GameHistory.findAll", query = "SELECT g FROM GameHistory g")
    , @NamedQuery(name = "GameHistory.findByIdGameHistory", query = "SELECT g FROM GameHistory g WHERE g.idGameHistory = :idGameHistory")
    , @NamedQuery(name = "GameHistory.findByMoneyCollected", query = "SELECT g FROM GameHistory g WHERE g.moneyCollected = :moneyCollected")
    , @NamedQuery(name = "GameHistory.findByDate", query = "SELECT g FROM GameHistory g WHERE g.date = :date")})
public class GameHistory implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idGameHistory")
    private Integer idGameHistory;
    @Basic(optional = false)
    @NotNull
    @Column(name = "moneyCollected")
    private float moneyCollected;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "date")
    private String date;
    @JoinColumn(name = "machineId", referencedColumnName = "serie")
    @ManyToOne(optional = false)
    private Machine machineId;
    @JoinColumns({
        @JoinColumn(name = "awardId", referencedColumnName = "id")
        , @JoinColumn(name = "awardPrice", referencedColumnName = "price")})
    @ManyToOne(optional = false)
    private Award award;

    public GameHistory() {
    }

    public GameHistory(Integer idGameHistory) {
        this.idGameHistory = idGameHistory;
    }

    public GameHistory(Integer idGameHistory, float moneyCollected, String date) {
        this.idGameHistory = idGameHistory;
        this.moneyCollected = moneyCollected;
        this.date = date;
    }

    public Integer getIdGameHistory() {
        return idGameHistory;
    }

    public void setIdGameHistory(Integer idGameHistory) {
        this.idGameHistory = idGameHistory;
    }

    public float getMoneyCollected() {
        return moneyCollected;
    }

    public void setMoneyCollected(float moneyCollected) {
        this.moneyCollected = moneyCollected;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Machine getMachineId() {
        return machineId;
    }

    public void setMachineId(Machine machineId) {
        this.machineId = machineId;
    }

    public Award getAward() {
        return award;
    }

    public void setAward(Award award) {
        this.award = award;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idGameHistory != null ? idGameHistory.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GameHistory)) {
            return false;
        }
        GameHistory other = (GameHistory) object;
        if ((this.idGameHistory == null && other.idGameHistory != null) || (this.idGameHistory != null && !this.idGameHistory.equals(other.idGameHistory))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.GameHistory[ idGameHistory=" + idGameHistory + " ]";
    }
    
}
