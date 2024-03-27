import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CadastroClientes cadastro = new CadastroClientes();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== Menu de Opções ===");
            System.out.println("1. Adicionar Cliente");
            System.out.println("2. Visualizar Clientes");
            System.out.println("3. Salvar Clientes");
            System.out.println("4. Carregar Clientes");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer do scanner

            switch (opcao) {
                case 1:
                    System.out.print("Digite o nome do cliente: ");
                    String nome = scanner.nextLine();
                    System.out.print("Digite o email do cliente: ");
                    String email = scanner.nextLine();
                    System.out.print("Digite o telefone do cliente: ");
                    String telefone = scanner.nextLine();
                    Cliente cliente = new Cliente(nome, email, telefone);
                    cadastro.adicionarCliente(cliente);
                    System.out.println("Cliente adicionado com sucesso!");
                    break;

                case 2:
                    System.out.println("\n=== Clientes Cadastrados ===");
                    cadastro.visualizarClientes();
                    break;

                case 3:
                    System.out.print("Digite o nome do arquivo para salvar os clientes: ");
                    String nomeArquivoSalvar = scanner.nextLine();
                    try {
                        cadastro.salvarClientes(nomeArquivoSalvar);
                        System.out.println("Clientes salvos com sucesso!");
                    } catch (IOException e) {
                        System.out.println("Erro ao salvar os clientes: " + e.getMessage());
                    }
                    break;

                case 4:
                    System.out.print("Digite o nome do arquivo para carregar os clientes: ");
                    String nomeArquivoCarregar = scanner.nextLine();
                    try {
                        cadastro.carregarClientes(nomeArquivoCarregar);
                        System.out.println("Clientes carregados com sucesso!");
                    } catch (IOException | ClassNotFoundException e) {
                        System.out.println("Erro ao carregar os clientes: " + e.getMessage());
                    }
                    break;

                case 5:
                    System.out.println("Saindo...");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
                    break;
            }
        }
    }
}