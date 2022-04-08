package businessmodels;

import java.io.Serializable;
import java.util.*;


public class Book implements Serializable {
    private String title;
    private String isbn;
    private int maxCheckoutLength;
    private List<BookCopy> bookCopies = new ArrayList<>();
    private List<Author> authors;

    public Book(String title, String isbn, int maxCheckoutLength) {
        this.title = title;
        this.isbn = isbn;
        this.maxCheckoutLength = maxCheckoutLength;
    }

    public void removeCopy(int i) {
        bookCopies.remove(i - 1);
    }

    public static class Builder{
        private final String isbn;
        private final String title;
        private final List<Author> authors;

        private int numCopies = 1;
        private int maxCheckout = 7;

        public Builder(String isbn, String title, List<Author> authors){
            this.isbn = isbn;
            this.title = title;
            this.authors = authors;
        }
        public Builder numCopies(int numCopies){
            this.numCopies = numCopies;
            return this;
        }
        public Builder maxCheckout(int days){
            this.maxCheckout = days;
            return this;
        }
        public Book build(){
            return new Book(this);
        }

    }

    private Book(Builder builder){
        this.title = builder.title;
        this.isbn = builder.isbn;
        this.authors = builder.authors;
        this.maxCheckoutLength = builder.maxCheckout;
        for(int i = 0; i < builder.numCopies; i++)
            bookCopies.add(new BookCopy(this, i + 1));
    }

    public String getTitle() {
        return title;
    }

    public String getIsbn() {
        return isbn;
    }

    public int getMaxCheckoutTime() {
        return maxCheckoutLength;
    }

    public void addBookCopy(BookCopy bookCopy) {
        bookCopies.add(bookCopy);
    }

    public List<BookCopy> getBookCopies() {
        return bookCopies;
    }

    public BookCopy getBookCopy(String copyNum) {
//        for(BookCopy bookCopy: bookCopies) {
//            if (bookCopy.getIsbn() == copyNum) {
//                return bookCopy;
//            }
//        }
        return null;
    }

    public BookCopy getLastCopy(){
        int lastCopyIdx = getCopyCount();
        BookCopy copy = bookCopies.get(lastCopyIdx - 1);
        removeCopy(lastCopyIdx);
        return copy;
    }

    public int getCopyCount() {
        return bookCopies.size();
    }

}
