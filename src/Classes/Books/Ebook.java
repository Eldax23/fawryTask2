package Classes.Books;

import Interfaces.Services.IDeliveryService;

public class Ebook extends BaseBook{
    private String fileType;


    public Ebook(String ISBN , String title , int year , double price , String fileType) {

        super(ISBN , title , year , price);
        this.fileType = fileType;
    }

    public String getFileType() {
        return this.fileType;
    }

    @Override
    public boolean isForSale() {
        return true;
    }

    @Override
    public void buyBook(int quantity,  String email , IDeliveryService shippingService){
        System.out.println("An Ebook with title " + getTitle() + " and a filetype " + getFileType());
        shippingService.deliver(email);
    }
}
