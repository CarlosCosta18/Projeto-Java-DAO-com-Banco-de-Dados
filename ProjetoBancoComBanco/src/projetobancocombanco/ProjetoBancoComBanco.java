/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package projetobancocombanco;
import java.sql.Connection;
/**
 *
 * @author Carlos
 */
public class ProjetoBancoComBanco {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
     
        Connection conn = ConectionFactory.getConnection();
        IContaDao dao = new ContaDao(conn);
        GerenciadorContasApp app = new GerenciadorContasApp(dao);
        app.solicitarOperacao();
        
        
    }
    
}
