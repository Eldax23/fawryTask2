package Classes.Books;

import Interfaces.IBook;
import Interfaces.Services.IDeliveryService;

public abstract class BaseBook implements IBook {
    private String ISBN;
    private String title;
    private int year;
    private double price;

    public BaseBook(String ISBN , String title , int year , double price) {
        this.ISBN = ISBN;
        this.title = title;
        this.year = year;
        this.price = price;
    }

    @Override
    public String getISBN() {
        return ISBN;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public int getYear() {
        return year;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public boolean isForSale() {
        return true;
    }

    @Override
    public void buyBook(int quantity, String email , IDeliveryService shippingService) {

    }

    @Override
    public String toString() {
        return "\n--------------\nTitle: " + this.getTitle() + "\nYear: " + this.getYear() + "\nPrice: " + this.getPrice() + "\n------------";
    }

}
