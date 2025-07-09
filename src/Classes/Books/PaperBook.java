package Classes.Books;

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


}
