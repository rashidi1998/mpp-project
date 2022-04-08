package controller;

import java.util.*;
import java.util.stream.Collectors;

import Validators.BookValidator;
import Validators.ValidatorFactory;
import dataaccess.*;
import exceptions.InvalidFieldException;

import businessmodels.*;

import models.BookModel;
import models.BookCopyModel;

import uimodels.AddBookCopy;
import uimodels.AddNewBook;

public class BookController {
    private static BookController instance = new BookController();
    
    private BookController() {};

    public static BookController getInstance() {
        return instance;
    }

    public void addBookCopy(BookCopyModel bookCopyModel, AddBookCopy component) throws Exception {
        
        ValidatorFactory.checkNotEmptyOrNull(bookCopyModel);
        
        String isbn = bookCopyModel.isbn(); // TODO: Need to come from UI
        int numCopy = bookCopyModel.numCopy();

        Book book = DataAccessorFacade.getInstance().getBook(isbn);
            for(int i = 0; i < numCopy; i++){
                book.addBookCopy(new BookCopy(book, book.getCopyCount() + 1));
            }
        
        DataAccessorFacade.getInstance().saveNewBook(book);
    }

    public void addNewBook(BookModel bookModel, AddNewBook component) {

       BookValidator validator =  ValidatorFactory.getBookValidator();

        Book book = new Book.Builder(
                bookModel.isbn(),
                bookModel.title(),
                bookModel.authors().stream().map(Author::new).collect(Collectors.toList())
        ).maxCheckout(bookModel.maxCheckoutLength())
                .numCopies(bookModel.numCopies()).build();

        try{
            validator.validate(book);
        }catch (InvalidFieldException e){
            // TODO: show msg with exception
            throw new InvalidFieldException("Some inputs are incorrect", "Please double check");
        }

        DataAccessorFacade.getInstance().saveNewBook(book);
    }

    public List<Book> getBookList() {
        return DataAccessorFacade.getInstance().getBookList();
    }
}
