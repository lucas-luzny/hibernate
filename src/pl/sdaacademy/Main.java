package pl.sdaacademy;

import pl.sdaacademy.api.DBExecutor;
import pl.sdaacademy.api.Executor;
import pl.sdaacademy.model.*;
import pl.sdaacademy.service.HibernateService;
import pl.sdaacademy.service.PostgreSQLService;
import pl.sdaacademy.table.AuthorsManager;
import pl.sdaacademy.table.BooksManager;

import java.util.Scanner;

public class Main {
    private static Menu menu = new Menu();
    public static void main(String[] args) {
        final HibernateService service = new PostgreSQLService();
        final String config = "hibernate.cfg.xml";
        final Executor executor = new DBExecutor(service);
        final AuthorsManager authorsManager = new AuthorsManager(executor);
        final BooksManager booksManager = new BooksManager(executor);

        Author author = new Author("J.R.R", "Tolkien", 1892);
        Author authorUpdate = new Author("John Ronald Reuel", "Tolkien", 1892);

        Book book = new Book("Hobbit", author, BookType.FANTASY);

        while (true) {
            menu.showMenu();
            int menuOption = menu.chooseMenuOption();
            System.out.println("Menu option: " + menuOption);
            switch (menuOption) {
                case 1:
                    System.out.println("Option 1");
                    service.connect(config);
                    break;
                case 2:
                    System.out.println("Option 2");
                    service.disconnect();
                    break;
                case 3:
                    System.out.println("Option 3");
                    booksManager.add(book);
                    break;
                case 4:
                    System.out.println("Option 4");
                    authorsManager.add(author);
                    break;
                case 5:
                    System.out.println("Closing app!");
                    System.exit(0);
                    break;
                case 6:
                    System.out.println("Option 6");
                    booksManager.getList();
                    break;
                case 7:
                    System.out.println("Option 7");
                    authorsManager.getList();
                    System.out.println(authorsManager.getList());
                    break;
                case 8:
                    System.out.println("Option 8");
                    booksManager.update(book);
                    break;
                case 9:
                    System.out.println("Option 9");
                    authorsManager.update(authorUpdate);
                    break;
                case 10:
                    System.out.println("Option 10");
                    booksManager.delete(book);
                    break;
                case 11:
                    System.out.println("Option 11");
                    authorsManager.delete(author);
                    break;
                default:
            }
        }
    }
    private static class Menu {

        void showMenu() {
            System.out.println("Choose option");
            System.out.println("1.  Establish connection: ");
            System.out.println("2.  Close connection");
            System.out.println("3.  Add Book object");
            System.out.println("4.  Add Author object");
            System.out.println("5.  Close");
            System.out.println("6.  Get Books list");
            System.out.println("7.  Get Authors list");
            System.out.println("8.  Update Book");
            System.out.println("9.  Update Author");
            System.out.println("10. Delete Book");
            System.out.println("11. Delete Author");
            //add other necessary menu options
        }

        int chooseMenuOption() {
            Scanner reader = new Scanner(System.in);
            System.out.println("Enter a menu option: ");
            return reader.nextInt();
        }
    }
}
