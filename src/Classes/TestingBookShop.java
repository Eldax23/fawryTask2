package Classes;

import Classes.BookShop.BookShop;
import Classes.Books.BaseBook;
import Classes.Inventory.Inventory;
import Classes.Services.MailService;
import Classes.Services.ShippingService;
import Factory.BookFactory;
import Factory.BookType;

import java.awt.print.Book;

public class TestingBookShop {
    Inventory inventory = new Inventory();
    ShippingService shippingService = new ShippingService();
    MailService mailService = new MailService();
    BookShop store = new BookShop(inventory);

    BaseBook book1;
    BaseBook book2;
    BaseBook book3;



    public TestingBookShop() {
        book1 = BookFactory.createBook(BookType.PAPER, "ISBN1", "PaperBook", 30, 2015, 40, null);
        book2 = BookFactory.createBook(BookType.EBOOK, "ISBN2", "EBook", 50, 2011, 0, "PDF");
        book3 = BookFactory.createBook(BookType.DEMO, "ISBN3", "DemoBook", 30, 2015, 0, null);
    }

    public void testAddingBooks() {

        try {
            inventory.addBook(book1);
            inventory.addBook(book2);
            inventory.addBook(book3);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void testRemovingBooks() {
        try {
            inventory.removeBook("ISBN1"); // removing an existing book
            inventory.removeBook("ISBN55"); // removing a non existing book
        }
        catch (Exception e) {

            System.out.println(e.getMessage());
        }
    }

    public void testBuyingBooks() {
        // buying paper books
        try {
            store.buyBook("ISBN1" , 5 , "Cairo");           // just a regular test
//            store.buyBook("ISBN1" , 200 , "Cairo");           // A test where we buy more than the available stock
//            store.buyBook("ISBN15" , 2 , "Cairo");           // A test where we buy a book that doesn't exist
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }




}
