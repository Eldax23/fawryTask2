package Classes;

import Classes.BookShop.BookShop;
import Classes.Books.BaseBook;
import Classes.Inventory.Inventory;
import Classes.Services.MailService;
import Classes.Services.ShippingService;
import Factory.BookFactory;
import Factory.BookType;

import java.util.Scanner;

public class UserProgram {

    public static void userInterface() {

        Inventory inventory = new Inventory();
        ShippingService shippingService = new ShippingService();
        MailService mailService = new MailService();
        BookShop store = new BookShop(inventory);

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n-----Book Store -----\n");
            System.out.println("1-Add Book");
            System.out.println("2-Buy Book");
            System.out.println("3-Remove outdated books");
            System.out.println("4-Exit");
            System.out.print("Choose option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch(choice) {
                case 1:
                    addBook(scanner, inventory);
                    break;
                case 2:
                    buyBook(scanner, store);
                    break;
                case 3:
                    inventory.removeOutDatedBooks(5); // in years
                    break;
                default:
                    System.out.println("invalid option.");
                    return;
            }
        }
    }

    private static void addBook(Scanner scanner, Inventory inventory) {
        System.out.print("Enter book type [PAPER - EBOOK - DEMO]: ");
        String typeInput = scanner.nextLine().toUpperCase();
        if(!typeInput.equals("PAPER") && !typeInput.equals("EBOOK") && !typeInput.equals("DEMO")) {
            throw new IllegalArgumentException("Enter valid type");
        }

        BookType type = BookType.valueOf(typeInput);


        System.out.println("ISBN:");
        String ISBN = scanner.nextLine();

        System.out.println("Title: ");
        String title = scanner.nextLine();

        System.out.println("Year: ");
        int year = scanner.nextInt();

        double price = 0;
        String fileType = null;
        int stock = 0;

        if(type != BookType.DEMO){
            System.out.println("Price: ");
            price = scanner.nextDouble();
        }

        if(type == BookType.PAPER) {
            System.out.println("Stock: ");
            stock = scanner.nextInt();
        }

        if(type == BookType.EBOOK) {
            System.out.println("File type: ");
            fileType = scanner.nextLine();
        }

        BaseBook book = BookFactory.createBook(type, ISBN, title, price, year, stock, fileType);
        inventory.addBook(book);
    }

    private static void buyBook(Scanner scanner, BookShop store) {
        System.out.println("Enter ISBN: ");
        String ISBN = scanner.nextLine();

        System.out.println("Quantity: ");
        int quantity = scanner.nextInt();

        scanner.nextLine(); // just for format purposes

        System.out.println("Email: ");
        String email = scanner.nextLine();



        System.out.println("Address: ");
        String address = scanner.nextLine();

        try {
            store.buyBook(ISBN, quantity, address);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }}
