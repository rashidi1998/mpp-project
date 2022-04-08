package Validators;

import businessmodels.Book;
import exceptions.InvalidFieldException;

public class BookValidator implements validators.Validator<Book> {
    public BookValidator(){}

    private static final String CLASS = "BookValidator";

    @Override
    public boolean validate(Book book){
        return title(book.getTitle()) && ISBN(book.getIsbn());
    }

    private boolean title(String t){
        if(t != null && !t.isEmpty()){
            return true;
        }
        throw new InvalidFieldException("Title", "Title must not be null or empty", CLASS);
    }

    private boolean ISBN(String isbn){
        if(isbn != null && ( isbn.length() == 10 || isbn.length() == 13 )){
            return true;
        }
        throw new InvalidFieldException("ISBN", CLASS);
    }

    // TODO: more validations
}
