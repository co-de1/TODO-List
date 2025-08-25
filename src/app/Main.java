package app;

import model.Status;
import model.Task;
import service.TaskService;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final TaskService service = new TaskService();

    public static void main(String[] args) {
        int option;
        do {
            System.out.println("\n\n\nTODO LIST MENU \n\n");
            System.out.println("1. Adicionar Tarefa");
            System.out.println("2. Listar Todas");
            System.out.println("3. Listar por Categoria");
            System.out.println("4. Listar por Prioridade");
            System.out.println("5. Listar por Status");
            System.out.println("6. Remover Tarefa");
            System.out.println("0. Sair\n\n");
            System.out.print("Escolha: ");
            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1 -> addTask();
                case 2 -> service.listAll().forEach(System.out::println);
                case 3 -> {
                    System.out.print("Categoria: ");
                    String category = scanner.nextLine();
                    service.listByCategory(category).forEach(System.out::println);
                }
                case 4 -> {
                    System.out.print("Prioridade (1-5): ");
                    int priority = scanner.nextInt();
                    service.listByPriority(priority).forEach(System.out::println);
                }
                case 5 -> {
                    System.out.print("Status (TODO, DOING, DONE): ");
                    String string = scanner.nextLine();
                    service.listByStatus(string).forEach(System.out::println);
                }
                case 6 -> {
                    System.out.print("Nome da Tarefa a remover: ");
                    String name = scanner.nextLine();
                    boolean removed = service.deleteTask(name);
                    System.out.println(removed ? "Removida com sucesso." : "Não encontrada.");
                }
            }
        } while (option != 0);
    }

    private static void addTask() {
        System.out.print("Nome: ");
        String name = scanner.nextLine();
        System.out.print("Descrição: ");
        String description = scanner.nextLine();
        System.out.print("Data de término (AAAA-MM-DD): ");
        LocalDate due = LocalDate.parse(scanner.nextLine());
        System.out.print("Prioridade (1-5): ");
        int priority = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Categoria: ");
        String category = scanner.nextLine();
        System.out.print("Status (TODO, DOING, DONE): ");
        Status status = Status.valueOf(scanner.nextLine().toUpperCase());

        Task task = new Task(name, description, due, priority, category, status);
        service.addTask(task);
        System.out.println("Tarefa adicionada!");
    }
}
