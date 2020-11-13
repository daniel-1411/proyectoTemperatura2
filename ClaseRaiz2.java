/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyectotemperatura;

import java.util.List;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

/**
 *
 * @author Minikane
 */
@Root(name="consulta_municipiero", strict =false)
public class ClaseRaiz2 {
    @ElementList
    private List<Municipiero> municipiero;
    
    public List<Municipiero> getPrediccion() {
        return municipiero;
    }

    public void setPrediccion(List<Municipiero> prediccion) {
        this.municipiero = prediccion;
    }

    @Override
    public String toString() {
        return "ClaseRaiz{" + "prediccion=" + municipiero + '}';
    }
    
}