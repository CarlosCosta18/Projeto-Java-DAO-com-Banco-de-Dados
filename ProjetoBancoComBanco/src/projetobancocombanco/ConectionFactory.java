/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projetobancocombanco;


import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;




/**
 *
 * @author Carlos
 */
public class ConectionFactory {
    private static final String URL = "jdbc:postgresql://aws-0-sa-east-1.pooler.supabase.com:6543/postgres";

    private static final String usuario = "postgres.tykycrtxfgisxvlhdkbu";
    private static final String senha = "1Carloseduardo1";
    
    public static Connection getConnection(){
        try {
            return DriverManager.getConnection(URL, usuario, senha);
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao conectar com o banco: " + e.getMessage(), e);
        }
    
    }
}
