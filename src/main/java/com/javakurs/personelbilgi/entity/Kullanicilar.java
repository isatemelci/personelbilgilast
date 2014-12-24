/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javakurs.personelbilgi.entity;

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
 * @author BEM
 */
@Entity
@Table(catalog = "personelbilgi", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Kullanicilar.girisKontrol", query = "SELECT k FROM Kullanicilar k WHERE k.kullaniciAdi = :kullanici_adi and k.sifre = :sifre"),
    @NamedQuery(name = "Kullanicilar.findAll", query = "SELECT k FROM Kullanicilar k"),
    @NamedQuery(name = "Kullanicilar.findById", query = "SELECT k FROM Kullanicilar k WHERE k.id = :id"),
    @NamedQuery(name = "Kullanicilar.findByKullaniciAdi", query = "SELECT k FROM Kullanicilar k WHERE k.kullaniciAdi = :kullaniciAdi"),
    @NamedQuery(name = "Kullanicilar.findBySifre", query = "SELECT k FROM Kullanicilar k WHERE k.sifre = :sifre")})
public class Kullanicilar implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "kullanici_adi", nullable = false, length = 20)
    private String kullaniciAdi;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(nullable = false, length = 20)
    private String sifre;

    public Kullanicilar() {
    }

    public Kullanicilar(Integer id) {
        this.id = id;
    }

    public Kullanicilar(Integer id, String kullaniciAdi, String sifre) {
        this.id = id;
        this.kullaniciAdi = kullaniciAdi;
        this.sifre = sifre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getKullaniciAdi() {
        return kullaniciAdi;
    }

    public void setKullaniciAdi(String kullaniciAdi) {
        this.kullaniciAdi = kullaniciAdi;
    }

    public String getSifre() {
        return sifre;
    }

    public void setSifre(String sifre) {
        this.sifre = sifre;
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
        if (!(object instanceof Kullanicilar)) {
            return false;
        }
        Kullanicilar other = (Kullanicilar) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.javakurs.personelbilgi.entity.Kullanicilar[ id=" + id + " ]";
    }
    
}
