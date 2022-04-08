package businessmodels;

import java.io.Serializable;

public class BookCopy implements Serializable {
    private int copyNum;
    private Book book;

    public BookCopy(Book book, int copyNum){
        this.book = book;
        this.copyNum = copyNum;
    }

    public int getCopyNum() {
        return copyNum;
    }

    public int getMaxCheckoutTime() {
        return book.getMaxCheckoutTime();
    }

    public Book getBook() {
        return book;
    }
}
