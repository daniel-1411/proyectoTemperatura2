/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyectotemperatura;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

/**
 *
 * @author Minikane
 */
public class PeticionXML2 {
    private static ComunicacionPedirClima clase_llamante;

    public PeticionXML2(ComunicacionPedirClima clase_llamante) {
        this.clase_llamante = clase_llamante;
    }
    
    public static void pedirMunicipios()
    {
         String base="http://ovc.catastro.meh.es/ovcservweb/ovcswlocalizacionrc/ovccallejero.asmx/";
        
        Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(base).addConverterFactory(SimpleXmlConverterFactory.create())
            .build();
        OperacionInterface2 servicio=retrofit.create(OperacionInterface2.class);
        Call<ClaseRaiz2> llamada=servicio.pedirMunicipio();
        llamada.enqueue(new Callback<ClaseRaiz2>() {
                 @Override
                 public void onResponse(Call<ClaseRaiz2> call, Response<ClaseRaiz2> rspns) {
                     clase_llamante.mostrarDatos(rspns.body());
                 }

                 @Override
                 public void onFailure(Call<ClaseRaiz2> call, Throwable thrwbl) {
                     System.out.println("ERROR: "+thrwbl.getMessage());
                 }
    });
    }
    public interface ComunicacionPedirClima{
        public void mostrarDatos(ClaseRaiz2 r);
    }
}