/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javakurs.personelbilgi.webservice;

import com.javakurs.personelbilgi.entity.Kisi;
import com.javakurs.personelbilgi.service.KisiService;
import javax.ejb.EJB;
import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 *
 * @author Bora
 */
@WebService(serviceName = "KisiWS")
public class KisiWS {
    @EJB
    private KisiService ejbRef;// Add business logic below. (Right-click in editor and choose
    // "Web Service > Add Operation"

    @WebMethod(operationName = "ekle")
    @Oneway
    public void ekle(@WebParam(name = "p_kisi") Kisi p_kisi) {
        ejbRef.ekle(p_kisi);
    }
    
}
