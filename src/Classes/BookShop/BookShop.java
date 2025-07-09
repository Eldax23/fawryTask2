package Classes.BookShop;

import Classes.Books.Ebook;
import Classes.Books.PaperBook;
import Classes.Inventory.Inventory;
import Classes.Services.MailService;
import Classes.Services.ShippingService;
import Interfaces.IBook;
import Interfaces.Services.IDeliveryService;

public class BookShop implements IBookShop {
    private Inventory inventory;
    private ShippingService shippingService;
    private MailService mailService;
    public BookShop(Inventory inventory) {
        this.inventory = inventory;
        this.shippingService = new ShippingService();
        this.mailService = new MailService();
    }
    @Override
    public void buyBook(String ISBN,  int quantity, String contact) {
        IBook book = inventory.getBook(ISBN);

        if(!book.isForSale()) {
            throw new IllegalArgumentException("This book isn't for sale");
        }

        if (book instanceof Ebook) {
            book.buyBook(quantity , contact , mailService);
        }
        else if (book instanceof PaperBook) {

            book.buyBook(quantity , contact , shippingService);
        }

//        else {
//            // if we wanna add more book types
//
//        }

    }
}
