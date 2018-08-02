package services;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javax.sql.DataSource;
import oracle.jdbc.pool.OracleDataSource;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author jvict
 */
public class Db {

    public static Connection conectar() {
        Connection con = null;
        try {
            ResourceBundle bundle = ResourceBundle.getBundle("dbinfo");

            String path = bundle.getString("Oracle.path");
            String user = bundle.getString("Oracle.user");
            String pass = bundle.getString("Oracle.pass");

            OracleDataSource oracleDataSource = new OracleDataSource();
            oracleDataSource.setURL(path);
            oracleDataSource.setUser(user);
            oracleDataSource.setPassword(pass);

            DataSource dataSource = oracleDataSource;
            con = dataSource.getConnection();

        } catch (Exception e) {
            System.out.println("Connection failure. See the console for more details...");
            e.printStackTrace();
        }
        return con;
    }
    public static void endCon(Connection con){
			if (con != null) {
                            try{
                            con.close();
                            } catch (SQLException e){
                                System.out.println("Problem closing connection");
                                e.printStackTrace();
                            }
                        }
}
}


