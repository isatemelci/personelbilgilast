/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javakurs.personelbilgi.facade;

import com.javakurs.personelbilgi.entity.Kullanicilar;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author BEM
 */
@Stateless
public class KullanicilarFacade extends AbstractFacade<Kullanicilar> {

    @PersistenceContext(unitName = "personelbilgiPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public KullanicilarFacade() {
        super(Kullanicilar.class);
    }

    public boolean girisKontrol(String pKullaniciAdi, String pSifre) {

        Kullanicilar k = em.createNamedQuery("Kullanicilar.girisKontrol", Kullanicilar.class)
                .setParameter("kullanici_adi", pKullaniciAdi)
                .setParameter("sifre", pSifre).getSingleResult();

        if (k != null) {
            return true;
        } else {
            return false;
        }
       
    }
}
