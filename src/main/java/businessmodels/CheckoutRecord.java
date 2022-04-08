package businessmodels;

import java.io.Serializable;
import java.util.*;

public class CheckoutRecord implements Serializable {
    private LibraryMember libraryMember;
    private List<CheckoutRecordEntry> records;

    private CheckoutRecord(LibraryMember member, List<CheckoutRecordEntry> records){
        this.libraryMember = member;
        this.records = records;
    }

    public LibraryMember getLibraryMember() {
        return libraryMember;
    }

    public static class Builder{
        private LibraryMember libraryMember;
        private List<CheckoutRecordEntry> records = new ArrayList<>();
        private Book book;

        public Builder(LibraryMember member, Book book){
            this.libraryMember = member;
            this.book = book;
            createRecordEntry();
        }
        private void createRecordEntry(){
            BookCopy copy = book.getLastCopy();
            records.add(new CheckoutRecordEntry(libraryMember, copy));
        }
        public CheckoutRecord build(){
            return new CheckoutRecord(libraryMember, records);
        }
    }

    public void addRecord(Book book){
        records.add(new CheckoutRecordEntry(libraryMember, book.getLastCopy()));
    }

    public List<CheckoutRecordEntry> getCheckoutRecordEntry() {
        return records;
    }
}
