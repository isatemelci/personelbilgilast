/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javakurs.personelbilgi.service;

import com.javakurs.personelbilgi.facade.KullanicilarFacade;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author BEM
 */
@Stateless
public class KullaniciGirisServis {

    @EJB
    private KullanicilarFacade kullanicilarFacade;

    public boolean girisKontrol(String pKullaniciAdi, String pSifre) throws Exception {
        return kullanicilarFacade.girisKontrol(pKullaniciAdi, pSifre);
    }
}
