package application;

import entities.Item;
import entities.Pedido;
import services.GoogleMapsService;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program {
<<<<<<< Updated upstream
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Item> listaItens = new ArrayList<>();
        List<Pedido> listaPedidos = new ArrayList<>();
=======

    private static entities.Usuarios adm = new entities.Usuarios("admin", "123");
    private static entities.Usuarios user = new entities.Usuarios("user", "123");

    private static Scanner sc = new Scanner(System.in);
    private static List<Item> listaItens = new ArrayList<>();
    private static List<Pedido> listaPedidos = new ArrayList<>();

    public static void main(String[] args) {
        
>>>>>>> Stashed changes
        int opcao;
        

        do {
<<<<<<< Updated upstream
            //? Menu
            System.out.println("+---------------------------------+");
            System.out.println("|   Selecione a opção desejada    |");
            System.out.println("|---------------------------------|");
            System.out.println("| 1- Cadastrar Produto            |");
            System.out.println("| 2- Retirar Produto              |");
            System.out.println("| 3- Listar Pedidos               |");
            System.out.println("| 6- CalcularProdutos              |");
            System.out.println("| 4- Criar Pedido                 |");
            System.out.println("| 5- Listar  Distância           |");
            System.out.println("| 7- Sair                         |");
            System.out.println("+---------------------------------+");

=======
            System.out.println("----------- Login -----------");
            System.out.print("Digite seu usuário: ");
            String usuario_input = sc.nextLine();
            System.out.print("Digite sua senha: ");
            String senha_input = sc.nextLine();

            
                
                if (usuario_input.equals(adm.getUsuario()) && senha_input.equals(adm.getSenha())) {
                    System.out.println("Login realizado com sucesso!\n");
                    exibirMenuADM();
                    
                    break;
                } else if (usuario_input.equals(user.getUsuario()) && senha_input.equals(user.getSenha())) {
                    System.out.println("Login realizado com sucesso!\n");
                    exibirMenuUSER();
                    
                    break;
                } else {
                    System.out.println("Usuário ou senha inválidos. Tente novamente.\n");
                    
                }
            
            

            
>>>>>>> Stashed changes
            opcao = sc.nextInt();
            sc.nextLine();

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
                    sc.nextLine();
                    System.out.print("Digite a descrição do produto: ");
                    String descricao = sc.nextLine();
                    System.out.print("Digite a categoria do produto: ");
                    String categoria = sc.nextLine();
                    System.out.print("Digite o prazo do produto: ");
                    String prazo = sc.nextLine();

                    Item item = new Item(id, lote, quantidade, tamanho, descricao, categoria, prazo);
                    listaItens.add(item);
                    System.out.println("Produto cadastrado com sucesso!\n");
                    break;

                case 2:
                    System.out.print("Digite o ID do produto que deseja retirar: ");
                    int idRemover = sc.nextInt();
                    boolean removido = listaItens.removeIf(itemAtual -> itemAtual.getId() == idRemover);
                    System.out.println(removido ? "Produto removido com sucesso!\n" : "Produto não encontrado.\n");
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
                    System.out.println("----------- Criar Pedido -----------");
                    System.out.print("Digite o ID do pedido: ");
                    int idPedido = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Digite o endereço de entrega: ");
                    String endereco = sc.nextLine();
                    System.out.print("Digite a data de entrega: ");
                    String deadline = sc.nextLine();

                    System.out.println("Digite os IDs dos produtos do pedido (separados por espaço): ");
                    String[] idsProdutos = sc.nextLine().split(" ");
                    List<Integer> itensPedido = new ArrayList<>();
                    for (String idStr : idsProdutos) {
                        itensPedido.add(Integer.parseInt(idStr));
                    }
                    
                    Pedido pedido = new Pedido(idPedido, endereco, deadline, itensPedido);
                    listaPedidos.add(pedido);
                    System.out.println("Pedido criado com sucesso!\n");
                    
                    break;

                case 5:
                System.out.println("Listar Pedidos:");
                if (listaPedidos.isEmpty()) {
                    System.out.println("Nenhum pedido cadastrado.\n");
                } else {
                    for (Pedido p : listaPedidos) {
                        System.out.println("ID: " + p.getId() + "\nEndereço: " + p.getEndereco() +
                                "\nData de entrega: " + p.getDeadline() + "\nItens: " + p.getItens() + "\n");
                    }
                
                
                    }
                    break;

                case 6:
                    System.out.print("Digite o endereço de destino: ");
                    String destino = sc.nextLine();
                    String resultado = GoogleMapsService.calcularDistancia(destino);
                    System.out.println("\n--- Resultado da Distância ---");
                    System.out.println(resultado);
                    System.out.println("------------------------------\n");
                    break;

                case 7:
                    System.out.println("Saindo..."); 
                    break;

                default:
                    System.out.println("Opção inválida\n");
                    break;
            }
        } while (opcao != 7);

        sc.close();
<<<<<<< Updated upstream
=======
        }
        
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
        sc.nextLine();
        System.out.print("Digite a descrição do produto: ");
        String descricao = sc.nextLine();
        System.out.print("Digite a categoria do produto: ");
        String categoria = sc.nextLine();
        System.out.print("Digite o prazo do produto: ");
        String prazo = sc.nextLine();

        Item item = new Item(id, lote, quantidade, tamanho, descricao, categoria, prazo);
        listaItens.add(item);
        System.out.println("Produto cadastrado com sucesso!\n");
    }

    private static void retirarProduto() {
        System.out.print("Digite o ID do produto que deseja retirar: ");
        int idRemover = sc.nextInt();
        boolean removido = listaItens.removeIf(itemAtual -> itemAtual.getId() == idRemover);
        System.out.println(removido ? "Produto removido com sucesso!\n" : "Produto não encontrado.\n");
    }

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

    private static void criarPedido() {
        System.out.println("----------- Criar Pedido -----------");
        System.out.print("Digite o ID do pedido: ");
        int idPedido = sc.nextInt();
        sc.nextLine();
        System.out.print("Digite o endereço de entrega: ");
        String endereco = sc.nextLine();
        System.out.print("Digite a data de entrega: ");
        String deadline = sc.nextLine();

        System.out.println("Digite os IDs dos produtos do pedido (separados por espaço): ");
        String[] idsProdutos = sc.nextLine().split(" ");
        List<Integer> itensPedido = new ArrayList<>();
        for (String idStr : idsProdutos) {
            itensPedido.add(Integer.parseInt(idStr));
        }

        Pedido pedido = new Pedido(idPedido, endereco, deadline, itensPedido);
        listaPedidos.add(pedido);
        System.out.println("Pedido criado com sucesso!\n");
    }

    private static void listarPedidos() {
        System.out.println("Listar Pedidos:");
        if (listaPedidos.isEmpty()) {
            System.out.println("Nenhum pedido cadastrado.\n");
        } else {
            for (Pedido p : listaPedidos) {
                System.out.println("ID: " + p.getId() + "\nEndereço: " + p.getEndereco() +
                        "\nData de entrega: " + p.getDeadline() + "\nItens: " + p.getItens() + "\n");
            }
        }
    }

    private static void calcularDistancia() {
        System.out.print("Digite o endereço de destino: ");
        String destino = sc.nextLine();
        String resultado = GoogleMapsService.calcularDistancia(destino);
        System.out.println("\n-------- Resultado da Distância ------------------");
        System.out.println("|   " + resultado + "   |");
        System.out.println("--------------------------------------------------\n");
>>>>>>> Stashed changes
    }
}
