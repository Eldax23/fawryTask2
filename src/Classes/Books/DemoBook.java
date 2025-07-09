package Classes.Books;

public class DemoBook extends BaseBook {

    public DemoBook(String ISBN , String title , int year , int price) {
        super(ISBN , title , year , price);
    }

    @Override
    public boolean isForSale() {
       return false;
    }
}
