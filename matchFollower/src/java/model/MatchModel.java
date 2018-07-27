/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entities.Match;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jvict
 */
public class MatchModel {
    public Match find(){
        return new Match("m1","Brasil","Mexico",1,0);
    }
    
    public List<Match> findAll(){
        List<Match> result = new ArrayList<>();
        result.add(new Match ("m1","Brasil","Mexico",1,0));
        result.add(new Match ("m2","Alemanha","Franca",2,2));
        result.add(new Match ("m3","Canada","Usa",2,2));       
        return result;
    
    }
}
