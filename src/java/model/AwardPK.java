/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author USUARIO
 */
@Embeddable
public class AwardPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id")
    private int id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "price")
    private float price;

    public AwardPK() {
    }

    public AwardPK(int id, float price) {
        this.id = id;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) id;
        hash += (int) price;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AwardPK)) {
            return false;
        }
        AwardPK other = (AwardPK) object;
        if (this.id != other.id) {
            return false;
        }
        if (this.price != other.price) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.AwardPK[ id=" + id + ", price=" + price + " ]";
    }
    
}
