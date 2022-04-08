package controller;

import java.util.*;
import java.util.stream.Collectors;

import Validators.BookValidator;
import Validators.ValidatorFactory;
import validators.Validator;
import auth.AuthenticationManager;
import auth.UserDAO;
import dao.AuthorDAO;
import dataaccess.*;
import exceptions.InvalidFieldException;

import business.*;

import dao.BookDAO;
import dao.BookCopyDAO;

import ui.AddBookCopy;
import ui.AddNewBook;

public class BookController {
    private static BookController instance = new BookController();
    
    private BookController() {};

    public static BookController getInstance() {
        return instance;
    }

    public void addBookCopy(BookCopyDAO bookCopyDAO, AddBookCopy component) throws Exception {
        
        ValidatorFactory.checkNotEmptyOrNull(bookCopyDAO);
        
        String isbn = bookCopyDAO.isbn(); // TODO: Need to come from UI
        int numCopy = bookCopyDAO.numCopy();

        Book book = DataAccessFacade.getInstance().getBook(isbn);
            for(int i = 0; i < numCopy; i++){
                book.addBookCopy(new BookCopy(book, book.getCopyCount() + 1));
            }
        
        DataAccessFacade.getInstance().saveNewBook(book);
    }

    public void addNewBook(BookDAO bookDAO, AddNewBook component) {

       BookValidator validator =  ValidatorFactory.getBookValidator();

        Book book = new Book.Builder(
                bookDAO.isbn(),
                bookDAO.title(),
                bookDAO.authors().stream().map(Author::new).collect(Collectors.toList())
        ).maxCheckout(bookDAO.maxCheckoutLength())
                .numCopies(bookDAO.numCopies()).build();

        try{
            validator.validate(book);
        }catch (InvalidFieldException e){
            // TODO: show msg with exception
            throw new InvalidFieldException("Some inputs are incorrect", "Please double check");
        }

        DataAccessFacade.getInstance().saveNewBook(book);
    }

    public List<Book> getBookList() {
        return DataAccessFacade.getInstance().getBookList();
    }
}
