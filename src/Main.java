import Classes.BookShop.BookShop;
import Classes.Books.BaseBook;
import Classes.Books.Ebook;
import Classes.Books.PaperBook;
import Classes.Inventory.Inventory;
import Classes.Services.MailService;
import Classes.Services.ShippingService;
import Classes.TestingBookShop;
import Classes.UserProgram;
import Factory.BookFactory;
import Factory.BookType;
import Interfaces.Services.IDeliveryService;

import java.awt.print.Book;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // fot the general use of the program
        UserProgram.userInterface();

        // uncomment for testing adding , removing , buying
//        TestingBookShop test = new TestingBookShop();
//        test.testAddingBooks();
//        test.testBuyingBooks();
//        test.testRemovingBooks();
    }

}