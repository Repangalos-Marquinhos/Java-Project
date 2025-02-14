package application;

import entities.Item;
import services.GoogleMapsService; // Importando o serviço de cálculo de distância
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Item> listaItens = new ArrayList<>(); // Lista para armazenar os itens
        int opcao;

        do {
            System.out.println("+---------------------------------+");
            System.out.println("|   Selecione a opção desejada    |");
            System.out.println("|---------------------------------|");
            System.out.println("| 1- Cadastrar Produto            |");
            System.out.println("| 2- Retirar Produto              |");
            System.out.println("| 3- Listar Produtos              |");
            System.out.println("| 4- Calcular Distância           |");
            System.out.println("| 5- Sair                         |");
            System.out.println("+---------------------------------+");

            opcao = sc.nextInt();
            sc.nextLine(); // Consumir a quebra de linha

            switch (opcao) {
                case 1:
                    System.out.println("-----------Cadastrar Produto-----------");

                    System.out.print("Digite o id do produto: ");
                    int id = sc.nextInt();
                    System.out.print("Digite o lote do produto: ");
                    int lote = sc.nextInt();
                    System.out.print("Digite a quantidade do produto: ");
                    int quantidade = sc.nextInt();
                    System.out.print("Digite o tamanho do produto: ");
                    double tamanho = sc.nextDouble();
                    sc.nextLine(); // Consumir a quebra de linha
                    System.out.print("Digite a descrição do produto: ");
                    String descricao = sc.nextLine();
                    System.out.print("Digite a categoria do produto: ");
                    String categoria = sc.nextLine();
                    System.out.print("Digite o prazo do produto: ");
                    String prazo = sc.nextLine();

                    // Criar um novo item e adicionar à lista
                    Item item = new Item(id, lote, quantidade, tamanho, descricao, categoria, prazo);
                    listaItens.add(item);

                    System.out.println("Produto cadastrado com sucesso!\n");
                    break;

                case 2:
                    System.out.println("Retirar Produto:");
                    System.out.print("Digite o ID do produto que deseja retirar: ");
                    int idRemover = sc.nextInt();

                    // Remover o item da lista pelo ID
                    boolean removido = listaItens.removeIf(itemAtual -> itemAtual.getId() == idRemover);

                    if (removido) {
                        System.out.println("Produto removido com sucesso!\n");
                    } else {
                        System.out.println("Produto não encontrado.\n");
                    }
                    break;

                case 3:
                    System.out.println("Listar Produtos:");
                    if (listaItens.isEmpty()) {
                        System.out.println("Nenhum produto cadastrado.\n");
                    } else {
                        for (Item i : listaItens) {
                            System.out.println(i);
                        }
                    }
                    break;

                case 4:
                    System.out.println("Digite o endereço de destino:");
                    String destino = sc.nextLine();

                    // Chamando a API do Google Maps para calcular a distância
                    String resultado = GoogleMapsService.calcularDistancia(destino);

                    // Exibindo o resultado da distância
                    System.out.println("\n--- Resultado da Distância ---");
                    System.out.println(resultado);
                    System.out.println("------------------------------\n");
                    break;

                case 5:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida\n");
                    break;
            }
        } while (opcao != 5);

        sc.close();
    }
}
