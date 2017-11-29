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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author luis.giraldo10
 */
@Entity
@Table(name = "Dealer")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dealer.findAll", query = "SELECT d FROM Dealer d")
    , @NamedQuery(name = "Dealer.findById", query = "SELECT d FROM Dealer d WHERE d.id = :id")
    , @NamedQuery(name = "Dealer.findByFirstName", query = "SELECT d FROM Dealer d WHERE d.firstName = :firstName")
    , @NamedQuery(name = "Dealer.findByLastName", query = "SELECT d FROM Dealer d WHERE d.lastName = :lastName")
    , @NamedQuery(name = "Dealer.findByWorkedHourPrice", query = "SELECT d FROM Dealer d WHERE d.workedHourPrice = :workedHourPrice")})
public class Dealer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "firstName")
    private String firstName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "lastName")
    private String lastName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "workedHourPrice")
    private float workedHourPrice;

    public Dealer() {
    }

    public Dealer(Integer id) {
        this.id = id;
    }

    public Dealer(Integer id, String firstName, String lastName, float workedHourPrice) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.workedHourPrice = workedHourPrice;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public float getWorkedHourPrice() {
        return workedHourPrice;
    }

    public void setWorkedHourPrice(float workedHourPrice) {
        this.workedHourPrice = workedHourPrice;
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
        if (!(object instanceof Dealer)) {
            return false;
        }
        Dealer other = (Dealer) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Dealer[ id=" + id + " ]";
    }
    
}
