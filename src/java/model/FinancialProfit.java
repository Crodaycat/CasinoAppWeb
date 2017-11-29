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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
@Table(name = "financialprofit")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FinancialProfit.findAll", query = "SELECT f FROM FinancialProfit f")
    , @NamedQuery(name = "FinancialProfit.findById", query = "SELECT f FROM FinancialProfit f WHERE f.id = :id")
    , @NamedQuery(name = "FinancialProfit.findByBaccara", query = "SELECT f FROM FinancialProfit f WHERE f.baccara = :baccara")
    , @NamedQuery(name = "FinancialProfit.findByRulete", query = "SELECT f FROM FinancialProfit f WHERE f.rulete = :rulete")
    , @NamedQuery(name = "FinancialProfit.findByBlackjack", query = "SELECT f FROM FinancialProfit f WHERE f.blackjack = :blackjack")
    , @NamedQuery(name = "FinancialProfit.findByPoker", query = "SELECT f FROM FinancialProfit f WHERE f.poker = :poker")
    , @NamedQuery(name = "FinancialProfit.findByDate", query = "SELECT f FROM FinancialProfit f WHERE f.date = :date")
    , @NamedQuery(name = "FinancialProfit.findByMarginProfitBaccara", query = "SELECT f FROM FinancialProfit f WHERE f.marginProfitBaccara = :marginProfitBaccara")
    , @NamedQuery(name = "FinancialProfit.findByMarginProfitBlacjack", query = "SELECT f FROM FinancialProfit f WHERE f.marginProfitBlacjack = :marginProfitBlacjack")
    , @NamedQuery(name = "FinancialProfit.findByMarginProfitPoker", query = "SELECT f FROM FinancialProfit f WHERE f.marginProfitPoker = :marginProfitPoker")
    , @NamedQuery(name = "FinancialProfit.findByMarginProfitRulete", query = "SELECT f FROM FinancialProfit f WHERE f.marginProfitRulete = :marginProfitRulete")
    , @NamedQuery(name = "FinancialProfit.findByFinancialProfit", query = "SELECT f FROM FinancialProfit f WHERE f.financialProfit = :financialProfit")})
public class FinancialProfit implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "baccara")
    private float baccara;
    @Basic(optional = false)
    @NotNull
    @Column(name = "rulete")
    private float rulete;
    @Basic(optional = false)
    @NotNull
    @Column(name = "blackjack")
    private float blackjack;
    @Basic(optional = false)
    @NotNull
    @Column(name = "poker")
    private float poker;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "date")
    private String date;
    @Basic(optional = false)
    @NotNull
    @Column(name = "marginProfitBaccara")
    private int marginProfitBaccara;
    @Basic(optional = false)
    @NotNull
    @Column(name = "marginProfitBlacjack")
    private int marginProfitBlacjack;
    @Basic(optional = false)
    @NotNull
    @Column(name = "marginProfitPoker")
    private int marginProfitPoker;
    @Basic(optional = false)
    @NotNull
    @Column(name = "marginProfitRulete")
    private int marginProfitRulete;
    @Basic(optional = false)
    @NotNull
    @Column(name = "financialProfit")
    private float financialProfit;
    @JoinColumn(name = "dealerId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Dealer dealerId;

    public FinancialProfit() {
    }

    public FinancialProfit(Integer id) {
        this.id = id;
    }

    public FinancialProfit(Integer id, float baccara, float rulete, float blackjack, float poker, String date, int marginProfitBaccara, int marginProfitBlacjack, int marginProfitPoker, int marginProfitRulete, float financialProfit) {
        this.id = id;
        this.baccara = baccara;
        this.rulete = rulete;
        this.blackjack = blackjack;
        this.poker = poker;
        this.date = date;
        this.marginProfitBaccara = marginProfitBaccara;
        this.marginProfitBlacjack = marginProfitBlacjack;
        this.marginProfitPoker = marginProfitPoker;
        this.marginProfitRulete = marginProfitRulete;
        this.financialProfit = financialProfit;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public float getBaccara() {
        return baccara;
    }

    public void setBaccara(float baccara) {
        this.baccara = baccara;
    }

    public float getRulete() {
        return rulete;
    }

    public void setRulete(float rulete) {
        this.rulete = rulete;
    }

    public float getBlackjack() {
        return blackjack;
    }

    public void setBlackjack(float blackjack) {
        this.blackjack = blackjack;
    }

    public float getPoker() {
        return poker;
    }

    public void setPoker(float poker) {
        this.poker = poker;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getMarginProfitBaccara() {
        return marginProfitBaccara;
    }

    public void setMarginProfitBaccara(int marginProfitBaccara) {
        this.marginProfitBaccara = marginProfitBaccara;
    }

    public int getMarginProfitBlacjack() {
        return marginProfitBlacjack;
    }

    public void setMarginProfitBlacjack(int marginProfitBlacjack) {
        this.marginProfitBlacjack = marginProfitBlacjack;
    }

    public int getMarginProfitPoker() {
        return marginProfitPoker;
    }

    public void setMarginProfitPoker(int marginProfitPoker) {
        this.marginProfitPoker = marginProfitPoker;
    }

    public int getMarginProfitRulete() {
        return marginProfitRulete;
    }

    public void setMarginProfitRulete(int marginProfitRulete) {
        this.marginProfitRulete = marginProfitRulete;
    }

    public float getFinancialProfit() {
        return financialProfit;
    }

    public void setFinancialProfit(float financialProfit) {
        this.financialProfit = financialProfit;
    }

    public Dealer getDealerId() {
        return dealerId;
    }

    public void setDealerId(Dealer dealerId) {
        this.dealerId = dealerId;
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
        if (!(object instanceof FinancialProfit)) {
            return false;
        }
        FinancialProfit other = (FinancialProfit) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.FinancialProfit[ id=" + id + " ]";
    }
    
}
