import models.UserModel;
import services.UserService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        UserService userService = new UserService();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== Menu =====");
            System.out.println("[1] - Listar todos os usuários");
            System.out.println("[2] - Adicionar um usuário");
            System.out.println("[3] - Atualizar um usuário");
            System.out.println("[4] - Deletar um usuário");
            System.out.println("[5] - Buscar usuário por ID");
            System.out.println("[0] - Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("Lista de usuários:");
                    for (UserModel user : userService.getAllUsers()) {
                        System.out.printf("ID: %d | Nome: %s | Email: %s | Status: %s\n", user.getId(), user.getName(), user.getEmail(), user.getStatus());
                    }
                    break;
                case 2:
                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("Email: ");
                    String email = scanner.nextLine();
                    userService.createUser(nome, email);
                    System.out.println("Usuário criado!");
                    break;
                case 3:
                    System.out.print("ID do usuário para atualizar: ");
                    int idAtualizar = scanner.nextInt();
                    scanner.nextLine();

                    UserModel userToUpdate = userService.getUserById(idAtualizar);
                    if (userToUpdate == null) {
                        System.out.println("Usuário não encontrado.");
                        break;
                    }

                    System.out.print("Novo nome (enter para manter '" + userToUpdate.getName() + "'): ");
                    String novoNome = scanner.nextLine();
                    if (!novoNome.trim().isEmpty()) {
                        userToUpdate.setName(novoNome);
                    }

                    System.out.print("Novo email (enter para manter '" + userToUpdate.getEmail() + "'): ");
                    String novoEmail = scanner.nextLine();
                    if (!novoEmail.trim().isEmpty()) {
                        userToUpdate.setEmail(novoEmail);
                    }

                    userService.updateUser(userToUpdate);
                    System.out.println("Usuário atualizado.");
                    break;
                case 4:
                    System.out.print("ID do usuário para deletar: ");
                    int idDeletar = scanner.nextInt();
                    scanner.nextLine();

                    userService.deleteUser(idDeletar);
                    break;

                case 5:
                    System.out.print("ID do usuário para buscar: ");
                    int idBuscar = scanner.nextInt();
                    scanner.nextLine();

                    UserModel userFound = userService.getUserById(idBuscar);
                    if (userFound != null) {
                        System.out.printf("ID: %d | Nome: %s | Email: %s | Status: %s\n", userFound.getId(), userFound.getName(), userFound.getEmail(), userFound.getStatus());
                    } else {
                        System.out.println("Usuário não encontrado.");
                    }
                    break;

                case 0:
                    System.out.println("Saindo...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}

//        userService.createUser("Alice", "alice@example.com");
//        userService.createUser("Bob", "bob@example.com");
//
//        System.out.println("Todos usuários:");
//        for (models.UserModel user : userService.getAllUsers()) {
//            System.out.println(user.getId() + " - " + user.getName());
//        }
//
//        models.UserModel busca = userService.getUserById();
//        System.out.println("Busca usuário: " + busca.getName() + ", " + busca.getEmail());
//
//        userService.deleteUser(user2.getId());
//        System.out.println("Usuário deletado.");
//
//        System.out.println("Lista final:");
//        for (models.UserModel user : userService.getAllUsers()) {
//            System.out.println(user.getId() + " - " + user.getName());
//        }
//    }
//}
