package application; // Define o pacote onde a classe está inserida

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.Item;
import entities.Pedido;
import services.GoogleMapsService;

public class Program {

    // Lista para armazenar todos os produtos cadastrados
    private static List<Item> listaItens = new ArrayList<>();

    // Lista para armazenar todos os pedidos feitos
    private static List<Pedido> listaPedidos = new ArrayList<>();

    // Scanner para entrada de dados pelo terminal
    private static Scanner sc = new Scanner(System.in);

    // Usuário comum (login fixo para testes)
    private static entities.Usuarios user = new entities.Usuarios("user", "123");

    // Usuário administrador (login fixo para testes)
    private static entities.Usuarios adm = new entities.Usuarios("admin", "123");

    public static void main(String[] args) {

        int opcao = 0;

        do {
            // Tela de login
            System.out.println("----------- Login -----------");
            System.out.print("Digite seu usuário: ");
            String usuario_input = sc.nextLine();

            System.out.print("Digite sua senha: ");
            String senha_input = sc.nextLine();

            // Verifica se é admin
            if (usuario_input.equals(adm.getUsuario()) && senha_input.equals(adm.getSenha())) {
                System.out.println("Login realizado com sucesso!\n");
                exibirMenuADM(); // Exibe menu de administrador
                break;

                // Verifica se é usuário comum
            } else if (usuario_input.equals(user.getUsuario()) && senha_input.equals(user.getSenha())) {
                System.out.println("Login realizado com sucesso!\n");
                exibirMenuUSER(); // Exibe menu de usuário
                break;

            } else {
                System.out.println("Usuário ou senha inválidos. Tente novamente.\n");
            }

            // Leitura da opção de menu após login
            opcao = sc.nextInt();
            sc.nextLine(); // Consumir quebra de linha

            // Execução da opção escolhida
            switch (opcao) {
                case 1:
                    cadastrarProduto();
                    break;
                case 2:
                    retirarProduto();
                    break;
                case 3:
                    listarProdutos();
                    break;
                case 4:
                    criarPedido();
                    break;
                case 5:
                    listarPedidos();
                    break;
                case 6:
                    calcularDistancia();
                    break;
                case 7:
                    volumeGalpao();
                    break;
                case 8:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida\n");
                    break;
            }

        } while (opcao != 8);

        sc.close(); // Fecha o scanner no final
    }

    // Exibe o menu de opções para administradores
    private static void exibirMenuADM() {
        System.out.println("+---------------------------------+");
        System.out.println("|   Selecione a opção desejada    |");
        System.out.println("|---------------------------------|");
        System.out.println("| 1- Cadastrar Produto            |");
        System.out.println("| 2- Retirar Produto              |");
        System.out.println("| 3- Listar Produtos              |");
        System.out.println("| 4- Criar Pedido                 |");
        System.out.println("| 5- Listar Pedidos               |");
        System.out.println("| 6- Calcular Distância           |");
        System.out.println("| 7- Sair                         |");
        System.out.println("+---------------------------------+");
    }

    // Exibe o menu de opções para usuários comuns
    private static void exibirMenuUSER() {
        System.out.println("+---------------------------------+");
        System.out.println("|   Selecione a opção desejada    |");
        System.out.println("|---------------------------------|");
        System.out.println("| 1- Cadastrar Produto            |");
        System.out.println("| 2- Retirar Produto              |");
        System.out.println("| 3- Listar Produtos              |");
        System.out.println("| 4- Criar Pedido                 |");
        System.out.println("| 5- Listar Pedidos               |");
        System.out.println("| 6- Calcular Distância           |");
        System.out.println("| 7- Sair                         |");
        System.out.println("+---------------------------------+");
    }

    // Cadastra um novo produto na lista
    private static void cadastrarProduto() {
        System.out.println("-----------Cadastrar Produto-----------");

        System.out.print("Digite o id do produto: ");
        int id = sc.nextInt();

        System.out.print("Digite o lote do produto: ");
        int lote = sc.nextInt();

        System.out.print("Digite a quantidade do produto: ");
        int quantidade = sc.nextInt();

        System.out.print("Digite o tamanho do produto: ");
        double tamanho = sc.nextDouble();

        sc.nextLine(); // Consumir quebra de linha

        System.out.print("Digite a descrição do produto: ");
        String descricao = sc.nextLine();

        System.out.print("Digite a categoria do produto: ");
        String categoria = sc.nextLine();

        System.out.print("Digite o prazo do produto: ");
        String prazo = sc.nextLine();

        // Cria um novo item e adiciona à lista
        Item item = new Item(id, lote, quantidade, tamanho, descricao, categoria, prazo);
        listaItens.add(item);

        System.out.println("Produto cadastrado com sucesso!\n");
    }

