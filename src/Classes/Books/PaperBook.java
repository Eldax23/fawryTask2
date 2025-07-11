package Classes.Books;

import Classes.Services.ShippingService;
import Interfaces.Services.IDeliveryService;

public class PaperBook extends BaseBook {
    private int stock;
    public PaperBook(String ISBN , String title , int year , double price , int stock) {

        super(ISBN , title , year , price);
        this.stock = stock;
    }

    @Override
    public boolean isForSale() {
        return true;
    }

    @Override
    public void buyBook(int quantity, String email , IDeliveryService shippingService) {
        if(quantity > stock) {
            throw new IllegalArgumentException("Not enough stock");
        }
        this.stock -= quantity;
        System.out.println("the book " + this.getTitle() + " has been bought with a total of " + getPrice() * quantity + "$");
        shippingService.deliver(email); // the delivery method will change based on the given argument
    }
}
