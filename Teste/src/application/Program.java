package application;
import entities.Item;

import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int opcao = 0;

        do {
            System.out.println("+---------------------------------+");
            System.out.println("|   selecione a opção desejada    |");
            System.out.println("|---------------------------------|");
            System.out.println("| 1- Cadastrar Produto            |");
            System.out.println("| 2- Retirar Produto              |");
            System.out.println("| 3- Listar Produtos              |");
            System.out.println("| 4- Sair                         |");
            System.out.println("+---------------------------------+");

            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("Cadastrar Produto: ");
                    System.out.println("Digite o nome do Produto: ");
                    String name = sc.nextLine();
                    System.out.println("Digite o id do produto: ");
                    int id = sc.nextInt();
                    System.out.println("Digite o lote do produto: ");
                    int lote = sc.nextInt();
                    System.out.println("Digite a quantidade do produto: ");
                    int quantidade = sc.nextInt();
                    System.out.println("Digite o tamanho do produto: ");
                    double tamanho = sc.nextDouble();
                    sc.nextLine();
                    System.out.println("Digite a descrição do produto: ");
                    String descricao = sc.nextLine();
                    System.out.println("Digite a categoria do produto: ");
                    String categoria = sc.nextLine();
                    System.out.println("Digite o prazo do produto: ");
                    String prazo = sc.nextLine();

                    Item item = new Item(id, lote, quantidade, tamanho, descricao, categoria, prazo);
                    
                    System.out.println(item);
                    
                    break;
                case 2:
                    System.out.println("Retirar Produto");
                    break;
                case 3:
                    System.out.println("Listar Produtos");
                    break;
                case 4:
                    System.out.println("Sair");
                    break;
                default:
                    System.out.println("Opção inválida");
                    break;
            }
        }while(opcao != 4);




        sc.close();
    }

}