    // Remove um produto da lista com base no ID
    private static void retirarProduto() {
        System.out.print("Digite o ID do produto que deseja retirar: ");
        int idRemover = sc.nextInt();

        // Remove se o ID for encontrado
        boolean removido = listaItens.removeIf(itemAtual -> itemAtual.getId() == idRemover);

        System.out.println(removido ? "Produto removido com sucesso!\n" : "Produto não encontrado.\n");
    }

    // Exibe todos os produtos cadastrados
    private static void listarProdutos() {
        System.out.println("Listar Produtos:");

        if (listaItens.isEmpty()) {
            System.out.println("Nenhum produto cadastrado.\n");
        } else {
            for (Item i : listaItens) {
                System.out.println(i);
            }
        }
    }

    // Cria um novo pedido com uma lista de IDs de produtos
    private static void criarPedido() {
        System.out.println("----------- Criar Pedido -----------");

        System.out.print("Digite o ID do pedido: ");
        int idPedido = sc.nextInt();
        sc.nextLine(); // Consumir quebra de linha

        System.out.print("Digite o endereço de entrega: ");
        String endereco = sc.nextLine();

        System.out.print("Digite a data de entrega: ");
        String deadline = sc.nextLine();

        System.out.println("Digite os IDs dos produtos do pedido (separados por espaço): ");
        String[] idsProdutos = sc.nextLine().split(" ");

        // Converte os IDs em inteiros e armazena na lista de itens do pedido
        List<Integer> itensPedido = new ArrayList<>();
        for (String idStr : idsProdutos) {
            itensPedido.add(Integer.parseInt(idStr));
        }

        // Cria e adiciona o pedido
        Pedido pedido = new Pedido(idPedido, endereco, deadline, itensPedido);
        listaPedidos.add(pedido);

        System.out.println("Pedido criado com sucesso!\n");
    }

    // Lista todos os pedidos feitos
    private static void listarPedidos() {
        System.out.println("Listar Pedidos:");

        if (listaPedidos.isEmpty()) {
            System.out.println("Nenhum pedido cadastrado.\n");
        } else {
            for (Pedido p : listaPedidos) {
                System.out.println("ID do Pedido: " + p.getId());
                System.out.println("Endereço: " + p.getEndereco());
                System.out.println("Data de entrega: " + p.getDeadline());
                System.out.println("Itens do Pedido:");

                for (int idProduto : p.getItens()) {
                    // Tenta encontrar o produto correspondente ao ID
                    Item item = listaItens.stream()
                            .filter(i -> i.getId() == idProduto)
                            .findFirst()
                            .orElse(null);

                    if (item != null) {
                        System.out.println("  - " + item);
                    } else {
                        System.out.println("  - Produto com ID " + idProduto + " não encontrado.");
                    }
                }
                System.out.println();
            }
        }
    }

    // Calcula distância até um endereço usando serviço externo
    private static void calcularDistancia() {
        System.out.print("Digite o endereço de destino: ");
        String destino = sc.nextLine();

        // Chamada ao serviço fictício de distância
        String resultado = GoogleMapsService.calcularDistancia(destino);

        System.out.println("\n-------- Resultado da Distância ------------------");
        System.out.println("|   " + resultado + "   |");
        System.out.println("--------------------------------------------------\n");
    }

    // Simula o cálculo do volume de um galpão
    private static void volumeGalpao() {
        int x = 0;
        int y = 0;
        int z = 0;

        // O array tridimensional simula o espaço do galpão (ainda vazio aqui)
        int[][][] estoque = new int[x][y][z];

        System.out.println("Volume do Galpão: ");
        System.out.print("Digite a largura do galpão: ");
        x = sc.nextInt();

        System.out.print("Digite o comprimento do galpão: ");
        y = sc.nextInt();

        System.out.print("Digite a altura do galpão: ");
        z = sc.nextInt();

        System.out.println("Dimensões do galpão adicionado: " + x + "x" + y + "x" + z);
    }
}
