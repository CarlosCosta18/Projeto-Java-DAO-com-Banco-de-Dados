/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projetobancocombanco;

import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Carlos
 */
public class GerenciadorContasApp {
    private IContaDao contaDao;
    private Scanner scanner;

    public GerenciadorContasApp(IContaDao contaDAO) {
        this.contaDao = contaDAO;
        this.scanner = new Scanner(System.in);
    }

    public void solicitarOperacao() {
        int opcao;
        do {
            System.out.println("\n===== MENU DE OPERAÇÕES =====");
            System.out.println("1 - Criar nova conta");
            System.out.println("2 - Listar contas");
            System.out.println("3 - Atualizar conta");
            System.out.println("4 - Apagar conta");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1 -> criarConta();
                case 2 -> mostrarContas();
                case 3 -> alterarConta();
                case 4 -> apagarConta();
                case 0 -> System.out.println("Encerrando programa...");
                default -> System.out.println("Opção inválida.");
            }

        } while (opcao != 0);
    }

    private void criarConta() {
        System.out.print("Digite o número da conta: ");
        int numero = scanner.nextInt();
        System.out.print("Digite o saldo inicial: ");
        double saldo = scanner.nextDouble();

        Conta novaConta = new Conta(numero, saldo);
        contaDao.criarConta(novaConta);
        System.out.println("Conta criada com sucesso!");
    }

    private void mostrarContas() {
        List<Conta> contas = contaDao.lerTodasContas();
        if (contas.isEmpty()) {
            System.out.println("Nenhuma conta encontrada.");
        } else {
            System.out.println("Contas registradas:");
            for (Conta conta : contas) {
                System.out.println(conta);
            }
        }
    }

    private void alterarConta() {
        System.out.print("Digite o número da conta a ser atualizada: ");
        int numero = scanner.nextInt();
        System.out.print("Digite o novo saldo: ");
        double saldo = scanner.nextDouble();

        Conta contaAtualizada = new Conta(numero, saldo);
        contaDao.atualizarConta(contaAtualizada);
        System.out.println("Conta atualizada com sucesso!");
    }

    private void apagarConta() {
        System.out.print("Digite o número da conta a ser apagada: ");
        int numero = scanner.nextInt();

        contaDao.apagarConta(numero);
        System.out.println("Conta apagada com sucesso!");
    }
    
}
