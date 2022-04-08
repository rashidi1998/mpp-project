package controller;

import auth.AuthenticationManager;
import business.LibraryMember;
import dao.CheckoutDAO;
import dataaccess.DataAccessFacade;
import ui.Checkout;
import business.Book;
import business.CheckoutRecord;
import exceptions.BookNotAvailableException;

public class CheckoutController {
    private static CheckoutController instance = new CheckoutController();
    
    private CheckoutController() {};

    public static CheckoutController getInstance() {
        return instance;
    }

    public void checkoutBook(CheckoutDAO checkoutDAO, Checkout component) throws BookNotAvailableException {
        System.out.println("Book Checked out");

        LibraryMember member = DataAccessFacade.getInstance().getMember(checkoutDAO.memberId());
        Book book = DataAccessFacade.getInstance().getBook(checkoutDAO.isbn());

        if(book == null || book.getCopyCount() == 0){
            throw new BookNotAvailableException(" No books available ");
        }

        CheckoutRecord checkout = DataAccessFacade.getInstance().getCheckoutRecord(member.getMemberId());
        if(checkout == null){
            checkout = new CheckoutRecord.Builder(member, book).build();
        }else{
            checkout.addRecord(book);
        }

        DataAccessFacade.getInstance().saveNewBook(book);
        DataAccessFacade.getInstance().saveCheckoutRecords(checkout);
        
    }

    public CheckoutRecord getCheckoutRecord(String memberId) {
        return DataAccessFacade.getInstance().getCheckoutRecord(memberId);
    }
}
