/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package projetobancocombanco;

import java.util.List;

/**
 *
 * @author Carlos
 */
public interface IContaDao {
    
    void criarConta(Conta conta);
    List<Conta> lerTodasContas();
    void atualizarConta(Conta conta);
    void apagarConta(int conta);
    
    
}
