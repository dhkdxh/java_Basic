package BookMarket.cart;

import BookMarket.bookitem.Book;

public interface CartInterface {
    void printBookList(Book[] p);

    boolean isCartInBook(String id);

    void insertBook(Book p);

    void removeCart(int numid);

    void deleteBook();
}
