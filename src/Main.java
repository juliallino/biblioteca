import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BST biblioteca = new BST();
        Scanner scanner = new Scanner(System.in);
        int option, isbn;


        biblioteca.insert(12345);
        biblioteca.insert(67890);
        biblioteca.insert(11111);

        do {
            System.out.println("\n--- Biblioteca Digital ---");
            System.out.println("1. Inserir ISBN");
            System.out.println("2. Buscar ISBN");
            System.out.println("3. Remover ISBN");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    System.out.print("Digite o ISBN a ser inserido: ");
                    isbn = scanner.nextInt();
                    biblioteca.insert(isbn);
                    System.out.println("ISBN " + isbn + " inserido.");
                    break;
                case 2:
                    System.out.print("Digite o ISBN a ser buscado: ");
                    isbn = scanner.nextInt();
                    if (biblioteca.buscar(isbn)) {
                        System.out.println("ISBN " + isbn + " encontrado na biblioteca.");
                    } else {
                        System.out.println("ISBN " + isbn + " não encontrado na biblioteca.");
                    }
                    break;
                case 3:
                    System.out.print("Digite o ISBN a ser removido: ");
                    isbn = scanner.nextInt();
                    biblioteca.delete(isbn);
                    System.out.println("ISBN " + isbn + " removido.");
                    break;
                case 4:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (option != 4);

        scanner.close();
    }
}
