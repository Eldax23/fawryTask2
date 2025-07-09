package Classes.Inventory;

import Classes.Books.BaseBook;

public interface Iinventory {
    void addBook(BaseBook book);
    void removeOutDatedBooks(int expiryAge);
    public BaseBook getBook(String ISBN);
}
