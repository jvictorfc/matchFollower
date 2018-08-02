/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Match;
import entities.Team;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import static services.Utility.getPoints;
import static services.Utility.getTeam;


/**
 *
 * @author jvict
 */
public class Utility {
    public static Team getTeam(int id){        
        Team team = null;
        String query = "select * from team where idTeam=?";
        Connection con = Db.conectar();
        ResultSet rs = null;
        PreparedStatement stm = null;

        try{
            stm = con.prepareStatement(query);
            stm.setInt(1, id);
            rs = stm.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");
                String country = rs.getString("country");
                String city = rs.getString("city");
                int year = rs.getInt("year");
                String wsite = rs.getString("website");
                team = new Team(id,name,country,city,year,wsite);
            }
            rs.close();
            stm.close();
        }catch (SQLException e){
            System.out.println("Nao conseguiu criar o tine");
        }
        Db.endCon(con);
        return team;
    }
    
    public static Match getMatch(int id){
        Match match = null;
        String query = "select * from mat where idMat=?";
        Connection con = Db.conectar();
        ResultSet rs = null;
        PreparedStatement stm = null;
        try{
            stm = con.prepareStatement(query);
            stm.setInt(1, id);
            rs = stm.executeQuery();
            while (rs.next()) {
                int idTeam1 = rs.getInt("idTeam1");
                int idTeam2 = rs.getInt("idTeam2");
                Team t1 = getTeam(idTeam1);
                Team t2 = getTeam(idTeam2);
                int t1r = getPoints(id,idTeam1);
                int t2r = getPoints(id,idTeam2);
                String place = rs.getString("place");
                Date date = rs.getDate("dateMatch");
                match = new Match(id,t1,t2,t1r,t2r,place,date);
            }
            rs.close();
            stm.close();
        }catch (SQLException e){
            
        }
        Db.endCon(con);
        return match;
    }
    
    public static int getPoints(int idMat, int idTeam){
        int goals=0;
        String query = "select sum(score) as score from score where idMat=? and idTeam=?";
        Connection con = Db.conectar();
        ResultSet rs = null;
        PreparedStatement stm = null;
        try{
            stm = con.prepareStatement(query);
            stm.setInt(1, idMat);
            stm.setInt(2, idTeam);
            rs = stm.executeQuery();
            while (rs.next()) {
                goals = rs.getInt("score");
            }
            rs.close();
            stm.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        Db.endCon(con);
        
        return goals;
    }

        public static int changeScore(String ope, int idMat, int idTeam){
        
        String query = "insert into score values(?,?,1)";
        Connection con = Db.conectar();
        int ver=0;
        PreparedStatement stm = null;
        try{
            stm = con.prepareStatement(query);
            stm.setInt(1, idMat);
            stm.setInt(2, idTeam);
            ver = stm.executeUpdate();
            stm.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        Db.endCon(con);
        
        return ver;
    }

    public static ArrayList<Match> getMatches(){
        ArrayList<Match> matches = new ArrayList<Match>();
        String query = "select * from mat";
        Connection con = Db.conectar();
        ResultSet rs = null;
        PreparedStatement stm = null;
        try{
            stm = con.prepareStatement(query);;
            rs = stm.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("idMat");
                int idTeam1 = rs.getInt("idTeam1");
                int idTeam2 = rs.getInt("idTeam2");
                Team t1 = getTeam(idTeam1);
                Team t2 = getTeam(idTeam2);
                int t1r = getPoints(id,idTeam1);
                int t2r = getPoints(id,idTeam2);
                String place = rs.getString("place");
                Date date = rs.getDate("dateMatch");
                Match m = new Match(id,t1,t2,t1r,t2r,place,date);
                System.out.println(m);
                matches.add(m);
            }
            rs.close();
            stm.close();
        }catch (SQLException e){
            
        }
        Db.endCon(con);
        return matches;
    }
    }