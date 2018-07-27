/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author jvict
 */
public class Match {
    private String idM;
    private String t1;
    private String t2;
    private int t1r;
    private int t2r;

    public Match(String idM, String t1, String t2, int t1r, int t2r) {
        this.idM = idM;
        this.t1 = t1;
        this.t2 = t2;
        this.t1r = t1r;
        this.t2r = t2r;
    }

    public Match() {
    }

    
    
    public String getIdM() {
        return idM;
    }

    public void setIdM(String idM) {
        this.idM = idM;
    }

    public String getT1() {
        return t1;
    }

    public void setT1(String t1) {
        this.t1 = t1;
    }

    public String getT2() {
        return t2;
    }

    public void setT2(String t2) {
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
    
    
}
