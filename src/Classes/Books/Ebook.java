package Classes.Books;

import Interfaces.Services.IShippingService;

public class Ebook extends BaseBook{
    private String fileType;


    public Ebook(String ISBN , String title , int year , int price , String fileType) {

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
    public void buyBook(int quantity,  String email , IShippingService shippingService){
        System.out.println("An Ebook with title " + getTitle() + " and a filetype " + getFileType());
        shippingService.deliver(email);
    }
}
