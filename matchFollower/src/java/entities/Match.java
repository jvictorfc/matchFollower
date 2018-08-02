/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.Date;

/**
 *
 * @author jvict
 */
public class Match {
    private int idM;
    private Team t1;
    private Team t2;
    private int t1r;
    private int t2r;
    private Date dateM;
    private String place;

    public Match() {
    }

    @Override
    public String toString() {
        return "Match{" + "idM=" + idM + ", t1=" + t1 + ", t2=" + t2 + ", t1r=" + t1r + ", t2r=" + t2r + ", dateM=" + dateM + ", place=" + place + '}';
    }

    public Match(int idM, Team t1, Team t2, int t1r, int t2r, String place, Date dateM) {
        this.idM = idM;
        this.t1 = t1;
        this.t2 = t2;
        this.t1r = t1r;
        this.t2r = t2r;
        this.dateM = dateM;
        this.place = place;
    }

    public int getIdM() {
        return idM;
    }

    public void setIdM(int idM) {
        this.idM = idM;
    }

    public Team getT1() {
        return t1;
    }

    public void setT1(Team t1) {
        this.t1 = t1;
    }

    public Team getT2() {
        return t2;
    }

    public void setT2(Team t2) {
        this.t2 = t2;
    }

    public int getT1r() {
        return t1r;
    }

    public void setT1r(int t1r) {
        this.t1r = t1r;
    }

    public int getT2r() {
        return t2r;
    }

    public void setT2r(int t2r) {
        this.t2r = t2r;
    }

    public Date getDateM() {
        return dateM;
    }

    public void setDateM(Date dateM) {
        this.dateM = dateM;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }
    
    
    
    
    
}
