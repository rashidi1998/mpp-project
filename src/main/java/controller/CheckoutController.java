package controller;

import businessmodels.LibraryMember;
import models.CheckoutModel;
import dataaccess.DataAccessorFacade;
import uimodels.Checkout;
import businessmodels.Book;
import businessmodels.CheckoutRecord;
import exceptions.BookNotAvailableException;

public class CheckoutController {
    private static CheckoutController instance = new CheckoutController();
    
    private CheckoutController() {};

    public static CheckoutController getInstance() {
        return instance;
    }

    public void checkoutBook(CheckoutModel checkoutModel, Checkout component) throws BookNotAvailableException {
        System.out.println("Book Checked out");

        LibraryMember member = DataAccessorFacade.getInstance().getMember(checkoutModel.memberId());
        Book book = DataAccessorFacade.getInstance().getBook(checkoutModel.isbn());

        if(book == null || book.getCopyCount() == 0){
            throw new BookNotAvailableException(" No books available ");
        }

        CheckoutRecord checkout = DataAccessorFacade.getInstance().getCheckoutRecord(member.getMemberId());
        if(checkout == null){
            checkout = new CheckoutRecord.Builder(member, book).build();
        }else{
            checkout.addRecord(book);
        }

        DataAccessorFacade.getInstance().saveNewBook(book);
        DataAccessorFacade.getInstance().saveCheckoutRecords(checkout);
        
    }

    public CheckoutRecord getCheckoutRecord(String memberId) {
        return DataAccessorFacade.getInstance().getCheckoutRecord(memberId);
    }
}
