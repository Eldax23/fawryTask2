package Classes.Books;

import Interfaces.Services.IShippingService;

public class PaperBook extends BaseBook {
    private int stock;
    public PaperBook(String ISBN , String title , int year , int price , int stock) {

        super(ISBN , title , year , price);
        this.stock = stock;
    }

    @Override
    public boolean isForSale() {
        return true;
    }

    @Override
    public void buyBook(int quantity, String email , IShippingService shippingService) {
        if(quantity > stock) {
            throw new IllegalArgumentException("Not enough stock");
        }
        this.stock -= quantity;
        System.out.println("the book " + this.getTitle() + " has been bought with a total of " + getPrice());
        shippingService.deliver(email);
    }
}
