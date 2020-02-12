package consoleUI;

import com.twu.biblioteca.*;

import java.util.List;
import java.util.Scanner;

//Job: Represent a Biblioteca client
public class BibliotecaClient implements UserInterface {
    Biblioteca biblioteca;
    Library library;
    int option;
    Scanner scanner;
    static boolean exit;
    static boolean returnBack;

    private void init() {
        library = new Library(initBooks(), initMovies());
        biblioteca = new Biblioteca(library);
        scanner = new Scanner(System.in);
    }

    private List<Book> initBooks() {
        Book bookOne = new Book("Wings of Fire", "A P J Abdul Kalam", 2001);
        Book bookTwo = new Book("Kite Runner", "Khaled Hosseini", 2003);
        Book bookThree = new Book("Hunger Games", "Suzzane", 2009);
        return List.of(bookOne, bookTwo, bookThree);
    }

    private List<Movie> initMovies() {
        Rating ratingOne;
        Rating ratingTwo;
        List<Movie> movies = null;
        try {
            ratingOne = new Rating(9);
            ratingTwo = new Rating(10);

            Movie movieOne = new Movie("Harry Potter", 2001, "J K Rowling", ratingOne);
            Movie movieTwo = new Movie("Shawshank Redemption", 1999, "Frank Darabont", ratingOne);
            Movie movieThree = new Movie("Joker", 2019, "Todd philips", ratingTwo);
            Movie movieFour = new Movie("Ford V Ferrari", 2019, "James Mangold", ratingTwo);
            movies = List.of(movieOne, movieTwo, movieThree, movieFour);
        } catch (Exception ignored) {
        }
        return movies;
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
            String[] details = book.formattedDetails().split(",");
            System.out.format("%-20s\t%-30s\t%-20s", details[0], details[1], details[2]);
            System.out.println();
        }
    }

    private void printMovies(List<Movie> movies) {
        System.out.format("\n%-20s\t%-30s\t%-30s\t%-20s\n", "Name", "Year", "Director", "Rating");
        System.out.println();
        for (Movie movie : movies) {
            String[] details = movie.formattedDetails().split(",");
            System.out.format("%-20s\t%-30s\t%-30s\t%-20s", details[0], details[1], details[2], details[3]);
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
        Book book = biblioteca.getLibraryBooks().get(option-1);
        biblioteca.checkoutLibraryBook(book);
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

    @Override
    public void printListOfMovies() {
        do {
            List<Movie> movies = biblioteca.getLibraryMovies();
            printMovies(movies);
            returnToMenu();
        }
        while (!returnBack);
    }

    @Override
    public void movieCheckout() {
        printMovies(biblioteca.getLibraryMovies());
        System.out.println("\nEnter movie index for checkout");
        getOption();
        Movie movie = biblioteca.getLibraryMovies().get(option-1);
        biblioteca.checkoutLibraryMovie(movie);
        System.out.println(biblioteca.getCheckoutMessage());
        while (!returnBack) {
            returnToMenu();
        }
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
            Book book = issuedBooks.get(option - 1);
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
        if (option > 0 && option <= Option.values().length) {
            Option.values()[option - 1].executeOption(this);
        } else showInvalid();
    }

    public static void main(String[] args) {
        BibliotecaClient bibliotecaClient = new BibliotecaClient();
        bibliotecaClient.start();
    }
}
