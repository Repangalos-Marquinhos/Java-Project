#  MELHORIAS NO CÓDIGO

1. --Gerenciamento de IDs:

Atualmente o ID de produto e pedido é inserido manualmente. Isso pode gerar conflitos.

Crie um gerador automático de IDs (com uma variável estática que incrementa):

    private static int proximoIdItem = 1;
    private static int proximoIdPedido = 1;

    E no método de cadastro:

    int id = proximoIdItem++;

----------------------------------------------------------------------------------------------

2. --Validação de entrada do usuário:

Se o usuário digita um caractere onde deveria ser um número, o programa quebra.

➡️ Use try-catch ou valide com hasNextInt():

    if (sc.hasNextInt()) {
       int opcao = sc.nextInt();
    } else {
        System.out.println("Entrada inválida.");
        sc.next(); // limpar buffer
    }

----------------------------------------------------------------------------------------------

3. --Separação de responsabilidades:

A classe Utilidades faz de tudo. Considere separá-la em:

-ProdutoService

-PedidoService

-MenuService

----------------------------------------------------------------------------------------------

4. --Cadastro de usuários:

Atualmente, os usuários estão hardcoded. Implemente:

-Cadastro de novos usuários (com opção de criar conta)

-Diferenciação de perfis (ex: mais permissões ao admin)

----------------------------------------------------------------------------------------------

5. --Filtro de pedidos por status:

Permita listar pedidos por PENDENTE, ENTREGUE, etc.

----------------------------------------------------------------------------------------------

6. --Usar O Date/Time

para facilitar o uso do prazo de entrega.

----------------------------------------------------------------------------------------------

# EXTRAS (Funcionalidades Avançadas)


1. Histórico de alterações

Guarde um log com:

-Quem fez o login

-Quando o produto foi cadastrado ou retirado

-Quando o status do pedido mudou

----------------------------------------------------------------------------------------------

2. Relatórios

Produtos com menor quantidade em estoque

Pedidos entregues vs pendentes

----------------------------------------------------------------------------------------------

3. Interface Gráfica (GUI com JavaFX ou Swing)

Futuramente, migrar o sistema para uma interface gráfica para facilitar o uso por usuários.

----------------------------------------------------------------------------------------------

4. Integração com banco de dados

integrar o projeto inteiro com BD, facilitando o armazenamentos de dados longevidade do projeto

----------------------------------------------------------------------------------------------






