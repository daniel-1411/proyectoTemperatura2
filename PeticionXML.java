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
public class PeticionXML {
    private static ComunicacionPedirClima clase_llamante;

    public PeticionXML(ComunicacionPedirClima clase_llamante) {
        this.clase_llamante = clase_llamante;
    }
    
    public static void pedirProvicias()
    {
         String base="http://ovc.catastro.meh.es/ovcservweb/ovcswlocalizacionrc/ovccallejero.asmx/";
        
        Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(base).addConverterFactory(SimpleXmlConverterFactory.create())
            .build();
        OperacionInterface servicio=retrofit.create(OperacionInterface.class);
        Call<ClaseRaiz> llamada=servicio.pedirProvincia();
        llamada.enqueue(new Callback<ClaseRaiz>() {
                 @Override
                 public void onResponse(Call<ClaseRaiz> call, Response<ClaseRaiz> rspns) {
                     clase_llamante.mostrarDatos(rspns.body());
                     ClaseRaiz  articulo = rspns.body();
                     AccesoBD.introducirProvincias(articulo);
                 }

                 @Override
                 public void onFailure(Call<ClaseRaiz> call, Throwable thrwbl) {
                     System.out.println("ERROR: "+thrwbl.getMessage());
                 }
    });
    }
    public interface ComunicacionPedirClima{
        public void mostrarDatos(ClaseRaiz r);
    }
}