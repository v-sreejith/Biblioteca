package consoleUI;

import com.twu.biblioteca.*;

import java.util.List;
import java.util.Scanner;

//Job: Represent a Biblioteca client
public class BibliotecaClient implements UserInterface {
    boolean validUser;
    Biblioteca biblioteca;
    Inventory<Book> bookInventory;
    Inventory<Movie> movieInventory;
    UserCredential userCredential;
    MenuOptions menuOptions;
    User user;
    int option;
    Scanner scanner;
    static boolean exit;
    static boolean returnBack;

    public BibliotecaClient() {
        init();
    }

    private void init() {
        scanner = new Scanner(System.in);
        bookInventory = new Inventory<>(initBooks());
        movieInventory = new Inventory<>(initMovies());
        userCredential = new UserCredential(1234, "abcd");
        user = new User(userCredential, "example Name","abc@efg",1234567,"User");
        biblioteca = new Biblioteca(bookInventory, List.of(user), movieInventory);
        menuOptions = new MenuOptions(biblioteca);
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

    private void start() {
        printWelcomeMessage();
        while (!exit) {
            printMenu();
        }
    }

    private void printWelcomeMessage() {
        System.out.println(biblioteca.getWelcomeMessage());
    }

    private void login() {
        int libraryNumber;
        String password;
        System.out.println("\nEnter library number");
        libraryNumber = scanner.nextInt();
        System.out.println("\nEnter Password");
        password = scanner.next();
        biblioteca.login(libraryNumber, password);
        String loginMessage = biblioteca.getLoginMessage();
        System.out.println(loginMessage);
        if (loginMessage.equals("Login Success!!")) {
            validUser = true;
        }
        printMenu();
    }

    private void askLogin() {
        System.out.println("Enter 0 to Login");
    }

    private void printMenu() {
        System.out.println("\nSelect an option\n");
        List<Option> options = menuOptions.getOptions();
        int i = 1;
        if (!validUser) {
            askLogin();
        }
        for (Option option : options) {
            System.out.println(i + ". " + option.value);
            i += 1;
        }
        executeOption(options);
    }

    private void getOption() {
        option = scanner.nextInt();
    }

    private void executeOption(List<Option> options) {
        getOption();
        if (option == 0 && !validUser) {
            login();
        }
        else if (option > 0 && option <= options.size()) {
            options.get(option-1).executeOption(this);
        } else showInvalid();
    }

    public void showInvalid() {
        System.out.println("\nPlease select a valid option\n");
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

    public void printListOfBooks() {
        do {
            List<Book> books = biblioteca.getLibraryBooks();
            printBooks(books);
            returnToMenu();
        }
        while (!returnBack);
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

    public void printListOfMovies() {
        do {
            List<Movie> movies = biblioteca.getLibraryMovies();
            printMovies(movies);
            returnToMenu();
        }
        while (!returnBack);
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

    public void bookCheckout() {
        printBooks(biblioteca.getLibraryBooks());
        System.out.println("\nEnter book index for checkout");
        getOption();
        Book book = biblioteca.getLibraryBooks().get(option - 1);
        biblioteca.checkoutLibraryBook(book);
        System.out.println(biblioteca.getCheckoutMessage());
        while (!returnBack) {
            returnToMenu();
        }
    }

    public void movieCheckout() {
        List<Movie> movies = biblioteca.getLibraryMovies();
        printMovies(movies);
        System.out.println("\nEnter movie index for checkout");
        getOption();
        if (option > 0 && option < movies.size()) {
            Movie movie = movies.get(option - 1);
            biblioteca.checkoutLibraryMovie(movie);
            System.out.println(biblioteca.getCheckoutMessage());
        } else showInvalid();
        while (!returnBack) {
            returnToMenu();
        }
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

    public void returnMovie() {
        List<Movie> issuedMovies = biblioteca.getIssuedMovies();
        printMovies(issuedMovies);
        System.out.println("\nSelect a Movie to return");
        getOption();
        if (option > 0 && option <= issuedMovies.size()) {
            Movie movie = issuedMovies.get(option - 1);
            biblioteca.returnLibraryMovie(movie);
        }
        System.out.println(biblioteca.getReturnMessage());
        while (!returnBack) {
            returnToMenu();
        }
    }

    public void userDetails() {
        String[] details = biblioteca.currentUserDetails().split(",");
        System.out.println("\n\nName:\t" + details[0]);
        System.out.println("\n\nE-Mail:\t" + details[1]);
        System.out.println("\n\nPhone Number:\t" + details[2]);
    }

    public void quit() {
        exit = true;
    }

    public static void main(String[] args) {
        BibliotecaClient bibliotecaClient = new BibliotecaClient();
        bibliotecaClient.start();
    }
}
