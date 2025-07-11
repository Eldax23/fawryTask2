package Classes.Inventory;

import Classes.Books.BaseBook;

import javax.sql.rowset.BaseRowSet;
import java.time.Year;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Inventory implements Iinventory { // this is the main inventory where all the stock reigns

    private Map<String , BaseBook> inventory = new HashMap<>(); // hashmap for storing books (ISBN -> Book)

    @Override
    public void addBook(BaseBook book) { // adding book to the inventory
        inventory.put(book.getISBN() , book);
        System.out.println(book.getTitle() + "  Book has been added");
    }

    public void removeBook(String ISBN) {
        BaseBook removedBook = inventory.get(ISBN);
        if(removedBook == null) {
            throw new IllegalArgumentException("no book with that ISBN");
        }

        inventory.remove(ISBN);
        System.out.println("the book with ISBN : " + ISBN + " and title " + removedBook.getTitle()
        + "HAS BEEN DELETED.");
    }

    @Override
    public void removeOutDatedBooks(int expiryAge) {
        int currYear = Year.now().getValue();
        ArrayList<BaseBook> res = new ArrayList<BaseBook>();
        inventory.forEach((isbn , book) -> {
            if(currYear - book.getYear() > expiryAge) {
                inventory.remove(isbn);
                res.add(book);
            }
        });
    }

    @Override
    public BaseBook getBook(String ISBN) {
        if(!inventory.containsKey(ISBN)) throw new IllegalArgumentException("Book not available at the moment.");

        return inventory.get(ISBN);
    }
}
