import com.twu.biblioteca.*;

import java.util.List;
import java.util.Scanner;

public class BibliotecaApp implements Executable {
    Library library;
    int option;
    Scanner scanner;
    static boolean exit;
    static boolean returnBack;

    private void init() {
        library = new Library();
        scanner = new Scanner(System.in);
    }

    public BibliotecaApp() {
        init();
    }

    private void start() {
        printWelcomeMessage();
        while (!exit) {
            printMenu(library.getOptions());
        }
    }

    private void printWelcomeMessage() {
        System.out.println(library.welcomeMessage());
    }

    public void printListOfBooks() {
        do {
            List<Book> books = library.getAvailableBooks();
            System.out.format("\n%-20s\t%-30s\t%-20s\n", "Titles", "Authors", "Year of Publication");
            System.out.println();
            for (Book book : books) {
                System.out.format("%-20s\t%-30s\t%-20d", book.getName(), book.getAuthor(), book.getYear());
                System.out.println();
            }
            returnToMenu();
        }
        while (!returnBack);
    }

    @Override
    public void bookCheckout() {
        System.out.println("Enter book index for checkout");
        getOption();
        library.checkout(option);
        System.out.println(library.checkoutMessage());
        while (!returnBack) {
            returnToMenu();
        }
    }

    private void printMenu(List<String> options) {
        int i = 1;
        System.out.println("\nSelect an option\n");
        for (String option : options) {
            System.out.println(i + ". " + option);
            i += 1;
        }
        executeOption();
    }

    public void quit() {
        exit = true;
    }

    public void goBack() {
        printMenu(library.getOptions());
    }

    private void returnToMenu() {
        System.out.println("\nPress 0 to return to menu");
        getOption();
        if (option == 0) {
            Option.Back.executeOption(this);
            returnBack = true;
        } else {
            Option.Invalid.executeOption(this);
            returnBack = false;
        }
    }

    @Override
    public void showInvalid() {
        System.out.println("\nPlease select a valid option\n");
    }

    private void getOption() {
        option = scanner.nextInt();
    }

    private void executeOption() {
        getOption();
        switch (option) {
            case 1:
                Option.One.executeOption(this);
                break;
            case 2:
                Option.Two.executeOption(this);
                break;
            case 3:
                Option.Three.executeOption(this);
                break;
            default:
                Option.Invalid.executeOption(this);
        }
    }

    public static void main(String[] args) {
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        bibliotecaApp.start();
    }
}
