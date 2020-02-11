import com.twu.biblioteca.*;

import java.util.List;
import java.util.Scanner;

//Job: Represent a Bibliotica client
public class BibliotecaClient implements UserInterface {
    Biblioteca biblioteca;
    Library library;
    int option;
    Scanner scanner;
    static boolean exit;
    static boolean returnBack;

    private void init() {
        library = new Library(initBooks(), null);
        biblioteca = new Biblioteca(library);
        scanner = new Scanner(System.in);
    }

    private List<Book> initBooks() {
        Book bookOne = new Book("Wings of Fire", "A P J Abdul Kalam", 2001);
        Book bookTwo = new Book("Kite Runner", "Khaled Hosseini", 2003);
        Book bookThree = new Book("Hunger Games", "Suzzane", 2009);
        return List.of(bookOne, bookTwo, bookThree);
    }

    public BibliotecaClient() {
        init();
    }

    private void start() {
        printWelcomeMessage();
        while (!exit) {
            printMenu();
        }
    }

    private void printWelcomeMessage() {
        System.out.println(biblioteca.getWelcomeMessage());
    }

    private void printBooks(List<Book> books) {
        System.out.format("\n%-20s\t%-30s\t%-20s\n", "Titles", "Authors", "Year of Publication");
        System.out.println();
        for (Book book : books) {
            System.out.format("%-20s\t%-30s\t%-20d", book.getName(), book.getAuthor(), book.getYear());
            System.out.println();
        }
    }

    public void printListOfBooks() {
        do {
            List<Book> books = biblioteca.getLibraryBooks();
            printBooks(books);
            returnToMenu();
        }
        while (!returnBack);
    }

    @Override
    public void bookCheckout() {
        printBooks(biblioteca.getLibraryBooks());
        System.out.println("\nEnter book index for checkout");
        getOption();
        biblioteca.checkoutLibraryBook(option);
        System.out.println(biblioteca.getCheckoutMessage());
        while (!returnBack) {
            returnToMenu();
        }
    }

    private void printMenu() {
        int i = 1;
        System.out.println("\nSelect an option\n");
        for (Option option : Option.values()) {
            System.out.println(i + ". " + option.value);
            i += 1;
        }
        executeOption();
    }

    public void quit() {
        exit = true;
    }

    public void goBack() {
        printMenu();
    }

    private void returnToMenu() {
        System.out.println("\nPress 0 to return to menu");
        getOption();
        if (option == 0) {
            goBack();
            returnBack = true;
        } else {
            showInvalid();
            returnBack = false;
        }
    }

    @Override
    public void showInvalid() {
        System.out.println("\nPlease select a valid option\n");
    }

    public void returnBook() {
        List<Book> issuedBooks = biblioteca.getIssuedBooks();
        printBooks(issuedBooks);
        System.out.println("\nSelect a Book to return");
        getOption();
        if (option > 0 && option <= issuedBooks.size()) {
            Book book = issuedBooks.get(option-1);
            biblioteca.returnLibraryBook(book);
        }
        System.out.println(biblioteca.getReturnMessage());
        while (!returnBack) {
            returnToMenu();
        }
    }

    private void getOption() {
        option = scanner.nextInt();
    }

    private void executeOption() {
        getOption();
        switch (option) {
            case 1:
                Option.LIST_BOOKS.executeOption(this);
                break;
            case 2:
                Option.QUIT_APP.executeOption(this);
                break;
            case 3:
                Option.CHECKOUT_BOOK.executeOption(this);
                break;
            case 4:
                Option.RETURN_BOOK.executeOption(this);
                break;
            default:
                showInvalid();
        }
    }

    public static void main(String[] args) {
        BibliotecaClient bibliotecaClient = new BibliotecaClient();
        bibliotecaClient.start();
    }
}
