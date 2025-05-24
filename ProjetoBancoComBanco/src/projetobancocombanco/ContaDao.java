/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projetobancocombanco;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;

/**
 *
 * @author Carlos
 */
public class ContaDao implements IContaDao{
    
    private Connection connection;

    public ContaDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void criarConta(Conta conta) {
        String sql = "INSERT INTO conta (numero, saldo) VALUES (?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)){
            stmt.setInt(1, conta.getNumero());
            stmt.setDouble(2, conta.getSaldo());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("erro ao criar a conta: " + e.getMessage(), e);
        }
    }

    @Override
    public List<Conta> lerTodasContas() {
        List<Conta> contas = new ArrayList<>();
        String sql = "SELECT * FROM conta";
        try (PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                int numero = rs.getInt("numero");
                double saldo = rs.getDouble("saldo");
                contas.add(new Conta(numero, saldo));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao ler contas: " + e.getMessage(), e);
        }
        return contas;
    }

    @Override
    public void atualizarConta(Conta conta) {
        String sql = "UPDATE conta SET saldo = ? WHERE numero = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setDouble(1, conta.getSaldo());
            stmt.setInt(2, conta.getNumero());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar conta: " + e.getMessage(), e);
        }
    
    }

    @Override
    public void apagarConta(int conta) {
        String sql = "DELETE FROM conta WHERE numero = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, conta);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao apagar conta: " + e.getMessage(), e);
        }
    }
    
    
    
}
