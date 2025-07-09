package Classes.Books;

import Interfaces.Services.IDeliveryService;

public class DemoBook extends BaseBook {

    public DemoBook(String ISBN , String title , int year , double price) {
        super(ISBN , title , year , price);
    }

    @Override
    public boolean isForSale() {
       return false;
    }

    @Override
    public void buyBook(int quantity, String email, IDeliveryService shippingService) {
        System.out.println("this book isn't for sale because its a demo book.");
    }
}
