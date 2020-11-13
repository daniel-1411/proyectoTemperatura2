/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyectotemperatura;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 *
 * @author Minikane
 */
public interface OperacionInterface {
    @GET("ConsultaProvincia")
    Call<ClaseRaiz> pedirProvincia();
}