package businessmodels;

import java.io.Serializable;
import java.time.LocalDate;


public class CheckoutRecordEntry implements Serializable {
    private LibraryMember member;
    private BookCopy copy;
    private LocalDate dueDate;
    CheckoutRecordEntry(LibraryMember member, BookCopy copy){
        this.member = member;
        this.copy = copy;
        this.dueDate = LocalDate.now().plusDays(this.copy.getMaxCheckoutTime());
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public Book getBook() {
        return copy.getBook();
    }
}
