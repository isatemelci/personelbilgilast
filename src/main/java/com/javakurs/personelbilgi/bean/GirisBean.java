package com.javakurs.personelbilgi.bean;

import com.javakurs.personelbilgi.service.KullaniciGirisServis;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author BEM
 */
@Named(value = "girisBean")
@SessionScoped
public class GirisBean implements Serializable {

    @EJB
    private KullaniciGirisServis kullaniciGirisServis;

    private String kullaniciAdi;
    private String sifre;

    public GirisBean() {

    }

    public String doLogin() throws Exception {

        try {
            boolean sonuc = kullaniciGirisServis.girisKontrol(kullaniciAdi, sifre);
            
            if (sonuc) {
                return "kayit.jsf";
            } else {
                sifirla();
                return "giris.jsf";
            }
        } catch (Exception ex) {
            throw new Exception();
        }
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

    private void sifirla() {
        this.kullaniciAdi = "";
        this.sifre = "";
    }
}
