package Classes.Books;

public class Ebook extends BaseBook{
    private String fileType;


    public Ebook(String ISBN , String title , int year , int price , String fileType) {

        super(ISBN , title , year , price);
        this.fileType = fileType;
    }

    @Override
    public boolean isForSale() {
        return true;
    }
}
