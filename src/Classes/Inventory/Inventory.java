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
        ArrayList<String> keysToBeRemoved = new ArrayList<String>();
        for(Map.Entry<String,  BaseBook> m : inventory.entrySet()) {
            BaseBook b = m.getValue();
            if(currYear - b.getYear() > expiryAge) {
                res.add(b);
                keysToBeRemoved.add(m.getKey());
            }
        }

        for(String key : keysToBeRemoved) {
            inventory.remove(key);
        }

        System.out.println("\nBooks Removed: " + res.size());
        for(BaseBook b : res) {
            System.out.println(res.toString() + "\n");
        }
    }

    public void listBooks() {
        if(inventory.isEmpty()) System.out.println("The Inventory Is Currently Empty");
        for(Map.Entry<String , BaseBook> m : inventory.entrySet()) {
            BaseBook b = m.getValue();
//            System.out.println("ISBN: " + m.getKey() + "\nTitle: " + b.getTitle() +
//                    "\nPrice: " + b.getPrice() + "\nYear: " + b.getYear()
//            );

            System.out.println(b.toString());
        }
    }

    @Override
    public BaseBook getBook(String ISBN) {
        if(!inventory.containsKey(ISBN)) throw new IllegalArgumentException("Book not available at the moment.");

        return inventory.get(ISBN);
    }
}
