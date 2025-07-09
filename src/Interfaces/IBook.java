package Interfaces;

import Interfaces.Services.IDeliveryService;

public interface IBook {
    String getISBN();
    String getTitle();
    int getYear();
    double getPrice();
    boolean isForSale();
    void buyBook(int quantity, String email , IDeliveryService shippingService);

}
