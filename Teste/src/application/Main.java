package application;

import java.util.Scanner;
import entities.Cliente; // Importando a classe Cliente do pacote entities

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Cadastro de Cliente");

        // Solicitar email
        String email;
        do {
            System.out.print("Digite o email: ");
            email = scanner.nextLine();
            if (!Cliente.validarEmail(email)) {
                System.out.println("Email inválido! Tente novamente.");
            }
        } while (!Cliente.validarEmail(email));

        // Solicitar senha
        System.out.print("Digite a senha: ");
        String senha = scanner.nextLine();

        // Solicitar CPF
        String cpf;
        do {
            System.out.print("Digite o CPF (formato: 000.000.000-00): ");
            cpf = scanner.nextLine();
            if (!Cliente.validarCpf(cpf)) {
                System.out.println("CPF inválido! Tente novamente.");
            }
        } while (!Cliente.validarCpf(cpf));

        // Solicitar data de nascimento
        String dataNascimento;
        do {
            System.out.print("Digite a data de nascimento (formato: DD/MM/AAAA): ");
            dataNascimento = scanner.nextLine();
            if (!Cliente.validarDataNascimento(dataNascimento)) {
                System.out.println("Data de nascimento inválida! Tente novamente.");
            }
        } while (!Cliente.validarDataNascimento(dataNascimento));

        // Criar o objeto Cliente
        Cliente cliente = new Cliente(email, senha, cpf, dataNascimento);

        // Exibir dados do cliente
        cliente.exibirDados();

        scanner.close();
    }
}