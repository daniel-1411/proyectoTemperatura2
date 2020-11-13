/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyectotemperatura;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 *
 * @author Minikane
 */
public interface OperacionInterface2 {
    @GET("ConsultaMunicipio?Provincia=Toledo&Municipio=")
    Call<ClaseRaiz2> pedirMunicipio();
    //@Path("user") String user
}