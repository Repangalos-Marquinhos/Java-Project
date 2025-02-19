package entities;

import java.util.regex.Pattern;

public class Cliente {
    private String email;
    private String senha;
    private String cpf;
    private String dataNascimento;

    // Construtor
    public Cliente(String email, String senha, String cpf, String dataNascimento) {
        this.email = email;
        this.senha = senha;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
    }

    // Getters e Setters
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    // Método para exibir dados do cliente
    public void exibirDados() {
        System.out.println("\nDados do Cliente:");
        System.out.println("Email: " + email);
        System.out.println("Senha: " + senha);
        System.out.println("CPF: " + cpf);
        System.out.println("Data de Nascimento: " + dataNascimento);
    }

    // Métodos de validação (podem ser estáticos para uso externo)
    public static boolean validarEmail(String email) {
        String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
        return Pattern.compile(regex).matcher(email).matches();
    }

    public static boolean validarCpf(String cpf) {
        return cpf.matches("\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}");
    }

    public static boolean validarDataNascimento(String data) {
        return data.matches("\\d{2}/\\d{2}/\\d{4}");
    }
}