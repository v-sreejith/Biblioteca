import com.twu.biblioteca.Book;
import com.twu.biblioteca.Executable;
import com.twu.biblioteca.Library;
import com.twu.biblioteca.Option;

import java.util.List;
import java.util.Scanner;

public class BibliotecaApp implements Executable {
    Library library;
    int option;
    Scanner scanner;
    static boolean exit;

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
        }
        while (!returnToMenu());
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

    private boolean returnToMenu() {
        System.out.println("\nPress 0 to return to menu");
        getOption();
        if (option == 0) {
            Option.Back.executeOption(this);
            return true;
        } else {
            Option.Invalid.executeOption(this);
            return false;
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
            default:
                Option.Invalid.executeOption(this);
        }
    }

    public static void main(String[] args) {
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        bibliotecaApp.start();
    }
}
