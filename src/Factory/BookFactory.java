package Factory;

import Classes.Books.BaseBook;
import Classes.Books.DemoBook;
import Classes.Books.Ebook;
import Classes.Books.PaperBook;

import java.awt.print.Book;

public class BookFactory {

    public static BaseBook createBook(BookType bookType , String ISBN , String title
            , double price , int year , int stock , String fileType) {

        switch (bookType) {
            case BookType.PAPER -> {
                return new PaperBook(ISBN , title , year , price , stock);
            }
            case BookType.EBOOK -> {
                return new Ebook(ISBN , title , year , price , fileType);
            }
            case BookType.DEMO -> {

                return new DemoBook(ISBN , title , year , price);
            }
            default -> throw new IllegalArgumentException("Invalid BookType");
        }
    }
}
